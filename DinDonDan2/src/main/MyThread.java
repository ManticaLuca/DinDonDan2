package main;

import java.util.Random;

/**
 * @brief la classe gestisce i thread
 *
 * @author Luca Mantica
 */
public class MyThread implements Runnable {
    /**
     * @brief stringa del {@link #sound}
     *
     * @author Luca Mantica
     */
    private final String sound;

    /**
     * @brief booleana stato attivazione {@link #yield}
     *
     * @author Luca Mantica
     */
    private final boolean yield;
    
    /**
     * @brief booleana stato attivazione {@link #delay}
     *
     * @author Luca Mantica
     */
    private final boolean delay;
    private String csio;
    
    /**
     * @brief thread "DIN"
     *
     * @author Luca Mantica
     */
    private final SharedData sharedData;

    /**
     * @brief costruttore
     * @param sound stringa del {@link #sound}
     * @param yield booleana stato attivazione {@link #yield}
     * @param delay boolean stato attivazione {@link #delay}
     * @param sharedData oggeto sharing di dati {@link #sharedData}
     *
     * @author Luca Mantica
     */
    public MyThread(String sound, boolean yield, boolean delay,SharedData sharedData) {
        this.sound = sound;
        this.yield = yield;
        this.delay = delay;
        this.sharedData = sharedData;
    }

    /**
     * @brief run del thread
     * 
     * Riproduce il {@link #sound} in console
     * 
     * @author Luca Mantica
     */
    @Override
    public void run() {
        try {
            while (true) {
                
                Random rnd = new Random();
                int millis = rnd.nextInt(1000) + 1;
                if(Thread.interrupted())
                    throw new InterruptedException("Interrotto");
                System.out.println(sound);
                sharedData.increase(sound);
                if (yield) {
                    Thread.yield();
                }
                if (delay) {
                    Thread.sleep(millis);
                }
            }
        } catch (InterruptedException ex) {
            System.out.println("Thread " + sound + " interrumpted.");
        }

    }

}
