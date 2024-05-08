public class Medlem {

    String navn;
    String køn;
    int fødselsDato;
    int telefonNummer;
    String medlemsType;
    boolean juniorEllerSenior;
    boolean motionistEllerKonku;

    public Medlem(String navn, String køn, int fødselsDato, int telefonNummer, String medlemsType, boolean juniorEllerSenior, boolean mosionistEllerKonku) {
        this.navn = navn;
        this.køn = køn;
        this.fødselsDato = fødselsDato;
        this.telefonNummer = telefonNummer;
        this.medlemsType = medlemsType;
        this.juniorEllerSenior = juniorEllerSenior;
        this.motionistEllerKonku = mosionistEllerKonku;
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
}
