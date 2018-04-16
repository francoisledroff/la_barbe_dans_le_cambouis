/*
 * ******************************************************************************
 *  * ADOBE CONFIDENTIAL
 *  * ___________________
 *  *
 *  * Copyright 2016 Adobe Systems Incorporated
 *  * All Rights Reserved.
 *  *
 *  * NOTICE:  All information contained herein is, and remains
 *  * the property of Adobe Systems Incorporated and its suppliers,
 *  * if any.  The intellectual and technical concepts contained
 *  * herein are proprietary to Adobe Systems Incorporated and its
 *  * suppliers and are protected by trade secret or copyright law.
 *  * Dissemination of this information or reproduction of this material
 *  * is strictly forbidden unless prior written permission is obtained
 *  * from Adobe Systems Incorporated.
 *  *****************************************************************************
 */

package chez.les.barbus.danslecambouis.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Stuff {

  @Id
  private String title;
  private String text;
  @Indexed
  private String author;

  public Stuff() {
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public String toString() {
    return "StuffEntity{" +
        "title='" + title + '\'' +
        ", text='" + text + '\'' +
        '}';
  }
}
