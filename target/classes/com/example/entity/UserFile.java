package com.example.entity;

public class UserFile {
    private int id;
    private String f_name;
    private int size;
    private String type;
    private int uid;
    private String path;

    public UserFile(int id, String f_name, int size, String type, int uid, String path) {
        this.id = id;
        this.f_name = f_name;
        this.size = size;
        this.type = type;
        this.uid = uid;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public UserFile() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UserFile{" +
                "id=" + id +
                ", f_name='" + f_name + '\'' +
                ", size=" + size +
                ", type='" + type + '\'' +
                ", uid=" + uid +
                ", path='" + path + '\'' +
                '}';
    }
}
