package com.zombiewar;

/**
 *
 * @author rachel
 * @author Farhan
 * 
 */
// Base class for all characters in the game like zombies and survivors.
public abstract class Character {
    
    // Character's name
    protected String name;
    
    // How much health the character has now
    protected int health;

    // The highest health the character can have
    protected int maxHealth;

    // How much damage the character does when attacking
    protected int attackPower;

    // Shows if the character is still alive
    protected boolean isAlive;

    // Sets up the character with a name, health, and attack power
    public Character(String name, int health, int attackPower) {
        if (health <= 0 || attackPower < 0) {
            throw new IllegalArgumentException("Health must be > 0 and attack ≥ 0");
        }
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attackPower = attackPower;
        this.isAlive = true;
    }

    // Gets the character's name
    public String getName() {
        return name;
    }

    // Gets the character's health
    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    // Returns true if the character is still alive
    public boolean isAlive() {
        return isAlive;
    }

    // Lowers health by the damage amount and sets alive to false if health is zero
    public void takeDamage(int damage) {
        if (!isAlive) return;
        if (damage < 0) throw new IllegalArgumentException("Damage must be non-negative.");

        health -= damage;
        if (health <= 0) {
            health = 0;
            isAlive = false;
        }
    }

    // This method must be written in the child class to show how it attacks
    public abstract void attack(Character target);
}
