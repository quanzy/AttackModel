package com.xidian.attackmodel;

/**
 * @Author: quan
 * @Date: 2021/05/21/23:24
 * @Description:
 */
public class AttackVO {
    int id;
    String name;
    String typeName;
    String methodName;
    String dataMethod;
    String outBand;
    String intBand;

    public AttackVO(int id, String name, String dataMethod) {
        this.id = id;
        this.name = name;
        this.dataMethod = dataMethod;
    }

    public AttackVO(int id, String name,String methodName, String intBand,String outBand) {
        this.id = id;
        this.name = name;
        this.methodName = methodName;
        this.intBand = intBand;
        this.outBand = outBand;
    }

    public AttackVO(int id, String name, String typeName, String methodName) {
        this.id = id;
        this.name = name;
        this.typeName = typeName;
        this.methodName = methodName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getDataMethod() {
        return dataMethod;
    }

    public void setDataMethod(String dataMethod) {
        this.dataMethod = dataMethod;
    }

    public String getOutBand() {
        return outBand;
    }

    public void setOutBand(String outBand) {
        this.outBand = outBand;
    }

    public String getIntBand() {
        return intBand;
    }

    public void setIntBand(String intBand) {
        this.intBand = intBand;
    }
}
