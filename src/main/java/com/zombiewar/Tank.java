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
    	super(name, 150, 20);
    }

    @Override
    public void attack(Character target) {
        if (this.isAlive()) {
            target.takeDamage(20);
            if (!target.isAlive()) {
                System.out.println("   " + this.name + " killed " + target.getName());
            }
        }
    }
}
