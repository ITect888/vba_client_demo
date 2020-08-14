from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_v1_5 as Cipher_pkcs1_v1_5
import requests
from base64 import b64decode,b64encode
import urllib.parse as url_lib

ptyacct = "acctforzhudj"
ptycd = "cdforzhudj"
pwd = "12345678"
encrykey = "ect888ect888ect888"
public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCCIjEFl2tn3W9GssK0iDju2ILU5UlLwinOEy7CiZAF9Q/gYXPoAr8AWx3gQ8UVAszAEw1X25Qa2TPq63/boiLip6299pbzpCAToFFHzNhZT6SFm0HDvOQWJxs8k/kUDDMRF+TUbf9NJekhtg87bbMAB68fi3/jreeYJ7OYC5ZKSwIDAQAB"

data = "ptyacct=" + ptyacct + "&ptycd=" + ptycd + "&ptypwd=" + pwd + "&encrykey="+encrykey


def encrypt_msg(message, public_key):
    rsa_key = RSA.importKey(b64decode(public_key))
    encryptor = Cipher_pkcs1_v1_5.new(rsa_key)
    encry_data = encryptor.encrypt(message.encode('utf-8'))
    return encry_data


if __name__ == "__main__":
    data = encrypt_msg(data, public_key)
    data = b64encode(data).decode('utf-8')
    data = b64encode(url_lib.quote(data).encode('utf-8')).decode('utf-8')
    url = "https://112.65.144.19:9085/servlet/json"

    headers = {
        "Content-Type": "application/x-www-form-urlencoded"
    }
    param = {
        "funcNo": "2000002",
        "reqdata": data
    }
    requests.packages.urllib3.disable_warnings()
    r = requests.post(url, params=param, headers=headers, verify=False)
    print(r.json())
