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
	private Point<Node> currentPoint;
	private Point<Node> lastPoint;
	private ArrayList<Point<Node>> puntos;
	private ArrayList<Arco> arcos;
	private ArrayList<Node> recorrido;
    private URL fondo;
    private Image map;
    private Graph miGrafo;
   	private Node nodoAnterior;
   	private boolean initRecorrido;
	
	public MapPanel() {
		super();
		this.setBounds(PANEL_ANCHURA, 0, PANTALLA_ANCHURA, PANTALLA_ALTURA);
		this.addMouseListener(this);
		fondo = this.getClass().getResource("/gui/ciudad.png");
		map = new ImageIcon(fondo).getImage();
		puntos = new ArrayList<>();
		arcos = new ArrayList<>();
		recorrido = new ArrayList<>();
		miGrafo = new Graph();
		initRecorrido = false;
	}
	
	public void recorer() {
		if(puntos.size() == 0) {
			return;
		}
		recorrido = miGrafo.pathFrom(puntos.get(0).getElemento(), currentPoint.getElemento());
		repaint();
		
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
		Node<Point> nodoActual;
		for(int pos = 0; pos < recorrido.size(); pos++) {
			nodoActual = recorrido.get(pos);
			g.setColor(Color.RED);
			g.fillOval(nodoActual.getElement().getEjeX()-MOUSE_ADJUSTMENT, nodoActual.getElement().getEjeY()-MOUSE_ADJUSTMENT, RADIO_CIRCULO+10, RADIO_CIRCULO+10);
		}
		
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
					if(initRecorrido) {
						this.recorer();
						return;
					}
					puntos.add(puntoActual);
					Node miNodo = currentPoint.getElemento();
					miNodo.addArch(lastPoint.getElemento());
					arcos.add(new Arco(currentPoint,lastPoint));
					lastPoint = currentPoint;
					repaint();
					return;
				}
			}
			if(!existe) {
				currentPoint = new Point(pEvent.getX(), pEvent.getY());
				arcos.add(new Arco(currentPoint,lastPoint));
				Node nuevoNodo = new Node(currentPoint);
				miGrafo.addNode(nuevoNodo);
				miGrafo.addArch(nuevoNodo, lastPoint.getElemento());
				currentPoint.setElemento(nuevoNodo);
				puntos.add(currentPoint);
			}
		}else {
			currentPoint = new Point(pEvent.getX(), pEvent.getY());
			Node nuevoNodo = new Node(currentPoint);
			miGrafo.addNode(nuevoNodo);
			currentPoint.setElemento(nuevoNodo);
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
	public void setInitRecorido(boolean pbool) {
		initRecorrido = pbool;
	}

}
