import json
import os
import pymysql
import csv

# 利用secedit导出安全组策略
a = os.popen("secedit /export /cfg c:\gp.inf")
a.close()
# 打开策略文件,要用rb读二在进制然后转成UTF-16,否则Python识别不了
file = "c:\gp.inf"
f = open(file, 'rb')
data = f.read().decode('UTF-16LE')

# 每行都是以\r\n结尾,先将数据分解成每一行的list
split = data.split('\r\n')
dic = {}

# 将本地组策略存储为字典,去除空格,获得等号两边的值
for string in split:
    list = string.split("=")
    if (len(list) == 2):
        dic1 = {list[0].strip(): list[1].strip()}
        dic.update(dic1)

print(dic)


# 编写匹配规则
# 小于规则
def lt(value, proposed_val):
    return int(value) < int(proposed_val)


# 大于规则
def bt(value, proposed_val):
    return int(value) > int(proposed_val)


# 等于规则
def eq(value, proposed_val):
    return value == proposed_val


# between规则
def between(value, proposed_val):
    val = proposed_val[1:-1].split(',')
    return int(val[0]) <= int(value) <= int(val[1])


# 规则匹配
switch = {
    'lt': lt,
    'bt': bt,
    'eq': eq,
    'between': between,
}

# 连接数据库
conn = pymysql.connect(host='localhost', user='root', passwd='root', db='rule', charset='utf8')
# 使用 cursor() 方法创建一个游标对象 cursor
cursor = conn.cursor()
# 使用 execute()  方法执行 SQL 查询
cursor.execute("SELECT * from rules")
# 获取表中所有匹配规则，循环与字典重的值相匹配
results = cursor.fetchall()

for result in results:
    print(result)
    if switch.get(result[8])(dic[result[1]], result[7]):
        eval = "符合"
    else:
        eval = "不符合"

    # 每项检查后更新数据库
    # 构建sql语句
    sql = "update rules set checked_val = '%s',eval_result = '%s' where ID = %d"
    # 执行sql语句, 并传递参数
    cursor.execute(sql % ("已检查", eval, result[0]))
    conn.commit()

# 转为json文件和csv文件
try:
    cursor.execute("SELECT * from rules")
    data = cursor.fetchall()
    cursor.close()
    conn.close()
    jsonData = []
    # 循环读取元组数据
    # 将元组数据转换为列表类型，每个条数据元素为字典类型:[{'字段1':'字段1的值','字段2':'字段2的值',...,'字段N:字段N的值'},{第二条数据},...,{第N条数据}]
    for row in data:
        result = {}
        result['ID'] = row[0]
        result['item_name'] = row[1]
        result['checked_val'] = row[2]
        result['proposed_comment'] = str(row[3])
        result['eval_result'] = str(row[4])
        result['harden_tips'] = str(row[5])
        result['item_comment'] = str(row[6])
        result['proposed_val'] = str(row[7])
        result['proposed_val_type'] = str(row[8])
        result['path'] = str(row[8])
        jsonData.append(result)
except:
    print('pymysql connect fail...')
else:
    # 使用json.dumps将数据转换为json格式，json.dumps方法默认会输出成这种格式"\u5377\u76ae\u6298\u6263"，加ensure_ascii=False，则能够防止中文乱码。
    # json.dumps()是将原始数据转为json（其中单引号会变为双引号），而json.loads()是将json转为原始数据。
    jsondatar = json.dumps(jsonData, ensure_ascii=False)
    with open(r'json.json', 'w')as f:
        f.write(jsondatar)

headers = ['ID', 'item_name', 'checked_val', 'proposed_comment', 'eval_result', 'harden_tips', 'item_comment',
           'proposed_val', 'proposed_val_type', 'path']
with open('rule.csv', 'w', newline='') as f:
    writer = csv.DictWriter(f, fieldnames=headers)  # 提前预览列名，当下面代码写入数据时，会将其一一对应。
    writer.writeheader()  # 写入列名
    writer.writerows(jsonData)  # 写入数据
