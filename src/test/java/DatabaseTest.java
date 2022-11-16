import SuperHero.SuperHero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    private Database database;

    @BeforeEach
    void prepareTests() {
        database = new Database();
        database.createTestData();
    }

    @Test
    public void createSuperhero() {

        //Arrange test
        Database database = new Database();

        //Act on method
        database.addSuperHero("Superman", "Clark Kent", "flyve", true, 1838);
        ArrayList<SuperHero> results = database.getAllSuperHeroes();
        int expectedDBSize = 1;
        int actualSize = results.size();

        //Assert result
        assertEquals(expectedDBSize, actualSize);
        assertNotEquals(database.getAllSuperHeroes().get(0), null);

    }

    @Test
    public void createTestData() {

        //Act on method
        ArrayList<SuperHero> results = database.getAllSuperHeroes();
        int expectedDBSize = 3;
        int actualSize = results.size();

        //Assert result
        assertEquals(expectedDBSize, actualSize);

    }

    @Test
    public void addSuperhero() {
        Database database1 = new Database();
        //Act on method
        database1.addSuperHero("Superman", "Clark Kent", "flyve", true, 1838);
        database1.addSuperHero("Batman", "Bruce Wayne", "Money", true, 1939);
        int expectedDBSize = 2;
        int actualSize = database1.getAllSuperHeroes().size();

        //Assert result
        assertEquals(expectedDBSize, actualSize);

    }

    @Test
    public void searchZero() {

        //Act
        ArrayList<SuperHero> searchResult = database.searchFor("ii");

        int expected = 0;
        int actual = searchResult.size();


        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void searchOne() {

        //Act
        ArrayList<SuperHero> searchResult = database.searchFor("Spider");

        int expected = 1;
        int actual = searchResult.size();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void searchMore() {
        //Act
        ArrayList<SuperHero> searchResult = database.searchFor("man");

        int expected = 3;
        int actual = searchResult.size();


        //Assert
        assertEquals(expected, actual);
        assertNotEquals(database.getAllSuperHeroes().get(0), null);
    }

    @Test
    public void deleteSuperHero() {

        ArrayList<SuperHero> results = database.getAllSuperHeroes();

        SuperHero superHero = results.get(0);
        int expectedSize = results.size() - 1;
        boolean actualResult = database.deleteSuperhero(superHero);

        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);


        ArrayList<SuperHero> resultsAfterDelete = database.getAllSuperHeroes();
        int actualSize = resultsAfterDelete.size();

        assertEquals(expectedSize, actualSize);


    }

}


