package com.zombiewar;

public class Scientist extends Survivor {
    public Scientist(String name) {
        super(name, 20, 2);
    }
    
    @Override
    public void attack(Character target) {
        target.takeDamage(2);
    }
}
