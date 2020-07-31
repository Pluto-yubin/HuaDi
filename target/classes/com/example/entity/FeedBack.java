package com.example.entity;

public class FeedBack {
    private String msg;
    private int fid;
    /**
     * 数据库中没有uid,这里是为了能够让
     * 用户输入uid来获取相对应的fid
     */
    private int uid;
    public FeedBack(String msg, int fid, int uid) {
        this.msg = msg;
        this.fid = fid;
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public FeedBack() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "msg='" + msg + '\'' +
                ", fid=" + fid +
                ", uid=" + uid +
                '}';
    }
}
