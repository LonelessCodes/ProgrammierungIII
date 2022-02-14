/**
 * JavaGotchi
 */
public class Aufgabe04 {
   private static enum State {
      HAPPY, HUNGRY, EATING, STARVED
   };

   State currentState = State.HAPPY;
   int hungerLevel = 0;
   boolean gameRunning = true;

   void behaviourHungry() {
      System.out.println(":/ ... hunger");
      // in 25% der Fuelle finden wir etwas essbares
      if (Math.random() < 0.25) {
         currentState = State.EATING;
      }
   }

   void behaviourStarved() {
      System.out.println("x(");
   }

   void behaviourEating() {
      System.out.println(":# ... essen");
      hungerLevel = 0;
      currentState = State.HAPPY;
   }

   void behaviourHappy() {
      System.out.println(":)");
   }

   void update() {
      // Parameter werden angepasst, dabei muessen wir aufpassen,
      // den Uebergang von Hunger nach Essen nicht zu verlieren
      if (currentState == State.EATING)
         return;

      hungerLevel += (int) (Math.random() * 5);
      if (hungerLevel > 15) {
         currentState = State.HUNGRY; // :/
      }
      if (hungerLevel > 30) {
         currentState = State.STARVED; // x(
      }
   }

   private void sleep(long ms) {
      try {
         Thread.sleep(ms);
      } catch (InterruptedException e) {
      }
   }

   public void startGame() {
      while (gameRunning) {
         switch (currentState) {
            case HAPPY:
               behaviourHappy();
               break;
            case HUNGRY:
               behaviourHungry();
               break;
            case EATING:
               behaviourEating();
               break;
            case STARVED:
               behaviourStarved();
               gameRunning = false;
               return; // quit the game
         }

         update();
         sleep(400);
      }
   }

   public static void main(String[] args) {
      Aufgabe04 gotchi = new Aufgabe04();
      gotchi.startGame();
   }
}
