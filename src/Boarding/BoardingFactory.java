package Boarding;

public class BoardingFactory {
  public BoardingType createBoarding(String boardingType) {
    if (boardingType.equalsIgnoreCase("full board")) {
      return new FullBoard();
    } else if (boardingType.equalsIgnoreCase("half board")) {
      return new HalfBoard();
    } else if (boardingType.equalsIgnoreCase("bed and breakfast")) {
      return new BedAndBreakfast();
    }
    
    throw new IllegalArgumentException();
  }
}
