package com.example.battlecastle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button battle_btn, sim1_btn, sim2_btn;
    ImageView p1_char, p2_char;
    Heroes p1, p2;
    boolean p1Win;
    int p1_armytype[], p2_armytype[], p1_troops[], p2_troops[];
    int p1_heroestype, p2_heroestype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        battle_btn = findViewById(R.id.battle_btn);
        p1_char = findViewById(R.id.player1_char);
        p2_char = findViewById(R.id.player2_char);
        sim1_btn = findViewById(R.id.sim1_btn);
        sim2_btn = findViewById(R.id.sim2_btn);

        battle_btn.setOnClickListener(battle_listener);
        sim1_btn.setOnClickListener(sim1_listener);
        sim2_btn.setOnClickListener(sim2_listener);
    }

    View.OnClickListener battle_listener = new View.OnClickListener() {
        @SuppressLint("ResourceType")
        @Override
        public void onClick(View v) {

            if(p1_heroestype == 1){
                p1 = new HeroesArcher(p1_heroestype, p1_armytype, p1_troops);
            }
            else if(p1_heroestype == 2){
                p1 = new HeroesCavalry(p1_heroestype, p1_armytype, p1_troops);
            }
            else {
                p1 = new HeroesInfantry(p1_heroestype, p1_armytype, p1_troops);
            }
            if(p2_heroestype == 1){
                p2 = new HeroesArcher(p2_heroestype, p2_armytype, p2_troops);
            }
            else if(p2_heroestype == 2){
                p2 = new HeroesCavalry(p2_heroestype, p2_armytype, p2_troops);
            }
            else {
                p2 = new HeroesInfantry(p2_heroestype, p2_armytype, p2_troops);
            }

            p1Win = p1.Battle(p1, p2);

            if(p1Win == true){
                Toast.makeText(MainActivity.this, "Player 1 Win", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(MainActivity.this, "Player 2 Win", Toast.LENGTH_LONG).show();
            }

        }
    };

    View.OnClickListener sim1_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            p1_char.setImageResource(R.drawable.cavalry);
            p2_char.setImageResource(R.drawable.infantry);

            p1_heroestype = 2;
            p2_heroestype = 3;

            p1_armytype = new int[]{2};
            p2_armytype = new int[]{3};

            p1_troops = new int[]{100000};
            p2_troops = new int[]{100000};
        }
    };

    View.OnClickListener sim2_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            p1_char.setImageResource(R.drawable.infantry);
            p2_char.setImageResource(R.drawable.cavalry);

            p1_heroestype = 3;
            p2_heroestype = 2;

            p1_armytype = new int[]{3};
            p2_armytype = new int[]{2, 1};

            p1_troops = new int[]{100000};
            p2_troops = new int[]{75000, 25000};
        }
    };

}