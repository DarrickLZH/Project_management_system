package com.uchain.projectsystem.entity;

import lombok.Data;

import java.io.Serializable;
/**
 * @author lzh
 */
@Data
public class ProjectInfo implements Serializable {
    private Integer id;

    private Integer type;

    private String name;

    private String manager;

    private String startTime;

    private String endTime;

    private String isPaid;

    private Integer payChannel;

    private Integer selfChoice;

    private String payWarrant;

    private String commentSchool;

    private String commentCompany;

    private String envidence;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid == null ? null : isPaid.trim();
    }

    public Integer getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }

    public Integer getSelfChoice() {
        return selfChoice;
    }

    public void setSelfChoice(Integer selfChoice) {
        this.selfChoice = selfChoice;
    }

    public String getPayWarrant() {
        return payWarrant;
    }

    public void setPayWarrant(String payWarrant) {
        this.payWarrant = payWarrant == null ? null : payWarrant.trim();
    }

    public String getCommentSchool() {
        return commentSchool;
    }

    public void setCommentSchool(String commentSchool) {
        this.commentSchool = commentSchool == null ? null : commentSchool.trim();
    }

    public String getCommentCompany() {
        return commentCompany;
    }

    public void setCommentCompany(String commentCompany) {
        this.commentCompany = commentCompany == null ? null : commentCompany.trim();
    }

    public String getEnvidence() {
        return envidence;
    }

    public void setEnvidence(String envidence) {
        this.envidence = envidence == null ? null : envidence.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", name=").append(name);
        sb.append(", manager=").append(manager);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", isPaid=").append(isPaid);
        sb.append(", payChannel=").append(payChannel);
        sb.append(", selfChoice=").append(selfChoice);
        sb.append(", payWarrant=").append(payWarrant);
        sb.append(", commentSchool=").append(commentSchool);
        sb.append(", commentCompany=").append(commentCompany);
        sb.append(", envidence=").append(envidence);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}