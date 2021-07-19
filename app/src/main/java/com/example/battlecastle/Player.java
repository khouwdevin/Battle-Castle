package com.example.battlecastle;

import java.util.Random;

import static com.example.battlecastle.Heroes.attack_boost;

public class Player {

    private int heroes_send;
    private int heroes_type;
    private int army_type[];
    private int troops[];
    private int casualties;

    public Player(int heroes_type, int army_type[], int troops[]){
        this.heroes_type = heroes_type;
        this.army_type = army_type;
        this.troops = troops;
        this.casualties = 0;
    }

    public boolean Battle(Player p1, Player p2){
        boolean p1Win;
        Random rand = new Random();
        p1.heroes_send = rand.nextInt(5) + 1;
        p2.heroes_send = rand.nextInt(5) + 1;

        calc_power(p1, p2);
        calc_power(p2, p1);

        if(p1.casualties > p2.casualties){
            p1Win = true;
            return p1Win;
        }
        else if(p1.casualties < p2.casualties){
            p1Win = false;
            return p1Win;
        }
        else{
            System.out.println("Draw");
        }
        return false;
    }

    public void calc_power(Player p, Player e) {
        for (int i = 0; i < e.army_type.length; i++) {
            for (int j = 0; j < p.army_type.length; j++) {

                if (p.heroes_type == 1) {
                    if (p.army_type[j] == 1) {
                        if (e.army_type[i] == 1) {
                            e.casualties += 0;
                        } else if (e.army_type[i] == 2) {
                            e.casualties += (int) ((p.troops[i] + attack_boost * p.troops[i] * heroes_send) * HeroesArcher.kill_cavalry);
                        } else {
                            e.casualties += (int) ((p.troops[i] + attack_boost * p.troops[i] * heroes_send) * HeroesArcher.kill_infantry);
                        }
                    } else if (p.army_type[j] == 2) {
                        if (e.army_type[i] == 1) {
                            e.casualties += (int) ((p.troops[i]) * HeroesCavalry.kill_archer);
                        } else if (e.army_type[i] == 2) {
                            e.casualties += 0;
                        } else {
                            e.casualties += (int) ((p.troops[i]) * HeroesCavalry.kill_infantry);
                        }
                    } else {
                        if (e.army_type[i] == 1) {
                            e.casualties += (int) ((p.troops[i]) * HeroesInfantry.kill_archer);
                        } else if (e.army_type[i] == 2) {
                            e.casualties += (int) ((p.troops[i]) * HeroesInfantry.kill_calavry);
                        } else {
                            e.casualties += 0;
                        }
                    }

                } else if (p.heroes_type == 2) {

                    if (p.army_type[j] == 1) {
                        if (e.army_type[i] == 1) {
                            e.casualties += 0;
                        } else if (e.army_type[i] == 2) {
                            e.casualties += (int) ((p.troops[i]) * HeroesArcher.kill_cavalry);
                        } else {
                            e.casualties += (int) ((p.troops[i]) * HeroesArcher.kill_infantry);
                        }
                    } else if (p.army_type[j] == 2) {
                        if (e.army_type[i] == 1) {
                            e.casualties += (int) ((p.troops[i] + attack_boost * p.troops[i] * heroes_send) * HeroesCavalry.kill_archer);
                        } else if (e.army_type[i] == 2) {
                            e.casualties += 0;
                        } else {
                            e.casualties += (int) ((p.troops[i] + attack_boost * p.troops[i] * heroes_send) * HeroesCavalry.kill_infantry);
                        }
                    } else {
                        if (e.army_type[i] == 1) {
                            e.casualties += (int) ((p.troops[i]) * HeroesInfantry.kill_archer);
                        } else if (e.army_type[i] == 2) {
                            e.casualties += (int) ((p.troops[i]) * HeroesInfantry.kill_calavry);
                        } else {
                            e.casualties += 0;
                        }

                    }
                } else {

                    if (p.army_type[j] == 1) {
                        if (e.army_type[i] == 1) {
                            e.casualties += 0;
                        } else if (e.army_type[i] == 2) {
                            e.casualties += (int) ((p.troops[i]) * HeroesArcher.kill_cavalry);
                        } else {
                            e.casualties += (int) ((p.troops[i]) * HeroesArcher.kill_infantry);
                        }
                    } else if (p.army_type[j] == 2) {
                        if (e.army_type[i] == 1) {
                            e.casualties += (int) ((p.troops[i]) * HeroesCavalry.kill_archer);
                        } else if (e.army_type[i] == 2) {
                            e.casualties += 0;
                        } else {
                            e.casualties += (int) ((p.troops[i]) * HeroesCavalry.kill_infantry);
                        }
                    } else {
                        if (e.army_type[i] == 1) {
                            e.casualties += (int) ((p.troops[i] + attack_boost * p.troops[i] * heroes_send) * HeroesInfantry.kill_archer);
                        } else if (e.army_type[i] == 2) {
                            e.casualties += (int) ((p.troops[i] + attack_boost * p.troops[i] * heroes_send) * HeroesInfantry.kill_calavry);
                        } else {
                            e.casualties += 0;
                        }
                    }

                }

            }
        }
    }
}
