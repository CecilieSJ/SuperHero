import SuperHero.SuperHero;

import java.io.IOException;
import java.util.ArrayList;
import Comparator.*;


public class Database {

    private ArrayList<SuperHero> superHeroDatabase = new ArrayList<>();
    private boolean change = false;

    public void addSuperHero(String heroName, String realName, String superPower, boolean ishuman, int creationYear) {

        SuperHero hero = new SuperHero(heroName, realName, superPower, ishuman, creationYear);
        superHeroDatabase.add(hero);

    }

    public void createTestData() {
        addSuperHero("Batman", "Bruce Wayne", "Money", true, 1939);
        addSuperHero("Superman", "Clark Kent", "flyver", true, 1938);
        addSuperHero("Spider-man", "Peter Parker", "Spindevæv", true, 1938);

    }

    public ArrayList<SuperHero> searchFor(String searchTerm) {
        ArrayList<SuperHero> searchResult = new ArrayList<>();

        for (SuperHero superHero : superHeroDatabase) {
            if (superHero.getHeroName().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResult.add(superHero);
            }
        }
        return searchResult;

    }


    public ArrayList<SuperHero> getAllSuperHeroes() {
        return superHeroDatabase;
    }

    public boolean deleteSuperhero(SuperHero superHero) {
        boolean succes;
        succes = superHeroDatabase.remove(superHero);

        return succes;
    }


    public void addAll(ArrayList<SuperHero> superheroes) {
        superHeroDatabase.addAll(superheroes);
    }

    public boolean isChange() {
        return change;
    }
    public void setChange(boolean change) {
        this.change = change;

    }

    public void clearData() {
        superHeroDatabase.clear();
    }


    public void sortNameMethod() throws IOException {
        superHeroDatabase.sort(new HeroNameComparator());
    }
    public void sortSuperPower() {
        superHeroDatabase.sort(new SuperPowerComparator());
    }
    public void sortSuperHeroRealName() {
        superHeroDatabase.sort(new RealNameComparator());
    }
    public void sortCreationYear() {
        superHeroDatabase.sort(new CreationYearComparator());
    }
    public void sortIsHuman() {
        superHeroDatabase.sort(new IsHumanComparator());
    }

}




