package com.lichao.chaovolley;

/**
 * Created by Administrator on 2018-02-01.
 */

public class NewsPager {
    private String reason;
    private Pager result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Pager getResult() {
        return result;
    }
    @Override
    public String toString() {
        return "NewsPager{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public void setResult(Pager result) {

        this.result = result;
    }
}
