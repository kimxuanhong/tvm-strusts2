package com.xhk.travinhmotel.auth.entity;

import org.hibernate.annotations.Where;

import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.OffsetDateTime;

import static java.time.OffsetDateTime.now;


@MappedSuperclass
@Where(clause = "delete_flag = false")
public class AbstractEntity {

    @Basic(optional = false)
    private boolean deleteFlag;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    @PrePersist
    public void onPersist() {
        updatedAt = createdAt = now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = now();
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}


