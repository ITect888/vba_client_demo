package com.ect888.func347;

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

/**
 * @ClassName Function2000347Test
 * @Date 2022/9/22 17:07
 **/
public class Function2000347Test {

    private static Log log = LogFactory.getLog(Function2000347Test.class);

    static final String FUNC_NO = "2000347";

    /**
     * 港澳台居住证图片路径
     * 需用Base64编码
     * 建议转换成base64字符串后大小控制在50K-100K
     */
    String image = Thread.currentThread().getContextClassLoader().getResource("").getPath() + File.separator + "港澳台居住证模板.jpg";

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
    String biztypdesc = "证通港澳台居民居住证OCR";

    /**
     * 业务发生地
     * 符合入参长度即可，不做技术限制
     * <p>
     * 参与签名
     */
    String placeid = "00";

    /**
     * 来源渠道，填固定值“0”
     * <p>
     * 参与签名
     */
    String sourcechnl = "0";

    /**
     * 时间戳
     * <p>
     * 参与签名
     */
    String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    private Config config = Config.getInstance();

    private PoolClient client = PoolClient.getInstance();

    private FunctionCommonImpl funcCommon = FunctionCommonImpl.getInstance();

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

    /**
     * 模拟调用
     */
    public void doWork() {

        Map<String, String> params = buildParams();
        //加密加签,发起post请求，UrlEncodedFormEntity方式，选择相信服务端ssl证书，忽略证书认证
        String result = funcCommon.invoke(params);

        log.info("港澳台居住证oct接口响应：" + result);
    }

    @Before
    public void before() {
        String log4jFileStr = "log4j.properties";
        PropertyConfigurator.configure(log4jFileStr);
    }

    /**
     * 将入参，按照http post上送和签名规则，放入map内
     * <p>
     * 调用2000347接口时的签名过程：
     * 上送参数（biztyp,biztypdesc,placeid,ptyacct,ptycd,sourcechnl,timestamp,key(会话密钥)），其中key前面的是按照字母排序的，key则是要最后附加上去。
     * 其中在签名的时候身份证号需要利用会话密钥进行AES加密。
     * 生成的防篡改签名sign在接口调用时和业务参数一起上传。
     * <p>
     * 调用2000347比对查询接口：上送参数（biztyp,biztypdesc,placeid,ptyacct,ptycd,sourcechnl,timestamp, image,funcNo,sign(签名)）
     * ，证件照需用Base64编码，传上述参数的时候没有顺序要求的。
     *
     * @return 将入参，按照http post上送和签名规则，放入map内
     */
    private Map<String, String> buildParams() {
        Map<String, String> params = new HashMap<String, String>();
        //组装报文
        params.put(FunctionCommon.TO_SIGN_HEAD + "biztyp", biztyp);//对照接口文档查看
        params.put(FunctionCommon.TO_SIGN_HEAD + "biztypdesc", biztypdesc);//服务描述
        params.put(FunctionCommon.TO_SIGN_HEAD + "placeid", placeid);//业务发生地
        params.put(FunctionCommon.TO_SIGN_HEAD + "ptyacct", config.getPtyacct());//机构帐号
        params.put(FunctionCommon.TO_SIGN_HEAD + "ptycd", config.getPtycd());//机构号
        params.put(FunctionCommon.TO_SIGN_HEAD + "sourcechnl", sourcechnl);//来源渠道，pc端传0
        params.put(FunctionCommon.TO_SIGN_HEAD + "timestamp", timestamp);

        params.put("funcNo", FUNC_NO);//单笔请求业务BUS功能号
        params.put(FunctionCommon.TO_PIC_BASE64_HEAD + "image", image);//图片base64编码

        return params;
    }
}