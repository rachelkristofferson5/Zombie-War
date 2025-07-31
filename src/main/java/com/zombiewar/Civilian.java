package com.zombiewar;

public class Civilian extends Character {
    public Civilian(String name) {
        super(name, 100, 10);
    }

    @Override
    public void specialAttack(Character target) {
        target.takeDamage(this.attack);
        System.out.println(this.name + " whacked " + target.getName() + " for " + this.attack + " damage.");
    }
}
