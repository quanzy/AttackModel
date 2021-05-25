package com.xidian.attackmodel;

/**
 * @Author: quan
 * @Date: 2021/05/21/0:20
 * @Description:
 */
public class Attack {
    private int id;
    private String name;
    int attackTypeId;
    int attackMethodId;

    public Attack(int id, String name) {
        this.id = id;
        this.name = name;
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
}
