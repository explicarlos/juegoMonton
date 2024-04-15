// juego del montón: cada turno se cogen hasta n

public class JuegoMonton {

	static java.util.Scanner teclado=null;
	static void abrirTeclado() {
		teclado=new java.util.Scanner(System.in);
		return;
	}
	static void escribir(String texto) {
		System.out.print(texto);
		return;
	}
	static String leer() {
		if (teclado==null)
			abrirTeclado();
		return teclado.nextLine();
	}
	static String leerInt() {
		if (teclado==null)
			abrirTeclado();
		return teclado.hasNextInt() ? teclado.nextInt() + "" : "";
	}
	static String leerDouble() {
		if (teclado==null)
			abrirTeclado();
		return teclado.hasNextDouble() ? teclado.nextDouble() + "" : "";
	}
	static String preguntar(String pregunta) {
		System.out.print(pregunta + " -> ");
		return leer();
	}
	static int preguntarInt(String pregunta) {
		boolean esAceptado=false;
		String respuesta="";
		int datoInt=0;
		do {
			escribir(pregunta+" -> ");
			respuesta=leerInt();
			if (respuesta.isEmpty()) {
				escribir("Eso no es un entero.\n");
				esAceptado=false;
			} else {
				datoInt= Integer.parseInt(respuesta);
				esAceptado=true;
			}
		} while (!esAceptado);
		return datoInt;
	}
	static int preguntarInt(String pregunta, int cotaInf) {
		boolean esAceptado=false;
		String respuesta="";
		int datoInt=0;
		do {
			escribir(pregunta+" -> ");
			respuesta=leerInt();
			if (respuesta.isEmpty()) {
				escribir("Eso no es un entero.\n");
				esAceptado=false;
			} else {
				datoInt= Integer.parseInt(respuesta);
				if (datoInt<cotaInf){
					escribir("El entero debe ser "+cotaInf+" al menos.\n");
					esAceptado=false;
				} else
					esAceptado=true;
			}
		} while (!esAceptado);
		return datoInt;
	}
	static int preguntarInt(String pregunta, int cotaInf, int cotaSup) {
		boolean esAceptado=false;
		String respuesta="";
		int datoInt=0;
		if (cotaSup<cotaInf) {
			int aux=cotaInf;
			cotaInf=cotaSup;
			cotaSup=aux;
		}
		do {
			escribir(pregunta+" -> ");
			respuesta=leerInt();
			if (respuesta.isEmpty()) {
				escribir("Eso no es un entero.\n");
				esAceptado=false;
			} else {
				datoInt= Integer.parseInt(respuesta);
				if (datoInt<cotaInf || datoInt>cotaSup) {
					escribir("El entero debe estar entre "+cotaInf+" y "+cotaSup+" incluidos.\n");
					esAceptado=false;
				} else
					esAceptado=true;
			}
		} while (!esAceptado);
		return datoInt;
	}
	static double preguntarDouble(String pregunta) {
		boolean esAceptado=false;
		String respuesta="";
		double datoDouble=0.0;
		do {
			escribir(pregunta+" -> ");
			respuesta=leerDouble();
			if (respuesta.isEmpty()) {
				escribir("Eso no es un doble-precisión.\n");
				esAceptado=false;
			} else {
				datoDouble= Double.parseDouble(respuesta);
				esAceptado=true;
			}
		} while (!esAceptado);
		return datoDouble;
	}
	static double preguntarDouble(String pregunta, double cotaInf) {
		boolean esAceptado=false;
		String respuesta="";
		double datoDouble=0.0;
		do {
			escribir(pregunta+" -> ");
			respuesta=leerInt();
			if (respuesta.isEmpty()) {
				escribir("Eso no es un doble-precisión.\n");
				esAceptado=false;
			} else {
				datoDouble= Double.parseDouble(respuesta);
				if (datoDouble<cotaInf){
					escribir("El número debe ser "+cotaInf+" al menos.\n");
					esAceptado=false;
				} else
					esAceptado=true;
			}
		} while (!esAceptado);
		return datoDouble;
	}
	static double preguntarDouble(String pregunta, double cotaInf, double cotaSup) {
		boolean esAceptado=false;
		String respuesta="";
		double datoDouble=0.0;
		if (cotaSup<cotaInf) {
			double aux=cotaInf;
			cotaInf=cotaSup;
			cotaSup=aux;
		}
		do {
			escribir(pregunta+" -> ");
			respuesta=leerDouble();
			if (respuesta.isEmpty()) {
				escribir("Eso no es un doble-precisión.\n");
				esAceptado=false;
			} else {
				datoDouble= Double.parseDouble(respuesta);
				if (datoDouble<cotaInf || datoDouble>cotaSup) {
					escribir("El número debe estar entre "+cotaInf+" y "+cotaSup+" incluidos.\n");
					esAceptado=false;
				} else
					esAceptado=true;
			}
		} while (!esAceptado);
		return datoDouble;
	}

	public static void main(String[] args) {

		String respuesta=""; // respuesta por teclado del jugador
		boolean esAceptado=false; // controla permanencia en bucle de petición de datos
		int puntosIniciales; // puntos inicialmente en el montón
		int puntosRestantes; // puntos actualmente en el montón
		boolean esTurnoJugador; // es o no turno del jugador
		boolean esGanadorUltimo; // es ganador o no quien juega el último
		int jugadaMax; // máximo número de puntos a retirar
		int jugada; // puntos retirados en la jugada actual

		try {
			escribir("\n_______________________________________\n\n");
			escribir("En este juego hay un montón de puntos. Cada turno un jugador retira desde 1 hasta\n");
			escribir("\tun máximo de puntos. Vence (o pierde) quien juegue el último turno.\n\n");
			puntosIniciales=preguntarInt("¿Cuántos puntos tiene inicialmente el montón? (2 mínimo)", 2);
			jugadaMax=preguntarInt("¿Cuántos puntos pueden retirarse como máximo en una jugada? (2 mínimo)", 2);
			leer();
			esGanadorUltimo=(preguntar("¿Gana la partida quien juegue el último? (s/n)")+" ").toLowerCase().charAt(0)=='s';
			esTurnoJugador=(preguntar("¿Tienes tú el turno de juego? (s/n)")+" ").toLowerCase().charAt(0)=='s';
			escribir("\n_______________________________________\n\n");
			escribir("Esta es la situación: \n\thay "+puntosIniciales+" puntos en el montón,\n");
			escribir("\ten cada turno se retiran entre 1 y "+jugadaMax+" puntos,\n");
			escribir("\t"+(esGanadorUltimo ? "vence" : "pierde")+" quien juegue el último,\n");
			escribir(esTurnoJugador ? "\tempiezas jugando tú.\n" : "\tempiezo jugando yo.\n");
			escribir("\n_______________________________________\n\n");
			puntosRestantes=puntosIniciales;
			while (puntosRestantes>0) {
				if (esTurnoJugador) {
					if (esGanadorUltimo) {
						if (puntosRestantes==1)
							escribir("Tranquilo, que vas a vencer seguro.\n");
						else if (puntosRestantes<=jugadaMax)
							escribir("Piensa bien, que aquí se decide la partida.\n");
					} else {
						if (puntosRestantes==1)
							escribir("Abandona toda esperanza, que vas a perder seguro.\n");
						else if (puntosRestantes<=jugadaMax+1)
							escribir("Ten cuidado, que aquí se decide la partida.\n");
					}
					escribir("En este momento en el montón hay "+puntosRestantes+(puntosRestantes>1 ? " puntos" : " punto"));
					escribir(" y es tu turno de jugar.\n");
					jugada=preguntarInt("¿Cuántos puntos retiras del montón (1-"
							+((int) Math.min(jugadaMax, puntosRestantes))+") ?", 1, Math.min(jugadaMax, puntosRestantes));
					puntosRestantes-=jugada;
					escribir("\n_______________________________________\n\n");
					escribir("Has retirado "+jugada+(jugada>1 ? " puntos" : " punto")+" del montón.\n");
					escribir("Ahora hay "+puntosRestantes+(puntosRestantes==1 ? " punto" : " puntos")+" en el montón.\n");
					if (puntosRestantes==0)
						if (esGanadorUltimo)
							escribir("¡Enhorabuena! Has ganado esta partida.\n");
						else
							escribir("Lo siento, has perdido. Pero es que yo soy muy bueno...\n");
					esTurnoJugador=false;
				}
				if (puntosRestantes>0 && !esTurnoJugador) {
					if (esGanadorUltimo && puntosRestantes<=jugadaMax)
						escribir("¿Te das cuenta de que tengo la victoria a mi alcance?\n");
					else if (!esGanadorUltimo && puntosRestantes==1)
						escribir("Estoy obligado a jugar y ya sé que voy a perder.\n");
					if (puntosRestantes==1)
						jugada=1;
					else {
						jugada = (puntosRestantes - (esGanadorUltimo ? 0 : 1)) % (jugadaMax + 1);
						if (jugada == 0) {
							jugada = (int) Math.floor(1.0 + 2.0 * Math.random());
							escribir("Me temo que mi posición es preocupante.\n");
						} else
							escribir("Creo que estoy en posición ventajosa.\n");
					}
					escribir("Es mi turno de hacer jugada.\n");
					puntosRestantes-=jugada;
					escribir("Decido retirar "+jugada+(jugada>1 ? " puntos" : " punto")+" del montón.\n");
					if (puntosRestantes==0)
						if (esGanadorUltimo)
							escribir("He ganado la partida. Ha sido estupendo.\n");
						else
							escribir("¡Vaya! He perdido esta vez. Enhorabuena para ti.\n");
					esTurnoJugador=true;
				}
			}
			escribir("Hasta luego.\n");
			leer();
			leer();
		} catch (Exception e) {
			escribir("- Se han producido errores. Abortando programa.\n");
			System.exit(1);
		}
		escribir("- Programa terminado normalmente.\n");
		System.exit(0);
	}
}
