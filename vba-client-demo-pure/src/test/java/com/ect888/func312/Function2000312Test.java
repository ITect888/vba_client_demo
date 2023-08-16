package com.ect888.func312;

import com.ect888.bus.FunctionCommon;
import com.ect888.bus.impl.FunctionCommonImpl;
import com.ect888.config.Config;
import com.ect888.http.PoolClient;
import com.ect888.util.SHA256;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 联通SHA310
 */
public class Function2000312Test {

    private static Log log = LogFactory.getLog(Function2000312Test.class);

    static final String FUNC_NO = "2000312";



    /**
     * 身份证号码
     * 必填
     */
    String idCard = "330482202107281212";

    /**
     * 姓名
     * 必填
     */
    String userName = "姓名";

    /**
     * 手机号
     * 必填
     */
    String mobile = "12345678901";
    /**
     * 来源渠道，填固定值“0”
     * 参与签名
     */
    String sourcechnl = "0";
    /**
     * 业务发生地
     * 符合入参长度即可，不做技术限制
     * 参与签名
     */
    String placeid = "00";
    /**
     * 服务类型
     * 符合入参长度即可，不做技术限制
     * 参与签名
     */
    String biztyp = "A001";
    /**
     * 服务描述
     * 符合入参长度即可，不做技术限制
     * 参与签名
     */
    String biztypdesc = "对比服务";
    /**
     * 版本
     * 必填
     */
    String version = "2.0";
    /**
     * 真实用户
     * 必填
     */
    String realUser = "证通股份";
    /**
     * 应用场景
     * 必填
     */
    String scene = "01";
    /**
     * 时间戳
     * <p>
     * 参与签名
     */
    String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    private Config config = Config.getInstance();

    private PoolClient client = PoolClient.getInstance();

    private FunctionCommonImpl funcCommon = FunctionCommonImpl.getInstance();

    private Map<String, String> buildParams() {

        Map<String, String> params = new HashMap();
        params.put(FunctionCommon.TO_SIGN_HEAD + "idCardSHA256", SHA256.getSha256(idCard.getBytes(StandardCharsets.UTF_8)));
        params.put(FunctionCommon.TO_SIGN_HEAD + "mobileSHA256", SHA256.getSha256(mobile.getBytes(StandardCharsets.UTF_8)));
        params.put(FunctionCommon.TO_SIGN_HEAD + "timestamp", timestamp);
        params.put(FunctionCommon.TO_SIGN_HEAD + "biztypdesc", biztypdesc);
        params.put(FunctionCommon.TO_SIGN_HEAD + "biztyp", biztyp);
        params.put(FunctionCommon.TO_SIGN_HEAD + "placeid", placeid);
        params.put(FunctionCommon.TO_SIGN_HEAD + "sourcechnl", sourcechnl);
        params.put(FunctionCommon.TO_SIGN_HEAD + "ptyacct", config.getPtyacct());
        params.put(FunctionCommon.TO_SIGN_HEAD + "ptycd", config.getPtycd());
        params.put("userNameSHA256", SHA256.getSha256(userName.getBytes(StandardCharsets.UTF_8)));
        params.put("version", version);
        params.put("realUser", realUser);
        params.put("funcNo", FUNC_NO);
        params.put("scene", scene);

        return params;
    }

    /**
     * 模拟调用
     */
    public void doWork() {

        Map<String, String> params = buildParams();
        //加密加签,发起post请求，UrlEncodedFormEntity方式，选择相信服务端ssl证书，忽略证书认证
        String result = funcCommon.invoke(params);
        System.out.println("结果=" + result);
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
