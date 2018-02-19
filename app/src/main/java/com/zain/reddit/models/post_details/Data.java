
package com.zain.reddit.models.post_details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("after")
    @Expose
    private Object after;
    @SerializedName("whitelist_status")
    @Expose
    private Object whitelistStatus;
    @SerializedName("modhash")
    @Expose
    private Object modhash;
    @SerializedName("dist")
    @Expose
    private Object dist;
    @SerializedName("children")
    @Expose
    private List<Child> children = null;
    @SerializedName("before")
    @Expose
    private Object before;

    public Object getAfter() {
        return after;
    }

    public void setAfter(Object after) {
        this.after = after;
    }

    public Object getWhitelistStatus() {
        return whitelistStatus;
    }

    public void setWhitelistStatus(Object whitelistStatus) {
        this.whitelistStatus = whitelistStatus;
    }

    public Object getModhash() {
        return modhash;
    }

    public void setModhash(Object modhash) {
        this.modhash = modhash;
    }

    public Object getDist() {
        return dist;
    }

    public void setDist(Object dist) {
        this.dist = dist;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Object getBefore() {
        return before;
    }

    public void setBefore(Object before) {
        this.before = before;
    }

}
