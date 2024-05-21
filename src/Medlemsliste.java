import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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
            bw.write(String.format("%s,%s,%d,%d,%s,%b,%b,%b,%s,%s,%d,%d",
                    medlem.getNavn(), medlem.getKøn(), medlem.getFødselsDato(),
                    medlem.getTelefonNummer(), medlem.getMedlemsType(),
                    medlem.isJuniorEllerSenior(), medlem.isMotionistEllerKonku(),medlem.getRestance(),
                    medlem.getSvømmeDisciplin(), medlem.getStævne(),medlem.getTid(), medlem.getPlacering()));
            bw.newLine();
        }

        // Close BufferedWriter and FileWriter
        bw.close();
        fw.close();

        System.out.println("Opdateret medlemsinfo er nu gemt! :)");
    }

    public void addMedlem(String navn, String køn, int fødselsdato, int telefonNummer, String medlemstype, boolean juniorEllerSenior, boolean motionistEllerKonku, boolean restance, String svømmeDisciplin, String stævne, int tid, int placering) {
        medlemListe.add(new Medlem(navn, køn, fødselsdato, telefonNummer, medlemstype, juniorEllerSenior, motionistEllerKonku,restance,svømmeDisciplin,stævne,tid,placering));

    }

    public ArrayList<String> listeAfMedlemmer() {
        ArrayList<String> locallisteAfMedlemmer = new ArrayList<>();
        for (int i = 0; i < medlemListe.size(); i++) {
            locallisteAfMedlemmer.add(medlemListe.get(i).getNavn());
        }
        return locallisteAfMedlemmer;
    }

    public ArrayList<String> top5Svømmere(String svømmeDisciplin) {


        List<Medlem> sortedMedlemmer = medlemListe.stream()
                .filter(medlem -> medlem.getSvømmeDisciplin().equalsIgnoreCase(svømmeDisciplin))
                .sorted(Comparator.comparingInt(Medlem::getTid))
                .collect(Collectors.toList());


        ArrayList<String> top5Svømmerelokal = new ArrayList<>();


        for (int i = 0; i < Math.min(sortedMedlemmer.size(), 5); i++) {
            Medlem medlem = sortedMedlemmer.get(i);
            top5Svømmerelokal.add(medlem.getNavn() + ". Tid i sekunder: " + medlem.getTid() + " Stævne: " + medlem.getStævne() + "\n");
        }

        return top5Svømmerelokal;
    }
        /*ArrayList<String> top5Svømmerelokal = new ArrayList<>();
        int i = 0;
        for (Medlem medlem : medlemListe) {


            if (medlem.getSvømmeDisciplin().equalsIgnoreCase(svømmeDisciplin) && i <= 5) {
                top5Svømmerelokal.add(medlemListe.get(i).getNavn() + " " + medlemListe.get(i).getTid());

                i++;

            }
        }
        return top5Svømmerelokal;

    }*/
    public Medlem findMedlemByName(String name) {
        for (Medlem medlem : medlemListe) {
            if (medlem.getNavn().equalsIgnoreCase(name)) {
                return medlem;
            }
        }
        return null;
    }
    public void setRestanceStatusViaName(String name, boolean restanceStatus) {
        Medlem medlem = findMedlemByName(name);
        if (medlem != null) {
            medlem.setRestance(restanceStatus);
            System.out.println("Restance status af " + name + " opdateret til " + restanceStatus);
        } else {
            System.out.println("Medlem med navnet " + name + " blev ikke fundet.");
        }
    }


    public void getList() {
        for (Medlem m : medlemListe) {
            System.out.println(m.toString());
        }
    }

   /* public String showMedlemsliste() {
        String resultat = "";
        for (Medlem medlem : medlemListe) {
            resultat += medlem.toString() + "\n\n";
        }
        return resultat;
    }*/
   public String showMedlemsliste() {
       StringBuilder resultat = new StringBuilder();
       for (Medlem medlem : medlemListe) {
           resultat.append(medlem).append("\n\n");
       }
       return resultat.toString();
   }


    public ArrayList<Medlem> søgMedlem(String navn) {
        ArrayList<Medlem> søgResultat = new ArrayList<>();
        for (Medlem med : medlemListe) {
            if (med.getNavn().toLowerCase().contains(navn.toLowerCase())) {
                søgResultat.add(med);
                //break;
                }
            }
            return søgResultat;
        }



    public void sorterMedlemmer() {
        Collections.sort(medlemListe, new Comparator<Medlem>() {
            @Override
            public int compare(Medlem o1, Medlem o2) {
                return o1.getNavn().compareToIgnoreCase(o2.getNavn());
            }
        });
    }

    public String showMedlemslisteSorteretEfterNavn() {
        sorterMedlemmer();
        StringBuilder result = new StringBuilder();
        result.append("Medlemsliste sorteret efter navn:\n");


        for (Medlem medlem : medlemListe) {
            result.append(medlem.toString()).append("\n");
        }
        return result.toString();
    }

    public static void setMedlemListe(ArrayList<Medlem> nyMedlemListe) {
        medlemListe = nyMedlemListe;
    }

    public ArrayList<Medlem> getMedlemListe() {
        return medlemListe;
    }

    double totalIndbetalteKontingenter;


    public void Kontingent() {
        this.totalIndbetalteKontingenter = 0.0;

    }


    public void beregnTotalIndbetalteKontingenter() {
        if (medlemListe == null || medlemListe.isEmpty()) {
            System.out.println("Ingen medlemmer i listen");
            return;
        }




        for (Medlem medlem : medlemListe) {
            // Extracting year, month, and day components from the integer
            int fødselsDato = medlem.getFødselsDato();
            int year = fødselsDato % 10000; // Extracting year (last four digits)
            fødselsDato /= 10000; // Removing year from fødselsDato

            // Extracting month and day while ensuring two digits with leading zeros if needed
            int month = Integer.parseInt(String.format("%02d", fødselsDato % 100)); // Extracting month
            int day = Integer.parseInt(String.format("%02d", fødselsDato / 100)); // Extracting day

            // Calculate the age
            LocalDate fødselsDatoLocalDate = LocalDate.of(year, month, day);
            int age = Period.between(fødselsDatoLocalDate, LocalDate.now()).getYears();



            if (medlem.medlemsType.equals("aktiv")) {
                if (!medlem.juniorEllerSenior&& age <=60) {
                    totalIndbetalteKontingenter += 1600;
                } else if (age >= 60) {
                    totalIndbetalteKontingenter += 1600 * 0.75; // 25% rabat for seniorer
                } else {
                    totalIndbetalteKontingenter += 1000; // Junior member fee
                }
            } else {
                totalIndbetalteKontingenter += 500; // Kontingent for passivt medlemskab
            }
        }
        System.out.println("Det samlede indbetalte kontingent: " + totalIndbetalteKontingenter);
    }


    public void visMedlemmerIRestance() {
        for (Medlem medlem : medlemListe) {
        }

        System.out.println("Liste over medlemmer i restance:");

    }
    public static ArrayList<Medlem> findMedlemmerIRestance(ArrayList<Medlem> medlemsliste) {
        ArrayList<Medlem> medlemmerIRestance = new ArrayList<>();
        for (Medlem medlem : medlemsliste) {
            if (medlem.getRestance() == true) {
                medlemmerIRestance.add(medlem);
            }
        }
        return medlemmerIRestance;
    }
    public static void fjernMedlem(String navn){
       for(Medlem medlem : medlemListe){
           if (medlem.getNavn().equals(navn)){
               medlemListe.remove(medlem);
               System.out.println("Medlem fjernet: " + navn);
               return;
           }
       }
        System.out.println("Medlem med navnet " + navn + " blev ikke fundet" );
    }





}