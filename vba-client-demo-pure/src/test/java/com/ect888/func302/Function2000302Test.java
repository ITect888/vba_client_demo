package com.ect888.func302;

import com.alibaba.fastjson.JSON;
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
 * 2000302 运营商风险用户核验
 * 示例代码
 */
public class Function2000302Test {

    static final String FUNC_NO = "2000302";

    /**
     * 手机号码
     * 参与签名
     */
    String phoneno = "17621784178";

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
     * 对照接口文档查看
     * 符合入参长度即可，不做技术限制
     * 参与签名
     */
    String biztyp = "A001";
    /**
     * 服务描述
     * 符合入参长度即可，不做技术限制
     * 参与签名
     */
    String biztypdesc = "运营商风险用户核验";
    /**
     * 时间戳
     * <p>
     * 参与签名
     */
    String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    /**
     * 模拟调用
     */
    public void doWork() {

        Map<String, String> params = buildParams();
        //加密加签,发起post请求，UrlEncodedFormEntity方式，选择相信服务端ssl证书，忽略证书认证
        String result = funcCommon.invoke(params);

        //解析返回数据并处理
        processResult(result);
    }

    /**
     * 将入参，按照http post上送和签名规则，放入map内
     * <p>
     * <p>
     * 上送参数（biztyp,biztypdesc,phoneno,placeid,ptyacct,ptycd,sourcechnl,timestamp,funcNo,sign(会话密钥)），传上述参数的时候没有顺序要求的  。
     * <p>
     * 签名过程：加签的参数（biztyp,biztypdesc,phoneno,placeid,ptyacct,ptycd,sourcechnl,timestamp,key(会话密钥)），其中key前面的是按照字母排序的
     * ，key则是要最后附加上去。其中参与签名的姓名、手机号为AES加密后的。
     *
     * @return 将入参，按照http post上送和签名规则，放入map内
     */
    private Map<String, String> buildParams() {
        Map<String, String> params = new HashMap<String, String>();

        params.put(FunctionCommon.TO_SIGN_HEAD+"phoneno", phoneno);
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
     * json结果result的解析并处理
     *
     * @param result
     */
    private void processResult(String result) {
        Json302 json = JSON.parseObject(result, Json302.class);

        if (null == json) {
            log.error("返回报文解析为null,配置为" + JSON.toJSONString(config));
            return;
        }

        if ("0".equals(json.getError_no())) {//系统级调用成功
            if (json.getResults().isEmpty() || null == json.getResults().get(0))//异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端
                throw new IllegalStateException("异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端");

            Result302 re = json.getResults().get(0);
            log.info("业务应答码respcd=" + re.getRespcd());
            log.info("业务应答信息respinfo=" + re.getRespinfo());
        } else {//系统级调用失败，异常，查看入参或者联系服务端
            throw new IllegalStateException("系统级调用失败，异常，查看入参或者联系服务端");
        }

    }

    private Config config = Config.getInstance();

    private PoolClient client = PoolClient.getInstance();

    private FunctionCommonImpl funcCommon = FunctionCommonImpl.getInstance();

    private static Log log = LogFactory.getLog(Function2000302Test.class);

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
