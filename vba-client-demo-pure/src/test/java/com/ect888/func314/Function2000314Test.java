package com.ect888.func314;

import com.ect888.bus.FunctionCommon;
import com.ect888.bus.impl.FunctionCommonImpl;
import com.ect888.config.Config;
import com.ect888.http.PoolClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Function2000314Test {

    private static Log log = LogFactory.getLog(Function2000314Test.class);

    static final String FUNC_NO = "2000314";

    /**
     * 身份证正面照图片路径
     * 需用Base64编码
     * 不支持1MB以上的图片。
     */
    String image = Thread.currentThread().getContextClassLoader().getResource("").getPath() + File.separator + "passport.jpg";


    /**
     * 来源渠道，填固定值“0”
     * <p>
     * 参与签名
     */
    String sourcechnl = "0";
    /**
     * 业务发生地
     * 符合入参长度即可，不做技术限制
     * <p>
     * 参与签名
     */
    String placeid = "00";
    /**
     * 业务类型
     * 符合入参长度即可，不做技术限制
     * <p>
     * 参与签名
     */
    String biztyp = "A001";
    /**
     * 服务描述
     * <p>
     * 符合入参长度即可，不做技术限制
     * <p>
     * 参与签名
     */
    String biztypdesc = "对比服务";
    /**
     * 时间戳
     * <p>
     * 参与签名
     */
    String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    private Config config = Config.getInstance();

    private PoolClient client = PoolClient.getInstance();

    private FunctionCommonImpl funcCommon = FunctionCommonImpl.getInstance();

    /**
     * 将入参，按照http post上送和签名规则，放入map内
     * <p>
     * <p>
     * 调用2000202接口时的签名过程：
     * 上送参数（biztyp,biztypdesc,certseq，placeid,ptyacct,ptycd,sourcechnl,timestamp,key(会话密钥)），其中key前面的是按照字母排序的，key则是要最后附加上去。其中在签名的时候身份证号需要利用会话密钥进行AES加密。
     * 生成的防篡改签名sign在接口调用时和业务参数一起上传。"
     * <p>
     * 调用2000202比对查询接口：上送参数（biztyp,biztypdesc,certseq,placeid,ptyacct,ptycd,sourcechnl,timestamp, videopic, usernm,funcNo,sign(签名)）
     * ，传上述参数时的身份证号要进行以下处理，步骤为：[a]，用会话密钥加密(AES加密方法);[b].URLEncoder.encode（[a]中加密串）;[c],base64（[b]中字符串）  ,身份证正面照需用Base64编码，传上述参数的时候没有顺序要求的。
     *
     * @return 将入参，按照http post上送和签名规则，放入map内
     */
    private Map<String, String> buildParams() {
        Map<String, String> params = new HashMap<String, String>();

        params.put(FunctionCommon.TO_PIC_BASE64_HEAD + "image", image);

        params.put(FunctionCommon.TO_SIGN_HEAD + "timestamp", timestamp);
        params.put(FunctionCommon.TO_SIGN_HEAD + "biztypdesc", biztypdesc);
        params.put(FunctionCommon.TO_SIGN_HEAD + "biztyp", biztyp);
        params.put(FunctionCommon.TO_SIGN_HEAD + "placeid", placeid);
        params.put(FunctionCommon.TO_SIGN_HEAD + "sourcechnl", sourcechnl);

        params.put(FunctionCommon.TO_SIGN_HEAD + "ptyacct", config.getPtyacct());
        params.put(FunctionCommon.TO_SIGN_HEAD + "ptycd", config.getPtycd());

        params.put("funcNo", FUNC_NO);

        return params;
    }

    /**
     * 模拟调用
     */
    public void doWork() {

        Map<String, String> params = buildParams();
        //加密加签,发起post请求，UrlEncodedFormEntity方式，选择相信服务端ssl证书，忽略证书认证
        String result = funcCommon.invoke(params);


    }

    @Test
    public void test() {
        try {
            doWork();
        } catch (RuntimeException e) {
            log.error("运行时异常", e);
        } finally {
            //应用结束，关闭长连接及其连接池
            client.destroy();
            client.getConnManager().destroy();
        }
    }

    @Before
    public void before() {
        String log4jFileStr = "log4j.properties";
        PropertyConfigurator.configure(log4jFileStr);
    }
}