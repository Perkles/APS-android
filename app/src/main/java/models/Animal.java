package models;

import android.media.MediaPlayer;
import android.widget.ImageView;

public class Animal {

    private int id;
    private String animalName;
    private ImageView animalPhoto;
    private ImageView animalShadow;
    private MediaPlayer animalSound;

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

    public MediaPlayer getAnimalSound() {
        return animalSound;
    }
    public void setAnimalSound(MediaPlayer animalSound) {
        this.animalSound = animalSound;
    }

}
