package com.zombiewar;

public class Scientist extends Survivor {
    public Scientist(String name) {
        super(name, 20, 2);
    }

    @Override
    public void specialAttack(Character target) {
        target.takeDamage(this.getAttack());
    }
}
