package gui;

public class Arco<T> {
	private Point<T> puntoA;
	private Point<T> puntoB;
	
	public Arco(Point<T> pA, Point<T> pB){
		puntoA = pA;
		puntoB = pB;
	}

	public Point<T> getPuntoA() {
		return puntoA;
	}

	public Point<T> getPuntoB() {
		return puntoB;
	}

}
