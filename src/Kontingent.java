import java.util.List;

public class Kontingent {
    double totalIndbetalteKontingenter;


    public Kontingent() {
        this.totalIndbetalteKontingenter = 0.0;

    }

    public void beregnTotalIndbetalteKontingenter(List <Medlem> medlemliste) {
       if (medlemliste == null || medlemliste.isEmpty()) {
           System.out.println("Ingen medlemmer i listen");
           return;
       }

       for (Medlem medlem : medlemliste) {
            if (medlem.medlemsType.equals("aktiv")) {
                int alder = medlem.getFødselsDato();
                if (alder < 18) {
                    totalIndbetalteKontingenter += 1000;
                } else if (alder>= 18 && alder < 60) {
                    totalIndbetalteKontingenter += 1600;
                } else {
                    totalIndbetalteKontingenter += 1600 * 0.75; // 25% rabat for seniorer
                }
            } else {
                totalIndbetalteKontingenter += 500; // Kontingent for passivt medlemskab
            }
        }
        System.out.println("Det samlede indbetalte kontingent: " + totalIndbetalteKontingenter);
    }

}
