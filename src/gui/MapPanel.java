package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import otros.IConstants;

public class MapPanel extends JPanel implements IConstants, MouseListener, ActionListener {
	private int currentX;
	private int currentY;
	private int lastX;
	private int lastY;
	private int cantNodos;
    private boolean paintCircle;
    private boolean recorrer;
    private Image imageBuffer;
    private URL fondo;
    private Image map;
	
	public MapPanel() {
		super();
		//this.setSize(PANEL_ANCHURA-PANEL_ANCHURA, PANTALLA_ALTURA);
		this.setBounds(PANEL_ANCHURA, 0, PANTALLA_ANCHURA, PANTALLA_ALTURA);
		this.addMouseListener(this);
		fondo = this.getClass().getResource("/gui/ciudad.png");
		map = new ImageIcon(fondo).getImage();
		//pVentana.getContentPane().add(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void paint(Graphics g) {
    	if (imageBuffer == null) {
    		imageBuffer = this.createImage(PANTALLA_ANCHURA, PANTALLA_ALTURA);
    	}
    	if (paintCircle) {
    		Graphics g2 = imageBuffer.getGraphics();
    		if(cantNodos!=0) {
    			g2.drawLine(lastX, lastY, currentX, currentY);
    		}
			g2.fillOval(currentX-MOUSE_ADJUSTMENT, currentY-MOUSE_ADJUSTMENT, RADIO_CIRCULO, RADIO_CIRCULO);
			lastX = currentX;
			lastY = currentY;
			cantNodos++;
			paintCircle = false;
    	}
    	//super.paint(g);
    	if(recorrer) {
    		
    	}
    	g.drawImage(imageBuffer, 0, 0, null);
    }
	

	@Override
	public void mouseClicked(MouseEvent pEvent) {
		// TODO Auto-generated method stub
		currentX = pEvent.getX();
        currentY = pEvent.getY();
        paintCircle = true;
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
