import javax.xml.crypto.Data;
import java.util.Scanner;


public class Main {
    //public SuperHero[] superHeroes;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //Database database = new Database();
        //database.dataBase();


        System.out.println("Venligst indtast navnet på din superhelt!");
        String heroName = scan.next();

        System.out.println("Skriv hvilken superpower din superhelt har");
        String superPower = scan.next();

        System.out.println("Skriv hvilken styrke de besider");
        String strenght = scan.next();

        System.out.println("Skriv hvilke år karrakteren blev lavet");
        int creationYear = scan.nextInt();

        System.out.println("Din superhelt er: " + heroName + "\nSuperpower: " + superPower + "\nStyrke :" + strenght + "\n33Karrakterens udgivelses år: " + creationYear);






    }

}
