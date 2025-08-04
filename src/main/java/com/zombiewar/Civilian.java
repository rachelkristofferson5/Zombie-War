package com.zombiewar;

public class Civilian extends Survivor {
    public Civilian(String name) {
        super(name, 50, 5);
    }

    @Override
    public void attack(Character target) {
        target.takeDamage(5);
        if (!target.isAlive()) {
            System.out.println("   " + this.getName() + " killed " + target.getName());
        }
    }
}
