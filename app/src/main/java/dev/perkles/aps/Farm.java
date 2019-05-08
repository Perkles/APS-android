package dev.perkles.aps;

import android.content.ClipData;
import android.content.ClipDescription;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;

import java.util.List;

import models.Animal;
import models.Enviroment;

public class Farm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm);

        Enviroment farmEnviroment = new Enviroment();
        farmEnviroment.populate();
        List<Animal> randomizeAnimals = farmEnviroment.randomize(3);
        Animal chosedAnimal = farmEnviroment.choseOneAnimalFrom(randomizeAnimals);

        findViewById(R.id.imageView_sheep_placeholder).setOnLongClickListener(new MyOnLongClickListener());
        findViewById(R.id.imageView_sheep).setOnLongClickListener(new MyOnLongClickListener());
    }

    class MyOnLongClickListener implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("simple_test", "teste");

            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, shadowBuilder, v, 0);
            v.setVisibility(View.INVISIBLE);
            return true;
        }
    }

    class MyOnDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {

            int action = event.getAction();

            switch (action){
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_LOCATION:
                    break;
                case DragEvent.ACTION_DROP:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;
            }
            return true;
        }
    }
}
