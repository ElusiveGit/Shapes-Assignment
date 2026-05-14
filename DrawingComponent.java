//Benjamin Montgomery
//Drawing App

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.io.*;

import javax.swing.*;

public class DrawingComponent extends JComponent {
	
	private ArrayList<Shape> shapes = new ArrayList<>();
	private Shape currentShape = null;
	
	private ShapeType currentType = ShapeType.LINE;
	private Color currentColor = Color.black;
	private boolean trailsOn = false;
	
	private static final int NEST_DECREMENT = 5;
	private static final int NEST_MIN_SIZE = 10;
	private boolean nestingOn = false;
	
	public DrawingComponent() {
		
		MouseAdapter adapter = new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent event) {
				Point p = new Point(event.getX(), event.getY());
				currentShape = createShape(p, p);
				shapes.add(currentShape);
				
				repaint();
			}
			
			@Override
			public void mouseDragged(MouseEvent event) {
				Point p = new Point(event.getX(), event.getY());
				
				if (!trailsOn) {
					if (currentShape != null) {
						currentShape.setP2(p);
					}
				} else {
						Shape s = createShape(currentShape.getP1(), p);
						shapes.add(s);
					}
					
					repaint();
				}
				
			@Override
			public void mouseReleased(MouseEvent event) {
				if (nestingOn && (currentType == ShapeType.BOX || currentType == ShapeType.OVAL)) {
					Shape last = shapes.get(shapes.size() - 1);
					generateNestedShapes(last);
				}
				currentShape = null;
				repaint();
			}
			
			
		};
		
		addMouseListener(adapter);
		addMouseMotionListener(adapter);
		
	}
	
	private Shape createShape(Point p1, Point p2) {
		switch (currentType) {
		case BOX:
			return new Box(p1, p2, currentColor, nestingOn);
		case OVAL:
			return new Oval(p1, p2, currentColor, nestingOn);
		default:
			return new Line(p1, p2, currentColor, nestingOn);
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		for (Shape s : shapes) {
			s.draw(g);
		}		
	}

	public void processKey(String key) {
		key = key.toUpperCase();
		
		switch (key) {
		case "E":
			shapes.clear();
			repaint();
			break;
			
		case "T":
			trailsOn = !trailsOn;
			if (trailsOn) nestingOn = false;
			break;
			
		case "N":
			nestingOn = !nestingOn;
			if (nestingOn) trailsOn = false;
			break;
			
		case "L":
			currentType = ShapeType.LINE;
			break;
			
		case "B":
			currentType = ShapeType.BOX;
			break;
			
		case "O":
			currentType = ShapeType.OVAL;
			break;
			
		case "C":
			Color chosen = JColorChooser.showDialog(this, "Choose a Color: ", currentColor);
			if (chosen != null) {
				currentColor = chosen;
				break;
			}
				
		case "S":
			saveDrawing();
			break;
			
		case "R":
			restoreDrawing();
			break;
				
			}
		}
		
	
	public void generateNestedShapes(Shape original) {
		createNestedRecursive(original);
	}
	
	public void createNestedRecursive(Shape shape) {
		Shape smaller = shape.createSmaller(NEST_DECREMENT);
		
		if (smaller.getWidth() < NEST_MIN_SIZE || smaller.getHeight() < NEST_MIN_SIZE) {
			return;
		}
		shapes.add(smaller);
		createNestedRecursive(smaller);
	}


	private void saveDrawing() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);
	
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
		
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
				out.writeObject(shapes);
				repaint();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Error saving file:\n" + e.getMessage());
			}
		}
	}
	
	private void restoreDrawing() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);
		
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
				shapes = (ArrayList<Shape>) in.readObject();
				repaint();
			} catch (IOException | ClassNotFoundException e) {
				JOptionPane.showMessageDialog(this, "Error loading file:\n" + e.getMessage());
			}
		}
	}
}
