import java.util.ArrayList;

public class Controller {

    public static Medlemsliste nyMedlemsListe = new Medlemsliste();

    public Controller() {

    }


    public static void addMedlem(String navn, String køn, int fødselsdato, int telefonNummer, String medlemstype, boolean juniorEllerSenior, boolean motionistEllerKonku) {
        nyMedlemsListe.addMedlem(navn, køn, fødselsdato, telefonNummer, medlemstype, juniorEllerSenior, motionistEllerKonku);
    }

    public ArrayList<String> listeAfMedlemmer() {
        return nyMedlemsListe.listeAfMedlemmer();

    }

    public static Medlemsliste getNyMedlemsListe() {
        return nyMedlemsListe;
    }

    public void getList() {
        nyMedlemsListe.getList();
    }

    public static String showMedlemsliste() {
        return nyMedlemsListe.showMedlemsliste();
    }

    public static ArrayList<Medlem> søgMedlem(String search) {
        return nyMedlemsListe.søgMedlem(search);
    }

    public void redigerMedlemmer (String navn, String newNavn, String newKøn, String newFødselsdato, String newTelefonnummer, String newMedlemstype, boolean newJuniorEllerSenior, boolean newMotionistEllerKonku) {
        ArrayList<Medlem> medlemmerAtRedigere = nyMedlemsListe.søgMedlem(navn);
        if (!medlemmerAtRedigere.isEmpty()) {
            Medlem medlemAtRedigere = medlemmerAtRedigere.get(0);

            medlemAtRedigere.setNavn(newNavn);;
            medlemAtRedigere.setKøn(newKøn);
            medlemAtRedigere.setFødselsDato(newFødselsdato);
            medlemAtRedigere.setTelefonNummer(newTelefonnummer);
            medlemAtRedigere.setMedlemsType(newMedlemstype);
            medlemAtRedigere.setJuniorEllerSenior(newJuniorEllerSenior);
            medlemAtRedigere.setMotionistEllerKonku(newMotionistEllerKonku);
        } else {
            System.out.println("Der blev ikke fundet et medlem med navnet " + navn);
        }
    }
}





