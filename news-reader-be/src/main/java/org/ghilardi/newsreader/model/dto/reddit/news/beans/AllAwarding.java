
package org.ghilardi.newsreader.model.dto.reddit.news.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AllAwarding {

    @JsonProperty("count")
    private final Integer count;
    @JsonProperty("is_enabled")
    private final Boolean isEnabled;
    @JsonProperty("subreddit_id")
    private final Object subredditId;
    @JsonProperty("description")
    private final String description;
    @JsonProperty("end_date")
    private final Object endDate;
    @JsonProperty("coin_reward")
    private final Integer coinReward;
    @JsonProperty("icon_url")
    private final String iconUrl;
    @JsonProperty("days_of_premium")
    private final Integer daysOfPremium;
    @JsonProperty("id")
    private final String id;
    @JsonProperty("icon_height")
    private final Integer iconHeight;
    @JsonProperty("resized_icons")
    private final List<ResizedIcon> resizedIcons = null;
    @JsonProperty("days_of_drip_extension")
    private final Integer daysOfDripExtension;
    @JsonProperty("award_type")
    private final String awardType;
    @JsonProperty("start_date")
    private final Object startDate;
    @JsonProperty("coin_price")
    private final Integer coinPrice;
    @JsonProperty("icon_width")
    private final Integer iconWidth;
    @JsonProperty("subreddit_coin_reward")
    private final Integer subredditCoinReward;
    @JsonProperty("name")
    private final String name;
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
