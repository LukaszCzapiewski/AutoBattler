import javax.swing.*;
import java.awt.*;
import java.util.List;

class DrawPanel extends JPanel {

    List<Unit> party;
    List<Unit> enemies;

    public DrawPanel(List<Unit> party, List<Unit> enemies) {
        this.party = party;
        this.enemies = enemies;
    }

    private void doDrawing(Graphics g) {
        var g2d = (Graphics2D) g;
        int i =0;
        for (Unit hero:party) {
            float a = hero.current_health;
            float b = hero.max_health;
            int c = Math.max((int) (a / b * 120), 0);
            System.out.println(c);
            g2d.setColor(Color.black);
            g2d.drawString("" + hero.current_health + "/" + hero.max_health,45,40+i*160);
            g2d.setColor(Color.green);
            g2d.drawRect(10,40+i*160,120,20);
            g2d.fillRect(10,40+i*160, c, 20);
            g2d.drawImage(hero.image, 10, 62+i*160, null);
            i++;
        }

        i=0;
        int j=0;

        for (Unit enemy:enemies) {
            float a = enemy.current_health;
            float b = enemy.max_health;
            int c = Math.max((int) (a / b * 120), 0);
            g2d.setColor(Color.black);
            g2d.drawString("" + enemy.current_health + "/" + enemy.max_health,450+j*160,40+i*160);
            g2d.setColor(Color.red);
            g2d.drawRect(410+j*160,40+i*160,120,20);
            g2d.fillRect(410+j*160,40+i*160, c, 20);
            g2d.drawImage(enemy.image, 410+j*160, 62+i*160, null);
            i++;
            if(i==3) {i=0;++j;}
        }



    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }


}

