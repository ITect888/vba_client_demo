<?php
class AES {
    /**
     *
     * @param string $string 需要加密的字符串
     * @param string $key 密钥
     * @return string
     */
    public function encrypt($string, $key){
        // 对接java，AES加密通过SHA1PRNG算法（只要password一样，每次生成的数组都是一样的）
        $key = substr(openssl_digest(openssl_digest($key, 'sha1', true), 'sha1', true), 0, 16);
        // openssl_encrypt 加密不同Mcrypt，对秘钥长度要求，超出16加密结果不变
        $data = openssl_encrypt($string, 'AES-128-ECB', $key, OPENSSL_RAW_DATA);
        //echo '$data->'.$data;
        $data = base64_encode($data);
        return $data;
    }


    /**
     * @param string $string 需要解密的字符串
     * @param string $key 密钥
     * @return string
     */
    public function decrypt($string, $key){
        $key = substr(openssl_digest(openssl_digest($key, 'sha1', true), 'sha1', true), 0, 16);
        $decrypted = openssl_decrypt(base64_decode($string), 'AES-128-ECB', $key, OPENSSL_RAW_DATA);
        return $decrypted;
    }
}

class Utils{
		
	 /*
         * 以下代码获取字节码
        */
	public function getBytes($str) {  
        $bytes = array();
        for($i = 0; $i < strlen($str); $i++){  
             $bytes[] = ord($str[$i]);  
        }  
        /*
        echo 'getBytes:<br>';
        print_r($bytes);
        echo '<br><br>';
        */
        return $bytes;
    }  
	
    public function signature($param,$key){
    	$paramLen=sizeof($param);    	
    	$strOrigin="";    	
    	if($paramLen <1){
    		return 'err:param should not be null';
    	}
    	
    	foreach($param as $k => $v){
		$strOrigin=$strOrigin.$k.$v;
    	}
    
    	$strOrigin=$strOrigin.$key;
	echo 'signature origin:<br>'.$strOrigin.'<br><br>';
    	return hash( 'sha512',$strOrigin);
    	//return openssl_digest($strOrigin, 'sha512');
    }
    public function getBase64($str){
    	return base64_encode(urlencode(utf8_encode($str)));
    } 
    
    public function decryptBase64($str){
    	return base64_decode($str);
    } 
    public function cryptBase64($str){
    	return base64_encode(utf8_encode($str));
    } 
    
    public function encryptByPublicKey($data,$key){
    	
    }
    
	/*
     *   php访问url路径，post请求
     *
     *   durl   路径url
     *   post_data   array()   post参数数据
     */
    public function curl_post($durl, $post_data){
        // header传送格式
        /*
        $headers = array(
            "token:1111111111111",
            "over_time:22222222222",
        );
        */
        //初始化
        $curl = curl_init();
        //设置抓取的url
        curl_setopt($curl, CURLOPT_URL, $durl);
        //设置头文件的信息作为数据流输出
        curl_setopt($curl, CURLOPT_HEADER, false);
        //设置获取的信息以文件流的形式返回，而不是直接输出。
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
        //设置post方式提交
        curl_setopt($curl, CURLOPT_POST, true);
        // 设置post请求参数
        curl_setopt($curl, CURLOPT_POSTFIELDS, $post_data);
        // 添加头信息
        //curl_setopt($curl, CURLOPT_HTTPHEADER, $headers);
        // CURLINFO_HEADER_OUT选项可以拿到请求头信息
        curl_setopt($curl, CURLINFO_HEADER_OUT, true);
        // 不验证SSL
        curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, FALSE);
        curl_setopt($curl, CURLOPT_SSL_VERIFYHOST, FALSE);
        //执行命令
        $data = curl_exec($curl);
        // 打印请求头信息
//        echo curl_getinfo($curl, CURLINFO_HEADER_OUT);
        //关闭URL请求
        curl_close($curl);
        //显示获得的数据
        return $data;
    }
}


//测试公钥//请注意格式不要换行
$publicKey='MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCCIjEFl2tn3W9GssK0iDju2ILU5UlLwinOEy7CiZAF9Q/gYXPoAr8AWx3gQ8UVAszAEw1X25Qa2TPq63/boiLip6299pbzpCAToFFHzNhZT6SFm0HDvOQWJxs8k/kUDDMRF+TUbf9NJekhtg87bbMAB68fi3/jreeYJ7OYC5ZKSwIDAQAB';

//这里请注意格式，确保一致，否则报错
$publicKey='
-----BEGIN PUBLIC KEY-----
'.$publicKey.'
-----END PUBLIC KEY-----
';

//访问地址    测试环境 
$url="https://112.65.144.19:9085/servlet/json"; 
$acctNo ="6217001210031656620";
$certSeq = "342422199203247574";
//机构帐号
$ptyAcct="acctforzhouxx";
//机构号
$ptyCD="cdforzhouxx";
//会话密钥
$ptyKey ="8f20363268a09922e760b83df1f8d1b1";


$aes = new AES();
$utils =  new Utils();

$data = "ptyacct=".$ptyAcct."&ptycd=".$ptyCD."&ptypwd=xnt123456&encrykey=".$ptyKey;
$encrypted = "";

//这个函数取公钥
$pubKey = openssl_pkey_get_public($publicKey);

echo '$pu_key:<br>';
print_r(openssl_pkey_get_details($pubKey));
echo '<br><br>';

openssl_public_encrypt ($data,$encrypted,$pubKey,OPENSSL_PKCS1_PADDING);

$encrypted=base64_encode($encrypted);
echo '$data值:<br>'.$data.'<br>';
echo '$encrypted计算值:<br>'.$encrypted.'<br>';

$encrypted=urlencode($encrypted);
echo '$encrypted-encode值:<br>'.$encrypted.'<br>';

$encrypted=base64_encode($encrypted);
echo '$encrypted-encode-base64-encode值:<br>'.$encrypted.'<br>';


$param=array(
	"funcNo"=>"2000002",
	"reqdata" => $encrypted
	);


	$reqRespData=$utils->curl_post($url,$param);
	echo '<br>resp-json:'.$reqRespData;
?>