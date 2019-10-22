<template>
  <div>{{ msg }}</div>
</template>

<script>
import CryptoJS from "crypto-js";
import api from "@/utils/api";

export default {
  name: "HelloWorld",
  data() {
    return {
      msg: "#",
      //公钥
      publicKey:
        "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCCIjEFl2tn3W9GssK0iDju2ILU5UlLwinOEy7CiZAF9Q/gYXPoAr8AWx3gQ8UVAszAEw1X25Qa2TPq63/boiLip6299pbzpCAToFFHzNhZT6SFm0HDvOQWJxs8k/kUDDMRF+TUbf9NJekhtg87bbMAB68fi3/jreeYJ7OYC5ZKSwIDAQAB",
      //测试接口url
      url: "https://112.65.144.19:9085/servlet/json",
      //银行账号
      acctNo: "6217001210031656620",
      //身份证号
      certSeq: "342422199203247574",
      //机构账号
      ptyAcct: "acctforzhouxx",
      //机构号
      ptyCD: "cdforzhouxx",
      //会话密钥
      ptyKey: "8f20363268a09922e760b83df1f8d1b1"
    };
  },
  mounted() {
    //this.doMount();

    //////aes-start////////////////////////////////////////////////////////////////////////
    let aesCertSeq = this.encrypt(this.certSeq);

    let certSeqBase64 = CryptoJS.enc.Base64.stringify(
      CryptoJS.enc.Utf8.parse(encodeURIComponent(aesCertSeq))
    );

    console.log("certSeqBase64",certSeqBase64);


    let aesAcctNo = this.encrypt(this.acctNo);
    let acctNoBase64 = CryptoJS.enc.Base64.stringify(
      CryptoJS.enc.Utf8.parse(encodeURIComponent(aesAcctNo))
    );

    console.log("acctNoBase64",acctNoBase64);

    // this.msg = aesAcctNo;

    //////aes-end////////////////////////////////////////////////////////////////////////

    //////signature-start//////////////////////////////////////////////////////////////////////////////////
    let jsonSrc = {
      acctno: aesAcctNo,
      biztyp: "0541", //对照接口文档查看
      biztypdesc: "银行卡认证", //服务描述
      certseq: aesCertSeq, //身份证号
      code: "", //短信验证码 .如不调用短信，这里可以传空字符
      phoneno: "13411112222", //手机号
      sysseqnb: "", //调用生成短信接口返回的业务流水号 .如不调用短信，这里可以传空字符
      placeid: "330104", //业务发生地
      ptyacct: this.ptyAcct, //机构帐号
      ptycd: this.ptyCD, //机构号
      sourcechnl: "0" //来源渠道，pc端传0
    };

    let signDes = this.getSignature(jsonSrc);

    signDes = signDes.toString();
    this.msg = signDes;

    //////signature-end////////////////////////////////////////////////////////////////////////////////////////

    let jsonParam = Object.assign(
      {
        "sign": signDes, //防篡改密钥
        "funcNo": "2000207", //单笔请求业务BUS功能号
        "usernm": "李四" //姓名
      },
      jsonSrc
    );

    jsonParam.acctno=encodeURIComponent(acctNoBase64);
    jsonParam.certseq=encodeURIComponent(certSeqBase64);


    this.$forceUpdate();

    console.log("jsonParam->", jsonParam);
    api.post({
      url: this.url,
      async: false,
      data: jsonParam,
      succ: function(data) {
        console.log("req-succ->", data);
      },
      fail: function(data) {
        console.log("req-fail->", data);
      }
    });

    // let acctNoUrlEncode=encodeURIComponent(acctNoBase64);

    // acctNoBase64 = CryptoJS.enc.Base64.stringify(
    //   CryptoJS.enc.Utf8.parse(acctNoUrlEncode)
    // );

    // this.msg = acctNoUrlEncode;

    // this.msg=this.encrypt(this.acctNo);
    // this.msg+="<<<<>>>>"
    // this.msg+=this.encrypt(this.certSeq);
  },
  methods: {
    getSignSrc(jsonObj, key) {
      key = key ? key : this.ptyKey;
      let arr = [];
      for (let key in jsonObj) {
        arr.push(key);
      }
      console.log("arr-sort->", arr, arr.sort());
      arr.sort();
      let str = "";
      for (let i in arr) {
        str += arr[i] + jsonObj[arr[i]];
      }
      return str + key;
    },
    getSignature(jsonSrc, key) {
      let signSrc = this.getSignSrc(jsonSrc);
      console.log("jsonSrc->", jsonSrc);
      console.log("signSrc->", signSrc);

      let signDes = CryptoJS.SHA512(signSrc);
      console.log("signDes->", signDes);

      return signDes;
    },
    getSHA1PRNG(keyStr) {
      keyStr = keyStr ? keyStr : this.ptyKey;
      let result = CryptoJS.SHA1(keyStr);
      console.log("getSHA1PRNG-shal-1->", result, result.toString());
      result = CryptoJS.SHA1(result);
      console.log("getSHA1PRNG-shal-2->", result, result.toString());

      console.log("getSHA1PRNG-3->", result, result.toString());
      result = result.toString().substring(0, 32);
      console.log("getSHA1PRNG-3-1->", result, result.toString());
      // result=result.toString(CryptoJS.enc.Utf8);
      // console.log('getSHA1PRNG-3-2->',result,result.toString());

      // result=result.toString();
      // console.log('getSHA1PRNG->',result);

      // let resultDestination=Object.assign({},result);
      // let words=result.words;
      // words=words.slice(0,2);
      // resultDestination['words']=words;
      // console.log('getSHA1PRNG-3->',resultDestination,resultDestination.toString());

      return result;
    },

    encrypt(src, keyStr) {
      console.log("encrypt:");
      console.log("src->", src);
      console.log("key->", keyStr);
      keyStr = keyStr ? keyStr : this.ptyKey;
      keyStr = this.getSHA1PRNG(keyStr);
      console.log("keyStr->", keyStr);

      // let key = keyStr;
      let key = CryptoJS.enc.Hex.parse(keyStr);
      console.log("key->", key);

      let srcs = CryptoJS.enc.Utf8.parse(src);
      console.log("srcs->", srcs);

      let encrypted = CryptoJS.AES.encrypt(srcs, key, {
        mode: CryptoJS.mode.ECB,
        padding: CryptoJS.pad.Pkcs7
      });
      console.log("encrypted->", encrypted);

      //下面为了明文显示加密值
      let result = encrypted.toString();
      console.log("result->", result);

      console.log();

      return result;

      //return CryptoJS.enc.Base64.stringify(result).toString();
    }
    // ,
    //解密
    // decrypt(src, keyStr){
    //   console.log("decrypt:");
    //   console.log("src->",src);
    //   console.log("key->",keyStr);
    //   keyStr = keyStr ? keyStr : this.ptyKey;
    //   keyStr = this.getSHA1PRNG(keyStr);

    //   let key  = CryptoJS.enc.Utf8.parse(keyStr);//Latin1 w8m31+Yy/Nw6thPsMpO5fg==
    //   let decrypt = CryptoJS.AES.decrypt(src, key, {mode:CryptoJS.mode.ECB,padding: CryptoJS.pad.Pkcs7});
    //   let result=CryptoJS.enc.Utf8.stringify(decrypt).toString()
    //   console.log("result->",result);

    //   return result;
    // }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
