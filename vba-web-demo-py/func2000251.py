from Crypto.Cipher import AES
import hashlib
from base64 import b64encode
import base64, urllib.parse, requests, json, time, datetime

BS = AES.block_size


# key排序
def sorted_key(value):
    a = sorted(value, key=lambda x: x[0])
    b = ""
    for i in range(len(a)):
        b += (a[i][0] + a[i][1])
    print(b)
    return b


# SHA1PRNG加密
def padding_pkcs5(value):
    return str.encode(value + (BS - len(value) % BS) * chr(BS - len(value) % BS))


def aes_ecb_encrypt(key, value):
    # AES/ECB/PKCS5padding
    # key is sha1prng encrypted before
    cryptor = AES.new(bytes.fromhex(key), AES.MODE_ECB)
    padding_value = padding_pkcs5(value)  # padding content with pkcs5
    ciphertext = cryptor.encrypt(padding_value)
    return b64encode(ciphertext).decode('utf-8')


def get_sha1prng_key(key):
    signature = hashlib.sha1(key.encode()).digest()
    signature = hashlib.sha1(signature).digest()
    return ''.join(['%02x' % i for i in signature]).upper()[:32]


if __name__ == "__main__":

    videopic_url = "C:\\Users\\user\\Desktop\\1.jpg"  # 正面人像图片(BASE64格式)
    encrykey = "Ig685ldbNCWAGMxb9tnGJbhysEkvYn"  # 会话秘钥
    ptycd = "cgxyczbank"  # 机构号
    ptyacct = "cgxyczbank01"  # 机构账号
    usernm = "系统判断为同一人"  # 姓名
    certseq = "341227198912173710"  # 身份证号
    timestamp = str(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S'))  # 业务发生时间
    biztypdesc = "对比服务"  # 业务类型描述
    biztyp = "A001"  # 业务类型 # 固定值A001
    placeid = "00"  # 业务地址 # 固定值00
    sourcechnl = "0"  # 来源渠道 # 固定值0
    funcNo = "2000251"  # 接口号

    with open(videopic_url, 'rb') as f:
        image = f.read()
        print(image)
        videopic = base64.b64encode(image)
        # print(ls_f)
        # videopic = str(base64.b64encode(ls_f), encoding='utf-8')
        print("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111")
        print(videopic)
        print("************************************************************************************")
        f.close()

    certseqEncrypt = aes_ecb_encrypt(get_sha1prng_key(encrykey), certseq)
    print(certseqEncrypt)

    orgin = sorted_key([("ptycd", ptycd), ("ptyacct", ptyacct), ("certseq", certseqEncrypt), ("timestamp", timestamp),
                        ("biztypdesc", biztypdesc), ("biztyp", biztyp), ("placeid", placeid),
                        ("sourcechnl", sourcechnl)])
    orgin += encrykey
    sha512 = hashlib.sha512()
    sha512.update(orgin.encode('utf-8'))
    sign = sha512.hexdigest()

    url = "https://112.65.144.19:9085/servlet/json"

    headers = {
        'Content-Type': 'application/x-www-form-urlencoded',
    }

    data = {
        "usernm": usernm,
        "biztyp": biztyp,
        "certseq": base64.b64encode(
            urllib.parse.quote(aes_ecb_encrypt(get_sha1prng_key(encrykey), certseq), 'utf-8').encode("utf-8")).decode(
            'utf-8'),
        "ptycd": ptycd,
        "funcNo": funcNo,
        "placeid": placeid,
        "sign": sign,
        "sourcechnl": sourcechnl,
        "ptyacct": ptyacct,
        "biztypdesc": biztypdesc,
        "videopic": videopic.decode('utf-8'),
        "timestamp": timestamp
    }
    print(data)
    s = requests.session()

    s.keep_alive = False
    requests.adapters.DEFAULT_RETRIES = 1
    requests.packages.urllib3.disable_warnings()
    r = requests.post(url, data=data, headers=headers, verify=False)

    # print(r)
    # print(r.url)
    # print(r.json())

    # 解析json字符串
    data_result = json.dumps(eval(str(r.json())))
    data2 = json.loads(data_result)
    if data2["error_no"] == '0':
        print(str(data2["results"])[1:-1])
        results = json.loads(json.dumps(eval(str(data2["results"])[1:-1])))
        print("姓名：" + str(results["name"]))
        print("身份证号：" + str(results["certseq"]))
        print("认证结果：" + str(results["respinfo"]))
        print("成功！！！")

# usernm=%E5%A7%93%E5%90%8D&biztyp=A001&certseq=REdveVJmTlRCOVZpdFRzTSUyRlFTZXVRbkpLR1JTRTRWdiUyRkkwayUyQmc1V2hqYyUzRA%3D%3D&ptycd=ect888_public&funcNo=2000209&placeid=00&sign=c0d5862d5578d5ae5fcb09e354f5c1bb67082f6e499b6c7a4baf41be994b8f49013822374b96e61a3cb637d69d848d86b47bf3fc83ac49a8027259f8ab59b538&sourcechnl=0&ptyacct=ect888_public_demo&biztypdesc=%E5%AF%B9%E6%AF%94%E6%9C%8D%E5%8A%A1&timestamp=2019-03-08+20%3A06%3A55

# https://112.65.144.19:9085/servlet/json?usernm=%E6%B8%A4%E6%B5%B7%E4%B8%87&biztyp=A001&certseq=REM1N0IzMUQ2MkRGMEUyMDA5N0UwNTc0QUM4Q0RFQjQ3QkY4MjJEMkUyRTc4REU3NjE5OUU5MDEwQzA3QzhERg%3D%3D&ptycd=cgxyczbank&funcNo=2000209&placeid=00&sign=a3c0d2a753d33de8682c3e4f6fb2ca6c5fe062a465b88678d423e69a0be8f58a8aab98f8dcc5e1859e38c2526ba672150c071eb08ffc4ae796fdbff2c49062e0&sourcechnl=0&ptyacct=cgxyczbank01&biztypdesc=%E5%AF%B9%E6%AF%94%E6%9C%8D%E5%8A%A1&timestamp=2020-08-14+08%3A30%3A15
