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


//测试公钥
$publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCCIjEFl2tn3W9GssK0iDju2ILU5UlLwinOEy7CiZAF9Q/gYXPoAr8AWx3gQ8UVAszAEw1X25Qa2TPq63/boiLip6299pbzpCAToFFHzNhZT6SFm0HDvOQWJxs8k/kUDDMRF+TUbf9NJekhtg87bbMAB68fi3/jreeYJ7OYC5ZKSwIDAQAB";
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
//$ptyKey ="ehk34sssss2344121jX";


$aes = new AES();
$utils =  new Utils();
$aesAcctNo = $aes->encrypt($acctNo,$ptyKey);
$aesCertSeq = $aes->encrypt($certSeq,$ptyKey);
echo 'aes:<br>acctNo->'.$aesAcctNo.'<br>certSeq->'.$aesCertSeq.'<br><br>';

$base64AcctNo=$utils->getBase64($aesAcctNo);
$base64CertSeq=$utils->getBase64($aesCertSeq);

/*
$base64AcctNo=base64_encode(ord(urlencode(utf8_encode($aesAcctNo))));
$base64CertSeq=base64_encode(ord(urlencode(utf8_encode($aesCertSeq))));
*/
echo 'base64:<br>acctNo->'.$base64AcctNo.'<br>certSeq->'.$base64CertSeq.'<br><br>';


$param = array(
	"acctno"=> $aesAcctNo,
	"biztyp"=> "0541",//对照接口文档查看
	"biztypdesc"=> "银行卡认证",//服务描述
	"certseq"=> $aesCertSeq,//身份证号
	"code"=> "",//短信验证码 .如不调用短信，这里可以传空字符
	"phoneno"=> "13411112222",//手机号			
	"sysseqnb"=> "",//调用生成短信接口返回的业务流水号 .如不调用短信，这里可以传空字符
	"placeid"=> "330104",//业务发生地
	"ptyacct"=> $ptyAcct,//机构帐号
	"ptycd"=> $ptyCD,//机构号
	"sourcechnl"=> "0"//来源渠道，pc端传0
);

//////////////////////根据key大小写重新排序 start//////////////////////////////
	$keysArray=array_keys($param);
	echo '<br>-----------------------------------<br>';
	print_r($keysArray);
	echo '<br>-----------------------------------<br>';
	asort($keysArray);
	reset($keysArray);
	print_r($keysArray);
	echo '<br>-----------------------------------<br>';
	
	
	$paramSorted=array();
	echo '<br>-----';
	foreach($keysArray as $k=>$v){
		echo $k.'=>'.$v.'|';
		$paramSorted[$v]=$param[$v];
	}
	echo '----<br>';
	
//////////////////////根据key大小写重新排序 end//////////////////////////////

	$sign=$utils->signature($paramSorted,$ptyKey);
	echo 'sign:<br>'.$sign.'<br>目标值：<br>';
	echo 'e4c56777f33b2195b768fb43cea2cd246754a83fbf1db44cbe9ea21fc52c3f1b4153cb2d1585592baa1373ca742d79ff3986f98fe80b7b8c46292e4b1824fa83';
	echo '<br><br>';
	
	$param["sign"]=$sign;//防篡改密钥
	$param["funcNo"]="2000207";//单笔请求业务BUS功能号
	$param["acctno"]=$base64AcctNo;
	$param["certseq"]=$base64CertSeq;//身份证号
	$param["usernm"]="李四";//姓名



	$reqRespData=$utils->curl_post($url,$param);

	echo '<br>resp-json:'.$reqRespData;

	?>