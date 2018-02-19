
package com.zain.reddit.models.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Image_ implements Serializable {

    @SerializedName("source")
    @Expose
    private Source_ source;
    @SerializedName("resolutions")
    @Expose
    private List<Resolution_> resolutions = null;

    @SerializedName("id")
    @Expose
    private String id;

    public Source_ getSource() {
        return source;
    }

    public void setSource(Source_ source) {
        this.source = source;
    }

    public List<Resolution_> getResolutions() {
        return resolutions;
    }

    public void setResolutions(List<Resolution_> resolutions) {
        this.resolutions = resolutions;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
