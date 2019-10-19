package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Grafo.Graph;
import Grafo.Node;
import otros.IConstants;

public class MapPanel extends JPanel implements IConstants, MouseListener, ActionListener {
	private Point currentPoint;
	private Point lastPoint;
	private ArrayList<Point> puntos;
	ArrayList<Arco> arcos;
    private boolean paintCircle;
    private boolean inRange;
    private boolean recorrer;
    //private Image imageBuffer;
    private URL fondo;
    private Image map;
    private Graph miGrafo;
   	private Node nodoAnterior;
	
	public MapPanel() {
		super();
		this.setBounds(PANEL_ANCHURA, 0, PANTALLA_ANCHURA, PANTALLA_ALTURA);
		this.addMouseListener(this);
		fondo = this.getClass().getResource("/gui/ciudad.png");
		map = new ImageIcon(fondo).getImage();
		puntos = new ArrayList<>();
		arcos = new ArrayList<>();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void paint(Graphics g) {
		g.drawImage(map, 0, 0, null);

		Point<Node> puntoActual;
		for (int punto = 0; punto < puntos.size(); punto++) {
			puntoActual = puntos.get(punto);
			g.fillOval(puntoActual.getEjeX()-MOUSE_ADJUSTMENT, puntoActual.getEjeY()-MOUSE_ADJUSTMENT, RADIO_CIRCULO, RADIO_CIRCULO);
			
		}
		Arco<Node> arcoActual;
		for (int arco = 0; arco < arcos.size(); arco++) {
			arcoActual = arcos.get(arco);
			g.drawLine(arcoActual.getPuntoA().getEjeX(), arcoActual.getPuntoA().getEjeY(), arcoActual.getPuntoB().getEjeX(), arcoActual.getPuntoB().getEjeY());
		}
		
		/*if(puntos.size() != 0) {
			if(inRange){
					g.drawLine(lastPoint.getEjeX(), lastPoint.getEjeY(), currentPoint.getEjeX(), currentPoint.getEjeY());
					paintCircle = false;
					lastPoint = currentPoint;
					inRange = false;
					return;
			}
			g.drawLine(lastPoint.getEjeX(), lastPoint.getEjeY(), currentPoint.getEjeX(), currentPoint.getEjeY());
		}
    	if (paintCircle) {
			g.fillOval(currentPoint.getEjeX()-MOUSE_ADJUSTMENT, currentPoint.getEjeY()-MOUSE_ADJUSTMENT, RADIO_CIRCULO, RADIO_CIRCULO);
			lastPoint = currentPoint;
			puntos.add(currentPoint);
			paintCircle = false;
    	}
    	if(recorrer) {
    		
    	}
    	//g.drawImage(imageBuffer, 0, 0, null);*/
    }
	

	@Override
	public void mouseClicked(MouseEvent pEvent) {
		// TODO Auto-generated method stub
		Point puntoActual;
		boolean existe = false;
		if(puntos.size() != 0) {
			for (int punto = 0; punto < puntos.size(); punto++) {
				puntoActual = puntos.get(punto);
				existe = puntoActual.inRange(pEvent.getX(), pEvent.getY());
				if(existe) {
					currentPoint = puntoActual;
					inRange = true;
					puntos.add(puntoActual);
					arcos.add(new Arco(currentPoint,lastPoint));
					lastPoint = currentPoint;
					repaint();
					return;
				}
			}
			currentPoint = new Point(pEvent.getX(), pEvent.getY());
			arcos.add(new Arco(currentPoint,lastPoint));
		}
		if(!existe) {
			currentPoint = new Point(pEvent.getX(), pEvent.getY());
			puntos.add(currentPoint);
		}
		lastPoint = currentPoint;
        repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
