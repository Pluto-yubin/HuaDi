package com.example.entity;

import org.springframework.data.relational.core.sql.In;

public class User {
    private Integer uid;
    private String  upassword;
    private String utype;
    private String unumber;

    public User(Integer uid, String upassword, String utype, String unumber) {
        this.uid = uid;
        this.upassword = upassword;
        this.utype = utype;
        this.unumber = unumber;
    }

    public User(String name, String type, String number) {
        this.upassword = upassword;
        this.utype = utype;
        this.unumber = unumber;
    }

    public User() {

    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public String getUnumber() {
        return unumber;
    }

    public void setUnumber(String unumber) {
        this.unumber = unumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", upassword='" + upassword + '\'' +
                ", utype='" + utype + '\'' +
                ", unumber='" + unumber + '\'' +
                '}';
    }
}
