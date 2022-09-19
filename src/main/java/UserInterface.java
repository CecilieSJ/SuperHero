import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    Scanner scan = new Scanner(System.in);
    Database database = new Database();


    public void startMenu() {

        database.createTestData();

        int menu;

        do {
            System.out.println("Velkommen til SuperHelte Universet\n" + "-".repeat(35) + "\n1. Opret Superhelt \n2. Se liste over Superhelte \n3. Søg efter Superhelt \n4. Rediger superheltenavnet \n9. Afslut");
            menu = scan.nextInt();
            scan.nextLine();
            if (menu == 1) {
                addHero();

            } else if (menu == 2) {
                listOfHeroes();

            } else if (menu == 3) {
                heroSearch();

            } else if (menu == 4) {
                editHero();

            } else if (menu == 9) {
                System.out.println("Afsluttet");
            }


        } while (menu != 9);

    }

    public void addHero() {

        System.out.print("Venligst indtast superheltens navn (fx.Superman):");
        String heroName = scan.nextLine();

        System.out.print("Indtast superheltens rigtige navn (fx. Clark Kent): ");
        String realName = scan.nextLine();

        System.out.println("Indtast superheltens superkraft (fx. flyve): ");
        String superPower = scan.nextLine();

        System.out.print("Er din superhelt menneske eller ej (true/false): ");
        boolean ishuman = scan.nextBoolean();

               /* String input = scan.nextLine();
                switch (input) {   //
                    case "ja" -> {
                        boolean ishuman = true;
                    }
                    case "nej" -> {
                       boolean ishuman = false;
                    }
                    default -> System.out.println("Invald input");
                }*/

        System.out.print("Indtast superheltens oprettelsesår (fx. 1838): ");
        int creationYear = scan.nextInt();

        System.out.print("Din superhelt er: " + heroName + "\nRigtige navn: " + realName + "\nSuperpower: " + superPower + "\nMenneske: " + ishuman + "\nKarrakterens udgivelses år: " + creationYear);

        database.createSuperhero(heroName, realName, superPower, ishuman, creationYear);
        System.out.println("\nDu har nu tilføjet en ny superhelt!!");


    }

    public void listOfHeroes() {
        for (SuperHero superHero : database.getAllSuperHeroes()) {
            System.out.println("-".repeat(45) + "\nSuperheltens navn: " + superHero.getHeroName());
            System.out.println("Rigtige navn: " + superHero.getRealName());
            System.out.println("Superpower: " + superHero.getSuperPower());
            if (superHero.getishuman()) {
                System.out.println("Menneske: ja");

            } else {
                System.out.println("Menneske: nej");
            }
            System.out.println("Udgivelses år: " + superHero.getCreationYear());
        }
    }

    public void heroSearch() {

        System.out.println("Indtast navnet på den superhelt du ønsker at finde");
        String searchTerm = scan.next();
        ArrayList<SuperHero> searchResult = database.searchFor(searchTerm);

        if (searchResult.isEmpty()) {
            System.out.println("Ingen superhelte fundet");

        } else {
            System.out.println("Superhelte fundet: ");
            for (SuperHero superHero : searchResult) {
                System.out.println(superHero);
            }

        }
    }

    public void editHero() {

        System.out.println("Indtast navnet på den superhelt du ønsker at finde");
        String searchTerm = scan.next();
        ArrayList<SuperHero> searchResult = database.searchFor(searchTerm);

        if (searchResult.isEmpty()) {
            System.out.println("Ingen superhelte fundet");

        } else {
            System.out.println("Superhelte fundet: ");
            for (int i = 0; i < searchResult.size(); i++) {
                System.out.println(((i) + 1) + ") " + searchResult.get(i));
            }
            System.out.println("Vælg en superhelt");
            int number = scan.nextInt();
            scan.nextLine();
            SuperHero hero = searchResult.get(number - 1);

            System.out.println("Skriv det nye superheltenavn eller tryk enter for at beholde det nyværende");
            String heroName = scan.nextLine();

            if (!heroName.isEmpty()) {
                hero.setHeroName(heroName);
            }

            System.out.println("Skriv et nyt navn eller tryk enter");
            String realName = scan.nextLine();

            if (!realName.isEmpty()) {
                hero.setRealName();
            }

            System.out.println("Skriv den nye superpower eller tryk enter");
            String superPower = scan.nextLine();

            if (!superPower.isEmpty()) {
                hero.setSuperPower();
            }

            //System.out.println("Er dine helt menneske? (true/false)");
            //boolean ishuman = scan.nextBoolean();
            //if()

            System.out.println("Skriv oprindelsesåret for din superhelt");
            String creationYear = scan.nextLine();

            if (!creationYear.isEmpty()) {
                hero.setCreationYear();
            }

            System.out.println("Din nyredigeret superhelt: " + hero);


        }
    }


}




