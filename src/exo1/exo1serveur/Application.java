package exo1.exo1serveur;

import java.io.IOException;

class Application {
	private final static int PORT = 1000;

	public static void main(String[] args) {
		try {
			new Thread(new Serveur(PORT)).start();
			System.out.println("Serveur lance sur le port " + PORT);

			
		} catch (IOException e) {
				System.err.println("Pb lors de la création du serveur : " +  e);			
		}
	}
}
