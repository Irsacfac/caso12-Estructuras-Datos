package gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import otros.IConstants;

public class MainWindow extends JFrame implements IConstants{
	private MapPanel myMapPanel;

	public MainWindow() {
		this("No Title");
	}
	
	public MainWindow(String pNombre) {
		super(pNombre);
		
		this.setLayout(null);
		this.setSize(PANTALLA_ANCHURA, PANTALLA_ALTURA);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setExtendedState(Frame.NORMAL);
        
        initComponents();
        
        this.setVisible(true);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		myMapPanel = new MapPanel();
		this.getContentPane().add(myMapPanel);
		
		JButton buttonSimular = new JButton();
		buttonSimular.setBounds((int)PANEL_ANCHURA/2, (int)PANTALLA_ALTURA/2, DEFAULT_BUTTON_ANCHURA, DEFAULT_BUTTON_ALTURA);
		buttonSimular.setName("Simular");
		
		JPanel buttonPlace = new JPanel();
		buttonPlace.setBounds(0, 0, PANEL_ANCHURA, PANTALLA_ALTURA);
		//buttonPlace.setBackground(Color.BLUE);
		this.getContentPane().add(buttonPlace);
		
		buttonPlace.add(buttonSimular);
		buttonSimular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
}
