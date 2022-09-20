import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @org.junit.jupiter.api.Test
    public void createSuperhero() {
        //Arrange test
        Database database = new Database();

        //Act on method
        database.addSuperHero("Superman", "Clark Kent", "flyve", true, 1838);

        //Assert result
        int expectedDBSize = 1;
        int actualSize = database.getAllSuperHeroes().size();
        assertEquals(expectedDBSize, actualSize);

    }


    @Test
    public void addSuperhero() {
        //Arrange test
        Database database = new Database();

        //Act on method
        database.addSuperHero("Superman", "Clark Kent", "flyve", true, 1838);
        database.addSuperHero("Batman", "Bruce Wayne", "Money", true, 1939);

        //Assert result
        int expectedDBSize = 2;
        int actualSize = database.getAllSuperHeroes().size();
        assertEquals(expectedDBSize, actualSize);

    }
    @Test
    public void searchZero() {

        //Arrange
        Database database = new Database();
        int expected = 0;
        String search = "iii";

        //Act
        database.addSuperHero("Superman", "Clark Kent", "flyve", true, 1838);
        database.addSuperHero("Batman", "Bruce Wayne", "Money", true, 1939);
        database.addSuperHero("Spider-man", "Peter Parker", "Spindevæv", true, 1938);
        ArrayList<SuperHero> searchResult = database.searchFor(search);

        int actual = searchResult.size();


        //Assert
        assertEquals(expected, actual);
    }
    @Test
    public void searchFor() {

        //Arrange
        Database database = new Database();
        int expected = 1;
        String search = "Spider";

        //Act
        database.addSuperHero("Superman", "Clark Kent", "flyve", true, 1838);
        database.addSuperHero("Batman", "Bruce Wayne", "Money", true, 1939);
        database.addSuperHero("Spider-man", "Peter Parker", "Spindevæv", true, 1938);
        ArrayList<SuperHero> searchResult = database.searchFor(search);

        int actual = searchResult.size();


        //Assert
        assertEquals(expected, actual);
    }


    @Test
    public void searchOne() {

        //Arrange
        Database database = new Database();
        int expected = 3;
        String search = "man";

        //Act
        database.addSuperHero("Superman", "Clark Kent", "flyve", true, 1838);
        database.addSuperHero("Batman", "Bruce Wayne", "Money", true, 1939);
        database.addSuperHero("Spider-man", "Peter Parker", "Spindevæv", true, 1938);
        ArrayList<SuperHero> searchResult = database.searchFor(search);

        int actual = searchResult.size();


        //Assert
        assertEquals(expected, actual);
    }

}


