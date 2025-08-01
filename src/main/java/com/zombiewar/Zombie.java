/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zombiewar;

/**
 *
 * @author titi
 */
public abstract class Zombie extends Character {

    public Zombie(String name, int health, int attackPower) {
    	super(name, health, attackPower);
    }

    @Override
    public void attack(Character target) {
        if (this.isAlive() && target.isAlive()) {
            target.takeDamage(this.attackPower);
        }
    }

    @Override
    public String toString() {
        return "Zombie " + getName() + " [Health: " + getHealth() + ", Attack Power: " + this.getAttackPower() + "]";
    }
}