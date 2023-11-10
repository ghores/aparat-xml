package com.example.aparat.model;

import java.io.Serializable;
import java.lang.String;

public class Video implements Serializable {
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
}
