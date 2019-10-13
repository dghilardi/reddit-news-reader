
package org.ghilardi.newsreader.model.dto.reddit.news;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.ghilardi.newsreader.model.dto.reddit.core.RedditContentDto;
import org.ghilardi.newsreader.model.dto.reddit.news.beans.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RedditNewsDataDto extends RedditContentDto {

    @JsonProperty("approved_at_utc")
    private final Object approvedAtUtc;
    @JsonProperty("subreddit")
    private final String subreddit;
    @JsonProperty("selftext")
    private final String selftext;
    @JsonProperty("author_fullname")
    private final String authorFullname;
    @JsonProperty("saved")
    private final Boolean saved;
    @JsonProperty("mod_reason_title")
    private final Object modReasonTitle;
    @JsonProperty("gilded")
    private final Integer gilded;
    @JsonProperty("clicked")
    private final Boolean clicked;
    @JsonProperty("title")
    private final String title;
    @JsonProperty("link_flair_richtext")
    private final List<Object> linkFlairRichtext = null;
    @JsonProperty("subreddit_name_prefixed")
    private final String subredditNamePrefixed;
    @JsonProperty("hidden")
    private final Boolean hidden;
    @JsonProperty("pwls")
    private final Integer pwls;
    @JsonProperty("link_flair_css_class")
    private final Object linkFlairCssClass;
    @JsonProperty("downs")
    private final Integer downs;
    @JsonProperty("thumbnail_height")
    private final Integer thumbnailHeight;
    @JsonProperty("hide_score")
    private final Boolean hideScore;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("quarantine")
    private final Boolean quarantine;
    @JsonProperty("link_flair_text_color")
    private final String linkFlairTextColor;
    @JsonProperty("author_flair_background_color")
    private final Object authorFlairBackgroundColor;
    @JsonProperty("subreddit_type")
    private final String subredditType;
    @JsonProperty("ups")
    private final Integer ups;
    @JsonProperty("total_awards_received")
    private final Integer totalAwardsReceived;
    @JsonProperty("media_embed")
    private final MediaEmbed mediaEmbed;
    @JsonProperty("thumbnail_width")
    private final Integer thumbnailWidth;
    @JsonProperty("author_flair_template_id")
    private final Object authorFlairTemplateId;
    @JsonProperty("is_original_content")
    private final Boolean isOriginalContent;
    @JsonProperty("user_reports")
    private final List<Object> userReports = null;
    @JsonProperty("secure_media")
    private final Object secureMedia;
    @JsonProperty("is_reddit_media_domain")
    private final Boolean isRedditMediaDomain;
    @JsonProperty("is_meta")
    private final Boolean isMeta;
    @JsonProperty("category")
    private final Object category;
    @JsonProperty("secure_media_embed")
    private final SecureMediaEmbed secureMediaEmbed;
    @JsonProperty("link_flair_text")
    private final Object linkFlairText;
    @JsonProperty("can_mod_post")
    private final Boolean canModPost;
    @JsonProperty("score")
    private final Integer score;
    @JsonProperty("approved_by")
    private final Object approvedBy;
    @JsonProperty("thumbnail")
    private final String thumbnail;
    @JsonProperty("edited")
    private final Boolean edited;
    @JsonProperty("author_flair_css_class")
    private final Object authorFlairCssClass;
    @JsonProperty("steward_reports")
    private final List<Object> stewardReports = null;
    @JsonProperty("author_flair_richtext")
    private final List<Object> authorFlairRichtext = null;
    @JsonProperty("gildings")
    private final Gildings gildings;
    @JsonProperty("post_hint")
    private final String postHint;
    @JsonProperty("content_categories")
    private final Object contentCategories;
    @JsonProperty("is_self")
    private final Boolean isSelf;
    @JsonProperty("mod_note")
    private final Object modNote;
    @JsonProperty("created")
    private final Integer created;
    @JsonProperty("link_flair_type")
    private final String linkFlairType;
    @JsonProperty("wls")
    private final Integer wls;
    @JsonProperty("banned_by")
    private final Object bannedBy;
    @JsonProperty("author_flair_type")
    private final String authorFlairType;
    @JsonProperty("domain")
    private final String domain;
    @JsonProperty("allow_live_comments")
    private final Boolean allowLiveComments;
    @JsonProperty("selftext_html")
    private final Object selftextHtml;
    @JsonProperty("likes")
    private final Object likes;
    @JsonProperty("suggested_sort")
    private final Object suggestedSort;
    @JsonProperty("banned_at_utc")
    private final Object bannedAtUtc;
    @JsonProperty("view_count")
    private final Object viewCount;
    @JsonProperty("archived")
    private final Boolean archived;
    @JsonProperty("no_follow")
    private final Boolean noFollow;
    @JsonProperty("is_crosspostable")
    private final Boolean isCrosspostable;
    @JsonProperty("pinned")
    private final Boolean pinned;
    @JsonProperty("over_18")
    private final Boolean over18;
    @JsonProperty("preview")
    private final Preview preview;
    @JsonProperty("all_awardings")
    private final List<AllAwarding> allAwardings = null;
    @JsonProperty("awarders")
    private final List<Object> awarders = null;
    @JsonProperty("media_only")
    private final Boolean mediaOnly;
    @JsonProperty("can_gild")
    private final Boolean canGild;
    @JsonProperty("spoiler")
    private final Boolean spoiler;
    @JsonProperty("locked")
    private final Boolean locked;
    @JsonProperty("author_flair_text")
    private final Object authorFlairText;
    @JsonProperty("visited")
    private final Boolean visited;
    @JsonProperty("num_reports")
    private final Object numReports;
    @JsonProperty("distinguished")
    private final Object distinguished;
    @JsonProperty("subreddit_id")
    private final String subredditId;
    @JsonProperty("mod_reason_by")
    private final Object modReasonBy;
    @JsonProperty("removal_reason")
    private final Object removalReason;
    @JsonProperty("link_flair_background_color")
    private final String linkFlairBackgroundColor;
    @JsonProperty("id")
    private final String id;
    @JsonProperty("is_robot_indexable")
    private final Boolean isRobotIndexable;
    @JsonProperty("report_reasons")
    private final Object reportReasons;
    @JsonProperty("author")
    private final String author;
    @JsonProperty("discussion_type")
    private final Object discussionType;
    @JsonProperty("num_comments")
    private final Integer numComments;
    @JsonProperty("send_replies")
    private final Boolean sendReplies;
    @JsonProperty("whitelist_status")
    private final String whitelistStatus;
    @JsonProperty("contest_mode")
    private final Boolean contestMode;
    @JsonProperty("mod_reports")
    private final List<Object> modReports = null;
    @JsonProperty("author_patreon_flair")
    private final Boolean authorPatreonFlair;
    @JsonProperty("author_flair_text_color")
    private final Object authorFlairTextColor;
    @JsonProperty("permalink")
    private final String permalink;
    @JsonProperty("parent_whitelist_status")
    private final String parentWhitelistStatus;
    @JsonProperty("stickied")
    private final Boolean stickied;
    @JsonProperty("url")
    private final String url;
    @JsonProperty("subreddit_subscribers")
    private final Integer subredditSubscribers;
    @JsonProperty("created_utc")
    private final Integer createdUtc;
    @JsonProperty("num_crossposts")
    private final Integer numCrossposts;
    @JsonProperty("media")
    private final Object media;
    @JsonProperty("is_video")
    private final Boolean isVideo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
