import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;



public class UserInterface {
    Controller ml = new Controller();
    Medlemsliste saver = new Medlemsliste();


    Scanner scanner = new Scanner(System.in);

    public UserInterface(String role) {
    }

    public void start(String role) {
        int sentinel = 5;
        int tal = 0;
        String filename = "medlemsliste.csv";
        ArrayList<Medlem> loadedData = Filehandler.loadDataFromCSV(filename);
        Medlemsliste.setMedlemListe(loadedData);
        switch (role) {
            case "Ejer":
                handleOwnerAccess();
                break;
            case "Træner":
                handleCoachAccess();
                break;
            case "Restance":
                handleAccountantAccess();
                break;
            default:
                System.out.println("Ugyldig rolle. Adgang nægtet.");
                break;
        }
    }


    private void handleOwnerAccess() {
        // Ejeren har adgang til alle funktioner
        int tal = 0;
        while (tal != 9) {
            System.out.println("\n1. Tilføj et medlem");
            System.out.println("2. Vis medlemsliste");
            System.out.println("3. Søg efter et medlem");
            System.out.println("4. Sorter medlemslisten");
            System.out.println("5. Opdater medlemsliste medlem");
            System.out.println("6. Fjern et medlem");
            System.out.println("7. Se forventet kontigent");
            System.out.println("8. Se medlemmer i restance");
            System.out.println("9. Afslut program");
            System.out.println("10. Tilføj medlem som er i restance");
            System.out.println("11. Liste over konkurrencesvømmere");


            tal = scanner.nextInt();
            scanner.nextLine();

            if (tal == 1) {
                addMedlem();

            } else if (tal == 2) {
                System.out.println("\nMedlemsliste:\n");
                //ml.showMedlemsliste();
                System.out.println(Controller.showMedlemsliste());
            } else if (tal == 3) {
                søgMedlem();

            } else if (tal == 4) {
                sorterMedlemmer();
            } else if (tal == 5) {
                redigerMedlemmer();
            } else if (tal == 6) {
                fjernMedlem();
            } else if (tal == 8) {
                System.out.println(Controller.findMedlemmerIRestance());
            } else if (tal == 7) {
                saver.beregnTotalIndbetalteKontingenter();
            } else if (tal == 9) {
                System.out.println("Programmet blev afsluttet");
                try {
                    saver.saveMedlemsliste();
                    break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }else if(tal == 10) {
                tilføjMedlemIRestance();

            }else if(tal == 11) {
                System.out.println("\nTop 5:\n");
                System.out.println(Controller.showTopFemListe());

            }
        }
    }
    private void handleCoachAccess() {
        // Træneren har adgang til at vise medlemslisten, søge efter et medlem og afslutte programmet
        int tal = 0;
        while (tal != 9) {
            System.out.println("\n2. Vis medlemsliste");
            System.out.println("3. Søg efter et medlem");
            System.out.println("8. Afslut program");

            tal = scanner.nextInt();
            scanner.nextLine();

            switch (tal) {
                case 2:
                    System.out.println("\nMedlemsliste:\n");
                    System.out.println(Controller.showMedlemsliste());
                    break;
                case 3:
                    søgMedlem();
                    break;
                case 9:
                    System.out.println("Programmet blev afsluttet");
                    try {
                        saver.saveMedlemsliste();
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
                    break;
            }
        }
    }
        private void handleAccountantAccess () {
                // Personen, der håndterer restance, har adgang til at se forventet kontingent og afslutte programmet
                int tal = 0;
                while (tal != 9) {
                    System.out.println("\n1. Se forventet kontigent");
                    System.out.println("2. Afslut program");

                    tal = scanner.nextInt();
                    scanner.nextLine();

                    switch (tal) {
                        case 7:
                            // Se forventet kontingent
                            break;
                        case 9:
                            System.out.println("Programmet blev afsluttet");
                            try {
                                saver.saveMedlemsliste();
                                break;
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        default:
                            System.out.println("Ugyldigt valg. Prøv igen.");
                            break;
                    }
                }
            }

            private void tilføjMedlemIRestance(){
                System.out.println("Her kan du ændre status på om en medlem er i restance. Indtast medlems navn");
                boolean restanceStatus = false;
                String name = scanner.next().toLowerCase();
                System.out.println("Er medlemmen i restance? ja eller nej");
                String restancejaellernej = scanner.next().toLowerCase();
                if (restancejaellernej.equals("ja")) {
                    restanceStatus = true;
                    saver.setRestanceStatusViaName(name,restanceStatus);
                    System.out.println("Medlem tilføjet til listen af medlemmer i restance.");
                }else if(restancejaellernej.equals("nej")){
                    restanceStatus = false;
                    saver.setRestanceStatusViaName(name,restanceStatus);
                    System.out.println("Medlem fjernet fra listen af medlemmer i restance.");
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
                if (konkuEllerMotionist.equals("motionist")) {
                    motionistEllerKonku = true;

                }
                boolean restance = false;


                Controller.addMedlem(navn, køn, fødselsDato, telefonNummer, medlemsType, juniorEllerSenior, motionistEllerKonku,restance);

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
                if (motionistNot.equals("motionist") || motionistNot.equals("konkurrencesvømmer")) {
                    newMotionistEllerKonku = true;
                }
                scanner.nextLine();


                ml.redigerMedlemmer(name, newNavn, newKøn, newFødselsdato, newTelefonnummer, newMedlemstype, newJuniorEllerSenior, newMotionistEllerKonku);

                System.out.println("Medlemmet blev redigeret");

            }

            private void søgMedlem () {
                System.out.println("\nSøg efter medlem");
                String navn = scanner.next();

                boolean fundet = false;
                ArrayList<Medlem> fundetMedlemmer = Controller.søgMedlem(navn);

                for (Medlem med : fundetMedlemmer) {
                    System.out.println(med);
                    fundet = true;
                }

                if (!fundet) {
                    System.out.println("ingen medlemmer med det navn fundet!");
                }

            }

            private void fjernMedlem () {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Indtast navn på medlem");
                String navn = scanner.nextLine();
                Medlemsliste.fjernMedlem(navn);
            }

            private void sorterMedlemmer () {
                System.out.println("Vælg, hvad der skal sorteres efter:");
                System.out.println("1. Navn");
                System.out.println("2. Køn");
                System.out.println("3. Fødselsår");
                System.out.println("4. Telefonnummer");
                System.out.println("5. Medlemstype");
                System.out.println("6. Junior eller Senior");
                System.out.println("7. Motionist eller konkurrencesvømmer");
                System.out.println("8. Medlemmer i restance");

                int sorterValg = scanner.nextInt();
                ArrayList<Medlem> sorterMedlem = new ArrayList<>(Controller.getNyMedlemsListe().getMedlemListe());

                switch (sorterValg) {
                    case 1:
                        sorterMedlem.sort(Comparator.comparing(Medlem::getNavn));
                        break;
                    case 2:
                        sorterMedlem.sort(Comparator.comparing(Medlem::getKøn));
                        break;
                    case 3:
                        sorterMedlem.sort(Comparator.comparing(Medlem::getFødselsDato));
                        break;
                    case 4:
                        sorterMedlem.sort(Comparator.comparing(Medlem::getTelefonNummer));
                        break;
                    case 5:
                        sorterMedlem.sort(Comparator.comparing(Medlem::getMedlemsType));
                        break;
                    case 6:
                        sorterMedlem.sort(Comparator.comparing(Medlem::isJuniorEllerSenior));
                        break;
                    case 7:
                        sorterMedlem.sort(Comparator.comparing(Medlem::isMotionistEllerKonku));
                        break;
                    case 8:
                        sorterMedlem.sort(Comparator.comparing(Medlem::getRestance));
                        break;
                }

                System.out.println("\nSorterede medlemmer:");
                System.out.println();
                for (Medlem medlem : sorterMedlem) {
                    System.out.println(medlem);
                    System.out.println();
                }

            }
    }
