package com.example.battlecastle;

import java.util.Random;

public class HeroesCavalry extends Heroes{

    public static final float kill_infantry = 0.4f;
    public static final float kill_archer = 0.1f;

    public HeroesCavalry(int heroes_type, int[] army_type, int[] troops) {
        super(heroes_type, army_type, troops);
    }

    @Override
    public boolean Battle(Heroes p1, Heroes p2) {
        boolean p1Win;
        Random rand = new Random();
        p1.heroes_send = rand.nextInt(5) + 1;
        p2.heroes_send = rand.nextInt(5) + 1;

        calc_power(p1, p2);
        calc_power(p2, p1);

        if (p1.casualties > p2.casualties) {
            p1Win = false;
            return p1Win;
        } else if (p1.casualties < p2.casualties) {
            p1Win = true;
            return p1Win;
        } else {
            System.out.println("Draw");
        }
        return false;
    }

    @Override
    public void calc_power(Heroes p, Heroes e) {

        for (int i = 0; i < e.army_type.length; i++) {
            for (int j = 0; j < p.army_type.length; j++) {

                if (p.heroes_type == 1) {
                    if (p.army_type[j] == 1) {
                        if (e.army_type[i] == 1) {
                            e.casualties += 0;
                        } else if (e.army_type[i] == 2) {
                            e.casualties += (int) ((p.troops[j] + attack_boost * p.troops[j] * heroes_send) * HeroesArcher.kill_cavalry);
                        } else {
                            e.casualties += (int) ((p.troops[j] + attack_boost * p.troops[j] * heroes_send) * HeroesArcher.kill_infantry);
                        }
                    } else if (p.army_type[j] == 2) {
                        if (e.army_type[i] == 1) {
                            e.casualties += (int) ((p.troops[j]) * HeroesCavalry.kill_archer);
                        } else if (e.army_type[i] == 2) {
                            e.casualties += 0;
                        } else {
                            e.casualties += (int) ((p.troops[j]) * HeroesCavalry.kill_infantry);
                        }
                    } else {
                        if (e.army_type[i] == 1) {
                            e.casualties += (int) ((p.troops[j]) * HeroesInfantry.kill_archer);
                        } else if (e.army_type[i] == 2) {
                            e.casualties += (int) ((p.troops[j]) * HeroesInfantry.kill_calavry);
                        } else {
                            e.casualties += 0;
                        }
                    }

                } else if (p.heroes_type == 2) {

                    if (p.army_type[j] == 1) {
                        if (e.army_type[i] == 1) {
                            e.casualties += 0;
                        } else if (e.army_type[i] == 2) {
                            e.casualties += (int) ((p.troops[j]) * HeroesArcher.kill_cavalry);
                        } else {
                            e.casualties += (int) ((p.troops[j]) * HeroesArcher.kill_infantry);
                        }
                    } else if (p.army_type[j] == 2) {
                        if (e.army_type[i] == 1) {
                            e.casualties += (int) ((p.troops[j] + attack_boost * p.troops[j] * heroes_send) * HeroesCavalry.kill_archer);
                        } else if (e.army_type[i] == 2) {
                            e.casualties += 0;
                        } else {
                            e.casualties += (int) ((p.troops[j] + attack_boost * p.troops[j] * heroes_send) * HeroesCavalry.kill_infantry);
                        }
                    } else {
                        if (e.army_type[i] == 1) {
                            e.casualties += (int) ((p.troops[j]) * HeroesInfantry.kill_archer);
                        } else if (e.army_type[i] == 2) {
                            e.casualties += (int) ((p.troops[j]) * HeroesInfantry.kill_calavry);
                        } else {
                            e.casualties += 0;
                        }

                    }
                } else {

                    if (p.army_type[j] == 1) {
                        if (e.army_type[i] == 1) {
                            e.casualties += 0;
                        } else if (e.army_type[i] == 2) {
                            e.casualties += (int) ((p.troops[j]) * HeroesArcher.kill_cavalry);
                        } else {
                            e.casualties += (int) ((p.troops[j]) * HeroesArcher.kill_infantry);
                        }
                    } else if (p.army_type[j] == 2) {
                        if (e.army_type[i] == 1) {
                            e.casualties += (int) ((p.troops[j]) * HeroesCavalry.kill_archer);
                        } else if (e.army_type[i] == 2) {
                            e.casualties += 0;
                        } else {
                            e.casualties += (int) ((p.troops[j]) * HeroesCavalry.kill_infantry);
                        }
                    } else {
                        if (e.army_type[i] == 1) {
                            e.casualties += (int) ((p.troops[j] + attack_boost * p.troops[j] * heroes_send) * HeroesInfantry.kill_archer);
                        } else if (e.army_type[i] == 2) {
                            e.casualties += (int) ((p.troops[j] + attack_boost * p.troops[j] * heroes_send) * HeroesInfantry.kill_calavry);
                        } else {
                            e.casualties += 0;
                        }
                    }

                }

            }
        }
    }
}
