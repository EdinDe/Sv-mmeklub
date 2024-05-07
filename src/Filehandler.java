import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Filehandler {
    public static ArrayList<Medlem> loadDataFromCSV(String medlemliste) {
        ArrayList<Medlem> medlemListe = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("medlemsliste.csv"))) {
            String line;
            Medlem medlem = null;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Split CSV line by comma
                medlem = new Medlem(
                        (values[0]), // filmnavn
                        (values[1]), // film direktør
                        (Integer.parseInt(values[2])), // film dato
                        (Integer.parseInt(values[3])), // film længde
                        (values[4]),
                        Boolean.parseBoolean(values[5])
                ,Boolean.parseBoolean(values[6]));

                medlemListe.add(medlem);



            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace(); // Handle exceptions
        }

        return medlemListe;
    }
}

