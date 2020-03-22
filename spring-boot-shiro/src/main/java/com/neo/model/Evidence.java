package com.neo.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by waynamigo on 19-5-14
 */
@Entity
public class Evidence implements Serializable {
    @Autowired
    @Id
    @GeneratedValue
    private Integer evid;
    private String pictures_url;
    private String behavior;
    private Date recordtime;
    private String stuid;
    public Evidence() {
    }

    public Evidence(String pictures_url, String behavior, Date recordtime, String stuid) {
        this.pictures_url = pictures_url;
        this.behavior = behavior;
        this.recordtime = recordtime;
        this.stuid = stuid;
    }

    public Integer getEvid() {
        return evid;
    }

    public void setEvid(Integer evid) {
        this.evid = evid;
    }

    public String getPictures_url() {
        return pictures_url;
    }

    public void setPictures_url(String pictures_url) {
        this.pictures_url = pictures_url;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public Date getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }
}
