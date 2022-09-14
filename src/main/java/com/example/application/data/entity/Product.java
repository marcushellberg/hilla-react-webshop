package com.example.application.data.entity;

import javax.annotation.Nonnull;
import javax.persistence.Entity;

@Entity
public class Product extends AbstractEntity {
  private String name;

  private String description;

  public String getName() {
    return name;
  }

  public void setName(@Nonnull String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}