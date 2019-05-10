package models;

import android.content.Context;
import android.widget.ImageView;

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
        Animal pickedAnimal = new Animal();
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

    public List<Animal> randomize(int maxAmount) {
        List<Animal> randomizedList = new ArrayList<>();
        while (maxAmount != 0){
            Random randomize = new Random();
            int randomIndex = randomize.nextInt(this.enviromentAnimals.size() +1);
            if (randomIndex == 0){
                randomIndex +=1;
            }
            randomizedList.add(this.returnAnimalById(randomIndex));
            maxAmount -=1;
        }
        return randomizedList;
    }

    public Animal choseOneAnimalFrom(List<Animal> randomizeAnimals) {

        Animal choosedAnimal = new Animal();

        for (Animal animal : randomizeAnimals) {
            choosedAnimal = animal;
        }
        return choosedAnimal;
    }

    public void populate(Context viewContext) {

        this.setEnviromentName("Farm");

        ImageView imageViewDonkey = new ImageView(viewContext);
        imageViewDonkey.setImageResource(R.drawable.donkey);
        ImageView imageViewDonkeyShwadow = new ImageView(viewContext);
        imageViewDonkeyShwadow.setImageResource(R.drawable.donkey_shadow);

        Animal donkey = new Animal();
        donkey.setId(1);
        donkey.setAnimalName("Downkey");
        donkey.setAnimalPhoto(imageViewDonkey);
        donkey.setAnimalShadow(imageViewDonkeyShwadow);


        ImageView imageViewSheep = new ImageView(viewContext);
        imageViewSheep.setImageResource(R.drawable.sheep);
        ImageView imageViewSheepShadow = new ImageView(viewContext);
        imageViewSheepShadow.setImageResource(R.drawable.sheep_shadow);

        Animal sheep = new Animal();
        sheep.setId(2);
        sheep.setAnimalName("Sheep");
        sheep.setAnimalPhoto(imageViewSheep);
        sheep.setAnimalShadow(imageViewSheepShadow);

        ImageView imageViewRooster = new ImageView(viewContext);
        imageViewRooster.setImageResource(R.drawable.rooster);
        ImageView imageViewRoosterShadow = new ImageView(viewContext);
        imageViewRoosterShadow.setImageResource(R.drawable.rooster_shadow);

        Animal rooster = new Animal();
        rooster.setId(3);
        rooster.setAnimalName("Rooster");
        rooster.setAnimalPhoto(imageViewRooster);
        rooster.setAnimalShadow(imageViewRoosterShadow);

        ImageView imageViewPig = new ImageView(viewContext);
        imageViewPig.setImageResource(R.drawable.pig);
        ImageView imageViewPigShadow = new ImageView(viewContext);
        imageViewPigShadow.setImageResource(R.drawable.pig_shadow);

        Animal pig = new Animal();
        pig.setId(4);
        pig.setAnimalName("Pig");
        pig.setAnimalPhoto(imageViewPig);
        pig.setAnimalShadow(imageViewPigShadow);

        this.setAnimal(donkey);
        this.setAnimal(sheep);
        this.setAnimal(rooster);
        this.setAnimal(pig);

    }

}
