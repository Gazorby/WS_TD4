package exo1.exo1serveur;

import java.io.*;
import java.net.*;


class ServiceInversion implements Runnable {
	
	private static int cpt = 1;
	
	private final int numero;
	private final Socket client;
	
	ServiceInversion(Socket socket) {
		this.numero = cpt ++;
		this.client = socket;
	}

	public void run() {
		System.out.println("*********Connexion "+this.numero+" d�marr�e");
		try {
			BufferedReader in = new BufferedReader (new InputStreamReader(client.getInputStream ( )));
			PrintWriter out = new PrintWriter (client.getOutputStream ( ), true);
			String line = in.readLine();
			System.out.println("Connexion "+this.numero+" <-- "+line);
			String invLine = new String (new StringBuffer(line).reverse());
			out.println(invLine);
			System.out.println("Connexion "+this.numero+" --> "+invLine);
		}
		catch (IOException e) {
		}
		//Fin du service d'inversion
		System.out.println("*********Connexion "+this.numero+" termin�e");
		try {client.close();} catch (IOException e2) {}
	}
	
	protected void finalize() throws Throwable {
		 client.close(); 
	}

	@Override
	public String toString() {
		return "Inversion de texte";
	}

	public void lancer() {
		new Thread(this).start();	
	}
}
