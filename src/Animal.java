import java.time.LocalDate;
import java.util.ArrayList;

public class Animal {

  private final long id;
  private final String species;
  private AnimalStatus status;// enum
  private final double base_conservation_value;
  private double health_rating;
  private ArrayList<Event> history = new ArrayList<>();
  private double currentConservationValue;

  public double getCurrentConservationValue() {
    return currentConservationValue;
  }

  public Animal(long id, String species, AnimalStatus status, double base_conservation_value, double health_rating) {
    this.id = id;
    this.species = species;
    this.status = status;
    this.base_conservation_value = base_conservation_value;
    this.health_rating = health_rating;
  }

  void updateHealth(double newHealth) {
    // integrity checks
    if (newHealth <= 0.0 && newHealth > 10.0)
      throw new IllegalArgumentException("Health must be 0.0 - 10.0");

    double oldValue = this.currentConservationValue;
    this.health_rating = newHealth;

    // update the currentConservationValue
    this.currentConservationValue = calculateConservationValue();
    double adjustment = this.currentConservationValue - oldValue;

    addEvent(
        new Event("health_update", adjustment,
            LocalDate.now(), "Health rating changed to " + newHealth));

  }// adjusts health rating and recalculates base_conservation_value

  void addEvent(Event event) {
    if (event == null)
      throw new IllegalArgumentException("Event cannot be null");
    history.add(event);
  } // records event

  double calculateConservationValue() {

    return base_conservation_value * getHealthMutiplier(health_rating);
    // add/minus the current event

  }// applies adjustment for health, events , breeding etc

  double getHealthMutiplier(double health) {
    if (health >= 8.0)
      return 1.2; // 20% bonus
    if (health >= 6.0)
      return 1.0; // normal
    if (health >= 4.0)
      return 0.8; // fair
    return 0.5;
  }

  public double getHistoricalValue(LocalDate fromDate) {
    double value = base_conservation_value * getHealthMutiplier(health_rating);
    // Add only events BEFORE fromDate
    //
    for (Event event : history) {
      LocalDate eventDate = event.getDate();
      if (eventDate.isBefore(fromDate)) {
        value += event.getAdjustment();
      }
    }

    return value;
  }

  void finalizeConservationvalue() {

    this.currentConservationValue = calculateConservationValue();

    addEvent(
        new Event("Finalized", 0.0, LocalDate.now(), "Final value locked: " + currentConservationValue));

  }// computes and locks final value for departed animals

  boolean isActive() {

    return status.equals(AnimalStatus.ACTIVE);
  } // checks it still in sactuary

  @Override
  public String toString() {
    return "Animal [id=" + id + ", species=" + species + ", status=" + status + ", health_rating=" + health_rating
        + "]";
  }

  public void setCurrentConservationValue(double currentConservationValue) {
    this.currentConservationValue = currentConservationValue;
  }

}
