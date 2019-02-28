/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 * @author Luca Mantica
 */
public class SharedData {

    private final String[] souni = {"DIN", "DON", "DAN"};
    private final boolean[] thRunning;
    private final Schermo schermo;

    /**
     * @brief costruttore
     * @author Luca Mantica
     */
    public SharedData() {
        this.schermo = new Schermo();
        this.thRunning = new boolean[3];
        for (int i = 0; i < thRunning.length; i++) {
            thRunning[i] = true;
        }
    }

    synchronized public Schermo GetSchermo() {
        return schermo;
    }

    /**
     * @brief controlla se i thread sono terminati
     * @return true se tutti i thread sono terminati
     * @author Luca Mantica
     */
    synchronized public boolean ThreadFiniti() {
        boolean ris = true;
        for (int i = 0; i < 3; i++) {
            if (thRunning[i]) {
                ris = false;
            }
        }
        return ris;
    }

    synchronized void SetFinito(String sound) {
        int ris = 0;
        for (int i = 0; i < souni.length; i++) {
            if (sound.equals(souni[i])) {
                ris = i;
            }
        }
        thRunning[ris] = false;
    }
}
