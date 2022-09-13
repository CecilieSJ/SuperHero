import java.util.ArrayList;

public class Database {

    private SuperHero[] listen = new SuperHero[5];
    private int index = 0;

    public void createSuperhero(String heroName, String realName, String superPower, boolean ishuman, int creationYear) {

        SuperHero hero = new SuperHero(heroName,realName,superPower,ishuman, creationYear );

        listen[index] = hero;
        index++;

        ArrayList<String> superHeroes = new ArrayList<>();

    }
}
