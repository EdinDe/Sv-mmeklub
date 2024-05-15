import java.util.Scanner;

public class KonkurrenceSvømmer {

        Scanner input = new Scanner(System.in);

        String svømmeDisciplin;
        String stævne;
        int tid;
        int placering;

    public void KonkurrenceSvømmer(){

    }
    public void start() {
            System.out.println("Er svømmeren en motionist eller konkurrencesvømmer? (true/false)");
            motionistEllerKonku = input.nextBoolean();

            if (motionistEllerKonku) {
                System.out.println("Er svømmeren en konkurrencesvømmer? (true/false)");
                boolean erKonkurrenceSvømmer = input.nextBoolean();

                if (erKonkurrenceSvømmer) {
                    System.out.print("Indtast svømmedisciplin: ");
                    svømmeDisciplin = input.next();

                    System.out.print("Indtast stævne: ");
                    stævne = input.next();

                    System.out.print("Indtast tid: ");
                    tid = input.nextInt();

                    System.out.print("Indtast placering: ");
                    placering = input.nextInt();
                } else {
                    System.out.println("Svømmeren er en motionist, ikke en konkurrencesvømmer.");
                }
            } else {
                System.out.println("Svømmeren er en motionist.");
            }
        }
    }