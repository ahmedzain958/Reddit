
package com.zain.reddit.models.me;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class    Subreddit {

    @SerializedName("default_set")
    @Expose
    private Boolean defaultSet;
    @SerializedName("icon_img")
    @Expose
    private String iconImg;
    @SerializedName("banner_img")
    @Expose
    private String bannerImg;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("header_size")
    @Expose
    private Object headerSize;
    @SerializedName("user_is_banned")
    @Expose
    private Boolean userIsBanned;
    @SerializedName("subscribers")
    @Expose
    private Integer subscribers;
    @SerializedName("is_default_icon")
    @Expose
    private Boolean isDefaultIcon;
    @SerializedName("key_color")
    @Expose
    private String keyColor;
    @SerializedName("show_media")
    @Expose
    private Boolean showMedia;
    @SerializedName("display_name_prefixed")
    @Expose
    private String displayNamePrefixed;
    @SerializedName("icon_color")
    @Expose
    private String iconColor;
    @SerializedName("user_is_muted")
    @Expose
    private Boolean userIsMuted;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("header_img")
    @Expose
    private Object headerImg;
    @SerializedName("is_default_banner")
    @Expose
    private Boolean isDefaultBanner;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("banner_size")
    @Expose
    private Object bannerSize;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("user_is_contributor")
    @Expose
    private Boolean userIsContributor;
    @SerializedName("user_is_moderator")
    @Expose
    private Boolean userIsModerator;
    @SerializedName("over_18")
    @Expose
    private Boolean over18;
    @SerializedName("public_description")
    @Expose
    private String publicDescription;
    @SerializedName("link_flair_enabled")
    @Expose
    private Boolean linkFlairEnabled;
    @SerializedName("icon_size")
    @Expose
    private List<Integer> iconSize = null;
    @SerializedName("subreddit_type")
    @Expose
    private String subredditType;
    @SerializedName("audience_target")
    @Expose
    private String audienceTarget;
    @SerializedName("user_is_subscriber")
    @Expose
    private Boolean userIsSubscriber;

    public Boolean getDefaultSet() {
        return defaultSet;
    }

    public void setDefaultSet(Boolean defaultSet) {
        this.defaultSet = defaultSet;
    }

    public String getIconImg() {
        return iconImg;
    }

    public void setIconImg(String iconImg) {
        this.iconImg = iconImg;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getHeaderSize() {
        return headerSize;
    }

    public void setHeaderSize(Object headerSize) {
        this.headerSize = headerSize;
    }

    public Boolean getUserIsBanned() {
        return userIsBanned;
    }

    public void setUserIsBanned(Boolean userIsBanned) {
        this.userIsBanned = userIsBanned;
    }

    public Integer getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Integer subscribers) {
        this.subscribers = subscribers;
    }

    public Boolean getIsDefaultIcon() {
        return isDefaultIcon;
    }

    public void setIsDefaultIcon(Boolean isDefaultIcon) {
        this.isDefaultIcon = isDefaultIcon;
    }

    public String getKeyColor() {
        return keyColor;
    }

    public void setKeyColor(String keyColor) {
        this.keyColor = keyColor;
    }

    public Boolean getShowMedia() {
        return showMedia;
    }

    public void setShowMedia(Boolean showMedia) {
        this.showMedia = showMedia;
    }

    public String getDisplayNamePrefixed() {
        return displayNamePrefixed;
    }

    public void setDisplayNamePrefixed(String displayNamePrefixed) {
        this.displayNamePrefixed = displayNamePrefixed;
    }

    public String getIconColor() {
        return iconColor;
    }

    public void setIconColor(String iconColor) {
        this.iconColor = iconColor;
    }

    public Boolean getUserIsMuted() {
        return userIsMuted;
    }

    public void setUserIsMuted(Boolean userIsMuted) {
        this.userIsMuted = userIsMuted;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Object getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(Object headerImg) {
        this.headerImg = headerImg;
    }

    public Boolean getIsDefaultBanner() {
        return isDefaultBanner;
    }

    public void setIsDefaultBanner(Boolean isDefaultBanner) {
        this.isDefaultBanner = isDefaultBanner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getBannerSize() {
        return bannerSize;
    }

    public void setBannerSize(Object bannerSize) {
        this.bannerSize = bannerSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getUserIsContributor() {
        return userIsContributor;
    }

    public void setUserIsContributor(Boolean userIsContributor) {
        this.userIsContributor = userIsContributor;
    }

    public Boolean getUserIsModerator() {
        return userIsModerator;
    }

    public void setUserIsModerator(Boolean userIsModerator) {
        this.userIsModerator = userIsModerator;
    }

    public Boolean getOver18() {
        return over18;
    }

    public void setOver18(Boolean over18) {
        this.over18 = over18;
    }

    public String getPublicDescription() {
        return publicDescription;
    }

    public void setPublicDescription(String publicDescription) {
        this.publicDescription = publicDescription;
    }

    public Boolean getLinkFlairEnabled() {
        return linkFlairEnabled;
    }

    public void setLinkFlairEnabled(Boolean linkFlairEnabled) {
        this.linkFlairEnabled = linkFlairEnabled;
    }

    public List<Integer> getIconSize() {
        return iconSize;
    }

    public void setIconSize(List<Integer> iconSize) {
        this.iconSize = iconSize;
    }

    public String getSubredditType() {
        return subredditType;
    }

    public void setSubredditType(String subredditType) {
        this.subredditType = subredditType;
    }

    public String getAudienceTarget() {
        return audienceTarget;
    }

    public void setAudienceTarget(String audienceTarget) {
        this.audienceTarget = audienceTarget;
    }

    public Boolean getUserIsSubscriber() {
        return userIsSubscriber;
    }

    public void setUserIsSubscriber(Boolean userIsSubscriber) {
        this.userIsSubscriber = userIsSubscriber;
    }

}
