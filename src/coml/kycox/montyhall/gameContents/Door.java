package coml.kycox.montyhall.gameContents;

public class Door {
    private DoorContents doorContents;

    public Door(DoorContents doorContents) {
        this.doorContents = doorContents;
    }

    public boolean isWinning() {
        return doorContents == DoorContents.WIN;
    }
}
