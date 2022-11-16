package Comparator;

import SuperHero.SuperHero;

import java.util.Comparator;

public class FlexibleComparator implements Comparator<SuperHero> {
    private String sortBy;
    public FlexibleComparator(String sortBy){
        this.sortBy = sortBy;
    }
    @Override
    public int compare(SuperHero o1, SuperHero o2) {
        switch(sortBy){
            case "heroName"->{
                return o1.getHeroName().compareTo(o2.getHeroName());
            }
            case "realName"->{
                return o1.getRealName().compareTo(o2.getRealName());
            }
            case "superPower"->{
                return o1.getSuperPower().compareTo(o2.getSuperPower());
            }
            case "creationYear"->{
                return Integer.compare(o1.getCreationYear(),o2.getCreationYear());
            }
            case "isHuman" -> {
                return Boolean.compare(o1.getishuman(),o2.getishuman());
            }
        }
        return 0;
    }
}
