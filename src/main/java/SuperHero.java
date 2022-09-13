
public class SuperHero {

    private String heroName;
    private String superPower;
    private String strenght;
    private int creationYear;
    private boolean ishuman;


    public SuperHero(String heroName, String superPower, String strenght, boolean ishuman, int creationYear) {
        this.heroName = heroName;
        this.superPower = superPower;
        this.strenght = strenght;
        this.ishuman = ishuman;
        this.creationYear = creationYear;

    }

    public String getHeroName(){
        return heroName;
    }


    public String getSuperPower(){
        return superPower;
    }


    public String getStrenght() {
        return strenght;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public boolean getishuman(){
        return ishuman;
    }

    public String toString(){
        return heroName + " " + superPower + " " + strenght + " " + creationYear;
    }



}

