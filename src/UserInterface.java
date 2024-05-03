import java.io.IOException;
import java.util.Scanner;



    public class UserInterface {
        Controller medlem = new Controller();


        Scanner scanner = new Scanner(System.in);

        public void start() {
            int sentinel = 2;
            int tal = 0;



            System.out.println("\nSvømmeklub Database");

            while (tal != sentinel) {
                System.out.println("\n1. tilføj en medlem");
                System.out.println("2. Vis medlemsliste");
                System.out.println("3. Søg efter en medlemmer");
                System.out.println("4. Sorter medlemsliste");
                System.out.println("5. Rediger medlem");
                System.out.println("6. Se forventet kontigent");
                System.out.println("7. Afslut program");


                tal = scanner.nextInt();
                scanner.nextLine();

                if (tal == 1) {
                    addMedlem();

                } else if (tal == 2) {
                    System.out.println("\nMedlemsliste:\n");
                    System.out.println(controller.instanceMovieCollection.showMovieCollectionSortedByTitle());
                } else if (tal == 3) {
                    searchMovie();
                }else if (tal==4){
                    sortByProberty();
                }else if (tal==5) {
                    editMovie();
                }else if(tal==6){
                    break;
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


            controller.addMedlem(navn, køn, fødselsDato, telefonNummer, medlemsType, juniorEllerSenior, motionistEllerKonku);

            System.out.println("\nMedlem blev tilføjet");




        }


}
