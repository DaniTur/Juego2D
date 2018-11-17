package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import control.Teclado;

public class Juego extends Canvas implements Runnable {

	// VARIABLES Y CONTANTES
	private static final long serialVersionUID = 1L;

	private static JFrame ventana;
	private static final int ANCHO = 800;
	private static final int ALTO = 600;

	private static final String NOMBRE = "Juego";

	private static int aps = 0;
	private static int fps = 0;

	private static Thread thread;

	private static Teclado teclado;

	// volatile, no se puede usar esta variable a la vez en diferentes threads
	private static volatile boolean enFuncionamiento = false;

	// CONTRUCTOR DE JUEGO
	private Juego() {

		setPreferredSize(new Dimension(ANCHO, ALTO));

		teclado = new Teclado();
		addKeyListener(teclado);

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

	private void actualizar() {
		teclado.actualizar();

		if (teclado.arriba) {
			System.out.println("arriba");
		}
		if (teclado.abajo) {
			System.out.println("abajo");
		}
		if (teclado.izquierda) {
			System.out.println("izquierda");
		}
		if (teclado.derecha) {
			System.out.println("derecha");
		}
		aps++; // contador de actualizaciones del programa por segundo
	}

	private void mostrar() {
		fps++; // contador de fps
	}

	@Override
	public void run() {
		final int NS_POR_SEGUNDO = 1000000000; // cuantos nanosegundos hay en 1 segundo
		final byte APS_OBJECTIVO = 60; // cuantas actualizaciones por segundo queremos
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJECTIVO; // 1 segundo(en nanosegundos) divido por las
																			// actualizaciones que queremos(60)
		// referencias para controlar velocidad del programa
		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();

		double tiempoTranscurrido;
		double delta = 0; // delta: cantidad de tiempo que ocurre hasta que hay una actualizacion

		requestFocus();

		while (enFuncionamiento) {
			final long inicioBucle = System.nanoTime(); // le fijamos unos nanosegundos cuando se ha iniciado el bucle

			tiempoTranscurrido = inicioBucle - referenciaActualizacion; // cuanto tiempo ha pasado entre la referencia y
																		// el inicio del bucle
			referenciaActualizacion = inicioBucle;

			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

			while (delta >= 1) { // limitamos y controlamos la velocidad de actualizacion(60 veces por segundo)
				actualizar();
				delta--;
			}

			mostrar();

			// contador se actualiza cada segundo y lo mostramos en la ventana
			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				ventana.setTitle(NOMBRE + "  APS: " + aps + "  FPS: " + fps);

				aps = 0; // reiniciamos contadores
				fps = 0;
				referenciaContador = System.nanoTime();
			}
		}
	}

}
