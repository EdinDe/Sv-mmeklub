import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Medlem {

    String navn;
    String køn;
    int fødselsDato;
    int telefonNummer;
    String medlemsType;
    boolean juniorEllerSenior;
    boolean motionistEllerKonku;
    boolean restance;




    public Medlem(String navn, String køn, int fødselsDato, int telefonNummer, String medlemsType, boolean juniorEllerSenior, boolean mosionistEllerKonku,boolean restance) {
        this.navn = navn;
        this.køn = køn;
        this.fødselsDato = fødselsDato;
        this.telefonNummer = telefonNummer;
        this.medlemsType = medlemsType;
        this.juniorEllerSenior = juniorEllerSenior;
        this.motionistEllerKonku = mosionistEllerKonku;
        this.restance = restance;


    }

    public boolean getRestance() {
        return restance;
    }

    public void setRestance(boolean restance) {
        this.restance = restance;
    }



    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getKøn() {
        return køn;
    }


    public void setKøn(String køn) {
        this.køn = køn;
    }

    public int getFødselsDato() {
        return fødselsDato;
    }

    public void setFødselsDato(String fødselsDato) {
        this.fødselsDato = Integer.parseInt(fødselsDato);
    }

    public int getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(String telefonNummer) {
        this.telefonNummer = Integer.parseInt(telefonNummer);
    }

    public String getMedlemsType() {
        return medlemsType;
    }



    public void setMedlemsType(String medlemsType) {
        this.medlemsType = medlemsType;
    }


    public boolean isJuniorEllerSenior() {
        return juniorEllerSenior;
    }

    public void setJuniorEllerSenior(boolean juniorEllerSenior) {
        this.juniorEllerSenior = juniorEllerSenior;
    }

    public boolean isMotionistEllerKonku() {
        return motionistEllerKonku;
    }

    public void setMotionistEllerKonku(boolean motionistEllerKonku) {
        this.motionistEllerKonku = motionistEllerKonku;
    }
    @Override
    public String toString() {
        return "Navn: " + navn + ", Køn: " + køn + ", Fødselsdato: " + fødselsDato + ", Telefonnummer: " + telefonNummer + ", Medlemstype: " + medlemsType + ", Junior/Senior: " + (juniorEllerSenior ? "Junior" : "Senior") + ", Motionist/Konkurrence: " + (motionistEllerKonku ? "Motionist" : "Konkurrence");
    }
    public String toStringRestance() {
        return "Navn: " + navn + ", Køn: " + køn + ", Junior/Senior: " + (juniorEllerSenior ? "Junior" : "Senior") + ", Motionist/Konkurrence: " + (motionistEllerKonku ? "Motionist" : "Konkurrence");
    }

    private static int calculateTotalIndbetalteKontingenter(Medlem medlem) {
        int totalIndbetalteKontingenter = 0;
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



        if (medlem.restance) {
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

        return totalIndbetalteKontingenter;
    }


    public static ArrayList<String> findMedlemmerIRestance(ArrayList<Medlem> medlemsliste) {
        ArrayList<String> medlemmerIRestance = new ArrayList<>();
        for (Medlem medlem : medlemsliste) {
            if (medlem.getRestance()) {
                // Calculate totalIndbetalteKontingenter based on your existing logic
                int totalIndbetalteKontingenter = calculateTotalIndbetalteKontingenter(medlem);

                // Convert totalIndbetalteKontingenter to string
                String totalAsString = Integer.toString(totalIndbetalteKontingenter);

                // Create a string with member's information and the total contribution amount
                String memberInfoWithTotal = medlem.toStringRestance() + " I restance: -" + totalAsString + "kr.";

                // Add memberInfoWithTotal to the result ArrayList
                medlemmerIRestance.add(memberInfoWithTotal);
            }
        }
        return medlemmerIRestance;
    }



}

