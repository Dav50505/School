import java.util.ArrayList;

public class Race {
  private ArrayList<Racer> racers;
  private double distanceInMeters = 100.0;
  private double timeIntervalinSeconds = 1.0;
  
  private Racer winner = null;

  public Race(double initDistanceInMeters, double initTimeIntervalinSeconds) {
    this.racers = new ArrayList<Racer>();
    this.distanceInMeters = initDistanceInMeters;
    this.timeIntervalinSeconds = initTimeIntervalinSeconds;
  }
  
  public void signupRacer(Racer racer) {
    if (! racers.contains(racer))
      racers.add(racer);
  }
  
  public void start() {
      while (this.winner == null)
        update();
  }
  
  private void update() {
      for (Racer racer : racers) {
        racer.run(this.timeIntervalinSeconds);

        if (racer.getDistanceCoveredInMeters() >= this.distanceInMeters) {
          this.winner = racer;
          break;
        }
      }
  }
  
  public Racer getWinner() {
      return this.winner;
  }
}