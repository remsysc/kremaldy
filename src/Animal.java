import java.util.ArrayList;

public class Animal {

  final long id;
  final String species;
  String status;// enum
  double base_conservation_value;
  double health_rating;
  ArrayList<Event> history = new ArrayList<>();
  double currentConservationValue;

  void updateHealth(double newHealth) {
  }// adjusts health rating and recalculates base_conservation_value

  void addEvent(Event event) {
  } // records event

  double recalculateConservationValue() {
  }// applies adjustment for health, events , breeding etc

  void finalizeConservationvalue() {
  }// computes and locks final value for departed animals

  boolean isActive() {
  } // checks it still in sactuary

}
