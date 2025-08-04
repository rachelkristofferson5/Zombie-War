package com.zombiewar;

public class Soldier extends Survivor {
    public Soldier(String name) {
        super(name, 100, 10);
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
        return "Soldier (" + this.getHealth() + "/" + this.getMaxHealth() + " HP, " + this.getAttackPower() + " ATK)";
    }
}
