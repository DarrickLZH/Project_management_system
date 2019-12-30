package com.uchain.projectsystem.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class EquipmentInfo implements Serializable {
    private Integer id;

    private String eName;

    private String ePrice;

    private Integer eState;

    private String purchaser;

    private String eManager;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public String getePrice() {
        return ePrice;
    }

    public void setePrice(String ePrice) {
        this.ePrice = ePrice == null ? null : ePrice.trim();
    }

    public Integer geteState() {
        return eState;
    }

    public void seteState(Integer eState) {
        this.eState = eState;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser == null ? null : purchaser.trim();
    }

    public String geteManager() {
        return eManager;
    }

    public void seteManager(String eManager) {
        this.eManager = eManager == null ? null : eManager.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", eName=").append(eName);
        sb.append(", ePrice=").append(ePrice);
        sb.append(", eState=").append(eState);
        sb.append(", purchaser=").append(purchaser);
        sb.append(", eManager=").append(eManager);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}