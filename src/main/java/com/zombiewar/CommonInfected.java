/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zombiewar;

/**
 *
 * @author titi
 */
public class CommonInfected extends Zombie {

    public CommonInfected(String name) {
        super(name);
        this.health = 30;
        this.attackPower = 5;
        this.maxHealth = 30;
        this.isAlive = true;
    }

    @Override
    public void attack(Character target) {
        if (this.isAlive()) {
            target.takeDamage(attackPower);
        }
    }
}