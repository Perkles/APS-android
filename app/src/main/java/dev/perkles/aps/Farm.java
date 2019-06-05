package dev.perkles.aps;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
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

        LinearLayout imageView1 = findViewById(R.id.animal_photo_one);
        LinearLayout imageView2 = findViewById(R.id.animal_photo_twoo);
        LinearLayout imageView3 = findViewById(R.id.animal_photo_three);

        Context context = this;

        Enviroment farmEnviroment = new Enviroment();

        farmEnviroment.populate(context);

        List<Animal> randomizeAnimals = farmEnviroment.randomize(3,imageView1,imageView2,imageView3);

        Animal chosedAnimal = farmEnviroment.choseOneAnimalFrom(randomizeAnimals);

        aplicationAnimalPlaceholderView.addView(chosedAnimal.getAnimalShadow());

        imageView1.setOnTouchListener(new draggableView());
        imageView2.setOnTouchListener(new draggableView());
        imageView3.setOnTouchListener(new draggableView());

        String CHOSED_TAG = chosedAnimal.getAnimalName();
        aplicationAnimalPlaceholderView.setOnDragListener(new dropableView());
        aplicationAnimalPlaceholderView.setTag(CHOSED_TAG);

    }
    private final class draggableView implements View.OnTouchListener {

        @Override
        public boolean onTouch(View draggedView, MotionEvent event) {
/*            String animalviewtext = draggedView.getTag().toString();
            Log.e("teste", animalviewtext);*/
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("simple_test", "teste");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(draggedView);
                draggedView.startDrag(data, shadowBuilder, draggedView, 0);
                return true;
            } else {
                return false;
            }
        }

    }

    private class dropableView implements View.OnDragListener {

        @Override
        public boolean onDrag(View dropedView, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    View view4 = (View) event.getLocalState();
                    String img_select4 = view4.getTag().toString();
                    String teste4 = dropedView.getTag().toString();
                    if (img_select4.equals(teste4)){
                        Log.e("teste", "MATCH");
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;
                default:
                    break;
            }
            return true;
        }

    }
}
