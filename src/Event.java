
public class Event {
  final String type; // eg breeding success, injury etc
  final double valueAdjustment; // 1.5 for breeding, -0.8 for injury
  final String date;
  final String details;

  public Event(String type, double valueAdjustment, String date, String details) {
    this.type = type;
    this.valueAdjustment = valueAdjustment;
    this.date = date;
    this.details = details;
  }

  // double getAdjustment() {
  //
  // }

}
