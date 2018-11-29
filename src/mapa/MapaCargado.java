package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import mapa.cuadro.Cuadro;

public class MapaCargado extends Mapa {

	private int[] pixeles;

	public MapaCargado(String ruta) {
		super(ruta);
	}

	protected void cargarMapa(String ruta) {

		try {

			BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));
			ancho = imagen.getWidth();
			alto = imagen.getHeight();

			cuadrosCatalogo = new Cuadro[ancho * alto];
			pixeles = new int[ancho * alto];

			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void generarMapa() {
		for (int i = 0; i < pixeles.length; i++) {
			switch (pixeles[i]) {
			case 0xff000000:
				cuadrosCatalogo[i] = Cuadro.ASFALTO;
				continue;
			case 0xffffebac:
				cuadrosCatalogo[i] = Cuadro.ARENA;
				continue;
			case 0xff4c4c4c:
				cuadrosCatalogo[i] = Cuadro.BORDE_CARRETERA;
				continue;
			case 0xff1c1c1c:
				cuadrosCatalogo[i] = Cuadro.CENTRO_CARRETERA;
				continue;
			case 0xff5f5f5f:
				cuadrosCatalogo[i] = Cuadro.ESQUINA_CARRETERA;
				continue;
			case 0xffcccccc:
				cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA;
				continue;
			case 0xffa9a9a9:
				cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA_INFERIOR;
				continue;
			case 0xff818181:
				cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA_CARRETERA;
				continue;
			case 0xffcccccd:
				cuadrosCatalogo[i] = Cuadro.PUERTA_SUPERIOR_IZQUIERDA;
				continue;
			case 0xff724b4d:
				cuadrosCatalogo[i] = Cuadro.PUERTA_INTERMEDIA_IZQUIERDA;
				continue;
			case 0xff271415:
				cuadrosCatalogo[i] = Cuadro.PUERTA_INFERIOR;
				continue;
			case 0xff3c2829:
				cuadrosCatalogo[i] = Cuadro.OXIDO;
				continue;
			case 0xff4e3335:
				cuadrosCatalogo[i] = Cuadro.PUERTA_SUPERIOR_CENTRAL;
				continue;
			default:
				cuadrosCatalogo[i] = Cuadro.VACIO;
			}
		}
	}
}
