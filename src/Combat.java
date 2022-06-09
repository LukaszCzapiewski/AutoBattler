import java.util.List;
import java.util.Random;


public class Combat {
    List<Unit> party;
    int rand;

    public Combat(List<Unit> party, List<Unit> enemies) {
        this.party = party;
        this.enemies = enemies;
    }

    List<Unit> enemies;

    void Resolve_Combat(){
        Receive_damage();
        Deal_damage();
    }
    void Deal_damage(){
        for (Unit hero:party) {
            if(enemies.size()==0) return;
            int rand = new Random().nextInt(enemies.size());
            enemies.get(rand).current_health-=hero.damage;
            if(enemies.get(rand).current_health<=0) enemies.remove(rand);
        }
    }
    
    void Receive_damage(){
        for (Unit enemy:enemies) {
            if(party.size()==0) return;
            int rand = new Random().nextInt(party.size());
            party.get(rand).current_health-=enemy.damage;
            if(party.get(rand).current_health<=0) party.remove(rand);

        }
    }
}

