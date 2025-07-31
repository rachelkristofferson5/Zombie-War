package com.zombiewar;

public class Soldier extends Character {
    public Soldier(String name) {
        super(name, 150, 20);
    }

    @Override
    public void specialAttack(Character target) {
        target.takeDamage(this.attack);
        System.out.println(this.name + " shot " + target.getName() + " for " + this.attack + " damage.");
    }
}
