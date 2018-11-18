package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public abstract class Cuadro {

	private int x;
	private int y;

	private Sprite sprite;

	public Cuadro(Sprite sprite) {
		this.sprite = sprite;

	}

	public void mostrar(int x, int y, Pantalla pantalla) {

	}

	public boolean solido() {
		return false;
	}
}
