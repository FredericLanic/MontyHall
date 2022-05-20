package coml.kycox.montyhall;

import coml.kycox.montyhall.game.MontyHall;

public class MainGame {

    private static final int DOORS_NBR = 3;
    private static final int DRAWS_NBR = 100_000_000;
    private static final boolean USER_CHANGES = true;

    public static void main(String... args) {
        System.out.println("Bienvenue dans le programme MontyHall pour essayer de définir les probabilités du jeu des trois portes");
        System.out.println("Voir lien Wikipedia : https://fr.wikipedia.org/wiki/Probl%C3%A8me_de_Monty_Hall");
        System.out.println("Version 0.1 commencé dans le TGV le 19 mai 2022");

        MontyHall montyHall = new MontyHall(DRAWS_NBR, DOORS_NBR);
        montyHall.setUserChanges(USER_CHANGES);
        montyHall.launchGames();
        montyHall.displayResults();

        montyHall.setUserChanges(!USER_CHANGES);
        montyHall.launchGames();
        montyHall.displayResults();
    }
}
