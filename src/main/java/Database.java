import java.util.ArrayList;

public class Database {

    private ArrayList<SuperHero> superHeroes = new ArrayList<>();

    public void createSuperhero(String heroName, String realName, String superPower, boolean ishuman, int creationYear) {

        SuperHero hero = new SuperHero(heroName, realName, superPower, ishuman, creationYear);
        superHeroes.add(hero);

    }

    public void createTestData() {
        createSuperhero("Batman", "Bruce Wayne", "Money", true, 1939);
        createSuperhero("Superman", "Clark Kent", "flyver", true, 1938);
        createSuperhero("Spider-man", "Peter Parker", "Spindevæv", true, 1938);

    }

    public ArrayList<SuperHero> searchFor(String searchTerm) {
        ArrayList<SuperHero> searchResult = new ArrayList<>();

        for (SuperHero superHero : superHeroes) {
            if (superHero.getHeroName().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResult.add(superHero);
            }
        }

        return searchResult;

    }


    public ArrayList<SuperHero> getAllSuperHeroes() {
        return superHeroes;
    }


}


