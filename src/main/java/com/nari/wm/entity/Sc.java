package com.nari.wm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Sc)实体类
 *
 * @author makejava
 * @since 2021-01-18 11:23:02
 */
@Data
public class Sc implements Serializable {
    private static final long serialVersionUID = 173493241805379467L;
    private String sid;
    
    private String cid;
    
    private Double score;


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

}