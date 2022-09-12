public class SuperHero {

    private String heroName;
    private String superPower;
    private String strenght;
    private int creationYear;


    public SuperHero(String heroName, String superPower, String strenght, int creationYear) {
        this.heroName = heroName;
        this.superPower = superPower;
        this.strenght = strenght;
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

    public String toString(){
        return heroName + " " + superPower + " " + strenght + " " + creationYear;
    }



}
