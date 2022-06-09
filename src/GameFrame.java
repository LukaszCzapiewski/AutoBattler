import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;



public class GameFrame extends JFrame {
    final static String path = new File("").getAbsolutePath()+"\\img\\";
    Image image = ImageIO.read(new File(path+"warrior.png"));
    Image image2 = ImageIO.read(new File(path+"barbarian.png"));
    public static ArrayList<Unit> Party = new ArrayList<>();
    public static ArrayList<Unit> Enemies = new ArrayList<>();

    public GameFrame() throws IOException {
        var button1 = new JButton();
        button1.setText("start");
   /*     add(button1);
        button1.setBounds(250, 170, 170, 70);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setVisible(false);
                start();
            }
        });*/
        setSize(720, 560);
        setResizable(false);
        setTitle("XD");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start();

    }
    public void start() {
        this.setIconImage(image);
        Unit unit1 = new Unit("Warrior",300,500,50,image);
        Unit unit2 = new Unit("Warrior",450,500,50,image);
        Unit unit3 = new Unit("Warrior",100,500,50,image);
        Party.add(unit1);
        Party.add(unit2);
        Party.add(unit3);
        Unit enemy1 = new Unit("Warrior",500,500,1,image2);
        Unit enemy2 = new Unit("Warrior",500,500,2,image2);
        Unit enemy3 = new Unit("Warrior",500,500,3,image2);
        Unit enemy4 = new Unit("Warrior",500,500,4,image2);
        Unit enemy5 = new Unit("Warrior",500,500,5,image2);
        Unit enemy6 = new Unit("Warrior",500,500,6,image2);
        Enemies.add(enemy1);
        Enemies.add(enemy2);
        Enemies.add(enemy3);
        Enemies.add(enemy4);
        Enemies.add(enemy5);
        Enemies.add(enemy6);
        var drawPanel = new DrawPanel(Party,Enemies);
        add(drawPanel);
        this.repaint();
        java.util.Timer timer = new Timer();
        TimerTask task = new Helper(Party, Enemies,this);
        timer.schedule(task, 0,100);
        System.out.println("done");

    }


}


class Helper extends TimerTask
{
    ArrayList<Unit> Party;
    ArrayList<Unit> Enemies;
    Combat combat;
    GameFrame frame;

    public Helper(ArrayList<Unit> party, ArrayList<Unit> enemies, GameFrame frame) {
        Party = party;
        Enemies = enemies;
        combat = new Combat(Party, Enemies);
        this.frame = frame;
    }

    public void run() {
        if (Party.size()==0) {
            this.cancel();
            //GAME OVER

        }

        if (Enemies.size()==0) {
            this.cancel();
            //UPGRADE SCREEN THEN NEXT BATTLE

        }
        combat.Resolve_Combat();
        frame.repaint();

    }
}

