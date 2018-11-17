package Juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Juego extends Canvas {

	// VARIABLES Y CONTANTES
	private static final long serialVersionUID = 1L;
	private static JFrame ventana;
	private static final int ANCHO = 800;
	private static final int ALTO = 600;
	private static final String NOMBRE = "Juego";

	// CONTRUCTOR DE JUEGO
	private Juego() {

		setPreferredSize(new Dimension(ANCHO, ALTO));

		// configuracion de ventana
		ventana = new JFrame(NOMBRE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar aplicacion al cerrar ventana
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout()); // el borde del canvas y el borde de la ventana es el mismo
		ventana.add(this, BorderLayout.CENTER);
		ventana.pack(); // tamaño de la ventana se ajuste a nuestra configuracion
		ventana.setLocationRelativeTo(null); // ventana enmedio de la pantalla
		ventana.setVisible(true);
	}

	// METODO MAIN
	public static void main(String[] args) {

		Juego juego = new Juego();

	}
}
