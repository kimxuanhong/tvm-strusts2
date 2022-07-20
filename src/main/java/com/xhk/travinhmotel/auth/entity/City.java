package com.xhk.travinhmotel.auth.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
    @Id
    private long id;

    private String type;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
