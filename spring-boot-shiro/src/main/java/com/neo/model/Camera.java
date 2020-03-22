package com.neo.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by waynamigo on 19-5-14
 */
@Entity
public class Camera implements Serializable {
    @Autowired
    @Id
    private String video_id;
    private String location;
    public Camera() {
    }

    public String getVideo_id() {
        return video_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }
}
