package com.zombiewar;

public class Scientist extends Survivor {
    public Scientist(String name) {
        super(name, 20, 2);
    }

    @Override
    public void attack(Character target) {
        target.takeDamage(this.getAttackPower());
    }

    @Override
    public String toString() {
        return "Scientist (" + this.getHealth() + "/" + this.getMaxHealth() + " HP, " + this.getAttackPower() + " ATK)";
    }
}
