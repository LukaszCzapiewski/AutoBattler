import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class AutoBattler {
    final static String path = new File("").getAbsolutePath()+"\\img\\";
    static GameFrame frame;
    public static void main(String[] args) throws IOException, InterruptedException {




        EventQueue.invokeLater(() -> {
            try {
                frame = new GameFrame();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            frame.setVisible(true);
        });
        Image image = ImageIO.read(new File(path+"warrior.png"));
        Image image2 = ImageIO.read(new File(path+"barbarian.png"));
        var Party = new ArrayList<Unit>();
        Unit unit = new Unit("Warrior",300,500,50,image);
        Unit unit2 = new Unit("Warrior",450,500,50,image);
        Unit unit3 = new Unit("Warrior",100,500,50,image);
        Party.add(unit);
        Party.add(unit2);
        Party.add(unit3);
        var Enemies = new ArrayList<Unit>();
        Unit enemy1 = new Unit("Warrior",500,500,50,image2);
        Unit enemy2 = new Unit("Warrior",500,500,50,image2);
        Unit enemy3 = new Unit("Warrior",500,500,50,image2);
        Enemies.add(enemy1);
        Enemies.add(enemy2);
        Enemies.add(enemy3);
        Enemies.add(enemy1);
        Enemies.add(enemy1);
        Enemies.add(enemy1);
        Enemies.add(enemy1);
        GameFrame.Party =Party;
        GameFrame.Enemies =Enemies;
        while (true){
            Thread.sleep(1000);
            unit2.AssignDamage(100);
            unit.AssignDamage(100);
            enemy1.AssignDamage(200);
            frame.repaint();
        }
    }}

