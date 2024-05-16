import java.util.ArrayList;

public class Medlem {

    String navn;
    String køn;
    int fødselsDato;
    int telefonNummer;
    String medlemsType;
    boolean juniorEllerSenior;
    boolean motionistEllerKonku;
    double restance;



    public Medlem(String navn, String køn, int fødselsDato, int telefonNummer, String medlemsType, boolean juniorEllerSenior, boolean mosionistEllerKonku) {
        this.navn = navn;
        this.køn = køn;
        this.fødselsDato = fødselsDato;
        this.telefonNummer = telefonNummer;
        this.medlemsType = medlemsType;
        this.juniorEllerSenior = juniorEllerSenior;
        this.motionistEllerKonku = mosionistEllerKonku;


    }

    public double getRestance() {
        return restance;
    }

    public void setRestance(double restance) {
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
        return "Navn: " + navn + ", Køn: gv" + køn + ", Fødselsdato: " + fødselsDato + ", Telefonnummer: " + telefonNummer + ", Medlemstype: " + medlemsType + ", Junior/Senior: " + (juniorEllerSenior ? "Junior" : "Senior") + ", Motionist/Konkurrence: " + (motionistEllerKonku ? "Motionist" : "Konkurrence");
    }
    public static ArrayList<Medlem> findMedlemmerIRestance(ArrayList<Medlem> medlemsliste) {
        ArrayList<Medlem> medlemmerIRestance = new ArrayList<>();
        for (Medlem medlem : medlemsliste) {
            if (medlem.getRestance() > 0) {
                medlemmerIRestance.add(medlem);
            }
        }
        return medlemmerIRestance;
    }



}

