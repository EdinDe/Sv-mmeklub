import java.util.Scanner;

public class KonkurrenceSvømmer {

        Scanner input = new Scanner(System.in);

        String svømmeDisciplin;
        String stævne;
        int tid;
        int placering;
    String svømmeDisciplin1;
    String stævne1;
    int tid1;
    int placering1;
    String svømmeDisciplin2;
    String stævne2;
    int tid2;
    int placering2;
    String svømmeDisciplin3;
    String stævne3;
    int tid3;
    int placering3;

    public void KonkurrenceSvømmer(String svømmeDisciplin, String stævne, int tid, int placering){
        this.svømmeDisciplin = svømmeDisciplin;
        this.stævne = stævne;
        this.tid = tid;
        this.placering = placering;
    }
    public void start() {
        System.out.print("Indtast svømmedisciplin: ");
        svømmeDisciplin = input.next();
        System.out.print("Indtast stævne: ");
        stævne = input.next();
        System.out.print("Indtast tid: ");
        tid = input.nextInt();
        System.out.print("Indtast placering: ");
        placering = input.nextInt();


        }
    }