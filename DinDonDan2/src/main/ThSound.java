package main;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @brief la classe gestisce i thread
 * @author Luca Mantica
 */
public class ThSound implements Runnable {

    /**
     * @brief stringa del {@link #sound}
     * @author Luca Mantica
     */
    private final String sound;
    private final SharedData sharedData;
    private final Semaphore nextsemTh;
    private final Semaphore semTh;

    /**
     * @brief costruttore
     * @param sound stringa del {@link #sound}
     * @param sharedData dati condivisi
     * @author Luca Mantica
     */
    public ThSound(String sound, SharedData sharedData, Semaphore semTh, Semaphore nextsemTh) {
        this.sound = sound;
        this.sharedData = sharedData;
        this.nextsemTh = nextsemTh;
        this.semTh = semTh;
    }

    /**
     * @brief run del thread
     * @author Luca Mantica
     */
    @Override
    public void run() {
        while (true) {
            try {
                semTh.acquire();
                if (Thread.interrupted()) {
                    sharedData.SetFinito(sound);
                    return;
                }
                sharedData.GetSchermo().GetBuffer().add(sound);
                nextsemTh.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThSound.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
