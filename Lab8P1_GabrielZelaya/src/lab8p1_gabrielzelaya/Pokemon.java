package lab8p1_gabrielzelaya;
import java.util.Random;

public class Pokemon {
    public String nombre;
    public int hp;
    public int dmg;
    public int luck;

    public Pokemon(String nombre, int hp, int dmg) {
        this.nombre = nombre;
        this.hp = hp;
        this.dmg = dmg;
    }

    public int getLuck() {
        luck = new Random().nextInt((5-1)+1)+1;
        return luck;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDmg() {
        return dmg;
    }
    
    
    
    
    
}
