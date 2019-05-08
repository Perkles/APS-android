package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    
    public Animal returnAnimalById(int animalId){
        Animal pickedAnimal = new Animal(0,"", 0, 0);
        for (Animal animal : this.enviromentAnimals) {
            if(animalId == animal.getId()){
                pickedAnimal = animal;
            }
        }
        return pickedAnimal;
    }

    public void setAnimal(Animal animal) {
       this.enviromentAnimals.add(animal);
    }

    public void populate() {

        this.setEnviromentName("Farm");
        Animal sheep = new Animal(1,"Sheep", R.id.imageView_sheep, R.id.imageView_sheep_placeholder);
        Animal sheep2 = new Animal(2,"Sheep", R.id.imageView_sheep, R.id.imageView_sheep_placeholder);
        Animal sheep3 = new Animal(3,"Sheep", R.id.imageView_sheep, R.id.imageView_sheep_placeholder);
        Animal sheep4 = new Animal(4,"Sheep", R.id.imageView_sheep, R.id.imageView_sheep_placeholder);
        this.setAnimal(sheep2);
        this.setAnimal(sheep3);
        this.setAnimal(sheep4);
        this.setAnimal(sheep);
    }

    public List<Animal> randomize(int maxAmount) {
        List<Animal> randomizedList = new ArrayList<>();
        while (maxAmount != 0){
            Random randomize = new Random();
            randomizedList.add(this.returnAnimalById(randomize.nextInt(this.enviromentAnimals.size())));
            maxAmount -=1;
        }
        return randomizedList;
    }

    public Animal choseOneAnimalFrom(List<Animal> randomizeAnimals) {

        Animal choosedAnimal = new Animal(0,"", 0, 0);
        Random randomize = new Random();
        int index = randomize.nextInt(randomizeAnimals.size());
        for (Animal animal : randomizeAnimals) {
            if(index == animal.getId()){
                choosedAnimal = animal;
            }
        }
        return choosedAnimal;
    }

}
