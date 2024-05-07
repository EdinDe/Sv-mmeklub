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

    public static ArrayList<Medlem> søgMedlem(String søg) {
        return nyMedlemsListe.søgMedlem(søg);
    }

}

