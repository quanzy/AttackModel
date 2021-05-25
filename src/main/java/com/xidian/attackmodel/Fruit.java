package com.xidian.attackmodel;

/**
 * @Author: quan
 * @Date: 2021/05/19/23:38
 * @Description:
 */
public class Fruit {
    int id;
    String name;

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

    public Fruit() {
    }

    public Fruit(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
