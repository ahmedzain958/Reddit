
package com.zain.reddit.models.me;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Me {

    @SerializedName("is_employee")
    @Expose
    private Boolean isEmployee;
    @SerializedName("has_visited_new_profile")
    @Expose
    private Boolean hasVisitedNewProfile;
    @SerializedName("pref_no_profanity")
    @Expose
    private Boolean prefNoProfanity;
    @SerializedName("is_suspended")
    @Expose
    private Boolean isSuspended;
    @SerializedName("pref_geopopular")
    @Expose
    private String prefGeopopular;
    @SerializedName("subreddit")
    @Expose
    private Subreddit subreddit;
    @SerializedName("is_sponsor")
    @Expose
    private Boolean isSponsor;
    @SerializedName("gold_expiration")
    @Expose
    private Object goldExpiration;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("suspension_expiration_utc")
    @Expose
    private Object suspensionExpirationUtc;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("new_modmail_exists")
    @Expose
    private Object newModmailExists;
    @SerializedName("features")
    @Expose
    private Features features;
    @SerializedName("over_18")
    @Expose
    private Boolean over18;
    @SerializedName("is_gold")
    @Expose
    private Boolean isGold;
    @SerializedName("is_mod")
    @Expose
    private Boolean isMod;
    @SerializedName("has_verified_email")
    @Expose
    private Boolean hasVerifiedEmail;
    @SerializedName("in_redesign_beta")
    @Expose
    private Boolean inRedesignBeta;
    @SerializedName("icon_img")
    @Expose
    private String iconImg;
    @SerializedName("has_mod_mail")
    @Expose
    private Boolean hasModMail;
    @SerializedName("oauth_client_id")
    @Expose
    private String oauthClientId;
    @SerializedName("hide_from_robots")
    @Expose
    private Boolean hideFromRobots;
    @SerializedName("link_karma")
    @Expose
    private Integer linkKarma;
    @SerializedName("inbox_count")
    @Expose
    private Integer inboxCount;
    @SerializedName("pref_top_karma_subreddits")
    @Expose
    private Boolean prefTopKarmaSubreddits;
    @SerializedName("has_mail")
    @Expose
    private Boolean hasMail;
    @SerializedName("pref_show_snoovatar")
    @Expose
    private Boolean prefShowSnoovatar;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("created")
    @Expose
    private Integer created;
    @SerializedName("gold_creddits")
    @Expose
    private Integer goldCreddits;
    @SerializedName("created_utc")
    @Expose
    private Integer createdUtc;
    @SerializedName("in_beta")
    @Expose
    private Boolean inBeta;
    @SerializedName("comment_karma")
    @Expose
    private Integer commentKarma;
    @SerializedName("has_subscribed")
    @Expose
    private Boolean hasSubscribed;

    public Boolean getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(Boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    public Boolean getHasVisitedNewProfile() {
        return hasVisitedNewProfile;
    }

    public void setHasVisitedNewProfile(Boolean hasVisitedNewProfile) {
        this.hasVisitedNewProfile = hasVisitedNewProfile;
    }

    public Boolean getPrefNoProfanity() {
        return prefNoProfanity;
    }

    public void setPrefNoProfanity(Boolean prefNoProfanity) {
        this.prefNoProfanity = prefNoProfanity;
    }

    public Boolean getIsSuspended() {
        return isSuspended;
    }

    public void setIsSuspended(Boolean isSuspended) {
        this.isSuspended = isSuspended;
    }

    public String getPrefGeopopular() {
        return prefGeopopular;
    }

    public void setPrefGeopopular(String prefGeopopular) {
        this.prefGeopopular = prefGeopopular;
    }

    public Subreddit getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(Subreddit subreddit) {
        this.subreddit = subreddit;
    }

    public Boolean getIsSponsor() {
        return isSponsor;
    }

    public void setIsSponsor(Boolean isSponsor) {
        this.isSponsor = isSponsor;
    }

    public Object getGoldExpiration() {
        return goldExpiration;
    }

    public void setGoldExpiration(Object goldExpiration) {
        this.goldExpiration = goldExpiration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getSuspensionExpirationUtc() {
        return suspensionExpirationUtc;
    }

    public void setSuspensionExpirationUtc(Object suspensionExpirationUtc) {
        this.suspensionExpirationUtc = suspensionExpirationUtc;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Object getNewModmailExists() {
        return newModmailExists;
    }

    public void setNewModmailExists(Object newModmailExists) {
        this.newModmailExists = newModmailExists;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    public Boolean getOver18() {
        return over18;
    }

    public void setOver18(Boolean over18) {
        this.over18 = over18;
    }

    public Boolean getIsGold() {
        return isGold;
    }

    public void setIsGold(Boolean isGold) {
        this.isGold = isGold;
    }

    public Boolean getIsMod() {
        return isMod;
    }

    public void setIsMod(Boolean isMod) {
        this.isMod = isMod;
    }

    public Boolean getHasVerifiedEmail() {
        return hasVerifiedEmail;
    }

    public void setHasVerifiedEmail(Boolean hasVerifiedEmail) {
        this.hasVerifiedEmail = hasVerifiedEmail;
    }

    public Boolean getInRedesignBeta() {
        return inRedesignBeta;
    }

    public void setInRedesignBeta(Boolean inRedesignBeta) {
        this.inRedesignBeta = inRedesignBeta;
    }

    public String getIconImg() {
        return iconImg;
    }

    public void setIconImg(String iconImg) {
        this.iconImg = iconImg;
    }

    public Boolean getHasModMail() {
        return hasModMail;
    }

    public void setHasModMail(Boolean hasModMail) {
        this.hasModMail = hasModMail;
    }

    public String getOauthClientId() {
        return oauthClientId;
    }

    public void setOauthClientId(String oauthClientId) {
        this.oauthClientId = oauthClientId;
    }

    public Boolean getHideFromRobots() {
        return hideFromRobots;
    }

    public void setHideFromRobots(Boolean hideFromRobots) {
        this.hideFromRobots = hideFromRobots;
    }

    public Integer getLinkKarma() {
        return linkKarma;
    }

    public void setLinkKarma(Integer linkKarma) {
        this.linkKarma = linkKarma;
    }

    public Integer getInboxCount() {
        return inboxCount;
    }

    public void setInboxCount(Integer inboxCount) {
        this.inboxCount = inboxCount;
    }

    public Boolean getPrefTopKarmaSubreddits() {
        return prefTopKarmaSubreddits;
    }

    public void setPrefTopKarmaSubreddits(Boolean prefTopKarmaSubreddits) {
        this.prefTopKarmaSubreddits = prefTopKarmaSubreddits;
    }

    public Boolean getHasMail() {
        return hasMail;
    }

    public void setHasMail(Boolean hasMail) {
        this.hasMail = hasMail;
    }

    public Boolean getPrefShowSnoovatar() {
        return prefShowSnoovatar;
    }

    public void setPrefShowSnoovatar(Boolean prefShowSnoovatar) {
        this.prefShowSnoovatar = prefShowSnoovatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getGoldCreddits() {
        return goldCreddits;
    }

    public void setGoldCreddits(Integer goldCreddits) {
        this.goldCreddits = goldCreddits;
    }

    public Integer getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(Integer createdUtc) {
        this.createdUtc = createdUtc;
    }

    public Boolean getInBeta() {
        return inBeta;
    }

    public void setInBeta(Boolean inBeta) {
        this.inBeta = inBeta;
    }

    public Integer getCommentKarma() {
        return commentKarma;
    }

    public void setCommentKarma(Integer commentKarma) {
        this.commentKarma = commentKarma;
    }

    public Boolean getHasSubscribed() {
        return hasSubscribed;
    }

    public void setHasSubscribed(Boolean hasSubscribed) {
        this.hasSubscribed = hasSubscribed;
    }

}
