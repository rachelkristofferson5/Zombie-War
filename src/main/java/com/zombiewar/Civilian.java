package com.zombiewar;

public class Civilian extends Survivor {
    public Civilian(String name) {
        super(name, 50, 5);
    }

    @Override
    public void specialAttack(Character target) {
        target.takeDamage(this.getAttack());
    }
}
