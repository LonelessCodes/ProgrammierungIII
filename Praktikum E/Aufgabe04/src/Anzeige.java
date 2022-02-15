package Aufgabe04.src;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

public class Anzeige extends JComponent {
	private static final long serialVersionUID = 1L;
	private BufferedImage front;

	public Anzeige(BufferedImage front) {
		this.front = front;
		this.setPreferredSize(new Dimension(front.getWidth(), front.getHeight()));
	}

	public BufferedImage flip(BufferedImage back) {
		BufferedImage newBack = front;
		synchronized (this) {
			front = back;
		}
		repaint();
		return newBack;
	}

	public BufferedImage getFrontImage() {
		return front;
	}

	@Override
   protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		synchronized (this) {
			g.drawImage(front, 0, 0, this);
		}
	}
}

