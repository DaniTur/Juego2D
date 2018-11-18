package graficos;

import mapa.cuadro.Cuadro;

public final class Pantalla {

	private final int ancho;
	private final int alto;

	private int diferenciaX;
	private int diferenciaY;

	public final int[] pixeles;

	public Pantalla(final int ancho, final int alto) {

		this.ancho = ancho;
		this.alto = alto;

		pixeles = new int[ancho * alto];
	}

	// ponemos todos los pixeles de color negro antes de volver a dibujar en
	// pantalla
	public void limpiar() {

		for (int i = 0; i < pixeles.length; i++) {
			pixeles[i] = 0;
		}
	}

	public void mostrarCuadro(int compensacionX, int compensacionY, Cuadro cuadro) {

		compensacionX -= diferenciaX;
		compensacionY -= diferenciaY;

		for (int y = 0; y < cuadro.sprite.obtenLado(); y++) {
			int posicionY = y + compensacionY;

			for (int x = 0; x < cuadro.sprite.obtenLado(); y++) {
				int posicionX = x + compensacionX;
				if (posicionX == 0 || posicionX > ancho || posicionY < 0 || posicionY > alto) {
					break;
				}

				pixeles[posicionX + posicionY * ancho] = cuadro.sprite.pixeles[x + y * cuadro.sprite.obtenLado()];
			}
		}
	}

	// establece la diferencia entre lo que esta dibujado y lo que se tendria que
	// ver respescto a la posicion del personaje
	public void estableceDiferencia(final int diferenciaX, final int diferenciaY) {
		this.diferenciaX = diferenciaX;
		this.diferenciaY = diferenciaY;
	}

	public int obtenAncho() {
		return ancho;

	}

	public int obtenAlto() {
		return alto;
	}
}
