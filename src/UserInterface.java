import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class UserInterface {
        Controller ml = new Controller();
        Medlemsliste saver = new Medlemsliste();


        Scanner scanner = new Scanner(System.in);

        public void start() {
            int sentinel = 5;
            int tal = 0;
            String filename = "medlemsliste.csv";
            ArrayList<Medlem> loadedData = Filehandler.loadDataFromCSV(filename);
            Medlemsliste.setMedlemListe(loadedData);



            System.out.println("\nSvømmeklub Database");

            while (tal != sentinel) {
                System.out.println("\n1. tilføj en medlem");
                System.out.println("2. Vis medlemsliste");
                System.out.println("3. Søg efter en medlemmer");
                System.out.println("4. Rediger medlem");
                System.out.println("5. Sorter medlemsliste");
                System.out.println("6. Se forventet kontigent");
                System.out.println("7. Se om hvor der er i restance eller ej");

                System.out.println("8. Afslut program");


                tal = scanner.nextInt();
                scanner.nextLine();

                if (tal == 1) {
                    addMedlem();

                } else if (tal == 2) {
                    System.out.println("\nMedlemsliste:\n");
                    //ml.showMedlemsliste();
                    System.out.println(Controller.showMedlemsliste());
                } else if (tal == 3) {

                }else if (tal==4){
                    redigerMedlemmer();

                }else if (tal==5) {
                    try {
                        saver.saveMedlemsliste();
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (tal==7) {
                    System.out.println(Controller.findMedlemmerIRestance());

                }else if(tal==8){
                    System.out.println("Programmet blev afsluttet");
                }else if (tal==6){
                    saver.beregnTotalIndbetalteKontingenter();
                }else if(tal==9){


                }

            }
        }
        private void addMedlem() {
            System.out.println("Angiv navn på ny medlem:");
            String navn = scanner.nextLine();

            System.out.println("Angiv medlems køn");
            String køn = scanner.nextLine();

            System.out.println("Angiv medlems fødselsår");
            int fødselsDato = scanner.nextInt();


            System.out.println("Angiv medlems telefonnummer");
            int telefonNummer = scanner.nextInt();

            System.out.println("Angiv medlems medlemstype");
            scanner.nextLine();
            String medlemsType = scanner.nextLine();

            System.out.println("Er medlem en junior eller senior?");
            boolean juniorEllerSenior = false;
            String seniorEllerJunior = scanner.next().toLowerCase();
            if (seniorEllerJunior.equals("junior")) {
                juniorEllerSenior = true;
            }

            System.out.println("Er medlem motionist eller konkurrencesvømmer");
            boolean motionistEllerKonku = false;
            String konkuEllerMotionist = scanner.next().toLowerCase();
            if(konkuEllerMotionist.equals("motionist")) {
                motionistEllerKonku = true;

            }


            Controller.addMedlem(navn, køn, fødselsDato, telefonNummer, medlemsType, juniorEllerSenior, motionistEllerKonku);

            System.out.println("\nMedlem blev tilføjet");





        }
    public void redigerMedlemmer () {
        System.out.println("Hvem vil du redigere i");
        String name = scanner.nextLine();

        System.out.println("Nyt navn på medlemmet");
        String newNavn = scanner.nextLine();

        System.out.println("Nyt køn");
        String newKøn = scanner.nextLine();

        System.out.println("Ny fødselsdato");
        String newFødselsdato = scanner.nextLine();

        System.out.println("Nyt telefonnummer");
        String newTelefonnummer = scanner.nextLine();

        System.out.println("Ny medlemstype");
        String newMedlemstype = scanner.nextLine();

        System.out.println(" Junior eller Senior");
        boolean newJuniorEllerSenior = false;
        String juniorNot = scanner.next().toLowerCase();
        if (juniorNot.equals("junior") || juniorNot.equals("senior")) {
            newJuniorEllerSenior = true;
        }
        scanner.nextLine();

        System.out.println("Motionist eller Konkurrencesvømmer");
        boolean newMotionistEllerKonku = false;
        String motionistNot = scanner.next().toLowerCase();
        if (motionistNot.equals("motionist") || motionistNot.equals("Konkurrencesvømmer")) {
            newMotionistEllerKonku = true;
        }
        scanner.nextLine();



        ml.redigerMedlemmer(name, newNavn, newKøn, newFødselsdato, newTelefonnummer, newMedlemstype, newJuniorEllerSenior, newMotionistEllerKonku);

        System.out.println("Medlemmet blev redigeret");

    }





}
