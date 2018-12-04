package entes.criaturas;

import entes.Ente;
import graficos.Sprite;

public abstract class Criatura extends Ente {

	protected Sprite sprite;
	protected char direccion = 'n';
	protected boolean enMovimiento = false;

	public void actualizar() {
	}

	public void mostrar() {
	}

	public void mover(int desplazamientoX, int desplazamientoY) {
		if (desplazamientoX > 0) { // si el desplazamiento es X positivo se mueve al este
			direccion = 'e';
		}
		if (desplazamientoX < 0) { // si el desplazamiento es X negativo se mueve al oeste
			direccion = 'o';
		}
		if (desplazamientoY > 0) { // si el desplazamiento es Y positivo se mueve al sur
			direccion = 's';
		}
		if (desplazamientoY < 0) { // si el desplazamiento es Y negativo se mueve al norte
			direccion = 'n';
		}

		if (!estaEliminado()) { // si no esta eliminada la criatura
			if (!enColision(desplazamientoX, 0)) {
				modificarPosicionX(desplazamientoX);
			}
			if (!enColision(0, desplazamientoY)) {
				modificarPosicionY(desplazamientoY);
			}
		}

	}

	private boolean enColision(int desplazamientoX, int desplazamientoY) {

		boolean colision = false;

		int posicionX = x + desplazamientoX;
		int posicionY = y + desplazamientoY;

		int margenIzquierdo = -6; // en pixeles
		int margenDerecho = 18;
		int margenSuperior = -4;
		int margenInferior = 31;

		int bordeIzquierdo = (posicionX + margenDerecho) / sprite.obtenLado();
		int bordeDerecho = (posicionX + margenDerecho + margenIzquierdo) / sprite.obtenLado();
		int bordeSuperior = (posicionY + margenInferior) / sprite.obtenLado();
		int bordeInferior = (posicionY + margenInferior + margenSuperior) / sprite.obtenLado();

		// se prevee el siguiente cuado a pisar y si es solido o no
		if (mapa.obtenCuadrosCatalogo(bordeIzquierdo + bordeSuperior * mapa.obtenerAncho()).esSolido()) {
			colision = true;
		}
		if (mapa.obtenCuadrosCatalogo(bordeIzquierdo + bordeInferior * mapa.obtenerAncho()).esSolido()) {
			colision = true;
		}
		if (mapa.obtenCuadrosCatalogo(bordeDerecho + bordeSuperior * mapa.obtenerAncho()).esSolido()) {
			colision = true;
		}
		if (mapa.obtenCuadrosCatalogo(bordeDerecho + bordeInferior * mapa.obtenerAncho()).esSolido()) {
			colision = true;
		}
		return colision;
	}

	public Sprite obtenSprite() {
		return sprite;
	}
}
