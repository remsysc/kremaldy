import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {

    Animal animal = new Animal(1, "cat", AnimalStatus.ACTIVE, 100, 8.0);

    animal.updateHealth(6);
    System.out.println(animal.calculateConservationValue());
    animal.updateHealth(4);
    System.out.println(animal.calculateConservationValue());

    SanctuaryManager sanctuaryManager = new SanctuaryManager();
    sanctuaryManager.registerAnimal(animal);
    System.out.println(sanctuaryManager.getTotalConservationValue());
    System.out.println(sanctuaryManager.getHighestValueAnimal());
  }
}
