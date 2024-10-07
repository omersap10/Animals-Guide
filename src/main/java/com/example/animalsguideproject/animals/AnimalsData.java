package com.example.animalsguideproject.animals;

public class AnimalsData {
    private final int nameResourceId;
    private final int descriptionResourceId;
    private final int imageResourceId;

    public AnimalsData(int nameResourceId, int descriptionResourceId, int imageResourceId) {
        this.nameResourceId = nameResourceId;
        this.descriptionResourceId = descriptionResourceId;
        this.imageResourceId = imageResourceId;
    }

    public int getNameResourceId() {
        return nameResourceId;
    }

    public int getDescriptionResourceId() {
        return descriptionResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
