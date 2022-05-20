package coml.kycox.montyhall.game;

import coml.kycox.montyhall.gameContents.DoorsGroup;

public class MontyHall {

    private int drawsNbr;
    private int doorsNbr;
    private boolean userChanges = false;

    private int winningUserChoiceNumber;
    private int loosingUserChoiceNumber;

    public MontyHall(int drawsNbr, int doorsNbr) {
        this.drawsNbr = drawsNbr;
        this.doorsNbr = doorsNbr;
    }

    public void displayResults() {
        System.out.println("Résultat des " + drawsNbr + " jeux " + (userChanges ? "avec":"sans") + " changement");
        System.out.println("Jeux gagnants : " + winningUserChoiceNumber + " - soit " + Draw.getStatistics(winningUserChoiceNumber, drawsNbr));
        System.out.println("Jeux perdants : " + loosingUserChoiceNumber + " - soit " + Draw.getStatistics(loosingUserChoiceNumber, drawsNbr));
    }

    public void launchGames() {
        winningUserChoiceNumber = 0;
        loosingUserChoiceNumber = 0;

        for (int i = 0; i < drawsNbr; i++) {
            DoorsGroup doorsGroup = initializeDoors(doorsNbr);
            int userChoiceIndex = getUserChoiceIndex(doorsGroup);
            updateStatistics(userChoiceIndex, doorsGroup);
        }
    }

    private DoorsGroup initializeDoors(int doorsNbr) {
        DoorsGroup doorsGroup = new DoorsGroup();
        doorsGroup.initializeDoors(doorsNbr);
        return doorsGroup;
    }

    private int getUserChoiceIndex(DoorsGroup doorsGroup) {
        if (userChanges) {
            return changeUserChoice(Draw.getDraw(doorsGroup.size()), doorsGroup);
        } else {
            return Draw.getDraw(doorsGroup.size());
        }
    }

    private int changeUserChoice(int userChoiceIndex, DoorsGroup doorsGroup) {
        int presenterChoiceIndex = doorsGroup.getPresenterChoiceIndex(userChoiceIndex);
        return doorsGroup.getNewUserChoiceIndex(userChoiceIndex, presenterChoiceIndex);
    }

    private void updateStatistics(int userChoiceIndex, DoorsGroup doorsGroup) {
        if (doorsGroup.isWinningDoor(userChoiceIndex)) {
            winningUserChoiceNumber++;
        } else {
            loosingUserChoiceNumber++;
        }
    }

    public void setUserChanges(boolean userChanges) {
        this.userChanges = userChanges;
    }
}
