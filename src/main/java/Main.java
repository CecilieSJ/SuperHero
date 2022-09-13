import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Database database = new Database();
        ArrayList<String> superHeroes = new ArrayList<>();

        int menu;

        do {
            System.out.println("Velkommen til SuperHelte Universet\n" + "-".repeat(35) + "\n1. Opret Superhelt \n2. Se liste over Superhelte \n9. Afslut");
            menu = scan.nextInt();
            scan.nextLine();
            if (menu == 1) {
                System.out.print("Venligst indtast superheltens navn (fx.Superman):");
                String heroName = scan.nextLine();

                System.out.print("Indtast superheltens rigtige navn (fx. Clark Kent): ");
                String realName = scan.nextLine();

                System.out.println("Indtast superheltens superkraft (fx. flyve): ");
                String superPower = scan.nextLine();

                System.out.print("Er din superhelt menneske eller ej (true/false): ");
                boolean ishuman = scan.nextBoolean();

                System.out.print("Indtast superheltens oprettelsesår (fx. 1838): ");
                int creationYear = scan.nextInt();

                System.out.print("Din superhelt er: " + heroName + "\nRigtige navn: " + realName + "\nSuperpower: " + superPower + "\nMenneske: " + ishuman + "\nKarrakterens udgivelses år: " + creationYear);
                database.createSuperhero(heroName, realName, superPower, ishuman, creationYear);

                SuperHero hero1 = new SuperHero(heroName, realName, superPower, ishuman, creationYear);
                superHeroes.add(hero1 + "hero1");
                System.out.println("\nDu har nu tilføjet: " + hero1 + " til databasen");

            } else if (menu == 2) {
                System.out.println(superHeroes.get(0));
                System.out.println(superHeroes.get(1));
                System.out.println(superHeroes.get(2));

           /* } else (menu == 9) {
                System.out.println("Afsluttet");
            }*/


            }

        }while (menu != 9 && menu != 2) ;
    }
}
