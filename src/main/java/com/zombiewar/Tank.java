/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zombiewar;

/**
 *
 * @author titi
 */
public class Tank extends Zombie {

    public Tank(String name) {
        super(name);
        this.health = 150;
        this.attackPower = 20;
        this.maxHealth = 150;
        this.isAlive = true;
    }

    @Override
    public void attack(Character target) {
        if (this.isAlive()) {
            target.takeDamage(attackPower);
        }
    }
}
