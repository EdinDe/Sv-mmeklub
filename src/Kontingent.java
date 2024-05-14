import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Kontingent  {
    List<Medlem> medlemliste;
    double totalIndbetalteKontingenter;


    public Kontingent() {
        this.medlemliste = new ArrayList<>();
        this.totalIndbetalteKontingenter = 0.0;

    }


    public void beregnTotalIndbetalteKontingenter() {
        if (medlemliste == null || medlemliste.isEmpty()) {
            System.out.println("Ingen medlemmer i listen");
            return;
        }




        for (Medlem medlem : medlemliste) {
            int birthYear = medlem.fødselsDato / 10000;
            int currentYear = LocalDate.now().getYear();
            int age = currentYear - birthYear;

            if (medlem.medlemsType.equals("aktiv")) {

                if (!medlem.juniorEllerSenior) {
                    totalIndbetalteKontingenter += 1600;
                } else if (medlem.juniorEllerSenior) {
                    totalIndbetalteKontingenter += 1000;
                } else if (!medlem.juniorEllerSenior && age >=60){

                    totalIndbetalteKontingenter += 1600 * 0.75; // 25% rabat for seniorer

                }
            } else {
                totalIndbetalteKontingenter += 500; // Kontingent for passivt medlemskab
            }
        }
        System.out.println("Det samlede indbetalte kontingent: " + totalIndbetalteKontingenter);
    }




        public ArrayList<Medlem> findMedlemmerIRestance() {
            ArrayList<Medlem> medlemmerIRestance = new ArrayList<>();
            for (Medlem medlem : medlemliste) {
                if (!medlem.medlemsType.equals("aktiv")) {
                    // Passive medlemmer betragtes altid i restance
                    medlemmerIRestance.add(medlem);
                } else {
                    int alder = java.time.Year.now().getValue() - medlem.getFødselsDato();
                    if (alder < 18) {
                        medlemmerIRestance.add(medlem);
                    } else if (alder >= 60) {
                        medlemmerIRestance.add(medlem);
                    }
                }
            }
            return medlemmerIRestance;
        }
    }
