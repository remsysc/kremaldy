import java.time.LocalDate;

public class Event {
  private final String type; // eg breeding success, injury etc
  private final double valueAdjustment; // 1.5 for breeding, -0.8 for injury
  private final LocalDate date;
  private final String details;

  public Event(String type, double valueAdjustment, LocalDate date, String details) {
    this.type = type;
    this.valueAdjustment = valueAdjustment;
    this.date = date;
    this.details = details;
  }

  public LocalDate getDate() {
    return date;
  }

  double getAdjustment() {
    return valueAdjustment;
  }

  @Override
  public String toString() {
    return "Event [type=" + type + ", valueAdjustment=" + valueAdjustment + ", date=" + date + ", details=" + details
        + "]";
  }

}
