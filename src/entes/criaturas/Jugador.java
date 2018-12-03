package entes.criaturas;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;

public class Jugador extends Criatura {

	private Teclado teclado;

	public Jugador(Teclado teclado, Sprite sprite) {
		this.teclado = teclado;
		this.sprite = sprite;
	}

	public Jugador(Teclado teclado, Sprite sprite, int posicionX, int posicionY) { // donde aparece el jugador en el
																					// mapa
		this.teclado = teclado;
		this.x = posicionX;
		this.y = posicionY;
		this.sprite = sprite;
	}

	public void actualizar() {

		int desplazamientoX = 0;
		int desplazamientoY = 0;

		if (teclado.arriba) {
			desplazamientoY--;
		}
		if (teclado.abajo) {
			desplazamientoY++;
		}
		if (teclado.izquierda) {
			desplazamientoX--;
		}
		if (teclado.derecha) {
			desplazamientoX++;
		}

		// si el jugador se mueve entonces lo desplazamos
		if (desplazamientoX != 0 || desplazamientoY != 0) {
			mover(desplazamientoX, desplazamientoY);
		}
	}

	public void mostrar(Pantalla pantalla) {
		pantalla.mostrarJugador(x, y, this);
	}

}
