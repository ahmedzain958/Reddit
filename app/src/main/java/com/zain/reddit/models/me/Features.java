
package com.zain.reddit.models.me;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Features {

    @SerializedName("search_public_traffic")
    @Expose
    private Boolean searchPublicTraffic;
    @SerializedName("ad_moderation")
    @Expose
    private Boolean adModeration;
    @SerializedName("mweb_xpromo_modal_listing_click_daily_dismissible_ios")
    @Expose
    private Boolean mwebXpromoModalListingClickDailyDismissibleIos;
    @SerializedName("show_amp_link")
    @Expose
    private Boolean showAmpLink;
    @SerializedName("interest_targeting")
    @Expose
    private Boolean interestTargeting;
    @SerializedName("live_happening_now")
    @Expose
    private Boolean liveHappeningNow;
    @SerializedName("adserver_reporting")
    @Expose
    private Boolean adserverReporting;
    @SerializedName("geopopular")
    @Expose
    private Boolean geopopular;
    @SerializedName("chat_rollout")
    @Expose
    private Boolean chatRollout;
    @SerializedName("legacy_search_pref")
    @Expose
    private Boolean legacySearchPref;
    @SerializedName("listing_service_rampup")
    @Expose
    private Boolean listingServiceRampup;
    @SerializedName("mobile_web_targeting")
    @Expose
    private Boolean mobileWebTargeting;
    @SerializedName("default_srs_holdout")
    @Expose
    private DefaultSrsHoldout defaultSrsHoldout;
    @SerializedName("adzerk_do_not_track")
    @Expose
    private Boolean adzerkDoNotTrack;
    @SerializedName("users_listing")
    @Expose
    private Boolean usersListing;
    @SerializedName("ads_auto_extend")
    @Expose
    private Boolean adsAutoExtend;
    @SerializedName("whitelisted_pms")
    @Expose
    private Boolean whitelistedPms;
    @SerializedName("inbox_push")
    @Expose
    private Boolean inboxPush;
    @SerializedName("personalization_prefs")
    @Expose
    private Boolean personalizationPrefs;
    @SerializedName("user_otp")
    @Expose
    private Boolean userOtp;
    @SerializedName("new_overview")
    @Expose
    private Boolean newOverview;
    @SerializedName("new_report_flow")
    @Expose
    private Boolean newReportFlow;
    @SerializedName("block_user_by_report")
    @Expose
    private Boolean blockUserByReport;
    @SerializedName("post_to_profile_beta")
    @Expose
    private Boolean postToProfileBeta;
    @SerializedName("ads_auto_refund")
    @Expose
    private Boolean adsAutoRefund;
    @SerializedName("orangereds_as_emails")
    @Expose
    private Boolean orangeredsAsEmails;
    @SerializedName("do_not_track")
    @Expose
    private Boolean doNotTrack;
    @SerializedName("crossposting_recent")
    @Expose
    private Boolean crosspostingRecent;
    @SerializedName("heartbeat_events")
    @Expose
    private Boolean heartbeatEvents;
    @SerializedName("expando_events")
    @Expose
    private Boolean expandoEvents;
    @SerializedName("eu_cookie_policy")
    @Expose
    private Boolean euCookiePolicy;
    @SerializedName("programmatic_ads")
    @Expose
    private Boolean programmaticAds;
    @SerializedName("force_https")
    @Expose
    private Boolean forceHttps;
    @SerializedName("activity_service_write")
    @Expose
    private Boolean activityServiceWrite;
    @SerializedName("chat_menu_notification")
    @Expose
    private Boolean chatMenuNotification;
    @SerializedName("ads_auction")
    @Expose
    private Boolean adsAuction;
    @SerializedName("crossposting_ga")
    @Expose
    private Boolean crosspostingGa;
    @SerializedName("outbound_clicktracking")
    @Expose
    private Boolean outboundClicktracking;
    @SerializedName("new_loggedin_cache_policy")
    @Expose
    private Boolean newLoggedinCachePolicy;
    @SerializedName("ios_profile_edit")
    @Expose
    private Boolean iosProfileEdit;
    @SerializedName("https_redirect")
    @Expose
    private Boolean httpsRedirect;
    @SerializedName("mweb_xpromo_interstitial_comments_ios")
    @Expose
    private Boolean mwebXpromoInterstitialCommentsIos;
    @SerializedName("pause_ads")
    @Expose
    private Boolean pauseAds;
    @SerializedName("native_ad_server")
    @Expose
    private Boolean nativeAdServer;
    @SerializedName("give_hsts_grants")
    @Expose
    private Boolean giveHstsGrants;
    @SerializedName("geopopular_ie_holdout")
    @Expose
    private GeopopularIeHoldout geopopularIeHoldout;
    @SerializedName("show_recommended_link")
    @Expose
    private Boolean showRecommendedLink;
    @SerializedName("mweb_xpromo_interstitial_comments_android")
    @Expose
    private Boolean mwebXpromoInterstitialCommentsAndroid;
    @SerializedName("screenview_events")
    @Expose
    private Boolean screenviewEvents;
    @SerializedName("new_report_dialog")
    @Expose
    private Boolean newReportDialog;
    @SerializedName("moat_tracking")
    @Expose
    private Boolean moatTracking;
    @SerializedName("subreddit_rules")
    @Expose
    private Boolean subredditRules;
    @SerializedName("upgrade_cookies")
    @Expose
    private Boolean upgradeCookies;
    @SerializedName("mobile_native_banner")
    @Expose
    private Boolean mobileNativeBanner;
    @SerializedName("show_user_sr_name")
    @Expose
    private Boolean showUserSrName;
    @SerializedName("onboarding_splash2")
    @Expose
    private Boolean onboardingSplash2;
    @SerializedName("post_embed")
    @Expose
    private Boolean postEmbed;
    @SerializedName("adzerk_reporting_2")
    @Expose
    private Boolean adzerkReporting2;
    @SerializedName("chat_group_rollout")
    @Expose
    private Boolean chatGroupRollout;
    @SerializedName("scroll_events")
    @Expose
    private Boolean scrollEvents;
    @SerializedName("mweb_xpromo_modal_listing_click_daily_dismissible_android")
    @Expose
    private Boolean mwebXpromoModalListingClickDailyDismissibleAndroid;
    @SerializedName("adblock_test")
    @Expose
    private Boolean adblockTest;
    @SerializedName("activity_service_read")
    @Expose
    private Boolean activityServiceRead;

    public Boolean getSearchPublicTraffic() {
        return searchPublicTraffic;
    }

    public void setSearchPublicTraffic(Boolean searchPublicTraffic) {
        this.searchPublicTraffic = searchPublicTraffic;
    }

    public Boolean getAdModeration() {
        return adModeration;
    }

    public void setAdModeration(Boolean adModeration) {
        this.adModeration = adModeration;
    }

    public Boolean getMwebXpromoModalListingClickDailyDismissibleIos() {
        return mwebXpromoModalListingClickDailyDismissibleIos;
    }

    public void setMwebXpromoModalListingClickDailyDismissibleIos(Boolean mwebXpromoModalListingClickDailyDismissibleIos) {
        this.mwebXpromoModalListingClickDailyDismissibleIos = mwebXpromoModalListingClickDailyDismissibleIos;
    }

    public Boolean getShowAmpLink() {
        return showAmpLink;
    }

    public void setShowAmpLink(Boolean showAmpLink) {
        this.showAmpLink = showAmpLink;
    }

    public Boolean getInterestTargeting() {
        return interestTargeting;
    }

    public void setInterestTargeting(Boolean interestTargeting) {
        this.interestTargeting = interestTargeting;
    }

    public Boolean getLiveHappeningNow() {
        return liveHappeningNow;
    }

    public void setLiveHappeningNow(Boolean liveHappeningNow) {
        this.liveHappeningNow = liveHappeningNow;
    }

    public Boolean getAdserverReporting() {
        return adserverReporting;
    }

    public void setAdserverReporting(Boolean adserverReporting) {
        this.adserverReporting = adserverReporting;
    }

    public Boolean getGeopopular() {
        return geopopular;
    }

    public void setGeopopular(Boolean geopopular) {
        this.geopopular = geopopular;
    }

    public Boolean getChatRollout() {
        return chatRollout;
    }

    public void setChatRollout(Boolean chatRollout) {
        this.chatRollout = chatRollout;
    }

    public Boolean getLegacySearchPref() {
        return legacySearchPref;
    }

    public void setLegacySearchPref(Boolean legacySearchPref) {
        this.legacySearchPref = legacySearchPref;
    }

    public Boolean getListingServiceRampup() {
        return listingServiceRampup;
    }

    public void setListingServiceRampup(Boolean listingServiceRampup) {
        this.listingServiceRampup = listingServiceRampup;
    }

    public Boolean getMobileWebTargeting() {
        return mobileWebTargeting;
    }

    public void setMobileWebTargeting(Boolean mobileWebTargeting) {
        this.mobileWebTargeting = mobileWebTargeting;
    }

    public DefaultSrsHoldout getDefaultSrsHoldout() {
        return defaultSrsHoldout;
    }

    public void setDefaultSrsHoldout(DefaultSrsHoldout defaultSrsHoldout) {
        this.defaultSrsHoldout = defaultSrsHoldout;
    }

    public Boolean getAdzerkDoNotTrack() {
        return adzerkDoNotTrack;
    }

    public void setAdzerkDoNotTrack(Boolean adzerkDoNotTrack) {
        this.adzerkDoNotTrack = adzerkDoNotTrack;
    }

    public Boolean getUsersListing() {
        return usersListing;
    }

    public void setUsersListing(Boolean usersListing) {
        this.usersListing = usersListing;
    }

    public Boolean getAdsAutoExtend() {
        return adsAutoExtend;
    }

    public void setAdsAutoExtend(Boolean adsAutoExtend) {
        this.adsAutoExtend = adsAutoExtend;
    }

    public Boolean getWhitelistedPms() {
        return whitelistedPms;
    }

    public void setWhitelistedPms(Boolean whitelistedPms) {
        this.whitelistedPms = whitelistedPms;
    }

    public Boolean getInboxPush() {
        return inboxPush;
    }

    public void setInboxPush(Boolean inboxPush) {
        this.inboxPush = inboxPush;
    }

    public Boolean getPersonalizationPrefs() {
        return personalizationPrefs;
    }

    public void setPersonalizationPrefs(Boolean personalizationPrefs) {
        this.personalizationPrefs = personalizationPrefs;
    }

    public Boolean getUserOtp() {
        return userOtp;
    }

    public void setUserOtp(Boolean userOtp) {
        this.userOtp = userOtp;
    }

    public Boolean getNewOverview() {
        return newOverview;
    }

    public void setNewOverview(Boolean newOverview) {
        this.newOverview = newOverview;
    }

    public Boolean getNewReportFlow() {
        return newReportFlow;
    }

    public void setNewReportFlow(Boolean newReportFlow) {
        this.newReportFlow = newReportFlow;
    }

    public Boolean getBlockUserByReport() {
        return blockUserByReport;
    }

    public void setBlockUserByReport(Boolean blockUserByReport) {
        this.blockUserByReport = blockUserByReport;
    }

    public Boolean getPostToProfileBeta() {
        return postToProfileBeta;
    }

    public void setPostToProfileBeta(Boolean postToProfileBeta) {
        this.postToProfileBeta = postToProfileBeta;
    }

    public Boolean getAdsAutoRefund() {
        return adsAutoRefund;
    }

    public void setAdsAutoRefund(Boolean adsAutoRefund) {
        this.adsAutoRefund = adsAutoRefund;
    }

    public Boolean getOrangeredsAsEmails() {
        return orangeredsAsEmails;
    }

    public void setOrangeredsAsEmails(Boolean orangeredsAsEmails) {
        this.orangeredsAsEmails = orangeredsAsEmails;
    }

    public Boolean getDoNotTrack() {
        return doNotTrack;
    }

    public void setDoNotTrack(Boolean doNotTrack) {
        this.doNotTrack = doNotTrack;
    }

    public Boolean getCrosspostingRecent() {
        return crosspostingRecent;
    }

    public void setCrosspostingRecent(Boolean crosspostingRecent) {
        this.crosspostingRecent = crosspostingRecent;
    }

    public Boolean getHeartbeatEvents() {
        return heartbeatEvents;
    }

    public void setHeartbeatEvents(Boolean heartbeatEvents) {
        this.heartbeatEvents = heartbeatEvents;
    }

    public Boolean getExpandoEvents() {
        return expandoEvents;
    }

    public void setExpandoEvents(Boolean expandoEvents) {
        this.expandoEvents = expandoEvents;
    }

    public Boolean getEuCookiePolicy() {
        return euCookiePolicy;
    }

    public void setEuCookiePolicy(Boolean euCookiePolicy) {
        this.euCookiePolicy = euCookiePolicy;
    }

    public Boolean getProgrammaticAds() {
        return programmaticAds;
    }

    public void setProgrammaticAds(Boolean programmaticAds) {
        this.programmaticAds = programmaticAds;
    }

    public Boolean getForceHttps() {
        return forceHttps;
    }

    public void setForceHttps(Boolean forceHttps) {
        this.forceHttps = forceHttps;
    }

    public Boolean getActivityServiceWrite() {
        return activityServiceWrite;
    }

    public void setActivityServiceWrite(Boolean activityServiceWrite) {
        this.activityServiceWrite = activityServiceWrite;
    }

    public Boolean getChatMenuNotification() {
        return chatMenuNotification;
    }

    public void setChatMenuNotification(Boolean chatMenuNotification) {
        this.chatMenuNotification = chatMenuNotification;
    }

    public Boolean getAdsAuction() {
        return adsAuction;
    }

    public void setAdsAuction(Boolean adsAuction) {
        this.adsAuction = adsAuction;
    }

    public Boolean getCrosspostingGa() {
        return crosspostingGa;
    }

    public void setCrosspostingGa(Boolean crosspostingGa) {
        this.crosspostingGa = crosspostingGa;
    }

    public Boolean getOutboundClicktracking() {
        return outboundClicktracking;
    }

    public void setOutboundClicktracking(Boolean outboundClicktracking) {
        this.outboundClicktracking = outboundClicktracking;
    }

    public Boolean getNewLoggedinCachePolicy() {
        return newLoggedinCachePolicy;
    }

    public void setNewLoggedinCachePolicy(Boolean newLoggedinCachePolicy) {
        this.newLoggedinCachePolicy = newLoggedinCachePolicy;
    }

    public Boolean getIosProfileEdit() {
        return iosProfileEdit;
    }

    public void setIosProfileEdit(Boolean iosProfileEdit) {
        this.iosProfileEdit = iosProfileEdit;
    }

    public Boolean getHttpsRedirect() {
        return httpsRedirect;
    }

    public void setHttpsRedirect(Boolean httpsRedirect) {
        this.httpsRedirect = httpsRedirect;
    }

    public Boolean getMwebXpromoInterstitialCommentsIos() {
        return mwebXpromoInterstitialCommentsIos;
    }

    public void setMwebXpromoInterstitialCommentsIos(Boolean mwebXpromoInterstitialCommentsIos) {
        this.mwebXpromoInterstitialCommentsIos = mwebXpromoInterstitialCommentsIos;
    }

    public Boolean getPauseAds() {
        return pauseAds;
    }

    public void setPauseAds(Boolean pauseAds) {
        this.pauseAds = pauseAds;
    }

    public Boolean getNativeAdServer() {
        return nativeAdServer;
    }

    public void setNativeAdServer(Boolean nativeAdServer) {
        this.nativeAdServer = nativeAdServer;
    }

    public Boolean getGiveHstsGrants() {
        return giveHstsGrants;
    }

    public void setGiveHstsGrants(Boolean giveHstsGrants) {
        this.giveHstsGrants = giveHstsGrants;
    }

    public GeopopularIeHoldout getGeopopularIeHoldout() {
        return geopopularIeHoldout;
    }

    public void setGeopopularIeHoldout(GeopopularIeHoldout geopopularIeHoldout) {
        this.geopopularIeHoldout = geopopularIeHoldout;
    }

    public Boolean getShowRecommendedLink() {
        return showRecommendedLink;
    }

    public void setShowRecommendedLink(Boolean showRecommendedLink) {
        this.showRecommendedLink = showRecommendedLink;
    }

    public Boolean getMwebXpromoInterstitialCommentsAndroid() {
        return mwebXpromoInterstitialCommentsAndroid;
    }

    public void setMwebXpromoInterstitialCommentsAndroid(Boolean mwebXpromoInterstitialCommentsAndroid) {
        this.mwebXpromoInterstitialCommentsAndroid = mwebXpromoInterstitialCommentsAndroid;
    }

    public Boolean getScreenviewEvents() {
        return screenviewEvents;
    }

    public void setScreenviewEvents(Boolean screenviewEvents) {
        this.screenviewEvents = screenviewEvents;
    }

    public Boolean getNewReportDialog() {
        return newReportDialog;
    }

    public void setNewReportDialog(Boolean newReportDialog) {
        this.newReportDialog = newReportDialog;
    }

    public Boolean getMoatTracking() {
        return moatTracking;
    }

    public void setMoatTracking(Boolean moatTracking) {
        this.moatTracking = moatTracking;
    }

    public Boolean getSubredditRules() {
        return subredditRules;
    }

    public void setSubredditRules(Boolean subredditRules) {
        this.subredditRules = subredditRules;
    }

    public Boolean getUpgradeCookies() {
        return upgradeCookies;
    }

    public void setUpgradeCookies(Boolean upgradeCookies) {
        this.upgradeCookies = upgradeCookies;
    }

    public Boolean getMobileNativeBanner() {
        return mobileNativeBanner;
    }

    public void setMobileNativeBanner(Boolean mobileNativeBanner) {
        this.mobileNativeBanner = mobileNativeBanner;
    }

    public Boolean getShowUserSrName() {
        return showUserSrName;
    }

    public void setShowUserSrName(Boolean showUserSrName) {
        this.showUserSrName = showUserSrName;
    }

    public Boolean getOnboardingSplash2() {
        return onboardingSplash2;
    }

    public void setOnboardingSplash2(Boolean onboardingSplash2) {
        this.onboardingSplash2 = onboardingSplash2;
    }

    public Boolean getPostEmbed() {
        return postEmbed;
    }

    public void setPostEmbed(Boolean postEmbed) {
        this.postEmbed = postEmbed;
    }

    public Boolean getAdzerkReporting2() {
        return adzerkReporting2;
    }

    public void setAdzerkReporting2(Boolean adzerkReporting2) {
        this.adzerkReporting2 = adzerkReporting2;
    }

    public Boolean getChatGroupRollout() {
        return chatGroupRollout;
    }

    public void setChatGroupRollout(Boolean chatGroupRollout) {
        this.chatGroupRollout = chatGroupRollout;
    }

    public Boolean getScrollEvents() {
        return scrollEvents;
    }

    public void setScrollEvents(Boolean scrollEvents) {
        this.scrollEvents = scrollEvents;
    }

    public Boolean getMwebXpromoModalListingClickDailyDismissibleAndroid() {
        return mwebXpromoModalListingClickDailyDismissibleAndroid;
    }

    public void setMwebXpromoModalListingClickDailyDismissibleAndroid(Boolean mwebXpromoModalListingClickDailyDismissibleAndroid) {
        this.mwebXpromoModalListingClickDailyDismissibleAndroid = mwebXpromoModalListingClickDailyDismissibleAndroid;
    }

    public Boolean getAdblockTest() {
        return adblockTest;
    }

    public void setAdblockTest(Boolean adblockTest) {
        this.adblockTest = adblockTest;
    }

    public Boolean getActivityServiceRead() {
        return activityServiceRead;
    }

    public void setActivityServiceRead(Boolean activityServiceRead) {
        this.activityServiceRead = activityServiceRead;
    }

}
