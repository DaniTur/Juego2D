package Juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Juego extends Canvas implements Runnable {

	// VARIABLES Y CONTANTES
	private static final long serialVersionUID = 1L;
	private static JFrame ventana;
	private static final int ANCHO = 800;
	private static final int ALTO = 600;
	private static final String NOMBRE = "Juego";
	private static Thread thread;

	// CONTRUCTOR DE JUEGO
	private Juego() {

		setPreferredSize(new Dimension(ANCHO, ALTO));

		// configuracion de ventana
		ventana = new JFrame(NOMBRE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

	// METODO MAIN
	public static void main(String[] args) {

		Juego juego = new Juego();
		juego.iniciarThread();

	}

	// THREAD
	private void iniciarThread() {
		thread = new Thread(this, "Graficos");
		thread.start();
	}

	private void detenerThread() {

	}

	@Override
	public void run() {
		System.out.println("Thread 2 iniciado");
	}

}
