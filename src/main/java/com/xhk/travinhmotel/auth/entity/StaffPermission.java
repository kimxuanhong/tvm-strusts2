package com.xhk.travinhmotel.auth.entity;

import com.xhk.travinhmotel.auth.entity.enums.PermissionName;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class StaffPermission {
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private PermissionName name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PermissionName getName() {
        return name;
    }

    public void setName(PermissionName name) {
        this.name = name;
    }
}
