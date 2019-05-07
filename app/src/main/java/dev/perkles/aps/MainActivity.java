package dev.perkles.aps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;

import models.Enviroment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button farmButton = findViewById(R.id.button_farm);
        Button jungleButton = findViewById(R.id.button_jungle);
        Button savanaButton = findViewById(R.id.button_savana);
        Button oceanButton = findViewById(R.id.button_ocean);

        farmButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent intent = new Intent(MainActivity.this, Farm.class);
                startActivity(intent);
            }
        });

        jungleButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String descricao = "Módulo nao disponpivel";
                Toast.makeText(getApplicationContext(), descricao, Toast.LENGTH_SHORT).show();
            }
        });

        savanaButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String descricao = "Módulo nao disponpivel";
                Toast.makeText(getApplicationContext(), descricao, Toast.LENGTH_SHORT).show();
            }
        });

        oceanButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String descricao = "Módulo nao disponpivel";
                Toast.makeText(getApplicationContext(), descricao, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
