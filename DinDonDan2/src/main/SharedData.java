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
public class SharedData {
    /**
     * @brief contatori
     *
     * @author Luca Mantica
     */
    private int numDIN, numDON, numDAN;

     /**
     * @brief costruttore vuoto
     *
     * @author Luca Mantica
     */
    public SharedData() {
        numDIN = 0;
        numDON = 0;
        numDAN = 0;
    }
    
    /**
     * @brief incrementa la variabile
     * @param threadName nome del Thread
     *
     * @author Luca Mantica
     */
    public void increase(String threadName) {
        switch (threadName) {
            case "DIN":
                numDIN++;
                break;
            case "DON":
                numDON++;
                break;
            case "DAN":
                numDAN++;
                break;
            default:
                break;
        }
    }

     /**
     * @brief max tra i contatori
     * @return numHighest nome del contatore
     *
     * @author Luca Mantica
     */
    public String numHighest() {
        int[] vect = new int[3];
        vect[0] = numDIN;
        vect[1] = numDON;
        vect[2] = numDAN;
        for (int i = 0; i < 2; i++) {
            if (vect[i] > vect[i + 1]) {
                int temp = vect[i];
                vect[i] = vect[i + 1];
                vect[1 + 1] = temp;
            }
        }
        if (vect[2] == numDIN) {
            return "DIN";
        } else if (vect[2] == numDON) {
            return "DON";
        }
        return "DAN";
    }
}
