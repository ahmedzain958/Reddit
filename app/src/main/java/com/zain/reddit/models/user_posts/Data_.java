
package com.zain.reddit.models.user_posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data_ {

    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("approved_at_utc")
    @Expose
    private Object approvedAtUtc;
    @SerializedName("mod_reason_by")
    @Expose
    private Object modReasonBy;
    @SerializedName("banned_by")
    @Expose
    private String bannedBy;
    @SerializedName("num_reports")
    @Expose
    private Integer numReports;
    @SerializedName("subreddit_id")
    @Expose
    private String subredditId;
    @SerializedName("thumbnail_width")
    @Expose
    private Integer thumbnailWidth;
    @SerializedName("subreddit")
    @Expose
    private String subreddit;
    @SerializedName("selftext_html")
    @Expose
    private Object selftextHtml;
    @SerializedName("selftext")
    @Expose
    private String selftext;
    @SerializedName("likes")
    @Expose
    private Object likes;
    @SerializedName("suggested_sort")
    @Expose
    private String suggestedSort;
    @SerializedName("user_reports")
    @Expose
    private List<Object> userReports = null;
    @SerializedName("secure_media")
    @Expose
    private Object secureMedia;
    @SerializedName("is_reddit_media_domain")
    @Expose
    private Boolean isRedditMediaDomain;
    @SerializedName("link_flair_text")
    @Expose
    private Object linkFlairText;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("banned_at_utc")
    @Expose
    private Integer bannedAtUtc;
    @SerializedName("mod_reason_title")
    @Expose
    private Object modReasonTitle;
    @SerializedName("view_count")
    @Expose
    private Integer viewCount;
    @SerializedName("archived")
    @Expose
    private Boolean archived;
    @SerializedName("clicked")
    @Expose
    private Boolean clicked;
    @SerializedName("media_embed")
    @Expose
    private MediaEmbed mediaEmbed;
    @SerializedName("report_reasons")
    @Expose
    private List<Object> reportReasons = null;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("num_crossposts")
    @Expose
    private Integer numCrossposts;
    @SerializedName("saved")
    @Expose
    private Boolean saved;
    @SerializedName("mod_reports")
    @Expose
    private List<Object> modReports = null;
    @SerializedName("can_mod_post")
    @Expose
    private Boolean canModPost;
    @SerializedName("is_crosspostable")
    @Expose
    private Boolean isCrosspostable;
    @SerializedName("pinned")
    @Expose
    private Boolean pinned;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("approved_by")
    @Expose
    private Object approvedBy;
    @SerializedName("over_18")
    @Expose
    private Boolean over18;
    @SerializedName("hidden")
    @Expose
    private Boolean hidden;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("edited")
    @Expose
    private Object edited;
    @SerializedName("link_flair_css_class")
    @Expose
    private Object linkFlairCssClass;
    @SerializedName("author_flair_css_class")
    @Expose
    private Object authorFlairCssClass;
    @SerializedName("contest_mode")
    @Expose
    private Boolean contestMode;
    @SerializedName("gilded")
    @Expose
    private Integer gilded;
    @SerializedName("downs")
    @Expose
    private Integer downs;
    @SerializedName("brand_safe")
    @Expose
    private Boolean brandSafe;
    @SerializedName("secure_media_embed")
    @Expose
    private SecureMediaEmbed secureMediaEmbed;
    @SerializedName("removal_reason")
    @Expose
    private Object removalReason;
    @SerializedName("author_flair_text")
    @Expose
    private Object authorFlairText;
    @SerializedName("stickied")
    @Expose
    private Boolean stickied;
    @SerializedName("visited")
    @Expose
    private Boolean visited;
    @SerializedName("can_gild")
    @Expose
    private Boolean canGild;
    @SerializedName("thumbnail_height")
    @Expose
    private Integer thumbnailHeight;
    @SerializedName("removed")
    @Expose
    private Boolean removed;
    @SerializedName("approved")
    @Expose
    private Boolean approved;
    @SerializedName("parent_whitelist_status")
    @Expose
    private Object parentWhitelistStatus;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("spoiler")
    @Expose
    private Boolean spoiler;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("subreddit_type")
    @Expose
    private String subredditType;
    @SerializedName("locked")
    @Expose
    private Boolean locked;
    @SerializedName("hide_score")
    @Expose
    private Boolean hideScore;
    @SerializedName("created")
    @Expose
    private Integer created;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("whitelist_status")
    @Expose
    private Object whitelistStatus;
    @SerializedName("quarantine")
    @Expose
    private Boolean quarantine;
    @SerializedName("spam")
    @Expose
    private Boolean spam;
    @SerializedName("created_utc")
    @Expose
    private Integer createdUtc;
    @SerializedName("subreddit_name_prefixed")
    @Expose
    private String subredditNamePrefixed;
    @SerializedName("ups")
    @Expose
    private Integer ups;
    @SerializedName("media")
    @Expose
    private Object media;
    @SerializedName("ignore_reports")
    @Expose
    private Boolean ignoreReports;
    @SerializedName("num_comments")
    @Expose
    private Integer numComments;
    @SerializedName("is_self")
    @Expose
    private Boolean isSelf;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("mod_note")
    @Expose
    private Object modNote;
    @SerializedName("is_video")
    @Expose
    private Boolean isVideo;
    @SerializedName("distinguished")
    @Expose
    private Object distinguished;
    @SerializedName("ban_note")
    @Expose
    private String banNote;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Object getApprovedAtUtc() {
        return approvedAtUtc;
    }

    public void setApprovedAtUtc(Object approvedAtUtc) {
        this.approvedAtUtc = approvedAtUtc;
    }

    public Object getModReasonBy() {
        return modReasonBy;
    }

    public void setModReasonBy(Object modReasonBy) {
        this.modReasonBy = modReasonBy;
    }

    public String getBannedBy() {
        return bannedBy;
    }

    public void setBannedBy(String bannedBy) {
        this.bannedBy = bannedBy;
    }

    public Integer getNumReports() {
        return numReports;
    }

    public void setNumReports(Integer numReports) {
        this.numReports = numReports;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

    public Integer getThumbnailWidth() {
        return thumbnailWidth;
    }

    public void setThumbnailWidth(Integer thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public Object getSelftextHtml() {
        return selftextHtml;
    }

    public void setSelftextHtml(Object selftextHtml) {
        this.selftextHtml = selftextHtml;
    }

    public String getSelftext() {
        return selftext;
    }

    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    public Object getLikes() {
        return likes;
    }

    public void setLikes(Object likes) {
        this.likes = likes;
    }

    public String getSuggestedSort() {
        return suggestedSort;
    }

    public void setSuggestedSort(String suggestedSort) {
        this.suggestedSort = suggestedSort;
    }

    public List<Object> getUserReports() {
        return userReports;
    }

    public void setUserReports(List<Object> userReports) {
        this.userReports = userReports;
    }

    public Object getSecureMedia() {
        return secureMedia;
    }

    public void setSecureMedia(Object secureMedia) {
        this.secureMedia = secureMedia;
    }

    public Boolean getIsRedditMediaDomain() {
        return isRedditMediaDomain;
    }

    public void setIsRedditMediaDomain(Boolean isRedditMediaDomain) {
        this.isRedditMediaDomain = isRedditMediaDomain;
    }

    public Object getLinkFlairText() {
        return linkFlairText;
    }

    public void setLinkFlairText(Object linkFlairText) {
        this.linkFlairText = linkFlairText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBannedAtUtc() {
        return bannedAtUtc;
    }

    public void setBannedAtUtc(Integer bannedAtUtc) {
        this.bannedAtUtc = bannedAtUtc;
    }

    public Object getModReasonTitle() {
        return modReasonTitle;
    }

    public void setModReasonTitle(Object modReasonTitle) {
        this.modReasonTitle = modReasonTitle;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Boolean getClicked() {
        return clicked;
    }

    public void setClicked(Boolean clicked) {
        this.clicked = clicked;
    }

    public MediaEmbed getMediaEmbed() {
        return mediaEmbed;
    }

    public void setMediaEmbed(MediaEmbed mediaEmbed) {
        this.mediaEmbed = mediaEmbed;
    }

    public List<Object> getReportReasons() {
        return reportReasons;
    }

    public void setReportReasons(List<Object> reportReasons) {
        this.reportReasons = reportReasons;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumCrossposts() {
        return numCrossposts;
    }

    public void setNumCrossposts(Integer numCrossposts) {
        this.numCrossposts = numCrossposts;
    }

    public Boolean getSaved() {
        return saved;
    }

    public void setSaved(Boolean saved) {
        this.saved = saved;
    }

    public List<Object> getModReports() {
        return modReports;
    }

    public void setModReports(List<Object> modReports) {
        this.modReports = modReports;
    }

    public Boolean getCanModPost() {
        return canModPost;
    }

    public void setCanModPost(Boolean canModPost) {
        this.canModPost = canModPost;
    }

    public Boolean getIsCrosspostable() {
        return isCrosspostable;
    }

    public void setIsCrosspostable(Boolean isCrosspostable) {
        this.isCrosspostable = isCrosspostable;
    }

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Object getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Object approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Boolean getOver18() {
        return over18;
    }

    public void setOver18(Boolean over18) {
        this.over18 = over18;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Object getEdited() {
        return edited;
    }

    public void setEdited(Object edited) {
        this.edited = edited;
    }

    public Object getLinkFlairCssClass() {
        return linkFlairCssClass;
    }

    public void setLinkFlairCssClass(Object linkFlairCssClass) {
        this.linkFlairCssClass = linkFlairCssClass;
    }

    public Object getAuthorFlairCssClass() {
        return authorFlairCssClass;
    }

    public void setAuthorFlairCssClass(Object authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
    }

    public Boolean getContestMode() {
        return contestMode;
    }

    public void setContestMode(Boolean contestMode) {
        this.contestMode = contestMode;
    }

    public Integer getGilded() {
        return gilded;
    }

    public void setGilded(Integer gilded) {
        this.gilded = gilded;
    }

    public Integer getDowns() {
        return downs;
    }

    public void setDowns(Integer downs) {
        this.downs = downs;
    }

    public Boolean getBrandSafe() {
        return brandSafe;
    }

    public void setBrandSafe(Boolean brandSafe) {
        this.brandSafe = brandSafe;
    }

    public SecureMediaEmbed getSecureMediaEmbed() {
        return secureMediaEmbed;
    }

    public void setSecureMediaEmbed(SecureMediaEmbed secureMediaEmbed) {
        this.secureMediaEmbed = secureMediaEmbed;
    }

    public Object getRemovalReason() {
        return removalReason;
    }

    public void setRemovalReason(Object removalReason) {
        this.removalReason = removalReason;
    }

    public Object getAuthorFlairText() {
        return authorFlairText;
    }

    public void setAuthorFlairText(Object authorFlairText) {
        this.authorFlairText = authorFlairText;
    }

    public Boolean getStickied() {
        return stickied;
    }

    public void setStickied(Boolean stickied) {
        this.stickied = stickied;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public Boolean getCanGild() {
        return canGild;
    }

    public void setCanGild(Boolean canGild) {
        this.canGild = canGild;
    }

    public Integer getThumbnailHeight() {
        return thumbnailHeight;
    }

    public void setThumbnailHeight(Integer thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Object getParentWhitelistStatus() {
        return parentWhitelistStatus;
    }

    public void setParentWhitelistStatus(Object parentWhitelistStatus) {
        this.parentWhitelistStatus = parentWhitelistStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSpoiler() {
        return spoiler;
    }

    public void setSpoiler(Boolean spoiler) {
        this.spoiler = spoiler;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getSubredditType() {
        return subredditType;
    }

    public void setSubredditType(String subredditType) {
        this.subredditType = subredditType;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getHideScore() {
        return hideScore;
    }

    public void setHideScore(Boolean hideScore) {
        this.hideScore = hideScore;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getWhitelistStatus() {
        return whitelistStatus;
    }

    public void setWhitelistStatus(Object whitelistStatus) {
        this.whitelistStatus = whitelistStatus;
    }

    public Boolean getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(Boolean quarantine) {
        this.quarantine = quarantine;
    }

    public Boolean getSpam() {
        return spam;
    }

    public void setSpam(Boolean spam) {
        this.spam = spam;
    }

    public Integer getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(Integer createdUtc) {
        this.createdUtc = createdUtc;
    }

    public String getSubredditNamePrefixed() {
        return subredditNamePrefixed;
    }

    public void setSubredditNamePrefixed(String subredditNamePrefixed) {
        this.subredditNamePrefixed = subredditNamePrefixed;
    }

    public Integer getUps() {
        return ups;
    }

    public void setUps(Integer ups) {
        this.ups = ups;
    }

    public Object getMedia() {
        return media;
    }

    public void setMedia(Object media) {
        this.media = media;
    }

    public Boolean getIgnoreReports() {
        return ignoreReports;
    }

    public void setIgnoreReports(Boolean ignoreReports) {
        this.ignoreReports = ignoreReports;
    }

    public Integer getNumComments() {
        return numComments;
    }

    public void setNumComments(Integer numComments) {
        this.numComments = numComments;
    }

    public Boolean getIsSelf() {
        return isSelf;
    }

    public void setIsSelf(Boolean isSelf) {
        this.isSelf = isSelf;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getModNote() {
        return modNote;
    }

    public void setModNote(Object modNote) {
        this.modNote = modNote;
    }

    public Boolean getIsVideo() {
        return isVideo;
    }

    public void setIsVideo(Boolean isVideo) {
        this.isVideo = isVideo;
    }

    public Object getDistinguished() {
        return distinguished;
    }

    public void setDistinguished(Object distinguished) {
        this.distinguished = distinguished;
    }

    public String getBanNote() {
        return banNote;
    }

    public void setBanNote(String banNote) {
        this.banNote = banNote;
    }

}
