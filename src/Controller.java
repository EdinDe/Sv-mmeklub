public class Controller {

    public static Medlemsliste nyMedlemsListe = new Medlemsliste();

    public Controller() {

    }


    public static void addMedlem(String navn, String køn, int fødselsdato, int telefonNummer, String medlemstype, boolean juniorEllerSenior, boolean motionistEllerKonku) {
        nyMedlemsListe.addMedlem(navn, køn, fødselsdato, telefonNummer, medlemstype, juniorEllerSenior, motionistEllerKonku);
    }
}
