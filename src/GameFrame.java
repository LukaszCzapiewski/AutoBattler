import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;


public class GameFrame extends JFrame {
    public static ArrayList<Unit> Party = new ArrayList<>();
    public static ArrayList<Unit> Enemies = new ArrayList<>();

    public GameFrame() throws IOException {
        initUI();
    }
    private void initUI() {
        var drawPanel = new DrawPanel(Party,Enemies);
        add(drawPanel);
        setSize(720, 560);
        setResizable(false);
        setTitle("XD");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}