package dev.perkles.aps;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import models.Animal;
import models.Enviroment;

public class Farm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm);

        LinearLayout aplicationAnimalPlaceholderView = findViewById(R.id.animal_placeholder);
        LinearLayout aplicationAnimalPhotoView = findViewById(R.id.animal_photo_one);
        LinearLayout aplicationAnimalPhotoViewTwoo = findViewById(R.id.animal_photo_twoo);
        LinearLayout aplicationAnimalPhotoViewThree = findViewById(R.id.animal_photo_three);

        Context context = this;
        Enviroment farmEnviroment = new Enviroment();
        farmEnviroment.populate(context);

        List<Animal> randomizeAnimals = farmEnviroment.randomize(3);
        Animal chosedAnimal = farmEnviroment.choseOneAnimalFrom(randomizeAnimals);

        aplicationAnimalPlaceholderView.addView(chosedAnimal.getAnimalShadow());


        aplicationAnimalPhotoView.addView(chosedAnimal.getAnimalPhoto());
        aplicationAnimalPhotoViewTwoo.removeAllViews();
        aplicationAnimalPhotoViewTwoo.addView(randomizeAnimals.get(1).getAnimalPhoto());
        aplicationAnimalPhotoViewThree.removeAllViews();
        aplicationAnimalPhotoViewThree.addView(randomizeAnimals.get(2).getAnimalPhoto());


        chosedAnimal.getAnimalPhoto().setOnTouchListener(new TouchEvent());

    }

    class TouchEvent implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            ClipData data = ClipData.newPlainText("simple_test", "teste");

            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, shadowBuilder, v, 0);
            v.setVisibility(View.INVISIBLE);
            return false;
        }
    }

    class MyOnDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View draggedView, DragEvent event) {

            int action = event.getAction();

            switch (action){

                case DragEvent.ACTION_DRAG_STARTED:
                    // Ação chamada quando o evento de arrastar inicia-se
                    if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                        return (true);
                    }else{
                        return false;
                    }
                case DragEvent.ACTION_DRAG_ENTERED:
                    // Evento chamado quando o objeto arrastado entra em uma área específica
                    draggedView.setBackgroundColor(Color.BLACK);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    // Identifica quando o objeto arrastado deixou específica área
                    break;
                case DragEvent.ACTION_DRAG_LOCATION:
                    // Local do objeto arrastado
                    break;
                case DragEvent.ACTION_DROP:

                    // Identifica evento de soltar objeto arrastado
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    // Termina o evento.
                    break;
            }
            return true;
        }
    }
}
