package com.xidian.attackmodel;

/**
 * @Author: quan
 * @Date: 2021/05/21/10:33
 * @Description:
 */
public class GatherMessage {
    String inGather;
    String outGather;

    public GatherMessage(String inGather, String outGather) {
        this.inGather = inGather;
        this.outGather = outGather;
    }

    public String getInGather() {
        return inGather;
    }

    public void setInGather(String inGather) {
        this.inGather = inGather;
    }

    public String getOutGather() {
        return outGather;
    }

    public void setOutGather(String outGather) {
        this.outGather = outGather;
    }
}
