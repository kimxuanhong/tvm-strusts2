package com.xhk.travinhmotel.auth.entity;

import javax.persistence.*;

@Entity
public class MotelUtility extends AbstractEntity {
    @EmbeddedId
    private MotelUtilityPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motel_id ")
    @MapsId("motel_id ")
    private Motel motel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utility_id")
    @MapsId("utility_id")
    private Utility utility;

    public MotelUtilityPK getId() {
        return id;
    }

    public void setId(MotelUtilityPK id) {
        this.id = id;
    }

    public Motel getMotel() {
        return motel;
    }

    public void setMotel(Motel motel) {
        this.motel = motel;
    }

    public Utility getUtility() {
        return utility;
    }

    public void setUtility(Utility utility) {
        this.utility = utility;
    }
}
