package dev.perkles.aps;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        LinearLayout imageView1 = findViewById(R.id.animal_photo_one);
        LinearLayout imageView2 = findViewById(R.id.animal_photo_twoo);
        LinearLayout imageView3 = findViewById(R.id.animal_photo_three);

        Context context = this;

        Enviroment farmEnviroment = new Enviroment();

        farmEnviroment.populate(context);

        List<Animal> randomizeAnimals = farmEnviroment.randomize(3,imageView1,imageView2,imageView3);

        Animal chosedAnimal = farmEnviroment.choseOneAnimalFrom(randomizeAnimals);

        aplicationAnimalPlaceholderView.addView(chosedAnimal.getAnimalShadow());

        imageView1.setOnTouchListener(new TouchEvent());
        imageView2.setOnTouchListener(new TouchEvent());
        imageView3.setOnTouchListener(new TouchEvent());
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
        public boolean onDrag(View v, DragEvent event) {

            int action = event.getAction();

            switch (action){
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d("MyApp",v.getTag().toString());
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d("MyApp",v.getTag().toString());
                    break;
                case DragEvent.ACTION_DRAG_LOCATION:
                    Log.d("MyApp",v.getTag().toString());
                    break;
                case DragEvent.ACTION_DROP:
                    Log.d("MyApp",v.getTag().toString());
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d("MyApp",v.getTag().toString());
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d("MyApp",v.getTag().toString());
                    break;
            }
            return true;
        }
    }
}
