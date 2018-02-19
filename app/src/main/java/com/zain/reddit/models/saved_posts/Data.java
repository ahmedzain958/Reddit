
package com.zain.reddit.models.saved_posts;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("after")
    @Expose
    private Object after;
    @SerializedName("dist")
    @Expose
    private Integer dist;
    @SerializedName("modhash")
    @Expose
    private Object modhash;
    @SerializedName("whitelist_status")
    @Expose
    private Object whitelistStatus;
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

    public Integer getDist() {
        return dist;
    }

    public void setDist(Integer dist) {
        this.dist = dist;
    }

    public Object getModhash() {
        return modhash;
    }

    public void setModhash(Object modhash) {
        this.modhash = modhash;
    }

    public Object getWhitelistStatus() {
        return whitelistStatus;
    }

    public void setWhitelistStatus(Object whitelistStatus) {
        this.whitelistStatus = whitelistStatus;
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
