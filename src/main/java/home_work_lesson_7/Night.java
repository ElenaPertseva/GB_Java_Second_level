package home_work_lesson_7;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Icon",
        "IconPhrase",
        "HasPrecipitation",
        "PrecipitationType",
        "PrecipitationIntensity"
})
@Generated("jsonschema2pojo")
public class Night {

    @JsonProperty("Icon")
    private Integer icon;
    @JsonProperty("IconPhrase")
    private String iconPhrase;
    @JsonProperty("HasPrecipitation")
    private Boolean hasPrecipitation;
    @JsonProperty("PrecipitationType")
    private String precipitationType;
    @JsonProperty("PrecipitationIntensity")
    private String precipitationIntensity;

    /**
     * No args constructor for use in serialization
     *
     */
    public Night() {
    }

    /**
     *
     * @param hasPrecipitation
     * @param precipitationIntensity
     * @param precipitationType
     * @param icon
     * @param iconPhrase
     */
    public Night(Integer icon, String iconPhrase, Boolean hasPrecipitation, String precipitationType, String precipitationIntensity) {
        super();
        this.icon = icon;
        this.iconPhrase = iconPhrase;
        this.hasPrecipitation = hasPrecipitation;
        this.precipitationType = precipitationType;
        this.precipitationIntensity = precipitationIntensity;
    }

    @JsonProperty("Icon")
    public Integer getIcon() {
        return icon;
    }

    @JsonProperty("Icon")
    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public Night withIcon(Integer icon) {
        this.icon = icon;
        return this;
    }

    @JsonProperty("IconPhrase")
    public String getIconPhrase() {
        return iconPhrase;
    }

    @JsonProperty("IconPhrase")
    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    public Night withIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
        return this;
    }

    @JsonProperty("HasPrecipitation")
    public Boolean getHasPrecipitation() {
        return hasPrecipitation;
    }

    @JsonProperty("HasPrecipitation")
    public void setHasPrecipitation(Boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    public Night withHasPrecipitation(Boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
        return this;
    }

    @JsonProperty("PrecipitationType")
    public String getPrecipitationType() {
        return precipitationType;
    }

    @JsonProperty("PrecipitationType")
    public void setPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType;
    }

    public Night withPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType;
        return this;
    }

    @JsonProperty("PrecipitationIntensity")
    public String getPrecipitationIntensity() {
        return precipitationIntensity;
    }

    @JsonProperty("PrecipitationIntensity")
    public void setPrecipitationIntensity(String precipitationIntensity) {
        this.precipitationIntensity = precipitationIntensity;
    }

    public Night withPrecipitationIntensity(String precipitationIntensity) {
        this.precipitationIntensity = precipitationIntensity;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Night.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("icon");
        sb.append('=');
        sb.append(((this.icon == null)?"<null>":this.icon));
        sb.append(',');
        sb.append("iconPhrase");
        sb.append('=');
        sb.append(((this.iconPhrase == null)?"<null>":this.iconPhrase));
        sb.append(',');
        sb.append("hasPrecipitation");
        sb.append('=');
        sb.append(((this.hasPrecipitation == null)?"<null>":this.hasPrecipitation));
        sb.append(',');
        sb.append("precipitationType");
        sb.append('=');
        sb.append(((this.precipitationType == null)?"<null>":this.precipitationType));
        sb.append(',');
        sb.append("precipitationIntensity");
        sb.append('=');
        sb.append(((this.precipitationIntensity == null)?"<null>":this.precipitationIntensity));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
