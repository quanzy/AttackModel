package com.xidian.attackmodel;

/**
 * @Author: quan
 * @Date: 2021/05/21/14:44
 * @Description:
 */
public class AttackType {
    int id;
    String typeName;

    public AttackType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
