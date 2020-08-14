import datetime
import hashlib
import requests
import urllib.parse
from base64 import b64encode

from Crypto.Cipher import AES

BS = AES.block_size


def sorted_key(value):
    a = sorted(value, key=lambda x: x[0])
    b = ""
    for i in range(len(a)):
        b += (a[i][0] + a[i][1])
    return b


def padding_pkcs5(value):
    return str.encode(value + (BS - len(value) % BS) * chr(BS - len(value) % BS))


def padding_zero(value):
    while len(value) % 16 != 0:
        value += '\0'
    return str.encode(value)


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
    encrykey = "Ig685ldbNCWAGMxb9tnGJbhysEkvYn"
    ptycd = "cgxyczbank"
    ptyacct = "cgxyczbank01"
    usernm = "渤海万"
    certseq = "412427199001011212"
    timestamp = str(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S'))
    biztypdesc = "对比服务"
    biztyp = "A001"
    placeid = "00"
    sourcechnl = "0"
    funcNo = "2000209"
    certseqEncrypt = aes_ecb_encrypt(get_sha1prng_key(encrykey), certseq)
    orgin = sorted_key(
        [("ptycd", ptycd), ("ptyacct", ptyacct), ("certseq", certseqEncrypt),
         ("timestamp", timestamp), ("biztypdesc", biztypdesc), ("biztyp", biztyp), ("placeid", placeid),
         ("sourcechnl", sourcechnl)])
    orgin += encrykey
    sha512 = hashlib.sha512()
    sha512.update(orgin.encode('utf-8'))
    sign = sha512.hexdigest()

    url = "https://112.65.144.19:9085/servlet/json"
    headers = {
        "Content-Type": "application/x-www-form-urlencoded"
    }
    data = {
        "usernm": usernm,
        "biztyp": biztyp,
        "ptycd": ptycd,
        "ptyacct": ptyacct,
        "funcNo": funcNo,
        "biztypdesc": biztypdesc,
        "placeid": placeid,
        "sourcechnl": sourcechnl,
        "timestamp": timestamp,
        "sign": sign,
        "certseq": b64encode(urllib.parse.quote(aes_ecb_encrypt(get_sha1prng_key(encrykey),
                                                                certseq)).encode('utf-8')).decode('utf-8')
    }
    print(data)
    requests.packages.urllib3.disable_warnings()
    r = requests.post(url, params=data, headers=headers, verify=False)
    print(r.json())
