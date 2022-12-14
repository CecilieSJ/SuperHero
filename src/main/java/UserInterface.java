import SuperHero.SuperHero;

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
                    "\n5. Slet superhelt" +
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

                } else if (menu == 5) {
                    deleteSuperhero();

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


        System.out.print("Er din superhelt menneske eller ej (ja/nej): ");
        String brugerInput = scan.nextLine();
        boolean ishuman;

        while (!brugerInput.equals("ja") && !brugerInput.equals("nej")) {
            System.out.println("Du skal indtaste ja eller nej");
            brugerInput = scan.nextLine();
        }
        if(brugerInput.equals("ja")){
            ishuman = true;
        }else {
            ishuman = false;
        }


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

        String jaEllerNej;
        if(ishuman){
            jaEllerNej = "ja";
        }else {
            jaEllerNej = "nej";
        }


        System.out.print("Din superhelt er: " + heroName + "\nRigtige navn: " + realName + "\nSuperpower: " + superPower + "\nMenneske: " + jaEllerNej + "\nKarrakterens udgivelses år: " + creationYear);

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


            boolean writingError = false;
            do {
                try {
                    System.out.println("Skriv oprindelsesåret for din superhelt");
                    String newcreationYear = scan.nextLine();
                    if (!newcreationYear.isEmpty()) {
                        hero.setCreationYear(Integer.parseInt(newcreationYear));
                    }
                    writingError = false;

                } catch (NumberFormatException e) {
                    System.out.println("Der opstod en fejl. Prøv igen");
                    writingError = true;
                }


            } while (writingError == true);

            System.out.println("Din nyredigeret superhelt:\n " + hero);
        }

    }

    public void deleteSuperhero() {

        System.out.print("Søg på en superhelt");
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

            System.out.print("Ønsker du at slette denne Superhelt? (true/false): " + hero);
            boolean delete1 = scan.nextBoolean();
            if (delete1 == true) {

                database.deleteSuperhero(hero);

                System.out.print("Fjerner Superhelt");

            } else if (delete1 == false) {
                System.out.println("Fjerner ikke" + hero);
            }
        }
    }
}

