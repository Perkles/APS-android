package models;

import android.widget.ImageView;

public class Animal {

    private int id;
    private String animalName;
    private int animalPhoto;
    private int animalShadow;

    public Animal(int id, String sheep, int imageView_sheep, int imageView_sheep_placeholder) {
        this.id = id;
        this.animalName = sheep;
        this.animalPhoto = imageView_sheep;
        this.animalShadow = imageView_sheep_placeholder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getAnimalPhoto() {
        return animalPhoto;
    }

    public void setAnimalPhoto(int animalPhoto) {
        this.animalPhoto = animalPhoto;
    }

    public int getAnimalShadow() {
        return animalShadow;
    }

    public void setAnimalShadow(int animalShadow) {
        this.animalShadow = animalShadow;
    }

}
