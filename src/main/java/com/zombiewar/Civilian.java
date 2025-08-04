package com.zombiewar;

public class Civilian extends Survivor {
    public Civilian(String name) {
        super(name, 50, 5);
    }

    @Override
    public void attack(Character target) {
        target.takeDamage(this.getAttackPower());
        if (!target.isAlive()) {
            System.out.println("   " + this.getName() + " killed " + target.getName());
        }
    }

    @Override
    public String toString() {
        return "Civilian (" + this.getHealth() + "/" + this.getMaxHealth() + " HP, " + this.getAttackPower() + " ATK)";
    }
}
