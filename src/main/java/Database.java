

public class Database {

    private SuperHero superHeroes;

    public void dataBase() {

        SuperHero helt1 = new SuperHero(superHeroes.getHeroName(), superHeroes.getSuperPower(), superHeroes.getStrenght(), superHeroes.getCreationYear());
        SuperHero helt2 = new SuperHero(superHeroes.getHeroName(), superHeroes.getSuperPower(), superHeroes.getStrenght(), superHeroes.getCreationYear());
        SuperHero helt3 = new SuperHero(superHeroes.getHeroName(), superHeroes.getSuperPower(), superHeroes.getStrenght(), superHeroes.getCreationYear());
        SuperHero helt4 = new SuperHero(superHeroes.getHeroName(), superHeroes.getSuperPower(), superHeroes.getStrenght(), superHeroes.getCreationYear());
        SuperHero helt5 = new SuperHero(superHeroes.getHeroName(), superHeroes.getSuperPower(), superHeroes.getStrenght(), superHeroes.getCreationYear());


        SuperHero[] superHeroArray = new SuperHero[]{helt1,helt2, helt3,helt4,helt5};



    }
}
