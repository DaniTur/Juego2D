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
//			case 0xff000000:
//				cuadrosCatalogo[i] = Cuadro.ASFALTO;
//				continue;
//			case 0xffffebac:
//				cuadrosCatalogo[i] = Cuadro.ARENA;
//				continue;
//			case 0xff4c4c4c:
//				cuadrosCatalogo[i] = Cuadro.BORDE_CARRETERA_IZQUIERDO;
//				continue;
//			case 0xff4c4c4f:
//				cuadrosCatalogo[i] = Cuadro.BORDE_CARRETERA_DERECHO;
//				continue;
//			case 0xff4c4c4e:
//				cuadrosCatalogo[i] = Cuadro.BORDE_CARRETERA_INFERIOR;
//				continue;
//			case 0xff4c4c4d:
//				cuadrosCatalogo[i] = Cuadro.BORDE_CARRETERA_SUPERIOR;
//				continue;
//			case 0xff1c1c1c:
//				cuadrosCatalogo[i] = Cuadro.CENTRO_CARRETERA_VERTICAL;
//				continue;
//			case 0xff1c1c1d:
//				cuadrosCatalogo[i] = Cuadro.CENTRO_CARRETERA_HORIZONTAL;
//				continue;
//			case 0xff5f5f5f:
//				cuadrosCatalogo[i] = Cuadro.ESQUINA_CARRETERA_INFERIOR_IZQUIERDA;
//				continue;
//			case 0xff5f5f7f:
//				cuadrosCatalogo[i] = Cuadro.ESQUINA_CARRETERA_INFERIOR_DERECHA;
//				continue;
//			case 0xff5f5f6f:
//				cuadrosCatalogo[i] = Cuadro.ESQUINA_CARRETERA_SUPERIOR_IZQUIERDA;
//				continue;
//			case 0xff5f5f8f:
//				cuadrosCatalogo[i] = Cuadro.ESQUINA_CARRETERA_SUPERIOR_DERECHA;
//				continue;
//			case 0xffcccccc:
//				cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA;
//				continue;
//			case 0xffa9a9a9:
//				cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA_INFERIOR;
//				continue;
//			case 0xff818181:
//				cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA_CARRETERA;
//				continue;
//			case 0xff818182:
//				cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA_CARRETERA_X_INVERTIDO;
//				continue;
//			case 0xffcccccd:
//				cuadrosCatalogo[i] = Cuadro.PUERTA_SUPERIOR_IZQUIERDA;
//				continue;
//			case 0xffccccce:
//				cuadrosCatalogo[i] = Cuadro.PUERTA_SUPERIOR_DERECHA;
//				continue;
//			case 0xff724b4d:
//				cuadrosCatalogo[i] = Cuadro.PUERTA_INTERMEDIA_IZQUIERDA;
//				continue;
//			case 0xff724b4e:
//				cuadrosCatalogo[i] = Cuadro.PUERTA_INTERMEDIA_DERECHA;
//				continue;
//			case 0xff271415:
//				cuadrosCatalogo[i] = Cuadro.PUERTA_INFERIOR;
//				continue;
//			case 0xff3c2829:
//				cuadrosCatalogo[i] = Cuadro.OXIDO;
//				continue;
//			case 0xff4e3335:
//				cuadrosCatalogo[i] = Cuadro.PUERTA_SUPERIOR_CENTRAL;
//				continue;
//			default:
//				cuadrosCatalogo[i] = Cuadro.VACIO;

			case 0xff8a8a8a:
				cuadrosCatalogo[i] = Cuadro.SUELO;
				continue;
			case 0xffff0000:
				cuadrosCatalogo[i] = Cuadro.ENTRADA_INFERIOR;
				continue;
			case 0xffd60000:
				cuadrosCatalogo[i] = Cuadro.ENTRADA_SUPERIOR;
				continue;
			case 0xffca3900:
				cuadrosCatalogo[i] = Cuadro.ENTRADA_LINEA_DERECHA;
				continue;
			case 0xfff04502:
				cuadrosCatalogo[i] = Cuadro.ENTRADA_LINEA_IZQUIERDA;
				continue;
			case 0xffe2e000:
				cuadrosCatalogo[i] = Cuadro.LINEA_DERECHA;
				continue;
			case 0xfffdfb00:
				cuadrosCatalogo[i] = Cuadro.LINEA_IZQUIERDA;
				continue;
			case 0xffb9b700:
				cuadrosCatalogo[i] = Cuadro.LINEA_SUPERIOR;
				continue;
			case 0xff00ffd8:
				cuadrosCatalogo[i] = Cuadro.ESQUINA_PEQUEÑA_ID;
				continue;
			case 0xff01d3b3:
				cuadrosCatalogo[i] = Cuadro.ESQUINA_PEQUEÑA_II;
				continue;
			case 0xff006152:
				cuadrosCatalogo[i] = Cuadro.ESQUINA_PEQUEÑA_SI;
				continue;
			case 0xff009d85:
				cuadrosCatalogo[i] = Cuadro.ESQUINA_PEQUEÑA_SD;
				continue;
			case 0xff390019:
				cuadrosCatalogo[i] = Cuadro.ESQUINA_LARGA_DERECHA;
				continue;
			case 0xffae195b:
				cuadrosCatalogo[i] = Cuadro.ESQUINA_LARGA_IZQUIERDA;
				continue;
			case 0xff5300fd:
				cuadrosCatalogo[i] = Cuadro.ESQUINA_SI;
				continue;
			case 0xff4602cf:
				cuadrosCatalogo[i] = Cuadro.ESQUINA_SD;
				continue;
			case 0xff954300: // color de la tierra, cuadro vacio para test
				cuadrosCatalogo[i] = Cuadro.VACIO;
				continue;
			case 0xff001725:
				cuadrosCatalogo[i] = Cuadro.PARED;
				continue;
			case 0xff012c47:
				cuadrosCatalogo[i] = Cuadro.PARED_EXTINTOR;
				continue;
			case 0xff005286:
				cuadrosCatalogo[i] = Cuadro.PARED_CARTEL;
				continue;
			case 0xff1b1b1b:
				cuadrosCatalogo[i] = Cuadro.PARED_IZQUIERDA;
				continue;
			case 0xff383838:
				cuadrosCatalogo[i] = Cuadro.PARED_DERECHA;
				continue;
			case 0xff4b4b4b:
				cuadrosCatalogo[i] = Cuadro.CONTROL_ACCESO;
				continue;
			case 0xff0479c3:
				cuadrosCatalogo[i] = Cuadro.PARED_CENTRAL;
				continue;
			case 0xff009cff:
				cuadrosCatalogo[i] = Cuadro.PUERTA;
				continue;
			default:
				cuadrosCatalogo[i] = Cuadro.VACIO;
			}
		}
	}
}
