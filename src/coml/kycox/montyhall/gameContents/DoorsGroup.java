package coml.kycox.montyhall.gameContents;

import coml.kycox.montyhall.game.Draw;

import java.util.ArrayList;
import java.util.List;

public class DoorsGroup {

    private List<Door> doors;

    public DoorsGroup() {
        doors = new ArrayList<>();
    }

    public void initializeDoors(int doorsNbr) {
        int doorWinnerIndex = Draw.getDraw(doorsNbr);
        for (int i=0; i < doorsNbr; i++) {
            doors.add(
                    new Door(doors.size() == doorWinnerIndex ? DoorContents.WIN : DoorContents.LOSE)
            );
        }
    }

    public boolean isWinningDoor(int userChoiceIndex) {
        Door openedDoor = doors.get(userChoiceIndex);
        return openedDoor.isWinning();
    }

    public int getPresenterChoiceIndex(int userChoiceIndex) {
        int presenterChoiceIndex = -1;
        for (int i = 0; i < doors.size(); i++) {
            if (i != userChoiceIndex && !doors.get(i).isWinning()) {
                presenterChoiceIndex = i;
                break;
            }
        }
        return presenterChoiceIndex;
    }

    public int getNewUserChoiceIndex(int oldUserChoiceIndex, int presenterChoiceIndex) {
        int newUserChoiceIndex = -1;
        for (int i = 0; i < doors.size(); i++) {
            if (i != oldUserChoiceIndex && i != presenterChoiceIndex){
                newUserChoiceIndex = i;
                break;
            }
        }
        return newUserChoiceIndex;
    }

    public int size() {
        return doors.size();
    }
}
