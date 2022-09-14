package com.example.application.data.dto;

import java.util.UUID;

public abstract class AbstractDTO {

    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        if (id != null) {
            return id.hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractDTO)) {
            return false; // null or other class
        }
        AbstractDTO other = (AbstractDTO) obj;

        if (id != null) {
            return id.equals(other.id) && getClass() == other.getClass();
        }
        return super.equals(other);
    }
}
