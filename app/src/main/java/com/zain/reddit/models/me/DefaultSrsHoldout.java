
package com.zain.reddit.models.me;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DefaultSrsHoldout {

    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("variant")
    @Expose
    private String variant;
    @SerializedName("experiment_id")
    @Expose
    private Integer experimentId;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public Integer getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Integer experimentId) {
        this.experimentId = experimentId;
    }

}
