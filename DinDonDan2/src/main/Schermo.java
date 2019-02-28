/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Luca Mantica
 */
public class Schermo {

    private final Queue<String> buffer;

    private final Semaforo semaforo;

    public Schermo() {
        this.buffer = new ArrayDeque();
        this.semaforo = new Semaforo(1);
    }

    synchronized public Semaforo GetSemaforo() {
        return semaforo;
    }

    synchronized public Queue<String> GetBuffer() {
        return buffer;
    }

}
