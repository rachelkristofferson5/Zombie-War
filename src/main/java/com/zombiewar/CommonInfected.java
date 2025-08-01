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
    	super(name, 30, 5);
    }

    @Override
    public void attack(Character target) {
        super.attack(target);
    }
    }