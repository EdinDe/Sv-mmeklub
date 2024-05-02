import java.io.IOException;
import java.util.Scanner;



    public class UserInterface {
        Controller medlem = new Controller();


        Scanner scanner = new Scanner(System.in);

        public void start() {
            int sentinel = 2;
            int tal = 0;



            System.out.println("\nVelkommen til min filmsamling");

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
                    System.out.println("\nListe af film:\n");
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
            String name = scanner.nextLine();

            System.out.println("Angiv filminstruktørens navn");
            String director = scanner.nextLine();

            System.out.println("Angiv det år filmen blev udgivet");
            int year = scanner.nextInt();

            System.out.println("Er filmen farvet eller ej");
            boolean isInColour = false;
            String colorOrNot = scanner.next().toLowerCase();
            if (colorOrNot.equals("ja")) {
                isInColour = true;
            }

            System.out.println("Angiv filmens spilletid");
            int lengthInMinutes = scanner.nextInt();

            System.out.println("Angiv filmens genre");
            String genre = scanner.next();

            controller.addMovie(name, director, year, lengthInMinutes, genre, isInColour);

            System.out.println("\nFilmen blev tilføjet");




        }


}
