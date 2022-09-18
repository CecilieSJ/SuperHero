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


        } while (menu != 9 && menu != 2);

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
            System.out.println("Superheltens navn: " + superHero.getHeroName());
            System.out.println("Superheltens rigtige navn: " + superHero.getRealName());
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
        SuperHero superhero = database.searchFor(searchTerm);
        System.out.println(superhero);
    }

    public void editHero() {

        System.out.println("Indtast navnet på den superhelt du vil ændre superheltenavnet på");
        String searchTerm = scan.nextLine();
        SuperHero superhero = database.searchFor(searchTerm);
        System.out.println(superhero);
        System.out.println("Hvad ønsker du din Superhelt skal hedde?4");
        String heroName = scan.nextLine();
        superhero.setHeroName(heroName);
    }
}

