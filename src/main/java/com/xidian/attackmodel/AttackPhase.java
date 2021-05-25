package com.xidian.attackmodel;

/**
 * @Author: quan
 * @Date: 2021/05/21/14:44
 * @Description:
 */
public class AttackPhase {
    int id;
    String methodName;

    public AttackPhase(int id, String methodName) {
        this.id = id;
        this.methodName = methodName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
