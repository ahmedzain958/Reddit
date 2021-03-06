
package com.zain.reddit.models.post_details;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data_ implements Parcelable {

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
    private Object bannedBy;
    @SerializedName("subreddit_id")
    @Expose
    private String subredditId;
    @SerializedName("thumbnail_width")
    @Expose
    private Object thumbnailWidth;
    @SerializedName("subreddit")
    @Expose
    private String subreddit;
    @SerializedName("selftext_html")
    @Expose
    private String selftextHtml;
    @SerializedName("selftext")
    @Expose
    private String selftext;
    @SerializedName("likes")
    @Expose
    private Boolean likes;
    @SerializedName("suggested_sort")
    @Expose
    private String suggestedSort;
    @SerializedName("mod_note")
    @Expose
    private Object modNote;
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
    private Object bannedAtUtc;
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
    @SerializedName("removal_reason")
    @Expose
    private Object removalReason;
    @SerializedName("hidden")
    @Expose
    private Boolean hidden;
    @SerializedName("num_comments")
    @Expose
    private Integer numComments;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("hide_score")
    @Expose
    private Boolean hideScore;
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
    @SerializedName("locked")
    @Expose
    private Boolean locked;
    @SerializedName("downs")
    @Expose
    private Integer downs;
    @SerializedName("brand_safe")
    @Expose
    private Boolean brandSafe;
    @SerializedName("secure_media_embed")
    @Expose
    private SecureMediaEmbed secureMediaEmbed;
    @SerializedName("media_embed")
    @Expose
    private MediaEmbed mediaEmbed;
    @SerializedName("spam")
    @Expose
    private Boolean spam;
    @SerializedName("can_gild")
    @Expose
    private Boolean canGild;
    @SerializedName("thumbnail_height")
    @Expose
    private Object thumbnailHeight;
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
    @SerializedName("whitelist_status")
    @Expose
    private Object whitelistStatus;
    @SerializedName("stickied")
    @Expose
    private Boolean stickied;
    @SerializedName("created")
    @Expose
    private Integer created;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("author_flair_text")
    @Expose
    private Object authorFlairText;
    @SerializedName("quarantine")
    @Expose
    private Boolean quarantine;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("created_utc")
    @Expose
    private Integer createdUtc;
    @SerializedName("subreddit_name_prefixed")
    @Expose
    private String subredditNamePrefixed;
    @SerializedName("distinguished")
    @Expose
    private Object distinguished;
    @SerializedName("media")
    @Expose
    private Object media;
    @SerializedName("upvote_ratio")
    @Expose
    private double upvoteRatio;
    @SerializedName("ignore_reports")
    @Expose
    private Boolean ignoreReports;
    @SerializedName("mod_reports")
    @Expose
    private List<Object> modReports = null;
    @SerializedName("is_self")
    @Expose
    private Boolean isSelf;
    @SerializedName("visited")
    @Expose
    private Boolean visited;
    @SerializedName("num_reports")
    @Expose
    private Integer numReports;
    @SerializedName("is_video")
    @Expose
    private Boolean isVideo;
    @SerializedName("ups")
    @Expose
    private Integer ups;
    @SerializedName("link_id")
    @Expose
    private String linkId;
    @SerializedName("parent_id")
    @Expose
    private String parentId;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("collapsed")
    @Expose
    private Boolean collapsed;
    @SerializedName("is_submitter")
    @Expose
    private Boolean isSubmitter;
    @SerializedName("collapsed_reason")
    @Expose
    private Object collapsedReason;
    @SerializedName("body_html")
    @Expose
    private String bodyHtml;
    @SerializedName("score_hidden")
    @Expose
    private Boolean scoreHidden;
    @SerializedName("controversiality")
    @Expose
    private Integer controversiality;
    @SerializedName("depth")
    @Expose
    private Integer depth;
    @SerializedName("replies")
    @Expose
    private Object replies;

    protected Data_(Parcel in) {
        domain = in.readString();
        subredditId = in.readString();
        subreddit = in.readString();
        selftextHtml = in.readString();
        selftext = in.readString();
        byte tmpLikes = in.readByte();
        likes = tmpLikes == 0 ? null : tmpLikes == 1;
        suggestedSort = in.readString();
        byte tmpIsRedditMediaDomain = in.readByte();
        isRedditMediaDomain = tmpIsRedditMediaDomain == 0 ? null : tmpIsRedditMediaDomain == 1;
        id = in.readString();
        if (in.readByte() == 0) {
            viewCount = null;
        } else {
            viewCount = in.readInt();
        }
        byte tmpArchived = in.readByte();
        archived = tmpArchived == 0 ? null : tmpArchived == 1;
        byte tmpClicked = in.readByte();
        clicked = tmpClicked == 0 ? null : tmpClicked == 1;
        author = in.readString();
        if (in.readByte() == 0) {
            numCrossposts = null;
        } else {
            numCrossposts = in.readInt();
        }
        byte tmpSaved = in.readByte();
        saved = tmpSaved == 0 ? null : tmpSaved == 1;
        byte tmpCanModPost = in.readByte();
        canModPost = tmpCanModPost == 0 ? null : tmpCanModPost == 1;
        byte tmpIsCrosspostable = in.readByte();
        isCrosspostable = tmpIsCrosspostable == 0 ? null : tmpIsCrosspostable == 1;
        byte tmpPinned = in.readByte();
        pinned = tmpPinned == 0 ? null : tmpPinned == 1;
        if (in.readByte() == 0) {
            score = null;
        } else {
            score = in.readInt();
        }
        byte tmpOver18 = in.readByte();
        over18 = tmpOver18 == 0 ? null : tmpOver18 == 1;
        byte tmpHidden = in.readByte();
        hidden = tmpHidden == 0 ? null : tmpHidden == 1;
        if (in.readByte() == 0) {
            numComments = null;
        } else {
            numComments = in.readInt();
        }
        thumbnail = in.readString();
        byte tmpHideScore = in.readByte();
        hideScore = tmpHideScore == 0 ? null : tmpHideScore == 1;
        byte tmpContestMode = in.readByte();
        contestMode = tmpContestMode == 0 ? null : tmpContestMode == 1;
        if (in.readByte() == 0) {
            gilded = null;
        } else {
            gilded = in.readInt();
        }
        byte tmpLocked = in.readByte();
        locked = tmpLocked == 0 ? null : tmpLocked == 1;
        if (in.readByte() == 0) {
            downs = null;
        } else {
            downs = in.readInt();
        }
        byte tmpBrandSafe = in.readByte();
        brandSafe = tmpBrandSafe == 0 ? null : tmpBrandSafe == 1;
        byte tmpSpam = in.readByte();
        spam = tmpSpam == 0 ? null : tmpSpam == 1;
        byte tmpCanGild = in.readByte();
        canGild = tmpCanGild == 0 ? null : tmpCanGild == 1;
        byte tmpRemoved = in.readByte();
        removed = tmpRemoved == 0 ? null : tmpRemoved == 1;
        byte tmpApproved = in.readByte();
        approved = tmpApproved == 0 ? null : tmpApproved == 1;
        name = in.readString();
        byte tmpSpoiler = in.readByte();
        spoiler = tmpSpoiler == 0 ? null : tmpSpoiler == 1;
        permalink = in.readString();
        subredditType = in.readString();
        byte tmpStickied = in.readByte();
        stickied = tmpStickied == 0 ? null : tmpStickied == 1;
        if (in.readByte() == 0) {
            created = null;
        } else {
            created = in.readInt();
        }
        url = in.readString();
        byte tmpQuarantine = in.readByte();
        quarantine = tmpQuarantine == 0 ? null : tmpQuarantine == 1;
        title = in.readString();
        if (in.readByte() == 0) {
            createdUtc = null;
        } else {
            createdUtc = in.readInt();
        }
        subredditNamePrefixed = in.readString();
        upvoteRatio = in.readDouble();
        byte tmpIgnoreReports = in.readByte();
        ignoreReports = tmpIgnoreReports == 0 ? null : tmpIgnoreReports == 1;
        byte tmpIsSelf = in.readByte();
        isSelf = tmpIsSelf == 0 ? null : tmpIsSelf == 1;
        byte tmpVisited = in.readByte();
        visited = tmpVisited == 0 ? null : tmpVisited == 1;
        if (in.readByte() == 0) {
            numReports = null;
        } else {
            numReports = in.readInt();
        }
        byte tmpIsVideo = in.readByte();
        isVideo = tmpIsVideo == 0 ? null : tmpIsVideo == 1;
        if (in.readByte() == 0) {
            ups = null;
        } else {
            ups = in.readInt();
        }
        linkId = in.readString();
        parentId = in.readString();
        body = in.readString();
        byte tmpCollapsed = in.readByte();
        collapsed = tmpCollapsed == 0 ? null : tmpCollapsed == 1;
        byte tmpIsSubmitter = in.readByte();
        isSubmitter = tmpIsSubmitter == 0 ? null : tmpIsSubmitter == 1;
        bodyHtml = in.readString();
        byte tmpScoreHidden = in.readByte();
        scoreHidden = tmpScoreHidden == 0 ? null : tmpScoreHidden == 1;
        if (in.readByte() == 0) {
            controversiality = null;
        } else {
            controversiality = in.readInt();
        }
        if (in.readByte() == 0) {
            depth = null;
        } else {
            depth = in.readInt();
        }
    }

    public static final Creator<Data_> CREATOR = new Creator<Data_>() {
        @Override
        public Data_ createFromParcel(Parcel in) {
            return new Data_(in);
        }

        @Override
        public Data_[] newArray(int size) {
            return new Data_[size];
        }
    };

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

    public Object getBannedBy() {
        return bannedBy;
    }

    public void setBannedBy(Object bannedBy) {
        this.bannedBy = bannedBy;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

    public Object getThumbnailWidth() {
        return thumbnailWidth;
    }

    public void setThumbnailWidth(Object thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getSelftextHtml() {
        return selftextHtml;
    }

    public void setSelftextHtml(String selftextHtml) {
        this.selftextHtml = selftextHtml;
    }

    public String getSelftext() {
        return selftext;
    }

    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    public Boolean getLikes() {
        return likes;
    }

    public void setLikes(Boolean likes) {
        this.likes = likes;
    }

    public String getSuggestedSort() {
        return suggestedSort;
    }

    public void setSuggestedSort(String suggestedSort) {
        this.suggestedSort = suggestedSort;
    }

    public Object getModNote() {
        return modNote;
    }

    public void setModNote(Object modNote) {
        this.modNote = modNote;
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

    public Object getBannedAtUtc() {
        return bannedAtUtc;
    }

    public void setBannedAtUtc(Object bannedAtUtc) {
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

    public Object getRemovalReason() {
        return removalReason;
    }

    public void setRemovalReason(Object removalReason) {
        this.removalReason = removalReason;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Integer getNumComments() {
        return numComments;
    }

    public void setNumComments(Integer numComments) {
        this.numComments = numComments;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Boolean getHideScore() {
        return hideScore;
    }

    public void setHideScore(Boolean hideScore) {
        this.hideScore = hideScore;
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

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
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

    public MediaEmbed getMediaEmbed() {
        return mediaEmbed;
    }

    public void setMediaEmbed(MediaEmbed mediaEmbed) {
        this.mediaEmbed = mediaEmbed;
    }

    public Boolean getSpam() {
        return spam;
    }

    public void setSpam(Boolean spam) {
        this.spam = spam;
    }

    public Boolean getCanGild() {
        return canGild;
    }

    public void setCanGild(Boolean canGild) {
        this.canGild = canGild;
    }

    public Object getThumbnailHeight() {
        return thumbnailHeight;
    }

    public void setThumbnailHeight(Object thumbnailHeight) {
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

    public Object getWhitelistStatus() {
        return whitelistStatus;
    }

    public void setWhitelistStatus(Object whitelistStatus) {
        this.whitelistStatus = whitelistStatus;
    }

    public Boolean getStickied() {
        return stickied;
    }

    public void setStickied(Boolean stickied) {
        this.stickied = stickied;
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

    public Object getAuthorFlairText() {
        return authorFlairText;
    }

    public void setAuthorFlairText(Object authorFlairText) {
        this.authorFlairText = authorFlairText;
    }

    public Boolean getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(Boolean quarantine) {
        this.quarantine = quarantine;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Object getDistinguished() {
        return distinguished;
    }

    public void setDistinguished(Object distinguished) {
        this.distinguished = distinguished;
    }

    public Object getMedia() {
        return media;
    }

    public void setMedia(Object media) {
        this.media = media;
    }

    public double getUpvoteRatio() {
        return upvoteRatio;
    }

    public void setUpvoteRatio(double upvoteRatio) {
        this.upvoteRatio = upvoteRatio;
    }

    public Boolean getIgnoreReports() {
        return ignoreReports;
    }

    public void setIgnoreReports(Boolean ignoreReports) {
        this.ignoreReports = ignoreReports;
    }

    public List<Object> getModReports() {
        return modReports;
    }

    public void setModReports(List<Object> modReports) {
        this.modReports = modReports;
    }

    public Boolean getIsSelf() {
        return isSelf;
    }

    public void setIsSelf(Boolean isSelf) {
        this.isSelf = isSelf;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public Integer getNumReports() {
        return numReports;
    }

    public void setNumReports(Integer numReports) {
        this.numReports = numReports;
    }

    public Boolean getIsVideo() {
        return isVideo;
    }

    public void setIsVideo(Boolean isVideo) {
        this.isVideo = isVideo;
    }

    public Integer getUps() {
        return ups;
    }

    public void setUps(Integer ups) {
        this.ups = ups;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getCollapsed() {
        return collapsed;
    }

    public void setCollapsed(Boolean collapsed) {
        this.collapsed = collapsed;
    }

    public Boolean getIsSubmitter() {
        return isSubmitter;
    }

    public void setIsSubmitter(Boolean isSubmitter) {
        this.isSubmitter = isSubmitter;
    }

    public Object getCollapsedReason() {
        return collapsedReason;
    }

    public void setCollapsedReason(Object collapsedReason) {
        this.collapsedReason = collapsedReason;
    }

    public String getBodyHtml() {
        return bodyHtml;
    }

    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

    public Boolean getScoreHidden() {
        return scoreHidden;
    }

    public void setScoreHidden(Boolean scoreHidden) {
        this.scoreHidden = scoreHidden;
    }

    public Integer getControversiality() {
        return controversiality;
    }

    public void setControversiality(Integer controversiality) {
        this.controversiality = controversiality;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Object getReplies() {
        return replies;
    }

    public void setReplies(Object replies) {
        this.replies = replies;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(domain);
        dest.writeString(subredditId);
        dest.writeString(subreddit);
        dest.writeString(selftextHtml);
        dest.writeString(selftext);
        dest.writeByte((byte) (likes == null ? 0 : likes ? 1 : 2));
        dest.writeString(suggestedSort);
        dest.writeByte((byte) (isRedditMediaDomain == null ? 0 : isRedditMediaDomain ? 1 : 2));
        dest.writeString(id);
        if (viewCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(viewCount);
        }
        dest.writeByte((byte) (archived == null ? 0 : archived ? 1 : 2));
        dest.writeByte((byte) (clicked == null ? 0 : clicked ? 1 : 2));
        dest.writeString(author);
        if (numCrossposts == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(numCrossposts);
        }
        dest.writeByte((byte) (saved == null ? 0 : saved ? 1 : 2));
        dest.writeByte((byte) (canModPost == null ? 0 : canModPost ? 1 : 2));
        dest.writeByte((byte) (isCrosspostable == null ? 0 : isCrosspostable ? 1 : 2));
        dest.writeByte((byte) (pinned == null ? 0 : pinned ? 1 : 2));
        if (score == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(score);
        }
        dest.writeByte((byte) (over18 == null ? 0 : over18 ? 1 : 2));
        dest.writeByte((byte) (hidden == null ? 0 : hidden ? 1 : 2));
        if (numComments == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(numComments);
        }
        dest.writeString(thumbnail);
        dest.writeByte((byte) (hideScore == null ? 0 : hideScore ? 1 : 2));
        dest.writeByte((byte) (contestMode == null ? 0 : contestMode ? 1 : 2));
        if (gilded == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(gilded);
        }
        dest.writeByte((byte) (locked == null ? 0 : locked ? 1 : 2));
        if (downs == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(downs);
        }
        dest.writeByte((byte) (brandSafe == null ? 0 : brandSafe ? 1 : 2));
        dest.writeByte((byte) (spam == null ? 0 : spam ? 1 : 2));
        dest.writeByte((byte) (canGild == null ? 0 : canGild ? 1 : 2));
        dest.writeByte((byte) (removed == null ? 0 : removed ? 1 : 2));
        dest.writeByte((byte) (approved == null ? 0 : approved ? 1 : 2));
        dest.writeString(name);
        dest.writeByte((byte) (spoiler == null ? 0 : spoiler ? 1 : 2));
        dest.writeString(permalink);
        dest.writeString(subredditType);
        dest.writeByte((byte) (stickied == null ? 0 : stickied ? 1 : 2));
        if (created == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(created);
        }
        dest.writeString(url);
        dest.writeByte((byte) (quarantine == null ? 0 : quarantine ? 1 : 2));
        dest.writeString(title);
        if (createdUtc == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(createdUtc);
        }
        dest.writeString(subredditNamePrefixed);
        dest.writeDouble(upvoteRatio);
        dest.writeByte((byte) (ignoreReports == null ? 0 : ignoreReports ? 1 : 2));
        dest.writeByte((byte) (isSelf == null ? 0 : isSelf ? 1 : 2));
        dest.writeByte((byte) (visited == null ? 0 : visited ? 1 : 2));
        if (numReports == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(numReports);
        }
        dest.writeByte((byte) (isVideo == null ? 0 : isVideo ? 1 : 2));
        if (ups == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(ups);
        }
        dest.writeString(linkId);
        dest.writeString(parentId);
        dest.writeString(body);
        dest.writeByte((byte) (collapsed == null ? 0 : collapsed ? 1 : 2));
        dest.writeByte((byte) (isSubmitter == null ? 0 : isSubmitter ? 1 : 2));
        dest.writeString(bodyHtml);
        dest.writeByte((byte) (scoreHidden == null ? 0 : scoreHidden ? 1 : 2));
        if (controversiality == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(controversiality);
        }
        if (depth == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(depth);
        }
    }
}
