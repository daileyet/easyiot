package com.openthinks.easyiot.core.model;

import java.util.Date;

public class BizRecordData {
    private Long id;

    private Date ts;

    private String deviceId;

    private String attr1;

    private String attr2;

    private String attr3;

    private String attr4;

    private String attr5;

    private String attr6;

    private String attr7;

    private String attr8;

    private String attr9;

    private String attr10;

    private String attr11;

    private String attr12;

    private String attr13;

    private String attr14;

    private String attr15;

    private String attr16;

    private String attr17;

    private String attr18;

    private String attr19;

    private String attr20;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1 == null ? null : attr1.trim();
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2 == null ? null : attr2.trim();
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3 == null ? null : attr3.trim();
    }

    public String getAttr4() {
        return attr4;
    }

    public void setAttr4(String attr4) {
        this.attr4 = attr4 == null ? null : attr4.trim();
    }

    public String getAttr5() {
        return attr5;
    }

    public void setAttr5(String attr5) {
        this.attr5 = attr5 == null ? null : attr5.trim();
    }

    public String getAttr6() {
        return attr6;
    }

    public void setAttr6(String attr6) {
        this.attr6 = attr6 == null ? null : attr6.trim();
    }

    public String getAttr7() {
        return attr7;
    }

    public void setAttr7(String attr7) {
        this.attr7 = attr7 == null ? null : attr7.trim();
    }

    public String getAttr8() {
        return attr8;
    }

    public void setAttr8(String attr8) {
        this.attr8 = attr8 == null ? null : attr8.trim();
    }

    public String getAttr9() {
        return attr9;
    }

    public void setAttr9(String attr9) {
        this.attr9 = attr9 == null ? null : attr9.trim();
    }

    public String getAttr10() {
        return attr10;
    }

    public void setAttr10(String attr10) {
        this.attr10 = attr10 == null ? null : attr10.trim();
    }

    public String getAttr11() {
        return attr11;
    }

    public void setAttr11(String attr11) {
        this.attr11 = attr11 == null ? null : attr11.trim();
    }

    public String getAttr12() {
        return attr12;
    }

    public void setAttr12(String attr12) {
        this.attr12 = attr12 == null ? null : attr12.trim();
    }

    public String getAttr13() {
        return attr13;
    }

    public void setAttr13(String attr13) {
        this.attr13 = attr13 == null ? null : attr13.trim();
    }

    public String getAttr14() {
        return attr14;
    }

    public void setAttr14(String attr14) {
        this.attr14 = attr14 == null ? null : attr14.trim();
    }

    public String getAttr15() {
        return attr15;
    }

    public void setAttr15(String attr15) {
        this.attr15 = attr15 == null ? null : attr15.trim();
    }

    public String getAttr16() {
        return attr16;
    }

    public void setAttr16(String attr16) {
        this.attr16 = attr16 == null ? null : attr16.trim();
    }

    public String getAttr17() {
        return attr17;
    }

    public void setAttr17(String attr17) {
        this.attr17 = attr17 == null ? null : attr17.trim();
    }

    public String getAttr18() {
        return attr18;
    }

    public void setAttr18(String attr18) {
        this.attr18 = attr18 == null ? null : attr18.trim();
    }

    public String getAttr19() {
        return attr19;
    }

    public void setAttr19(String attr19) {
        this.attr19 = attr19 == null ? null : attr19.trim();
    }

    public String getAttr20() {
        return attr20;
    }

    public void setAttr20(String attr20) {
        this.attr20 = attr20 == null ? null : attr20.trim();
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
        BizRecordData other = (BizRecordData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTs() == null ? other.getTs() == null : this.getTs().equals(other.getTs()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getAttr1() == null ? other.getAttr1() == null : this.getAttr1().equals(other.getAttr1()))
            && (this.getAttr2() == null ? other.getAttr2() == null : this.getAttr2().equals(other.getAttr2()))
            && (this.getAttr3() == null ? other.getAttr3() == null : this.getAttr3().equals(other.getAttr3()))
            && (this.getAttr4() == null ? other.getAttr4() == null : this.getAttr4().equals(other.getAttr4()))
            && (this.getAttr5() == null ? other.getAttr5() == null : this.getAttr5().equals(other.getAttr5()))
            && (this.getAttr6() == null ? other.getAttr6() == null : this.getAttr6().equals(other.getAttr6()))
            && (this.getAttr7() == null ? other.getAttr7() == null : this.getAttr7().equals(other.getAttr7()))
            && (this.getAttr8() == null ? other.getAttr8() == null : this.getAttr8().equals(other.getAttr8()))
            && (this.getAttr9() == null ? other.getAttr9() == null : this.getAttr9().equals(other.getAttr9()))
            && (this.getAttr10() == null ? other.getAttr10() == null : this.getAttr10().equals(other.getAttr10()))
            && (this.getAttr11() == null ? other.getAttr11() == null : this.getAttr11().equals(other.getAttr11()))
            && (this.getAttr12() == null ? other.getAttr12() == null : this.getAttr12().equals(other.getAttr12()))
            && (this.getAttr13() == null ? other.getAttr13() == null : this.getAttr13().equals(other.getAttr13()))
            && (this.getAttr14() == null ? other.getAttr14() == null : this.getAttr14().equals(other.getAttr14()))
            && (this.getAttr15() == null ? other.getAttr15() == null : this.getAttr15().equals(other.getAttr15()))
            && (this.getAttr16() == null ? other.getAttr16() == null : this.getAttr16().equals(other.getAttr16()))
            && (this.getAttr17() == null ? other.getAttr17() == null : this.getAttr17().equals(other.getAttr17()))
            && (this.getAttr18() == null ? other.getAttr18() == null : this.getAttr18().equals(other.getAttr18()))
            && (this.getAttr19() == null ? other.getAttr19() == null : this.getAttr19().equals(other.getAttr19()))
            && (this.getAttr20() == null ? other.getAttr20() == null : this.getAttr20().equals(other.getAttr20()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTs() == null) ? 0 : getTs().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getAttr1() == null) ? 0 : getAttr1().hashCode());
        result = prime * result + ((getAttr2() == null) ? 0 : getAttr2().hashCode());
        result = prime * result + ((getAttr3() == null) ? 0 : getAttr3().hashCode());
        result = prime * result + ((getAttr4() == null) ? 0 : getAttr4().hashCode());
        result = prime * result + ((getAttr5() == null) ? 0 : getAttr5().hashCode());
        result = prime * result + ((getAttr6() == null) ? 0 : getAttr6().hashCode());
        result = prime * result + ((getAttr7() == null) ? 0 : getAttr7().hashCode());
        result = prime * result + ((getAttr8() == null) ? 0 : getAttr8().hashCode());
        result = prime * result + ((getAttr9() == null) ? 0 : getAttr9().hashCode());
        result = prime * result + ((getAttr10() == null) ? 0 : getAttr10().hashCode());
        result = prime * result + ((getAttr11() == null) ? 0 : getAttr11().hashCode());
        result = prime * result + ((getAttr12() == null) ? 0 : getAttr12().hashCode());
        result = prime * result + ((getAttr13() == null) ? 0 : getAttr13().hashCode());
        result = prime * result + ((getAttr14() == null) ? 0 : getAttr14().hashCode());
        result = prime * result + ((getAttr15() == null) ? 0 : getAttr15().hashCode());
        result = prime * result + ((getAttr16() == null) ? 0 : getAttr16().hashCode());
        result = prime * result + ((getAttr17() == null) ? 0 : getAttr17().hashCode());
        result = prime * result + ((getAttr18() == null) ? 0 : getAttr18().hashCode());
        result = prime * result + ((getAttr19() == null) ? 0 : getAttr19().hashCode());
        result = prime * result + ((getAttr20() == null) ? 0 : getAttr20().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ts=").append(ts);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", attr1=").append(attr1);
        sb.append(", attr2=").append(attr2);
        sb.append(", attr3=").append(attr3);
        sb.append(", attr4=").append(attr4);
        sb.append(", attr5=").append(attr5);
        sb.append(", attr6=").append(attr6);
        sb.append(", attr7=").append(attr7);
        sb.append(", attr8=").append(attr8);
        sb.append(", attr9=").append(attr9);
        sb.append(", attr10=").append(attr10);
        sb.append(", attr11=").append(attr11);
        sb.append(", attr12=").append(attr12);
        sb.append(", attr13=").append(attr13);
        sb.append(", attr14=").append(attr14);
        sb.append(", attr15=").append(attr15);
        sb.append(", attr16=").append(attr16);
        sb.append(", attr17=").append(attr17);
        sb.append(", attr18=").append(attr18);
        sb.append(", attr19=").append(attr19);
        sb.append(", attr20=").append(attr20);
        sb.append("]");
        return sb.toString();
    }

    public static class Builder {
        private BizRecordData obj;

        public Builder() {
            this.obj = new BizRecordData();
        }

        public Builder id(Long id) {
            obj.id = id;
            return this;
        }

        public Builder ts(Date ts) {
            obj.ts = ts;
            return this;
        }

        public Builder deviceId(String deviceId) {
            obj.deviceId = deviceId;
            return this;
        }

        public Builder attr1(String attr1) {
            obj.attr1 = attr1;
            return this;
        }

        public Builder attr2(String attr2) {
            obj.attr2 = attr2;
            return this;
        }

        public Builder attr3(String attr3) {
            obj.attr3 = attr3;
            return this;
        }

        public Builder attr4(String attr4) {
            obj.attr4 = attr4;
            return this;
        }

        public Builder attr5(String attr5) {
            obj.attr5 = attr5;
            return this;
        }

        public Builder attr6(String attr6) {
            obj.attr6 = attr6;
            return this;
        }

        public Builder attr7(String attr7) {
            obj.attr7 = attr7;
            return this;
        }

        public Builder attr8(String attr8) {
            obj.attr8 = attr8;
            return this;
        }

        public Builder attr9(String attr9) {
            obj.attr9 = attr9;
            return this;
        }

        public Builder attr10(String attr10) {
            obj.attr10 = attr10;
            return this;
        }

        public Builder attr11(String attr11) {
            obj.attr11 = attr11;
            return this;
        }

        public Builder attr12(String attr12) {
            obj.attr12 = attr12;
            return this;
        }

        public Builder attr13(String attr13) {
            obj.attr13 = attr13;
            return this;
        }

        public Builder attr14(String attr14) {
            obj.attr14 = attr14;
            return this;
        }

        public Builder attr15(String attr15) {
            obj.attr15 = attr15;
            return this;
        }

        public Builder attr16(String attr16) {
            obj.attr16 = attr16;
            return this;
        }

        public Builder attr17(String attr17) {
            obj.attr17 = attr17;
            return this;
        }

        public Builder attr18(String attr18) {
            obj.attr18 = attr18;
            return this;
        }

        public Builder attr19(String attr19) {
            obj.attr19 = attr19;
            return this;
        }

        public Builder attr20(String attr20) {
            obj.attr20 = attr20;
            return this;
        }

        public BizRecordData build() {
            return this.obj;
        }
    }
}