package com.example.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "AUDITLOG")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOGID")
    private Long logId;

    @Column(name = "USERID")
    private Long userId;

    @Column(name = "ACTION")
    private String action;

    @Column(name = "TIMESTAMP")
    private Date timestamp;

    @Column(name = "TABLENAME")
    private String tableName;

    @Column(name = "RECORDEDID")
    private Long recordedId;

    @Column(name = "ACTIONTYPE")
    private String actionType;

    @Column(name = "OLDVALUE")
    private String oldValue;

    @Column(name = "NEWVALUE")
    private String newValue;

    // Getters and setters
    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getRecordedId() {
        return recordedId;
    }

    public void setRecordedId(Long recordedId) {
        this.recordedId = recordedId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
}
