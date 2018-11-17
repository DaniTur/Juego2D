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

	// volatile, no se puede usar esta variable a la vez en diferentes threads
	private static volatile boolean enFuncionamiento = false;

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
	private synchronized void iniciarThread() { // synchronized se asegura de que los dos metodos no puedan modificar la
												// variable de manera simultanea
		enFuncionamiento = true;

		thread = new Thread(this, "Graficos");
		thread.start();
	}

	private synchronized void detenerThread() {
		enFuncionamiento = false;

		try {
			thread.join(); // cerrar un thread puede dar un problema y lo tenemos que capturar
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (enFuncionamiento) {

		}
	}

}
