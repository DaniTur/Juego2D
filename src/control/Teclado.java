package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

	// codigo de las teclas que vamos a usar maximo
	private static final int numeroTeclas = 120;
	private final boolean[] teclas = new boolean[numeroTeclas];

	public boolean arriba;
	public boolean abajo;
	public boolean izquierda;
	public boolean derecha;

	public void actualizar() {

		arriba = teclas[KeyEvent.VK_W]; // arriba equivale a pulsar la "W"
		abajo = teclas[KeyEvent.VK_S];
		izquierda = teclas[KeyEvent.VK_A];
		derecha = teclas[KeyEvent.VK_D];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		teclas[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		teclas[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
