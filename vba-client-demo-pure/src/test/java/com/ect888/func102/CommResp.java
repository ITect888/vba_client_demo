package com.ect888.func102;

import java.util.List;

public class CommResp {


    /**
     * error_info :
     * dsName : ["results"]
     * results : [{"sysseqnb":"19103520200426621813080001"}]
     * error_no : 0
     */

    private String error_info;
    private String error_no;
    private List<String> dsName;
    private List<ResultsBean> results;

    public String getError_info() {
        return error_info;
    }

    public void setError_info(String error_info) {
        this.error_info = error_info;
    }

    public String getError_no() {
        return error_no;
    }

    public void setError_no(String error_no) {
        this.error_no = error_no;
    }

    public List<String> getDsName() {
        return dsName;
    }

    public void setDsName(List<String> dsName) {
        this.dsName = dsName;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * sysseqnb : 19103520200426621813080001
         */

        private String sysseqnb;

        public String getSysseqnb() {
            return sysseqnb;
        }

        public void setSysseqnb(String sysseqnb) {
            this.sysseqnb = sysseqnb;
        }
    }
}
