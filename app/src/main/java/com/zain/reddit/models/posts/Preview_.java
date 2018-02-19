
package com.zain.reddit.models.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Preview_   implements Serializable {

    @SerializedName("images")
    @Expose
    private List<Image_> images = null;
    @SerializedName("enabled")
    @Expose
    private Boolean enabled;

    public List<Image_> getImages() {
        return images;
    }

    public void setImages(List<Image_> images) {
        this.images = images;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
