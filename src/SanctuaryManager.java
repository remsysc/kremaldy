import java.time.LocalDate;
import java.util.ArrayList;

public class SanctuaryManager {
  ArrayList<Animal> animals = new ArrayList<>();

  void registerAnimal(Animal animal) {
  }

  //
  double getTotalConservationValue() {

    double total = 0;
    for (Animal animal : animals) {
      if (animal.isActive())
        total += animal.getCurrentConservationValue();
    }

    return total;

  } // sum of currentConservationValue for active animals only

  Animal getHighestValueAnimal() {

    Animal curr = null;
    double highest = 0;

    for (Animal animal : animals) {
      if (animal.getCurrentConservationValue() > highest) {
        curr = animal;
        highest = animal.getCurrentConservationValue();
      }

    }

    return curr;

  } // returns an active anmal with max
  // currentConservationValue
  //

  // double getValueChange(LocalDate fromDate) {
  //
  // } // compares total value before / after
  // evaluations in period
  //
  // ArrayList<Animal> getActiveAnimals() //filter current animals;
  //
  // void processEvaluation() // triggers updates/recalculations for all active
  // animals

}
