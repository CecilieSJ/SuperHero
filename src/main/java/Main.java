import javax.xml.crypto.Data;
import java.util.Scanner;


public class Main {
    //public SuperHero[] superHeroes;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Database database = new Database();

        int menu;
        do {
            System.out.println("Velkommen til SuperHelte Universet\n" + "-".repeat(35) + "\n1. Opret Superhelt \n9. Afslut");
            menu = scan.nextInt();
            if (menu == 1) {
                System.out.print("Venligst indtast navnet på din superhelt!");
                String heroName = scan.next();

                System.out.print("Skriv hvilken superpower din superhelt har: ");
                String superPower = scan.next();

                System.out.print("Skriv hvilken styrke de besider: ");
                String strenght = scan.next();

                System.out.print("Er din superhelt menneske eller ej (true/false): ");
                boolean ishuman = scan.nextBoolean();

                System.out.print("Skriv hvilke år karrakteren blev lavet: ");
                int creationYear = scan.nextInt();

                System.out.print("Din superhelt er: " + heroName + "\nSuperpower: " + superPower + "\nStyrke :" + strenght + "\nMenneske: " + ishuman + "\nKarrakterens udgivelses år: " + creationYear);
                database.createSuperhero(heroName, superPower, strenght, ishuman, creationYear);


            } else if (menu == 9) {
                System.out.println("Afsluttet");
            }

        } while (menu != 9);

    }
}
