package com.example.entity;

public class Rent {
    private String Object;
    private int oid;
    private int uid;

    public Rent() {

    }

    public String getObject() {
        return Object;
    }

    public void setObject(String object) {
        Object = object;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Rent(String object, int oid, int uid) {
        Object = object;
        this.oid = oid;
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "Object='" + Object + '\'' +
                ", oid=" + oid +
                ", uid=" + uid +
                '}';
    }
}
