package FileHandler;

import SuperHero.SuperHero;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;


public class FileHandler {


    public void saveData(ArrayList<SuperHero> superheroes) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("data\\superheroes.csv"));

        for (SuperHero hero : superheroes) {
            output.print(hero.getHeroName());
            output.print(";");
            output.print(hero.getRealName());
            output.print(";");
            output.print(hero.getSuperPower());
            output.print(";");
            output.print(hero.getCreationYear());
            output.print(";");
            output.print(hero.getishuman());
            output.print(";");


        }
        output.close();
    }


    private SuperHero csvLine(String line) {
        try {
            String[] parts = line.split(";");

            SuperHero superheroLoadData = new SuperHero();
            superheroLoadData.setHeroName(parts[0]);
            superheroLoadData.setRealName(parts[1]);
            superheroLoadData.setIshuman(Boolean.parseBoolean(parts[2]));
            superheroLoadData.setSuperPower(parts[3]);
            superheroLoadData.setCreationYear(Integer.parseInt(parts[4]));
            return superheroLoadData;

        } catch (NumberFormatException e) {
            System.out.println("Kan desværre ikke loade");
            return null;
        }
    }
    public void loadData(ArrayList<SuperHero> allSuperheroes) throws FileNotFoundException {

        Scanner reader = new Scanner(new File("data/superheroes.csv"));
        while (reader.hasNextLine()) {
            String line = reader.nextLine();

            SuperHero data = csvLine(line);
            allSuperheroes.add(data);
        }
    }

}