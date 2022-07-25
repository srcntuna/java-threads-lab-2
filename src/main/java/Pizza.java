public class Pizza {
  //Fix this method
  public static void cookPizza() throws InterruptedException {

      Base base = new Base();
      Sauce sauce = new Sauce();
      Tomatoes tomatoes = new Tomatoes();
      Cheese cheese = new Cheese();
      Bake bake = new Bake();

      java.util.List<Thread> cookingSteps = new java.util.ArrayList<>();
      cookingSteps.add(base);
      cookingSteps.add(sauce);
      cookingSteps.add(tomatoes);
      cookingSteps.add(cheese);
      cookingSteps.add(bake);

      for (Thread step : cookingSteps) {
          step.start();
          step.join();
      }
  }

  // DO NOT change any of the methods below
  static class Base extends Thread {
      @Override
      public void run() {
          System.out.println("cook base");
      }
  }

  static class Sauce extends Thread {
      @Override
      public void run() {
          System.out.println("cover base with sauce");
      }
  }

  static class Tomatoes extends Thread {
      @Override
      public void run() {
          for (int i = 3; i >= 1; i--) {
              System.out.println("slice tomatoes " + i);
          }
          System.out.println("put tomatoes on pizza");
      }
  }

  static class Cheese extends Thread {
      @Override
      public void run() {
          System.out.println("grate cheese on pizza");
      }
  }

  static class Bake extends Thread {
      @Override
      public void run() {
          for (int i = 4; i >= 0; i--) {
              if (i == 0) {
                  System.out.println("Your pizza is ready!");
                  break;
              }
              System.out.println("to bake..." + i + " min");

          }
      }
  }
}