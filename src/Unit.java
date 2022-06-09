import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Unit {
    final static String path = new File("").getAbsolutePath()+"\\img\\";
    final static Image dead;
    static {
        try {
            dead = ImageIO.read(new File(path+"dead.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    boolean alive = true;
    String name;
    int current_health;
    int max_health;
    int damage;
    Image image;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrent_health() {
        return current_health;
    }

    public void setCurrent_health(int current_health) {
        this.current_health = current_health;
    }

    public int getMax_health() {
        return max_health;
    }

    public void setMax_health(int max_health) {
        this.max_health = max_health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Unit(String name, int health, int max_health, int damage, Image image) {
        this.name = name;
        this.current_health = health;
        this.max_health = max_health;
        this.damage = damage;
        this.image = image;
    }

    public void Die() {
            current_health=0;
            alive=false;
            image=dead;
    }
}


