package com.example.battlecastle;

import java.util.Random;

public abstract class Heroes {

    public static final float attack_boost = 0.4f;

    public int heroes_send;
    public int heroes_type;
    public int army_type[];
    public int troops[];
    public int casualties;

    public Heroes(int heroes_type, int army_type[], int troops[]){
        this.heroes_type = heroes_type;
        this.army_type = army_type;
        this.troops = troops;
        this.casualties = 0;
    }

    public abstract boolean Battle(Heroes p1, Heroes p2);

    public abstract void calc_power(Heroes p, Heroes e);
}
