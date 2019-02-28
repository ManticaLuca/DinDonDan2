package main;

import java.io.IOException;
/**
 * @breif la classe gestisce l'entry point
 *
 * @author Luca Mantica
 */
public class Main {
    /**
     * @brief oggeto sharing di dati
     *
     * @author Luca Mantica
     */
    public static final SharedData sharedData = new SharedData();
    
    /**
     * @brief thread "DIN"
     *
     * @author Luca Mantica
     */
    private static final Thread th1 = new Thread(new MyThread("DIN", true, false,sharedData));

    /**
     * @brief thread "DON"
     *
     * @author Luca Mantica
     */
    private static final Thread th2 = new Thread(new MyThread("DON", true, false,sharedData));

    /**
     * @brief thread "DAN"
     *
     * @author Luca Mantica
     */
    private static final Thread th3 = new Thread(new MyThread("DAN", true, false,sharedData));

    /**
     * @brief entry point
     * @param args command line arguments
     *
     * @author Luca Mantica
     */
    public static void main(String[] args){
        try {
            //avvio thread
            System.out.println("Started");
            th1.start();
            th2.start();
            th3.start();

            //interruzione thread
            System.in.read();
            th1.interrupt();
            th2.interrupt();
            th3.interrupt();
            th1.join();
            th2.join();
            th3.join(); 
            System.out.println("Thread WINNER:" +sharedData.numHighest());
            System.out.println("Ended");
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }catch (IOException e){}
    }

}
