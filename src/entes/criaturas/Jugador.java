package entes.criaturas;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;

public class Jugador extends Criatura {

	private Teclado teclado;

	private int animacion;

	public Jugador(Mapa mapa, Teclado teclado, Sprite sprite) {
		this.mapa = mapa;
		this.teclado = teclado;
		this.sprite = sprite;
	}

	public Jugador(Mapa mapa, Teclado teclado, Sprite sprite, int posicionX, int posicionY) { // donde aparece el
																								// jugador en el
		// mapa
		this.mapa = mapa;
		this.teclado = teclado;
		this.sprite = sprite;
		this.x = posicionX;
		this.y = posicionY;
	}

	public void actualizar() {

		int desplazamientoX = 0;
		int desplazamientoY = 0;

		int velocidadMovimiento = 1;

		if (animacion < 32767) {
			animacion++;
		} else {
			animacion = 0;
		}

		if (teclado.correr) {
			velocidadMovimiento = 2;
		}
		if (teclado.arriba) {
			desplazamientoY -= velocidadMovimiento;
		}
		if (teclado.abajo) {
			desplazamientoY += velocidadMovimiento;
		}
		if (teclado.izquierda) {
			desplazamientoX -= velocidadMovimiento;
		}
		if (teclado.derecha) {
			desplazamientoX += velocidadMovimiento;
		}

		// si el jugador se mueve entonces lo desplazamos
		if (desplazamientoX != 0 || desplazamientoY != 0) {
			mover(desplazamientoX, desplazamientoY);
			enMovimiento = true;
		} else {
			enMovimiento = false;
		}

		// ANIMACIONES
		int resto = animacion % 40;

		if (direccion == 'n') {
			sprite = sprite.ARRIBA0;
			if (enMovimiento) {
				if (resto > 10 && resto <= 20) {
					sprite = sprite.ARRIBA1;
				} else if (resto > 20 && resto <= 30) {
					sprite = sprite.ARRIBA0;
				} else if (resto > 30) {
					sprite = sprite.ARRIBA2;
				} else {
					sprite = sprite.ARRIBA0;
				}
			}
		}
		if (direccion == 's') {
			sprite = sprite.ABAJO0;
			if (enMovimiento) {
				if (resto > 10 && resto <= 20) {
					sprite = sprite.ABAJO1;
				} else if (resto > 20 && resto <= 30) {
					sprite = sprite.ABAJO0;
				} else if (resto > 30) {
					sprite = sprite.ABAJO2;
				} else {
					sprite = sprite.ABAJO0;
				}
			}
		}
		if (direccion == 'e') {
			sprite = sprite.DERECHA0;
			if (enMovimiento) {
				if (resto > 10 && resto <= 20) {
					sprite = sprite.DERECHA1;
				} else if (resto > 20 && resto <= 30) {
					sprite = sprite.DERECHA0;
				} else if (resto > 30) {
					sprite = sprite.DERECHA2;
				} else {
					sprite = sprite.DERECHA0;
				}
			}
		}
		if (direccion == 'o') {
			sprite = sprite.IZQUIERDA0;
			if (enMovimiento) {
				if (resto > 10 && resto <= 20) {
					sprite = sprite.IZQUIERDA1;
				} else if (resto > 20 && resto <= 30) {
					sprite = sprite.IZQUIERDA0;
				} else if (resto > 30) {
					sprite = sprite.IZQUIERDA2;
				} else {
					sprite = sprite.IZQUIERDA0;
				}
			}
		}
	}

	public void mostrar(Pantalla pantalla) {
		pantalla.mostrarJugador(x, y, this);
	}

}
