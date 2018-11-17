package graficos;

public final class Pantalla {

	private final int ancho;
	private final int alto;

	private final int[] pixeles;

	public Pantalla(final int ancho, final int alto) {

		this.ancho = ancho;
		this.alto = alto;

		pixeles = new int[alto * ancho];
	}

	// ponemos todos los pixeles de color negro antes de volver a dibujar en pantalla
	public void limpiar() {

		for (int i = 0; i < pixeles.length; i++) {
			pixeles[i] = 0;
		}
	}

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

			}
		}

	}
}
