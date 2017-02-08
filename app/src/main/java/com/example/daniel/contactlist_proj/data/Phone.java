
package com.example.daniel.contactlist_proj.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "work",
    "home",
    "mobile"
})
public class Phone implements Parcelable{

    @JsonProperty("work")
    private String work;
    @JsonProperty("home")
    private String home;
    @JsonProperty("mobile")
    private String mobile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("work")
    public String getWork() {
        return work;
    }

    @JsonProperty("work")
    public void setWork(String work) {
        this.work = work;
    }

    @JsonProperty("home")
    public String getHome() {
        return home;
    }

    @JsonProperty("home")
    public void setHome(String home) {
        this.home = home;
    }

    @JsonProperty("mobile")
    public String getMobile() {
        return mobile;
    }

    @JsonProperty("mobile")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Phone() {
    }

    protected Phone(Parcel in) {
        work = in.readString();
        home = in.readString();
        mobile = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(work);
        dest.writeString(home);
        dest.writeString(mobile);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Phone> CREATOR = new Parcelable.Creator<Phone>() {
        @Override
        public Phone createFromParcel(Parcel in) {
            return new Phone(in);
        }

        @Override
        public Phone[] newArray(int size) {
            return new Phone[size];
        }
    };

}
