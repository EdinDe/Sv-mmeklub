public class Kontingent {
    double totalIndbetalteKontingenter;


    public Kontingent() {
        this.totalIndbetalteKontingenter = 0.0;

    }

    public void beregnTotalIndbetalteKontingenter() {
        for (Medlem medlem : medlemListe) {
            if (medlem.medlemsType.equals("aktiv")) {
                if (medlem.fødselsDato < 18) {
                    totalIndbetalteKontingenter += 1000;
                } else if (medlem.fødselsDato >= 18 && medlem.fødselsDato < 60) {
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
