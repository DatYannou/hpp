package fr.tse.hpp.mt.exo1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Exercice 1
 * 
 * <p>
 * A r�aliser
 * </p>
 * <ol>
 * <li>R�cup�rer les �l�ments pouss�s dans la file d'attente par le thread
 * principal</li>
 * <li>Concevoir un m�canisme permettant de terminer correctement le programme -
 * sans utiliser de {@link ThreadPoolExecutor}</li>
 * </ol>
 * 
 * Votre programme doit correctement afficher les NUMBER_OF_ELEMENTS
 * 
 * @author Julien
 *
 */
public class Main {

	static final int NUMBER_OF_THREADS = 4;

	static final int NUMBER_OF_ELEMENTS = 10;

	static final BlockingQueue<Object> QUEUE = new LinkedBlockingQueue<Object>();

	public static void main(String[] args) {
		// Tableau pour stocker les threads
		Thread[] threads = new Thread[NUMBER_OF_THREADS];
		// Start threads
		for (int i = 0; i < NUMBER_OF_THREADS; i++) {
			threads[i] = new Thread(new MyThread());
			threads[i].setName("Thread" + i); // Pour affichage de d�buggage -
												// JVisualVM
			threads[i].start();
		}
		// Envoie les �l�ments dans file d'attente
		for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
			try {
				QUEUE.put(new Object());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Fin du programme
		System.out.println("Fini");

	}

	/**
	 * Nested class pour le thread. Pas besoin de mettre dans un fichier � part
	 * 
	 * @author Julien
	 *
	 */
	static class MyThread implements Runnable {

		public void run() {
			Object obj = null;
			// Prend un �l�ment de la queue

			// Affiche le nom du thread et l'objet
			System.out.println(Thread.currentThread().getName() + ": " + obj);
		}

	}
}
