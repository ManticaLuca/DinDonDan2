/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Luca Mantica
 */
public class ThVis extends Thread {

    private final SharedData sharedData;

    public ThVis(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        System.out.println("Started printing...");
        while (!sharedData.ThreadFiniti()) {
            String newString = sharedData.GetSchermo().GetBuffer().poll();
            if (newString != null) {
                System.out.println(newString);
            }
            if (isInterrupted()) {
                return;
            }
        }
        System.out.println("Ended printing.");
    }

}
