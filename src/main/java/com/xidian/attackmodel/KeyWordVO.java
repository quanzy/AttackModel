package com.xidian.attackmodel;

/**
 * @Author: quan
 * @Date: 2021/05/24/16:00
 * @Description:
 */
public class KeyWordVO {
    String keyword;
    int type;

    public KeyWordVO(String keyword, int type) {
        this.keyword = keyword;
        this.type = type;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
