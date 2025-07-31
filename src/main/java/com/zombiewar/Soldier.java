package com.zombiewar;

public class Soldier extends Survivor {
    public Soldier(String name) {
        super(name, 100, 10);
    }

    @Override
    public void specialAttack(Character target) {
        target.takeDamage(this.getAttack());
    }
}

