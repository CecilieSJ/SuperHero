package SuperHero;

public class SuperHero {

    private String heroName;
    private String realName;
    private String superPower;
    private int creationYear;
    private boolean ishuman = true;

    public SuperHero() {
    }

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

    public void setRealName(String realName){
        this.realName = realName;
    }


    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower){
        this.superPower = superPower;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear){
        this.creationYear = creationYear;
    }

    public boolean getishuman(){
        return ishuman;
    }

    public void setIshuman(boolean human){
        this.ishuman = ishuman;
    }

    @Override
    public String toString(){
        return "│Superheltens navn: " + heroName + "\n│Rigtige navn: " + realName + "\n│Superpower: " + superPower + "\n│Oprindelsesår: " + creationYear +"│\n";
    }



}

