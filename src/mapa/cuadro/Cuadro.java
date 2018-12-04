package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public class Cuadro {

	public int x;
	public int y;

	public Sprite sprite;

	public static final int LADO = 32;

	// coleccion de cuadros
//	public static final Cuadro VACIO = new Cuadro(Sprite.VACIO);
//	public static final Cuadro ASFALTO = new Cuadro(Sprite.ASFALTO);
//	public static final Cuadro ARENA = new Cuadro(Sprite.ARENA);
//	public static final Cuadro BORDE_CARRETERA_IZQUIERDO = new Cuadro(Sprite.BORDE_CARRETERA_IZQUIERDO);
//	public static final Cuadro BORDE_CARRETERA_DERECHO = new Cuadro(Sprite.BORDE_CARRETERA_DERECHO);
//	public static final Cuadro BORDE_CARRETERA_INFERIOR = new Cuadro(Sprite.BORDE_CARRETERA_INFERIOR);
//	public static final Cuadro BORDE_CARRETERA_SUPERIOR = new Cuadro(Sprite.BORDE_CARRETERA_SUPERIOR);
//	public static final Cuadro CENTRO_CARRETERA_VERTICAL = new Cuadro(Sprite.CENTRO_CARRETERA_VERTICAL);
//	public static final Cuadro CENTRO_CARRETERA_HORIZONTAL = new Cuadro(Sprite.CENTRO_CARRETERA_HORIZONTAL);
//	public static final Cuadro ESQUINA_CARRETERA_INFERIOR_IZQUIERDA = new Cuadro(
//			Sprite.ESQUINA_CARRETERA_INFERIOR_IZQUIERDA);
//	public static final Cuadro ESQUINA_CARRETERA_INFERIOR_DERECHA = new Cuadro(
//			Sprite.ESQUINA_CARRETERA_INFERIOR_DERECHA);
//	public static final Cuadro ESQUINA_CARRETERA_SUPERIOR_IZQUIERDA = new Cuadro(
//			Sprite.ESQUINA_CARRETERA_SUPERIOR_IZQUIERDA);
//	public static final Cuadro ESQUINA_CARRETERA_SUPERIOR_DERECHA = new Cuadro(
//			Sprite.ESQUINA_CARRETERA_SUPERIOR_DERECHA);
//	public static final Cuadro PARED_PIEDRA = new Cuadro(Sprite.PARED_PIEDRA);
//	public static final Cuadro PARED_PIEDRA_INFERIOR = new Cuadro(Sprite.PARED_PIEDRA_INFERIOR);
//	public static final Cuadro PARED_PIEDRA_CARRETERA = new Cuadro(Sprite.PARED_PIEDRA_CARRETERA);
//	public static final Cuadro PARED_PIEDRA_CARRETERA_X_INVERTIDO = new Cuadro(
//			Sprite.PARED_PIEDRA_CARRETERA_X_INVERTIDO);
//	public static final Cuadro PUERTA_SUPERIOR_IZQUIERDA = new Cuadro(Sprite.PUERTA_SUPERIOR_IZQUIERDA);
//	public static final Cuadro PUERTA_SUPERIOR_DERECHA = new Cuadro(Sprite.PUERTA_SUPERIOR_DERECHA);
//	public static final Cuadro PUERTA_INTERMEDIA_IZQUIERDA = new Cuadro(Sprite.PUERTA_INTERMEDIA_IZQUIERDA);
//	public static final Cuadro PUERTA_INTERMEDIA_DERECHA = new Cuadro(Sprite.PUERTA_INTERMEDIA_DERECHA);
//	public static final Cuadro PUERTA_INFERIOR = new Cuadro(Sprite.PUERTA_INFERIOR);
//	public static final Cuadro OXIDO = new Cuadro(Sprite.OXIDO);
//	public static final Cuadro PUERTA_SUPERIOR_CENTRAL = new Cuadro(Sprite.PUERTA_SUPERIOR_CENTRAL);
	// fin de la coleccion de cuadros

	// coleccion SUBTERRANEO
	public static final Cuadro VACIO = new Cuadro(Sprite.VACIO);
	public static final Cuadro SUELO = new Cuadro(Sprite.SUELO);
	public static final Cuadro ENTRADA_INFERIOR = new Cuadro(Sprite.ENTRADA_INFERIOR);
	public static final Cuadro ENTRADA_SUPERIOR = new Cuadro(Sprite.ENTRADA_SUPERIOR);
	public static final Cuadro ENTRADA_LINEA_DERECHA = new Cuadro(Sprite.ENTRADA_LINEA_DERECHA);
	public static final Cuadro ENTRADA_LINEA_IZQUIERDA = new Cuadro(Sprite.ENTRADA_LINEA_IZQUIERDA);
	public static final Cuadro LINEA_DERECHA = new Cuadro(Sprite.LINEA_DERECHA);
	public static final Cuadro LINEA_IZQUIERDA = new Cuadro(Sprite.LINEA_IZQUIERDA);
	public static final Cuadro LINEA_SUPERIOR = new Cuadro(Sprite.LINEA_SUPERIOR);
	public static final Cuadro ESQUINA_PEQUEÑA_ID = new Cuadro(Sprite.ESQUINA_PEQUEÑA_ID);
	public static final Cuadro ESQUINA_PEQUEÑA_II = new Cuadro(Sprite.ESQUINA_PEQUEÑA_II);
	public static final Cuadro ESQUINA_PEQUEÑA_SD = new Cuadro(Sprite.ESQUINA_PEQUEÑA_SD);
	public static final Cuadro ESQUINA_PEQUEÑA_SI = new Cuadro(Sprite.ESQUINA_PEQUEÑA_SI);
	public static final Cuadro ESQUINA_LARGA_DERECHA = new Cuadro(Sprite.ESQUINA_LARGA_DERECHA);
	public static final Cuadro ESQUINA_LARGA_IZQUIERDA = new Cuadro(Sprite.ESQUINA_LARGA_IZQUIERDA);
	public static final Cuadro ESQUINA_SI = new Cuadro(Sprite.ESQUINA_SI);
	public static final Cuadro ESQUINA_SD = new Cuadro(Sprite.ESQUINA_SD);
	public static final Cuadro TIERRA = new Cuadro(Sprite.TIERRA);
	public static final Cuadro PARED = new Cuadro(Sprite.PARED);
	public static final Cuadro PARED_EXTINTOR = new Cuadro(Sprite.PARED_EXTINTOR);
	public static final Cuadro PARED_CARTEL = new Cuadro(Sprite.PARED_CARTEL);
	public static final Cuadro PARED_IZQUIERDA = new Cuadro(Sprite.PARED_IZQUIERDA);
	public static final Cuadro PARED_DERECHA = new Cuadro(Sprite.PARED_DERECHA);
	public static final Cuadro CONTROL_ACCESO = new Cuadro(Sprite.CONTROL_ACCESO);
	public static final Cuadro PARED_CENTRAL = new Cuadro(Sprite.PARED_CENTRAL);
	public static final Cuadro PUERTA = new Cuadro(Sprite.PUERTA);

	// fin subteraneo
	public Cuadro(Sprite sprite) {
		this.sprite = sprite;

	}

	public void mostrar(int x, int y, Pantalla pantalla) {
		pantalla.mostrarCuadro(x << 5, y << 5, this);
	}

	public boolean solido() {
		return false;
	}
}
