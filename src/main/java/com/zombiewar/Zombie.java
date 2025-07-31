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

    public Zombie(String name) {
        super(name, 0, 0); // health and attack will be set in subclasses
    }

    @Override
    public abstract void attack(Character target); // Abstract method to override

    @Override
    public String toString() {
        return getName() + " [Zombie]";
    }
}