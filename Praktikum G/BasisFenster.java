import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BasisFenster extends Frame {
    public BasisFenster(String titel, int breite, int hoehe) {
        setTitle(titel);
        setSize(breite, hoehe);
        setResizable(false);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                // Fenster schließen
                event.getWindow().dispose();
                // Programm beenden
                System.exit(0);
            }
        });

        setVisible(true);
    }
}
