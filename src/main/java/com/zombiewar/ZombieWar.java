
package com.zombiewar;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
/**
 * Project: Zombie War
 * Group: Titi Emmanuel, Rachel Kristofferson, Farhan Mohamud, and Tyson Radke
 * @author Rachel Kristofferson
 * Date: July 29, 2025
 * 
 * 
 * Sources:
 *  https://stackoverflow.com/questions/28942406/how-to-print-20-random-number-between-5-and-25-in-java
 *  https://www.geeksforgeeks.org/java/difference-between-list-and-arraylist-in-java/
 *  https://stackoverflow.com/questions/2279030/type-list-vs-type-arraylist-in-java
 * 
 */
public class ZombieWar {

    private List<Survivor> survivors = new ArrayList<>();
    private List<Zombie> zombies = new ArrayList<>();
    private Random random = new Random();
    
    
    public static void main(String[] args) {
        ZombieWar beginBattle = new ZombieWar();
        beginBattle.generateCharacters();
        beginBattle.runSimulation();
    }
    
    /*
        Generates a random number between 5-20 of characters per array (zombies and
        survivors) as well as randomly chooses which type they'll be. Once both
        choices are done, the character will be added to their array. A print
        statement at the end will inform user of numbers of each type when ran.
    */
    public void generateCharacters() {
       // Generating random number (5-20) of survivors and type.
       int numSurvivors = random.nextInt(16) + 5;
       
       for(int i = 0; i < numSurvivors; i++) {
           String name = "Survivor" + i + 1;
           int survivorType = random.nextInt(3);
           
           // Using the random number to choose which survivor type to create 
           // and add to array.
           switch (survivorType) {
               case 0:
                   survivors.add(new Scientist(name));
                   break;
               case 1:
                   survivors.add(new Soldier(name));
                   break;
               case 2:
                   survivors.add(new Civilian(name));
                   break;
           }
       }
       
       // Generating random number (5-20) of zombies and type.
       int numZombies = random.nextInt(16) + 5;
       
       for(int i = 0; i < numZombies; i++) {
           int zombieType = random.nextInt(2);
           
           // Using the random number to choose which zombie type to create and add
           // to array.
           switch(zombieType) {
               case 0:
                    zombies.add(new CommonInfected(name));
                    break;
               case 1:
                   zombies.add(new Tank(name));
                   break;
           }
       }
       
       System.out.println("We have " + survivors.size() + " trying to make it to safety.");
       System.out.println("But there are " + zombies.size() + " zombies waiting for them.");
    }
    
    /*
        Uses a marker, gameOver, to check if the simulation should continue or not.
        While gameOver is false, it will call battle() and remove any dead 
        characters from their respective arrayLists. At the end of one iteration
        of the loop, we check isGameOver(). If so, the loop breaks, if not, 
        they have another round of battle until isGameOver() returns back true.
    */
    public void runSimulation() {
        boolean gameOver = false;
        
        while(gameOver == false) {
            battle();
            
            // Remove the dead survivors from list
            for(int i = survivors.size() - 1; i >= 0; i--) {
                if(!survivors.get(i).isAlive()) {
                    survivors.remove(i);
                }
            } 
            
            // Remove the dead zombies from list
            for(int i = zombies.size() - 1; i >= 0; i--) {
                if(!zombies.get(i).isAlive()) {
                    zombies.remove(i);
                }
            }
            // Setting gameOver to True if isGameOver() returns true, breaking loop.
            gameOver = isGameOver();
        }
        // Game is now over, print report
        reportResults();
    }
    
    /*
        Using a copy of the original lists, the two types of characters battle
        with survivors always attacking first, followed by the zombie attack. 
    */
    public void battle() {
        // Make copies of original lists so that we don't alter a list being used.
        List<Survivor> copySurvivors = new ArrayList<>();
        List<Zombie> copyZombies = new ArrayList<>();
        
        // Adding all alive survivors to the copied list
        for(Survivor survivor : survivors) {
            if(survivor.isAlive()) {
                copySurvivors.add(survivor);
            }
        }
        
        // Adding all alive zombies to the copied list
        for(Zombie zombie : zombies) {
            if(zombie.isAlive()) {
                copyZombies.add(zombie);
            }
        }
        
        // Survivors attack zombies
        for(Survivor survivor : copySurvivors) {
            if(!copyZombies.isEmpty()) {
                // New random zombie object chosen from copyZombies list
                Zombie target = copyZombies.get(random.nextInt(copyZombies.size()));
                survivor.attack(target);
                // Remove dead zombie from copy list. Will also be removed from
                // master list at end of first battle iteration in runSimulation().
                if(target.isAlive() == false) {
                copyZombies.remove(target);
                }    
            }
        }
        
        // Zombies attack survivors
        for(Zombie zombie : copyZombies) {
            if(!copySurvivors.isEmpty()) {
                Survivor target = copySurvivors.get(random.nextInt(copyZombies.size()));
                zombie.attack(target);
                if(target.isAlive() == false) {
                    copySurvivors.remove(target);
                }
            }
        }
    }
    
    /*
        Checks the number of survivors and zombies. Once one reaches zero, the
        other wins and game is over.
    */
    public boolean isGameOver() {
        // Count the alive survivors
        int aliveSurvivors = 0;
        
        for(Survivor survivor : survivors) {
            if(survivor.isAlive()) {
                aliveSurvivors++;
            }
        }
        
        // Count the alive zombies
        int aliveZombies = 0;
        
        for(Zombie zombie : zombies) {
            if(zombie.isAlive()) {
                aliveZombies++;
            }
        }
        
        // Different ending scenarios
        // No survivors, zombies won
        if(aliveSurvivors == 0) {
            return true;
        }
        
        // No zombies, survivors won
        else if(aliveZombies == 0) {
            return true;
        }
        
        // Someone is still alive from each, keep fighting
        return false;
    }
    
    /*
        Prints report on how many survivors made it to safety.
    */
    public void reportResults() {
        int survivorCount = survivorCount();
        
        if(survivorCount > 0) {
            System.out.println("It seems " + survivorCount + " have made it to safety.");
        }
        else {
            System.out.println("None of the survivors made it.");
        }
    }
    
    /*
        Counts the number of Survivors for final game tally.
    */
    public int survivorCount() {
        int count = 0;
        for(Survivor survivor : survivors) {
            if(survivor.isAlive()) {
                count++;
            }
        }
        return count;
    }
}
