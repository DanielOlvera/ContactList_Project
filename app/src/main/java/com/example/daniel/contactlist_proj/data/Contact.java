
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
    "name",
    "company",
    "favorite",
    "smallImageURL",
    "largeImageURL",
    "email",
    "website",
    "phone",
    "address"
})
public class Contact implements Parcelable{

    @JsonProperty("name")
    private String name;
    @JsonProperty("company")
    private String company;
    @JsonProperty("favorite")
    private Boolean favorite;
    @JsonProperty("smallImageURL")
    private String smallImageURL;
    @JsonProperty("largeImageURL")
    private String largeImageURL;
    @JsonProperty("email")
    private String email;
    @JsonProperty("website")
    private String website;
    @JsonProperty("phone")
    private Phone phone;
    @JsonProperty("address")
    private Address address;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Contact() {
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("company")
    public String getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(String company) {
        this.company = company;
    }

    @JsonProperty("favorite")
    public Boolean getFavorite() {
        return favorite;
    }

    @JsonProperty("favorite")
    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    @JsonProperty("smallImageURL")
    public String getSmallImageURL() {
        return smallImageURL;
    }

    @JsonProperty("smallImageURL")
    public void setSmallImageURL(String smallImageURL) {
        this.smallImageURL = smallImageURL;
    }

    @JsonProperty("largeImageURL")
    public String getLargeImageURL() {
        return largeImageURL;
    }

    @JsonProperty("largeImageURL")
    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("website")
    public String getWebsite() {
        return website;
    }

    @JsonProperty("website")
    public void setWebsite(String website) {
        this.website = website;
    }

    @JsonProperty("phone")
    public Phone getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    protected Contact(Parcel in) {
        name = in.readString();
        company = in.readString();
        byte favoriteVal = in.readByte();
        favorite = favoriteVal == 0x02 ? null : favoriteVal != 0x00;
        smallImageURL = in.readString();
        largeImageURL = in.readString();
        email = in.readString();
        website = in.readString();
        phone = (Phone) in.readValue(Phone.class.getClassLoader());
        address = (Address) in.readValue(Address.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(company);
        if (favorite == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (favorite ? 0x01 : 0x00));
        }
        dest.writeString(smallImageURL);
        dest.writeString(largeImageURL);
        dest.writeString(email);
        dest.writeString(website);
        dest.writeValue(phone);
        dest.writeValue(address);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

}
