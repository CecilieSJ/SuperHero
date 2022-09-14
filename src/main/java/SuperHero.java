
public class SuperHero {

    private String heroName;
    private String realName;
    private String superPower;
    private int creationYear;
    private boolean ishuman = true;


    public SuperHero(String heroName, String realName, String superPower, boolean ishuman, int creationYear) {
        this.heroName = heroName;
        this.realName = realName;
        this.superPower = superPower;
        this.ishuman = ishuman;
        this.creationYear = creationYear;

    }

    public String getHeroName(){
        return heroName;
    }

    public void setHeroName(String heroName){
        this.heroName = heroName;

    }

    public String getRealName(){
        return realName;
    }


    public String getSuperPower() {
        return superPower;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public boolean getishuman(){
        return ishuman;
    }

    @Override
    public String toString(){
        return heroName + " " + realName + " " + superPower + " " + creationYear;
    }



}

