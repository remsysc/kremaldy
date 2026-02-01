import java.time.LocalDate;
import java.util.ArrayList;

public class SanctuaryManager {
  ArrayList<Animal> animals = new ArrayList<>();

  void registerAnimal(Animal animal) {
    if (animal == null) {
      throw new IllegalArgumentException("Animal cannot be null");
    }
    animals.add(animal);
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

  public double getValueChange(LocalDate fromDate) {

    double beforeTotal = 0.0;

    for (Animal animal : animals) {
      if (!animal.isActive())
        continue;
      beforeTotal += animal.getHistoricalValue(fromDate);

    }
    double currentTotal = getTotalConservationValue(); // Active animals
    return currentTotal - beforeTotal;

  } // compares total value before / after
  // evaluations in period
  //

  //
  ArrayList<Animal> getActiveAnimals() {
    ArrayList<Animal> res = new ArrayList<>();
    for (Animal animal : res) {
      if (!animal.isActive())
        continue;

      res.add(animal);

    }

    return res;

  }// filter current animals;
   //

  public void processEvaluation() {
    for (Animal a : getActiveAnimals()) {
      // Just recalc current values (catch drift)
      a.setCurrentConservationValue(a.calculateConservationValue());
      a.addEvent(new Event("evaluation", 0.0,
          LocalDate.now(), "Routine check"));
    }
  }

  // triggers updates/recalculations for all active
  // animals

}
