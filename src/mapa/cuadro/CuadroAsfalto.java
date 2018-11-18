package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public class CuadroAsfalto extends Cuadro {

	public CuadroAsfalto(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}

	public void mostrar(int x, int y, Pantalla pantalla) {

		pantalla.mostrarCuadro(x, y, this);
	}

}
