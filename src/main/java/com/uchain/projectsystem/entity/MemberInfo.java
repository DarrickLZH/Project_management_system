package com.uchain.projectsystem.entity;

import lombok.Data;

import java.io.Serializable;
/**
 * @author lzh
 */
@Data
public class MemberInfo implements Serializable {
    private Integer id;

    private Integer pid;

    private String memberName;

    private String memberTask;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getMemberTask() {
        return memberTask;
    }

    public void setMemberTask(String memberTask) {
        this.memberTask = memberTask == null ? null : memberTask.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", memberName=").append(memberName);
        sb.append(", memberTask=").append(memberTask);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}