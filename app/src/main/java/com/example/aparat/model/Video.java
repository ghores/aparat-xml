package com.example.aparat.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.lang.String;

@Entity(tableName = "tbl_video")
public class Video implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    int videoId;
    @ColumnInfo(name = "special")
    private String special;
    @ColumnInfo(name = "creator")
    private String creator;
    @ColumnInfo(name = "view")
    private String view;
    @ColumnInfo(name = "cat_id")
    private String cat_id;
    @ColumnInfo(name = "icon")
    private String icon;
    @ColumnInfo(name = "link")
    private String link;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "id")
    private String id;
    @ColumnInfo(name = "time")
    private String time;
    @ColumnInfo(name = "title")
    private String title;

    public Video() {
    }

    public Video(String special, String creator, String view, String cat_id, String icon, String link, String description, String id, String time, String title) {
        this.special = special;
        this.creator = creator;
        this.view = view;
        this.cat_id = cat_id;
        this.icon = icon;
        this.link = link;
        this.description = description;
        this.id = id;
        this.time = time;
        this.title = title;
    }

    @Ignore
    public Video(int videoId, String special, String creator, String view, String cat_id, String icon, String link, String description, String id, String time, String title) {
        this.videoId = videoId;
        this.special = special;
        this.creator = creator;
        this.view = view;
        this.cat_id = cat_id;
        this.icon = icon;
        this.link = link;
        this.description = description;
        this.id = id;
        this.time = time;
        this.title = title;
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

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

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
