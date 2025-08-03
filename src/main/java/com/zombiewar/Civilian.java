package com.zombiewar;

public class Civilian extends Survivor {
    public Civilian(String name) {
        super(name, 50, 5);
    }

    @Override
    public void attack(Character target) {
        target.takeDamage(this.getAttackPower());
    }

    @Override
    public String toString() {
        return "Civilian (" + this.getHealth() + "/" + this.getMaxHealth() + " HP, " + this.getAttackPower() + " ATK)";
    }
}
