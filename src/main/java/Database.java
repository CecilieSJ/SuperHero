

public class Database {

    private SuperHero superHeroes;

    public void createSuperhero(String heroName, String superPower, String strenght, boolean ishuman, int creationYear) {

        SuperHero hero = new SuperHero(heroName,superPower,strenght,ishuman, creationYear );
        System.out.println(hero);
    }
}
