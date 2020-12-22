package com.abc.dao.entity;

public class Tdept {
    private int did;
    private String dname;

    public Tdept() {
    }

    public Tdept(int did, String dname) {
        this.did = did;
        this.dname = dname;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Tdept{" +
                "deptno=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }
}
