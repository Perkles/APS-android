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

    public Animal getAnimal() {
        return null;
    }
    
    public Animal returnAnimalById(int animalId){
        Animal pickedAnimal = new Animal(1,"Sheep", R.id.imageView_sheep, R.id.imageView_sheep_placeholder);
        for (Animal animal : this.enviromentAnimals) {
            if(animal.getId() == animalId){
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
        maxAmount = maxAmount -1;
        List<Animal> randomizedList = new ArrayList<>();

        while (maxAmount != 0){

            Random randomize = new Random();

            randomizedList.add(this.returnAnimalById(randomize.nextInt(this.enviromentAnimals.size())));

            maxAmount -=1;
        }
        return randomizedList;
    }

    public void choseOneAnimalFrom(List<Animal> randomizeAnimals){
/*        Animal chosedAnimal = new Animal(1,"Sheep", R.id.imageView_sheep, R.id.imageView_sheep_placeholder);

        Random randomize = new Random();
        int index = randomize.nextInt(randomizeAnimals.size());

        chosedAnimal = randomizeAnimals.returnAnimalById();



        return null;*/

    }


}
