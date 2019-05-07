package models;

import android.widget.ImageView;

public class Animal {

    private String animalName;
    private ImageView animalPhoto;
    private ImageView animalShadow;

    public Animal(String sheep, int imageView_sheep, int imageView_sheep_placeholder) {
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public ImageView getAnimalPhoto() {
        return animalPhoto;
    }

    public void setAnimalPhoto(ImageView animalPhoto) {
        this.animalPhoto = animalPhoto;
    }

    public ImageView getAnimalShadow() {
        return animalShadow;
    }

    public void setAnimalShadow(ImageView animalShadow) {
        this.animalShadow = animalShadow;
    }
}
