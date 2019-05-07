package models;

import java.util.ArrayList;
import java.util.Collection;

import dev.perkles.aps.R;

public class Enviroment {

    private String enviromentName;
    private ArrayList<Animal> enviromentAnimals = new ArrayList<Animal>();

    public String getEnviromentName() {
        return enviromentName;
    }

    public void setEnviromentName(String enviromentName) {
        this.enviromentName = enviromentName;
    }

    public Animal getAnimal() {
        return null;
    }

    public void setAnimal(Animal animal) {
       this.enviromentAnimals.add(animal);
    }

    public void populate() {

        this.setEnviromentName("Farm");
        Animal sheep = new Animal("Sheep", R.id.imageView_sheep, R.id.imageView_sheep_placeholder);
        Animal sheep2 = new Animal("Sheep", R.id.imageView_sheep, R.id.imageView_sheep_placeholder);
        Animal sheep3 = new Animal("Sheep", R.id.imageView_sheep, R.id.imageView_sheep_placeholder);
        Animal sheep4 = new Animal("Sheep", R.id.imageView_sheep, R.id.imageView_sheep_placeholder);
        this.setAnimal(sheep2);
        this.setAnimal(sheep3);
        this.setAnimal(sheep4);
        this.setAnimal(sheep);


    }
}
