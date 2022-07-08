# Threads Lab 2

## Instruction

You’re given a `Pizza` class that has methods for each step of cooking the
pizza. Each of the methods except for the `cookPizza` method extends the
`Thread` class and overrides the `run` method.

The `cookPizza` method is not giving the expected output. Your task is to fix it
so that the output looks like the following:

```plaintext
cook base
cover base with sauce
slice tomatoes 3
slice tomatoes 2
slice tomatoes 1
put tomatoes on pizza
grate cheese on pizza
to bake...4 min
to bake...3 min
to bake...2 min
to bake...1 min
Your pizza is ready!
```

## Starter Code

### Main.java

```java
class Main {
    public static void main(String[] args) throws InterruptedException {
        Pizza.cookPizza();
    }
}
```

### Pizza.java

```java
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
```
