import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    Scanner scan = new Scanner(System.in);
    Database database = new Database();


    public void startMenu() {

        database.createTestData();
        boolean writingError = false;
        int menu = 0;
        do {

            System.out.println("Velkommen til SuperHelte Universet\n" + "-".repeat(35) +
                    "\n1. Opret Superhelt " +
                    "\n2. Se liste over Superhelte " +
                    "\n3. Søg efter Superhelt " +
                    "\n4. Rediger superheltenavnet " +
                    "\n9. Afslut");

            try {
                menu = scan.nextInt();
                scan.nextLine();
                writingError = false;
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
                    System.exit(0);
                }
            } catch (InputMismatchException ime) {
                System.out.println("Der skete desværre en fejl!");
                scan.nextLine();
                writingError = true;
            }


        } while (menu != 9 || writingError == true);


    }


    public void addHero() {


        System.out.print("Venligst indtast superheltens navn (fx.Superman):");
        String heroName = scan.nextLine();

        System.out.print("Indtast superheltens rigtige navn (fx. Clark Kent): ");
        String realName = scan.nextLine();

        System.out.println("Indtast superheltens superkraft (fx. flyve): ");
        String superPower = scan.nextLine();


        System.out.print("Er din superhelt menneske eller ej (true/false): ");
        boolean writingError = false;   //Virker ikke ordentligt
        boolean ishuman = true;

        do {
            try {
                ishuman = scan.nextBoolean();
                scan.nextLine();
                writingError = false;
            } catch (InputMismatchException vv) {
                System.out.println("Der skete en fejl, prøv igen!");
                scan.nextLine();
            }

        } while (writingError == true);


        System.out.print("Indtast superheltens oprettelsesår (fx. 1838): ");
        int creationYear = 0;
        boolean writingError1 = false;
        do {
            try {
                creationYear = scan.nextInt();
                scan.nextLine();
                writingError1 = false;
            } catch (InputMismatchException nn) {
                System.out.print("Der skete en fejl, prøv igen");
                scan.nextLine();
                writingError1 = true;
            }
        } while (writingError1 == true);


        System.out.print("Din superhelt er: " + heroName + "\nRigtige navn: " + realName + "\nSuperpower: " + superPower + "\nMenneske: " + ishuman + "\nKarrakterens udgivelses år: " + creationYear);

        database.addSuperHero(heroName, realName, superPower, ishuman, creationYear);
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

        boolean writingError = false;
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
                hero.setRealName(realName);
            }

            System.out.println("Skriv den nye superpower eller tryk enter");
            String superPower = scan.nextLine();

            if (!superPower.isEmpty()) {
                hero.setSuperPower(superPower);
            }


            System.out.println("Skriv oprindelsesåret for din superhelt");
            do {
                String creationYear = scan.nextLine();

                if (!creationYear.isEmpty()) {
                    try {
                        hero.setCreationYear(Integer.parseInt(creationYear));
                        writingError = false;
                    } catch (NumberFormatException in) {
                        System.out.println("Der opstod en fejl. Prøv igen");
                        scan.nextLine();  //Den gemmer ikke svaret!
                        writingError = true;
                    }

                    System.out.println("Din nyredigeret superhelt:\n " + hero);
                    writingError = false;
                }


            } while (writingError == true);


        }


    }
}


