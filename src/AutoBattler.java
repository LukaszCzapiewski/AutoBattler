import java.awt.*;
import java.io.IOException;


public class AutoBattler {

    static GameFrame frame;

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            try {
                frame = new GameFrame();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            frame.setVisible(true);
        });

    }

}

