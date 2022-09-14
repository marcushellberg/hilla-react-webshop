package com.example.application.data.entity;

import javax.annotation.Nonnull;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class Product extends AbstractEntity {
  @Nonnull
  @Size(min = 1, max = 140)
  private String name;

  private String desctiption;

  @Nonnull
  public String getName() {
    return name;
  }

  public void setName(@Nonnull String name) {
    this.name = name;
  }

  public String getDescription() {
    return desctiption;
  }

  public void setDescription(String description) {
    this.desctiption = description;
  }
}