//Benjamin Montgomery
//Drawing App

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class DrawingFrame extends JFrame {

	DrawingComponent dc;
	
	public DrawingFrame() {
		
		class MyKeyListener implements KeyListener {
			
			@Override
			public void keyPressed(KeyEvent event) 
			{
				char ch = event.getKeyChar();
				String key = ("" + ch).toUpperCase();
				dc.processKey(key);
			}
			
			//do-nothing methods
			public void keyReleased(KeyEvent event) {}
			public void keyTyped(KeyEvent event) {}
		}
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		
		
		JLabel help = new JLabel("(E)rase (T)rails (L)ine (B)ox (O)val (C)olor (N)ested (S)ave (R)estore");
		help.setHorizontalAlignment(JLabel.CENTER);
		p.add(help, BorderLayout.SOUTH);
		add(p);
		
		dc = new DrawingComponent();
		p.add(dc, BorderLayout.CENTER);
			
		setSize(500, 500);
		setTitle("Simple Drawing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addKeyListener(new MyKeyListener());
		setFocusable(true);
		requestFocusInWindow();
		
	}
}
