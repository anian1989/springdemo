
package com.fanhanfei.springdemo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class KingDeeRequest {

    @SerializedName("ap0")
    private String mAp0;
    @SerializedName("clientinfo")
    private String mClientinfo;
    @SerializedName("compressed")
    private Boolean mCompressed;
    @SerializedName("format")
    private String mFormat;
    @SerializedName("nonce")
    private String mNonce;
    @SerializedName("sign")
    private String mSign;
    @SerializedName("timestamp")
    private String mTimestamp;
    @SerializedName("useragent")
    private String mUseragent;
    @SerializedName("v")
    private String mV;

    public String getAp0() {
        return mAp0;
    }

    public void setAp0(String ap0) {
        mAp0 = ap0;
    }

    public String getClientinfo() {
        return mClientinfo;
    }

    public void setClientinfo(String clientinfo) {
        mClientinfo = clientinfo;
    }

    public Boolean getCompressed() {
        return mCompressed;
    }

    public void setCompressed(Boolean compressed) {
        mCompressed = compressed;
    }

    public String getFormat() {
        return mFormat;
    }

    public void setFormat(String format) {
        mFormat = format;
    }

    public String getNonce() {
        return mNonce;
    }

    public void setNonce(String nonce) {
        mNonce = nonce;
    }

    public String getSign() {
        return mSign;
    }

    public void setSign(String sign) {
        mSign = sign;
    }

    public String getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(String timestamp) {
        mTimestamp = timestamp;
    }

    public String getUseragent() {
        return mUseragent;
    }

    public void setUseragent(String useragent) {
        mUseragent = useragent;
    }

    public String getV() {
        return mV;
    }

    public void setV(String v) {
        mV = v;
    }

}
