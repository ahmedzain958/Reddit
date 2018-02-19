
package com.zain.reddit.models.user_comments;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data_ {

    @SerializedName("subreddit_id")
    @Expose
    private String subredditId;
    @SerializedName("approved_at_utc")
    @Expose
    private Object approvedAtUtc;
    @SerializedName("edited")
    @Expose
    private Object edited;
    @SerializedName("mod_reason_by")
    @Expose
    private Object modReasonBy;
    @SerializedName("banned_by")
    @Expose
    private Object bannedBy;
    @SerializedName("removal_reason")
    @Expose
    private Object removalReason;
    @SerializedName("link_id")
    @Expose
    private String linkId;
    @SerializedName("link_author")
    @Expose
    private String linkAuthor;
    @SerializedName("likes")
    @Expose
    private Boolean likes;
    @SerializedName("replies")
    @Expose
    private String replies;
    @SerializedName("user_reports")
    @Expose
    private List<Object> userReports = null;
    @SerializedName("saved")
    @Expose
    private Boolean saved;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("banned_at_utc")
    @Expose
    private Object bannedAtUtc;
    @SerializedName("mod_reason_title")
    @Expose
    private Object modReasonTitle;
    @SerializedName("gilded")
    @Expose
    private Integer gilded;
    @SerializedName("archived")
    @Expose
    private Boolean archived;
    @SerializedName("report_reasons")
    @Expose
    private Object reportReasons;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("num_comments")
    @Expose
    private Integer numComments;
    @SerializedName("can_mod_post")
    @Expose
    private Boolean canModPost;
    @SerializedName("parent_id")
    @Expose
    private String parentId;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("approved_by")
    @Expose
    private Object approvedBy;
    @SerializedName("over_18")
    @Expose
    private Boolean over18;
    @SerializedName("mod_note")
    @Expose
    private Object modNote;
    @SerializedName("collapsed")
    @Expose
    private Boolean collapsed;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("link_title")
    @Expose
    private String linkTitle;
    @SerializedName("author_flair_css_class")
    @Expose
    private Object authorFlairCssClass;
    @SerializedName("downs")
    @Expose
    private Integer downs;
    @SerializedName("is_submitter")
    @Expose
    private Boolean isSubmitter;
    @SerializedName("collapsed_reason")
    @Expose
    private Object collapsedReason;
    @SerializedName("body_html")
    @Expose
    private String bodyHtml;
    @SerializedName("distinguished")
    @Expose
    private Object distinguished;
    @SerializedName("quarantine")
    @Expose
    private Boolean quarantine;
    @SerializedName("can_gild")
    @Expose
    private Boolean canGild;
    @SerializedName("removed")
    @Expose
    private Boolean removed;
    @SerializedName("approved")
    @Expose
    private Boolean approved;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("score_hidden")
    @Expose
    private Boolean scoreHidden;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("num_reports")
    @Expose
    private Object numReports;
    @SerializedName("link_permalink")
    @Expose
    private String linkPermalink;
    @SerializedName("stickied")
    @Expose
    private Boolean stickied;
    @SerializedName("created")
    @Expose
    private Integer created;
    @SerializedName("subreddit")
    @Expose
    private String subreddit;
    @SerializedName("author_flair_text")
    @Expose
    private Object authorFlairText;
    @SerializedName("link_url")
    @Expose
    private String linkUrl;
    @SerializedName("spam")
    @Expose
    private Boolean spam;
    @SerializedName("created_utc")
    @Expose
    private Integer createdUtc;
    @SerializedName("subreddit_name_prefixed")
    @Expose
    private String subredditNamePrefixed;
    @SerializedName("controversiality")
    @Expose
    private Integer controversiality;
    @SerializedName("ignore_reports")
    @Expose
    private Boolean ignoreReports;
    @SerializedName("mod_reports")
    @Expose
    private List<Object> modReports = null;
    @SerializedName("subreddit_type")
    @Expose
    private String subredditType;
    @SerializedName("ups")
    @Expose
    private Integer ups;

    public String getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

    public Object getApprovedAtUtc() {
        return approvedAtUtc;
    }

    public void setApprovedAtUtc(Object approvedAtUtc) {
        this.approvedAtUtc = approvedAtUtc;
    }

    public Object getEdited() {
        return edited;
    }

    public void setEdited(Object edited) {
        this.edited = edited;
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

    public Object getRemovalReason() {
        return removalReason;
    }

    public void setRemovalReason(Object removalReason) {
        this.removalReason = removalReason;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getLinkAuthor() {
        return linkAuthor;
    }

    public void setLinkAuthor(String linkAuthor) {
        this.linkAuthor = linkAuthor;
    }

    public Boolean getLikes() {
        return likes;
    }

    public void setLikes(Boolean likes) {
        this.likes = likes;
    }

    public String getReplies() {
        return replies;
    }

    public void setReplies(String replies) {
        this.replies = replies;
    }

    public List<Object> getUserReports() {
        return userReports;
    }

    public void setUserReports(List<Object> userReports) {
        this.userReports = userReports;
    }

    public Boolean getSaved() {
        return saved;
    }

    public void setSaved(Boolean saved) {
        this.saved = saved;
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

    public Integer getGilded() {
        return gilded;
    }

    public void setGilded(Integer gilded) {
        this.gilded = gilded;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Object getReportReasons() {
        return reportReasons;
    }

    public void setReportReasons(Object reportReasons) {
        this.reportReasons = reportReasons;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumComments() {
        return numComments;
    }

    public void setNumComments(Integer numComments) {
        this.numComments = numComments;
    }

    public Boolean getCanModPost() {
        return canModPost;
    }

    public void setCanModPost(Boolean canModPost) {
        this.canModPost = canModPost;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public Object getModNote() {
        return modNote;
    }

    public void setModNote(Object modNote) {
        this.modNote = modNote;
    }

    public Boolean getCollapsed() {
        return collapsed;
    }

    public void setCollapsed(Boolean collapsed) {
        this.collapsed = collapsed;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public Object getAuthorFlairCssClass() {
        return authorFlairCssClass;
    }

    public void setAuthorFlairCssClass(Object authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
    }

    public Integer getDowns() {
        return downs;
    }

    public void setDowns(Integer downs) {
        this.downs = downs;
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

    public Object getDistinguished() {
        return distinguished;
    }

    public void setDistinguished(Object distinguished) {
        this.distinguished = distinguished;
    }

    public Boolean getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(Boolean quarantine) {
        this.quarantine = quarantine;
    }

    public Boolean getCanGild() {
        return canGild;
    }

    public void setCanGild(Boolean canGild) {
        this.canGild = canGild;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getScoreHidden() {
        return scoreHidden;
    }

    public void setScoreHidden(Boolean scoreHidden) {
        this.scoreHidden = scoreHidden;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public Object getNumReports() {
        return numReports;
    }

    public void setNumReports(Object numReports) {
        this.numReports = numReports;
    }

    public String getLinkPermalink() {
        return linkPermalink;
    }

    public void setLinkPermalink(String linkPermalink) {
        this.linkPermalink = linkPermalink;
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

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public Object getAuthorFlairText() {
        return authorFlairText;
    }

    public void setAuthorFlairText(Object authorFlairText) {
        this.authorFlairText = authorFlairText;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
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

    public Integer getControversiality() {
        return controversiality;
    }

    public void setControversiality(Integer controversiality) {
        this.controversiality = controversiality;
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

    public String getSubredditType() {
        return subredditType;
    }

    public void setSubredditType(String subredditType) {
        this.subredditType = subredditType;
    }

    public Integer getUps() {
        return ups;
    }

    public void setUps(Integer ups) {
        this.ups = ups;
    }

}
