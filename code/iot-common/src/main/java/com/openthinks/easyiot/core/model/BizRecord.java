package com.openthinks.easyiot.core.model;

import java.util.Date;

public class BizRecord {
    private Long id;

    private String devId;

    private Date ts;

    private String source;

    private String data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId == null ? null : devId.trim();
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BizRecord other = (BizRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDevId() == null ? other.getDevId() == null : this.getDevId().equals(other.getDevId()))
            && (this.getTs() == null ? other.getTs() == null : this.getTs().equals(other.getTs()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getData() == null ? other.getData() == null : this.getData().equals(other.getData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDevId() == null) ? 0 : getDevId().hashCode());
        result = prime * result + ((getTs() == null) ? 0 : getTs().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getData() == null) ? 0 : getData().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", devId=").append(devId);
        sb.append(", ts=").append(ts);
        sb.append(", source=").append(source);
        sb.append(", data=").append(data);
        sb.append("]");
        return sb.toString();
    }

    public static class Builder {
        private BizRecord obj;

        public Builder() {
            this.obj = new BizRecord();
        }

        public Builder id(Long id) {
            obj.id = id;
            return this;
        }

        public Builder devId(String devId) {
            obj.devId = devId;
            return this;
        }

        public Builder ts(Date ts) {
            obj.ts = ts;
            return this;
        }

        public Builder source(String source) {
            obj.source = source;
            return this;
        }

        public Builder data(String data) {
            obj.data = data;
            return this;
        }

        public BizRecord build() {
            return this.obj;
        }
    }
}