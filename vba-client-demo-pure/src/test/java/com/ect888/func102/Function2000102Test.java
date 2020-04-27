package com.ect888.func102;

import com.alibaba.fastjson.JSON;
import com.ect888.config.Config;
import com.ect888.http.PoolClient;
import com.ect888.util.SignatureUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Function2000102Test {


    private static Log log = LogFactory.getLog(Function2000102Test.class);

    static final String FUNC_NO="2000102";
    private PoolClient client=PoolClient.getInstance();

    /**
     * 因循环获取  如 1 2 4 8 16秒间隔
     * @param result
     */
    public void doWork(String result){
        CommResp json= JSON.parseObject(result,CommResp.class);
        String sysSeqNub = json.getResults().get(0).getSysseqnb();

        Map<String,String> map = new HashMap<>();
        map.put("sysseqnb",sysSeqNub);
        map.put("ptyacct",Config.ptyacct);
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        map.put("timestamp",timestamp);

        String sign = SignatureUtil.signature(map,Config.ptyKey);
        map.put("sign",sign);
        map.put("funcNo",FUNC_NO);
        try {
            //延时获取
            Thread.sleep(3000);
            String resp  =  client.post(Config.url,map);
            log.info("返回应答："+resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
