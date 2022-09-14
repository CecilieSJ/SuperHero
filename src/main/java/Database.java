import java.util.ArrayList;

public class Database {

    private ArrayList<SuperHero> superHeroes = new ArrayList<>();
  //  private SuperHero[] listen = new SuperHero[5];
   // private int index = 0;

    public void createSuperhero(String heroName, String realName, String superPower, boolean ishuman, int creationYear) {

        SuperHero hero = new SuperHero(heroName,realName,superPower,ishuman, creationYear );

        superHeroes.add(hero);

        //SuperHero[index] = hero;
        // index++;


    }

    public ArrayList<SuperHero> getSuperHeroes() {
        return superHeroes;
    }
}
