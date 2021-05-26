package com.xidian.attackmodel;

/**
 * @Author: quan
 * @Date: 2021/05/26/9:27
 * @Description:
 */
public class DataMethod {
    int id;
    String method;
    String wordRemark;
    String picRemark;

    public DataMethod(int id, String method, String wordRemark, String picRemark) {
        this.id = id;
        this.method = method;
        this.wordRemark = wordRemark;
        this.picRemark = picRemark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getWordRemark() {
        return wordRemark;
    }

    public void setWordRemark(String wordRemark) {
        this.wordRemark = wordRemark;
    }

    public String getPicRemark() {
        return picRemark;
    }

    public void setPicRemark(String picRemark) {
        this.picRemark = picRemark;
    }
}
