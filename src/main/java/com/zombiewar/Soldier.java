package com.zombiewar;

public class Soldier extends Survivor {
    public Soldier(String name) {
        super(name, 100, 10);
    }

    @Override
    public void attack(Character target) {
        target.takeDamage(10);
        if (!target.isAlive()) {
            System.out.println("   " + this.getName() + " killed " + target.getName());
        }
    }
}
