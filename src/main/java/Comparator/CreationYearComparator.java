package Comparator;

import SuperHero.SuperHero;

import java.util.Comparator;

public class CreationYearComparator implements Comparator <SuperHero> {
    public int compare (SuperHero d1, SuperHero d2){
        return Integer.toString(d1.getCreationYear()).compareTo(Integer.toString(d2.getCreationYear()));
    }
}