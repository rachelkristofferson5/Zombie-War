package com.zombiewar;

import java.util.Random;

// Base class for all survivors
public abstract class Survivor extends Character {

    // Weapon details
    private String weaponName;
    private int weaponDamage;
    private double weaponAccuracy;

    // Random number generator for hit chance
    private final Random rand = new Random();

    // Constructor - sets survivor's name, health, and base attack power
    public Survivor(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    // Equip a weapon with name, damage, and accuracy
    public void setWeapon(String name, int damage, double accuracy) {
        this.weaponName = name;
        this.weaponDamage = Math.max(0, damage);
        this.weaponAccuracy = Math.max(0.0, Math.min(1.0, accuracy));
    }

    // Attack another character
    @Override
    public void attack(Character target) {
        // Don't attack if either character is dead
        if (!this.isAlive() || !target.isAlive()) return;

        int dealt;
        boolean weaponHit = false;

        if (weaponName != null) {
            // Roll for hit chance
            if (rand.nextDouble() <= weaponAccuracy) {
                dealt = this.attackPower() + weaponDamage;
                weaponHit = true;
            } else {
                // Miss with weapon - fallback to base attack
                System.out.println("   " + getName() + " missed with " + weaponName);
                dealt = this.getAttackPower();
                weaponHit = false;
            }
        } else {
            // No weapon equipped - use base attack
            dealt = this.getAttackPower();
        }

        // Apply damage if greater than zero
        if (dealt > 0) {
            target.takeDamage(dealt);
        }

        // If the target died from this attack
        if (!target.isAlive()) {
            if (weaponName != null && weaponHit) {
                System.out.println("   " + getName() + " killed " + target.getName() + " using " + weaponName);
            } else {
                System.out.println("   " + getName() + " killed " + target.getName());
            }
        }
    }
}
