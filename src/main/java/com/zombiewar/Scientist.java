package com.zombiewar;

public class Scientist extends Character {
    public Scientist(String name) {
        super(name, 50, 5);
    }

    @Override
    public void specialAttack(Character target) {
        target.takeDamage(this.attack);
        System.out.println(this.name + " zapped " + target.getName() + " for " + this.attack + " damage.");
    }
}
