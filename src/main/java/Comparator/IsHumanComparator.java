package Comparator;

import SuperHero.SuperHero;

import java.util.Comparator;

public class IsHumanComparator implements Comparator <SuperHero> {
    public int compare (SuperHero d1, SuperHero d2){
        return Boolean.toString(d1.getishuman()).compareTo(Boolean.toString(d2.getishuman()));
    }
}