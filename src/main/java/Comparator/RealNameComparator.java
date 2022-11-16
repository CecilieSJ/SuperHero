package Comparator;

import SuperHero.SuperHero;
import java.util.Comparator;

public class RealNameComparator implements Comparator <SuperHero> {
    public int compare (SuperHero d1, SuperHero d2){
        return d1.getRealName().toLowerCase().compareTo(d2.getRealName().toLowerCase());
    }
}
