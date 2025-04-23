class Main {
    public static void main(String[] args) {
      // create a 100 meter race
      Race myRace = new Race(100.0, 1.0);
      // create some racers
      Racer racer1 = new Tortoise("Tom");
      Racer racer2 = new Hare("Hana", 0.75);
      // sign up the racers
      myRace.signupRacer(racer1);
      myRace.signupRacer(racer2);
      // start the race
      myRace.start();
      // announce the winner
      System.out.println("The winner is " + myRace.getWinner());
    }
  }