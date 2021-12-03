package com.ect888.func327;

import com.ect888.bus.FunctionCommon;
import com.ect888.bus.impl.FunctionCommonImpl;
import com.ect888.config.Config;
import com.ect888.http.PoolClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 在网状态查询 SHA256 电信
 */
public class Function2000327Test {

    private static Log log = LogFactory.getLog(Function2000327Test.class);

    static final String FUNC_NO = "2000327";

    /**
     * 身份证号码SHA256
     * 必填
     */
    String certseq = "0680a4a36ca8ca8c387c90c45ff9f4eee6fea30b0dfb6007581977bec5910b8a";

    /**
     * 姓名SHA256
     * 必填
     */
    String usernm = "0680a4a36ca8ca8c387c90c45ff9f4eee6fea30b0dfb6007581977bec5910b8a";

    /**
     * 手机号SHA256
     * 必填
     */
    String phoneno = "0680a4a36ca8ca8c387c90c45ff9f4eee6fea30b0dfb6007581977bec5910b8a";

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
    String realUser = "真实用户";
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
        params.put(FunctionCommon.TO_SIGN_HEAD + "certseq", certseq);
        params.put(FunctionCommon.TO_SIGN_HEAD + "phoneno", phoneno);

        params.put(FunctionCommon.TO_SIGN_HEAD + "timestamp", timestamp);
        params.put(FunctionCommon.TO_SIGN_HEAD + "biztypdesc", biztypdesc);
        params.put(FunctionCommon.TO_SIGN_HEAD + "biztyp", biztyp);
        params.put(FunctionCommon.TO_SIGN_HEAD + "placeid", placeid);
        params.put(FunctionCommon.TO_SIGN_HEAD + "sourcechnl", sourcechnl);
        params.put(FunctionCommon.TO_SIGN_HEAD + "ptyacct", config.getPtyacct());
        params.put(FunctionCommon.TO_SIGN_HEAD + "ptycd", config.getPtycd());
        params.put("usernm", usernm);
        params.put("version", version);
        params.put("realUser", realUser);
        params.put("funcNo", FUNC_NO);
        params.put("scene", "01");
        params.put("version", "V2.0");

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
