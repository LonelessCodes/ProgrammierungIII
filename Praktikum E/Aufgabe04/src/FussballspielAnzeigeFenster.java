package Aufgabe04.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class FussballspielAnzeigeFenster extends JFrame implements FussballspielAnzeige {
	private static final long serialVersionUID = 1L;
	private FussballspielModell model;

	private final static Font fontText   = Font.decode("verdana-plain-16");
	private final static Font fontText2  = Font.decode("verdana-bold-16");
	private final static Font fontTor    = Font.decode("verdana-bold-28");
	private final static Font fontChance = Font.decode("verdana-plain-14");
	
	private BufferedImage offscreen, onscreen;
	private Anzeige anzeige;

	private static final int VIEW_WIDTH  = 512;
	private static final int VIEW_HEIGHT = 300;
	private BufferedImage backgroundImage;

	public FussballspielAnzeigeFenster(FussballspielModell m) {
		model = m;

		// Renderscreen
		offscreen = new BufferedImage(VIEW_WIDTH, VIEW_HEIGHT, BufferedImage.TYPE_INT_RGB);
		onscreen = new BufferedImage(VIEW_WIDTH, VIEW_HEIGHT, BufferedImage.TYPE_INT_RGB);
		anzeige = new Anzeige(onscreen);
		getContentPane().add(anzeige);

		// lade Hintergrundbild
		try {
			backgroundImage = ImageIO.read(new File("feld2.bmp"));
		} catch (IOException e) {
			System.out.println("FEHLER: Hintergrundbild konnte nicht geladen werden.");
			dispose();
		}
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(backgroundImage, 0);
		try {
			mt.waitForAll();
		} catch (InterruptedException e) {}

		// zentriere das Fenster
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - VIEW_WIDTH) / 2, (d.height - VIEW_HEIGHT) / 2,
				VIEW_WIDTH, VIEW_HEIGHT);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void zeigeSpielfeld(Graphics2D g) {
		g.setBackground(Color.WHITE);
		g.clearRect(0, 0, offscreen.getWidth(), offscreen.getHeight());

		// Hintergrund zeichnen
		g.drawImage(backgroundImage, null, VIEW_WIDTH / 2 - backgroundImage.getWidth() / 2, 150);
		g.setFont(fontTor);
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("" + model.getToreHeim(), VIEW_WIDTH / 2 - 40, 190);
		g.drawString("" + model.getToreGast(), VIEW_WIDTH / 2 + 30, 190);

		g.setFont(fontText);
		g.setColor(Color.DARK_GRAY);
		g.drawString(model.getNameHeim(), VIEW_WIDTH / 2 - 80 - 9
				* model.getNameHeim().length(), 180);
		g.drawString(model.getNameGast(), VIEW_WIDTH / 2 + 70, 180);
		g.setFont(fontChance);
		g.setColor(Color.LIGHT_GRAY);
		// Chancen, St�rken und Motivationen
		g.drawString("(C: " + model.getTorschuesseHeim() + 
				     ", S: "+ (int)model.getStaerkeHeim() +
				     ", M: "+ (int)model.getMotivationHeim() +
				     ")", VIEW_WIDTH / 2 - 80 - 9 * model.getNameHeim().length(), 200);
		g.drawString("(C: " + model.getTorschuesseGast() + 
				     ", S: "+ (int)model.getStaerkeGast() +
			         ", M: "+ (int)model.getMotivationGast() +
				     ")", VIEW_WIDTH / 2 + 70, 200);

		// Ball (Visualisierung der Tendenz)
		g.setColor(Color.ORANGE);
		Ellipse2D Circle = new Ellipse2D.Double(VIEW_WIDTH / 2 - 8
				+ (int) (-model.getTendenz() * 1.9), 240, 10, 10);
		g.fill(Circle);
	}

	@Override
   public void zeigeIntro() {
		// zeichnen im ges�uberten Screen
		Graphics2D g2 = offscreen.createGraphics();
		zeigeSpielfeld(g2);
		g2.setFont(fontText);
		g2.setColor(Color.DARK_GRAY);
		g2.drawString("Freundschaftspiel zwischen: ", 10, 30);
		g2.drawString(model.getNameHeim() + " und " + model.getNameGast(), 10,
				50);
		offscreen = anzeige.flip(offscreen);
	}

	@Override
   public void zeigeMinute() {
		// zeichnen im ges�uberten Screen
		Graphics2D g2 = offscreen.createGraphics();
		zeigeSpielfeld(g2);
		g2.setFont(fontText);
		g2.setColor(Color.DARK_GRAY);
		g2.drawString(model.getAktZeit() + ". Minute", 10, 30);
		offscreen = anzeige.flip(offscreen);
	}

	@Override
   public void zeigeTorchance() {
		// zeichnen im ges�uberten Screen
		Graphics2D g2 = offscreen.createGraphics();
		zeigeSpielfeld(g2);
		g2.setFont(fontText);
		g2.setColor(Color.DARK_GRAY);
		g2.drawString(model.getAktZeit() + ". Minute: ", 10, 30);
		g2.drawString(
				"   Chance fuer " + model.getAktMannschaftName() + " ...", 10,
				50);
		g2.drawString("   " + model.getAktSpielerName() + " zieht ab", 10, 70);
		offscreen = anzeige.flip(offscreen);
	}

	@Override
   public void zeigeTor() {
		// zeichnen im ges�uberten Screen
		Graphics2D g2 = anzeige.getFrontImage().createGraphics();
		g2.setFont(fontText2);
		g2.setColor(Color.DARK_GRAY);
		g2.drawString(
				"   TOR!!!     " + model.getToreHeim() + ":"
						+ model.getToreGast() + " " + model.getAktSpielerName()
						+ "(" + model.getAktSpielerTore() + ")", 10, 100);
		repaint();
	}

	@Override
   public void zeigeParade() {
		// zeichnen im ges�uberten Screen
		Graphics2D g2 = anzeige.getFrontImage().createGraphics();
		g2.setFont(fontText2);
		g2.setColor(Color.DARK_GRAY);
		g2.drawString(
				"   " + model.getAktTorwartName() + " pariert glanzvoll.", 10,
				100);
		repaint();
	}

	@Override
   public void zeigeErgebnis() {
		// zeichnen im ges�uberten Screen
		Graphics2D g2 = offscreen.createGraphics();
		zeigeSpielfeld(g2);
		g2.setFont(fontText);
		g2.setColor(Color.DARK_GRAY);
		g2.drawString("Das Freundschaftsspiel endete: ", 10, 30);
		g2.drawString(model.getNameHeim() + " " + model.getToreHeim() + ":"
				+ model.getToreGast() + " " + model.getNameGast(), 10, 50);
		offscreen = anzeige.flip(offscreen);
	}
}