package Comparator;

import SuperHero.SuperHero;
import java.util.Comparator;

public class HeroNameComparator implements Comparator <SuperHero> {
    public int compare(SuperHero d1, SuperHero d2) {
        return d1.getHeroName().toLowerCase().compareTo(d2.getHeroName().toLowerCase());
    }
}