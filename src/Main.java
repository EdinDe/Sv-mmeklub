import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<String, String> userRoles = new HashMap<>(); // Map for at opbevare brugerroller

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Opret et brugernavn og en adgangskode for ejeren
        String ownerUsername = "Ejer";
        String ownerPassword = "Ejer";

        // Opret et brugernavn og en adgangskode for træneren
        String coachUsername = "Træner";
        String coachPassword = "Træner";

        // Opret et brugernavn og en adgangskode for den, der ordner restance
        String accountantUsername = "Restance";
        String accountantPassword = "Restance";

        // Gem brugernavne og adgangskoder i map med deres roller
        userRoles.put(ownerUsername, "Ejer");
        userRoles.put(coachUsername, "Træner");
        userRoles.put(accountantUsername, "Restance");

        // Bed brugeren om at logge ind
        System.out.println("Velkommen! Log ind for at få adgang:");
        System.out.print("Brugernavn: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Adgangskode: ");
        String inputPassword = scanner.nextLine();

        // Kontroller om brugernavn og adgangskode er korrekte
        if (validateUser(inputUsername, inputPassword)) {
            // Hvis korrekt, få brugerens rolle og opret brugerfladen baseret på rollen
            String role = userRoles.get(inputUsername);
            System.out.println("Velkommen, " + role + "!");
            UserInterface ui = new UserInterface(role);
            ui.start(role);
        } else {
            // Hvis ikke, vis en fejlmeddelelse og afslut programmet
            System.out.println("Forkert brugernavn eller adgangskode. Adgang nægtet.");

        }

    }


    // Metode til at validere brugerens legitimationsoplysninger
    private static boolean validateUser(String username, String password) {
        String storedPassword = userRoles.get(username); // Hent gemt adgangskode fra map
        return storedPassword != null && storedPassword.equals(password); // Sammenlign med indtastet adgangskode
    }


}
