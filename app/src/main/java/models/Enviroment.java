package models;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

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

    public List<Animal> randomize(int maxAmount, LinearLayout aplicationAnimalPhotoView, LinearLayout aplicationAnimalPhotoViewTwoo, LinearLayout aplicationAnimalPhotoViewThree) {
        List<Animal> randomizedList = new ArrayList<>();
        List<Integer> uniqueIndexes = new ArrayList<>();

        int RandomViewOrder[] = generateRandomViewOrder();

        while (maxAmount != 0){
            Random randomize = new Random();
            int randomIndex = randomize.nextInt(this.enviromentAnimals.size() - 1) + 2 ;

            if(uniqueIndexes.contains(randomIndex)){
                while (uniqueIndexes.contains(randomIndex)){
                    randomIndex = randomize.nextInt(this.enviromentAnimals.size() - 1) + 2 ;
                }
            }
            uniqueIndexes.add(randomIndex);

            if (maxAmount == RandomViewOrder[0]){
                String IMAGEVIEW_TAG = this.returnAnimalById(randomIndex).getAnimalName();
                aplicationAnimalPhotoView.addView(this.returnAnimalById(randomIndex).getAnimalPhoto());
                aplicationAnimalPhotoView.setTag(IMAGEVIEW_TAG);
            }else if(maxAmount == RandomViewOrder[1]){
                String IMAGEVIEW_TAG2 = this.returnAnimalById(randomIndex).getAnimalName();
                aplicationAnimalPhotoViewTwoo.addView(this.returnAnimalById(randomIndex).getAnimalPhoto());
                aplicationAnimalPhotoViewTwoo.setTag(IMAGEVIEW_TAG2);
            }else if(maxAmount == RandomViewOrder[2]){
                String IMAGEVIEW_TAG3 = this.returnAnimalById(randomIndex).getAnimalName();
                aplicationAnimalPhotoViewThree.addView(this.returnAnimalById(randomIndex).getAnimalPhoto());
                aplicationAnimalPhotoViewThree.setTag(IMAGEVIEW_TAG3);
            }
            randomizedList.add(this.returnAnimalById(randomIndex));
            maxAmount -=1;
        }
        return randomizedList;
    }

    public int[] generateRandomViewOrder(){
        int intArray[] = new int[3];
        int randomOrderIndex = 3;

        Random randomizeNumber = new Random();

        while (randomOrderIndex !=0){

            int randomIndex = randomizeNumber.nextInt(4 - 1) + 1;

            if(contains(intArray, randomIndex)){
                while(contains(intArray, randomIndex)){
                    randomIndex = randomizeNumber.nextInt(4 - 1) + 1;
                }
            }
            intArray[randomOrderIndex -1] = randomIndex;
            randomOrderIndex -= 1;
        }
        return intArray;
    }

    public static boolean contains(int[] array, int v) {

        boolean result = false;

        for(int i : array){
            if(i == v){
                result = true;
                break;
            }
        }

        return result;
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
        donkey.setAnimalName("Donkey");
        donkey.setAnimalPhoto(imageViewDonkey);
        donkey.setAnimalShadow(imageViewDonkeyShwadow);

        MediaPlayer donkey_sound_effect = MediaPlayer.create(viewContext,R.raw.horse_sf);
        donkey.setAnimalSound(donkey_sound_effect);

        ImageView imageViewSheep = new ImageView(viewContext);
        imageViewSheep.setImageResource(R.drawable.sheep);
        ImageView imageViewSheepShadow = new ImageView(viewContext);
        imageViewSheepShadow.setImageResource(R.drawable.sheep_shadow);

        Animal sheep = new Animal();
        sheep.setId(2);
        sheep.setAnimalName("Sheep");
        sheep.setAnimalPhoto(imageViewSheep);
        sheep.setAnimalShadow(imageViewSheepShadow);

        MediaPlayer sheep_sound_effect = MediaPlayer.create(viewContext,R.raw.sheep_sf);
        donkey.setAnimalSound(sheep_sound_effect);

        ImageView imageViewRooster = new ImageView(viewContext);
        imageViewRooster.setImageResource(R.drawable.rooster);
        ImageView imageViewRoosterShadow = new ImageView(viewContext);
        imageViewRoosterShadow.setImageResource(R.drawable.rooster_shadow);

        Animal rooster = new Animal();
        rooster.setId(3);
        rooster.setAnimalName("Rooster");
        rooster.setAnimalPhoto(imageViewRooster);
        rooster.setAnimalShadow(imageViewRoosterShadow);

        MediaPlayer rooster_sound_effect = MediaPlayer.create(viewContext,R.raw.rooster_sf);
        donkey.setAnimalSound(rooster_sound_effect);

        ImageView imageViewPig = new ImageView(viewContext);
        imageViewPig.setImageResource(R.drawable.pig);
        ImageView imageViewPigShadow = new ImageView(viewContext);
        imageViewPigShadow.setImageResource(R.drawable.pig_shadow);

        Animal pig = new Animal();
        pig.setId(4);
        pig.setAnimalName("Pig");
        pig.setAnimalPhoto(imageViewPig);
        pig.setAnimalShadow(imageViewPigShadow);

        MediaPlayer pig_sound_effect = MediaPlayer.create(viewContext,R.raw.pig_sf);
        donkey.setAnimalSound(pig_sound_effect);

        this.setAnimal(donkey);
        this.setAnimal(sheep);
        this.setAnimal(rooster);
        this.setAnimal(pig);

    }

}
