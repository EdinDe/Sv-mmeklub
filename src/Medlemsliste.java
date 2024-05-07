import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Medlemsliste {


    public static ArrayList<Medlem> medlemListe;


    public Medlemsliste() {
        medlemListe = new ArrayList<>();
    }

    public void saveMedlemsliste() throws IOException {
        File file = new File("medlemsliste.csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        // Write CSV header


        // Write each movie to the CSV file
        for (Medlem medlem : medlemListe) {
            bw.write(String.format("%s, %s,%d,%d, %s, %b, %b",
                    medlem.getNavn(), medlem.getKøn(), medlem.getFødselsDato(),
                    medlem.getTelefonNummer(), medlem.getMedlemsType(),
                    medlem.isJuniorEllerSenior(),medlem.isMotionistEllerKonku()));
            bw.newLine();
        }

        // Close BufferedWriter and FileWriter
        bw.close();
        fw.close();

        System.out.println("Opdateret medlemsinfo er nu gemt! :)");
    }

    public void addMedlem(String navn, String køn, int fødselsdato, int telefonNummer, String medlemstype, boolean juniorEllerSenior, boolean motionistEllerKonku) {
        medlemListe.add(new Medlem(navn, køn, fødselsdato, telefonNummer, medlemstype, juniorEllerSenior, motionistEllerKonku));

    }

    public ArrayList<String> listeAfMedlemmer() {
        ArrayList<String> locallisteAfMedlemmer = new ArrayList<>();
        for (int i = 0; i < medlemListe.size(); i++) {
            locallisteAfMedlemmer.add(medlemListe.get(i).getNavn());
        }
        return locallisteAfMedlemmer;
    }

    public void getList() {
        for (Medlem m : medlemListe) {
            System.out.println(m.toString());
        }
    }

    public String showMedlemsliste() {
        String resultat = "";
        for (Medlem medlem : medlemListe) {
            resultat += medlem.toString() + "\n\n";
        }
        return resultat.toString();
    }

    public ArrayList<Medlem> søgMedlem (String navn) {
        ArrayList<Medlem> søgResultat = new ArrayList<>();
        for (Medlem med : medlemListe) {
            if (med.getNavn().toLowerCase().contains(navn.toLowerCase())) {
                søgResultat.add(med);
                //break;
            }
        }
        return søgResultat;
    }

    public void sorterMedlemmer () {
        Collections.sort(medlemListe, new Comparator<Medlem>() {
            @Override
            public int compare(Medlem o1, Medlem o2) {
                return o1.getNavn().compareToIgnoreCase(o2.getNavn());
            }
        });
    }

    public String showMedlemslisteSorteretEfterNavn() {
        sorterMedlemmer();
        return showMedlemsliste();
    }
    public static void setMedlemListe(ArrayList<Medlem> nyMedlemListe) {
        medlemListe = nyMedlemListe;
    }


    public ArrayList<Medlem> getMedlemListe() {
        return medlemListe;
    }




}
