package Boarding;

public class BoardingFactory {
    public BoardingType createBoarding(String boardingType) {
        if (boardingType.equalsIgnoreCase("Full Board")) {
            return new FullBoard();
        } else if (boardingType.equalsIgnoreCase("Half Board")) {
            return new HalfBoard();
        } else if (boardingType.equalsIgnoreCase("Bed & Breakfast")) {
            return new BedAndBreakfast();
        }

        throw new IllegalArgumentException();
    }
}
