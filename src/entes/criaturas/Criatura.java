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

		if (!estaEliminado()) {
			modificarPosicionX(desplazamientoX);
			modificarPosicionY(desplazamientoY);
		}

	}

	private boolean enColision() {
		return false;
	}
}
