package graficos;

import mapa.cuadro.Cuadro;

public final class Pantalla {

	private final int ancho;
	private final int alto;

	public final int[] pixeles;

	// temporal
	private final static int LADO_SPRITE = 32;
	private final static int MASCARA_SPRITE = LADO_SPRITE - 1;

	// fin temporal
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

	// temporal
	public void mostrar(final int compensacionX, final int compensacionY) {

		for (int y = 0; y < alto; y++) {

			int posicionY = y + compensacionY;
			if (posicionY < 0 || posicionY >= alto) {
				continue;
			}

			for (int x = 0; x < ancho; x++) {

				int posicionX = x + compensacionX;
				if (posicionX < 0 || posicionX >= ancho) {
					continue;
				}

				// codigo para redibujar
				// temporal
				pixeles[posicionX + posicionY * ancho] = Sprite.ASFALTO.pixeles[(x & MASCARA_SPRITE)
						+ (y & MASCARA_SPRITE) * LADO_SPRITE];

			}
		}

	}// fin temporal

	public void mostrarCuadro(int compensacionX, int compensacionY, Cuadro cuadro) {

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

	public int obtenAncho() {
		return ancho;

	}

	public int obtenAlto() {
		return alto;
	}
}
