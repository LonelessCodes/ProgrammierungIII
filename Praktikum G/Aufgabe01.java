import java.awt.Button;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Aufgabe01 extends BasisFenster {
    int oldX, oldY;
    Color aktuelleFarbe = Color.BLACK;

    public Aufgabe01() {
        super("MS Paint 2.0", 800, 600);

        Panel panel = new Panel();
        panel.setBackground(new Color(240, 240, 240));
        panel.setLayout(new BorderLayout());

        Panel leinwand = getLeinwand();

        panel.add(getMenü(leinwand), BorderLayout.NORTH);
        panel.add(leinwand, BorderLayout.CENTER);

        this.add(panel);
    }

    // Bauelemente
    private Panel getMenü(Panel leinwand) {
        Panel menü = new Panel();
        menü.setLayout(new FlowLayout(FlowLayout.LEFT));

        menü.add(new Label("Wähle Farbe:"));

        menü.add(getFarbButton(Color.RED));
        menü.add(getFarbButton(Color.YELLOW));
        menü.add(getFarbButton(Color.GREEN));
        menü.add(getFarbButton(Color.CYAN));
        menü.add(getFarbButton(Color.BLUE));
        menü.add(getFarbButton(Color.MAGENTA));
        menü.add(getFarbButton(Color.BLACK));
        menü.add(getFarbButton(Color.GRAY));
        menü.add(getFarbButton(Color.WHITE));

        menü.add(getLöschButton(leinwand));

        return menü;
    }

    private Button getFarbButton(Color farbe) {
        Button farbButton = new Button();
        farbButton.setBackground(farbe);
        farbButton.setPreferredSize(new Dimension(18, 18));
        farbButton.addActionListener(new ActionListener() { // Beobachter 1
            public void actionPerformed(ActionEvent event) {
                aktuelleFarbe = farbe;
            }
        });
        return farbButton;
    }

    private Button getLöschButton(Panel leinwand) {
        Button löschButton = new Button("Leinwand löschen");
        // Modell Button sendet bei Klick an Beobachter
        löschButton.addActionListener(new ActionListener() { // Beobachter 1
            public void actionPerformed(ActionEvent event) {
                Graphics g = leinwand.getGraphics();
                if (g == null) return;
                g.clearRect(0, 0, leinwand.getWidth(), leinwand.getHeight());
            }
        });
        return löschButton;
    }

    private Panel getLeinwand() {
        Panel leinwand = new Panel();

        MouseAdapter mouseAdapter = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }

            public void mouseDragged(MouseEvent e) {
                int newX = e.getX();
                int newY = e.getY();

                Graphics g = leinwand.getGraphics();
                g.setColor(aktuelleFarbe);
                g.drawLine(oldX, oldY, newX, newY);

                oldX = newX;
                oldY = newY;
            }
        };

        leinwand.addMouseListener(mouseAdapter);
        leinwand.addMouseMotionListener(mouseAdapter);

        leinwand.setBackground(Color.WHITE);
        leinwand.setLayout(null);

        return leinwand;
    }

    public static void main(String[] args) {
        new Aufgabe01();
    }
}
