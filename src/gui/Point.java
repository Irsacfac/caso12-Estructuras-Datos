package gui;

import otros.IConstants;

public class Point<T> implements IConstants{
	private int ejeX;
	private int ejeY;
	private T elemento;
	
	public Point(int pX, int pY) {
		ejeX = pX;
		ejeY = pY;
	}
	
	public boolean inRange(Point pPunto) {
		if(ejeX-RADIO_CIRCULO<=pPunto.getEjeX() && ejeX+RADIO_CIRCULO>=pPunto.getEjeX()) {
			if(ejeY-RADIO_CIRCULO<=pPunto.getEjeY() && ejeY+RADIO_CIRCULO>=pPunto.getEjeY()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean inRange(int pX, int pY) {
		if(ejeX-RADIO_CIRCULO<=pX && ejeX+RADIO_CIRCULO>=pX) {
			if(ejeY-RADIO_CIRCULO<=pY && ejeY+RADIO_CIRCULO>=pY) {
				return true;
			}
		}
		return false;
	}

	public int getEjeX() {
		return ejeX;
	}

	public int getEjeY() {
		return ejeY;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T pElemento) {
		this.elemento = pElemento;
	}
	
	
	
}
