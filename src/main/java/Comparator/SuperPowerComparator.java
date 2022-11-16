package Comparator;

import SuperHero.SuperHero;
import java.util.Comparator;

public class SuperPowerComparator implements Comparator<SuperHero> {
    public int compare(SuperHero d1, SuperHero d2){
        return d1.getSuperPower().toLowerCase().compareTo(d2.getSuperPower().toLowerCase());
    }
}
