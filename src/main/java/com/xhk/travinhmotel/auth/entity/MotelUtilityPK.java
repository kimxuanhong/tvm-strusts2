package com.xhk.travinhmotel.auth.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class MotelUtilityPK implements Serializable {

    @Column(name = "motel_id ")
    private long motelId;

    @Column(name = "utility_id")
    private long utilityId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MotelUtilityPK that = (MotelUtilityPK) o;
        return motelId == that.motelId &&
                utilityId == that.utilityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(motelId, utilityId);
    }

    public long getMotelId() {
        return motelId;
    }

    public void setMotelId(long motelId) {
        this.motelId = motelId;
    }

    public long getUtilityId() {
        return utilityId;
    }

    public void setUtilityId(long utilityId) {
        this.utilityId = utilityId;
    }
}
