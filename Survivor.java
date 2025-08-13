package com.zombiewar;

import java.util.Random;

// Base class for all survivors
public abstract class Survivor extends Character {

    // Weapon name
    private String weaponName;

    // Weapon damage on a hit
    private int weaponDamage;

    // Chance to hit 
    private double weaponAccuracy;

    // Used for hit rolls
    private final Random rand = new Random();

    // Sets name, health, and attack power
    public Survivor(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    // Gives this survivor a weapon
    public void setWeapon(String name, int damage, double accuracy) {
        this.weaponName = name;
        this.weaponDamage = Math.max(0, damage);
        this.weaponAccuracy = Math.max(0.0, Math.min(1.0, accuracy));
    }

    // Attacks another character
    @Override
    public void attack(Character target) {
        if (!this.isAlive() || !target.isAlive()) return;

        int dealt;

        if (weaponName != null) {
       // If weapon is equipped, roll to see if the attack hits
        if (rand.nextDouble() <= weaponAccuracy) {
            dealt = weaponDamage;  
        } else {
            // If miss, print message and use base attack power instead
            System.out.println("   " + getName() + " missed with " + weaponName);
            dealt = attackPower;
        }
    } else {
        // If no weapon, use base attack power
        dealt = attackPower;
    }

    // Apply damage to the target if greater than zero
    if (dealt > 0) target.takeDamage(dealt);

    // If the target is now dead, print kill message
    if (!target.isAlive()) {
        // Add weapon name to message if one was used
        String w = (weaponName != null) ? (" using " + weaponName) : "";
        System.out.println("   " + getName() + " killed " + target.getName() + w);
    }
