package com.example.aparat.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.lang.String;

public class Video implements Parcelable {
  private String special;

  private String creator;

  private String view;

  private String cat_id;

  private String icon;

  private String link;

  private String description;

  private String id;

  private String time;

  private String title;

  public Video() {
  }

  protected Video(Parcel in) {
    special = in.readString();
    creator = in.readString();
    view = in.readString();
    cat_id = in.readString();
    icon = in.readString();
    link = in.readString();
    description = in.readString();
    id = in.readString();
    time = in.readString();
    title = in.readString();
  }

  public static final Creator<Video> CREATOR = new Creator<Video>() {
    @Override
    public Video createFromParcel(Parcel in) {
      return new Video(in);
    }

    @Override
    public Video[] newArray(int size) {
      return new Video[size];
    }
  };

  public String getSpecial() {
    return this.special;
  }

  public void setSpecial(String special) {
    this.special = special;
  }

  public String getCreator() {
    return this.creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public String getView() {
    return this.view;
  }

  public void setView(String view) {
    this.view = view;
  }

  public String getCat_id() {
    return this.cat_id;
  }

  public void setCat_id(String cat_id) {
    this.cat_id = cat_id;
  }

  public String getIcon() {
    return this.icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getLink() {
    return this.link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTime() {
    return this.time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(@NonNull Parcel dest, int flags) {
    dest.writeString(special);
    dest.writeString(creator);
    dest.writeString(view);
    dest.writeString(cat_id);
    dest.writeString(icon);
    dest.writeString(link);
    dest.writeString(description);
    dest.writeString(id);
    dest.writeString(time);
    dest.writeString(title);
  }
}
