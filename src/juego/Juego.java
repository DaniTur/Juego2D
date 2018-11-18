package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import control.Teclado;
import graficos.Pantalla;

public class Juego extends Canvas implements Runnable {

	// VARIABLES Y CONTANTES
	private static final long serialVersionUID = 1L;

	private static JFrame ventana;
	private static final int ANCHO = 800;
	private static final int ALTO = 600;

	private static final String NOMBRE = "Juego";

	private static Thread thread;

	private static int aps = 0;
	private static int fps = 0;

	private static Teclado teclado;

	private static int x = 0;
	private static int y = 0;
	private static Pantalla pantalla;

	private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
	private static int pixeles[] = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();

	private static final ImageIcon icono = new ImageIcon(Juego.class.getResource("/icono/icono.png"));

	// volatile, no se puede usar esta variable a la vez en diferentes threads
	private static volatile boolean enFuncionamiento = false;

	// CONTRUCTOR DE JUEGO
	private Juego() {

		setPreferredSize(new Dimension(ANCHO, ALTO));

		pantalla = new Pantalla(ANCHO, ALTO);

		teclado = new Teclado();
		addKeyListener(teclado);

		// configuracion de ventana
		ventana = new JFrame(NOMBRE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setIconImage(icono.getImage());
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
			y++;
		}
		if (teclado.abajo) {
			y--;
		}
		if (teclado.izquierda) {
			x++;
		}
		if (teclado.derecha) {
			x--;
		}
		aps++; // contador de actualizaciones del programa por segundo
	}

	private void mostrar() {
		BufferStrategy estrategia = getBufferStrategy(); // 3 buffers: 1 calculando, 2 listo, 3 dibuja imagen

		if (estrategia == null) {
			createBufferStrategy(3);
			return;
		}

		pantalla.limpiar();
		pantalla.mostrar(x, y);

		System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);

		// for (int i = 0; i < pixeles.length; i++) {
		// pixeles[i] = pantalla.pixeles[i];
		// }

		Graphics g = estrategia.getDrawGraphics(); // dibuja lo que esta dentro de la estrategia de buffers

		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.white);
		g.fillRect(ANCHO / 2, ALTO / 2, 32, 32);
		g.dispose(); // destruye el espacio de la memoria que estaba usando g

		estrategia.show(); // para que la imagen se vea en pantalla

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
