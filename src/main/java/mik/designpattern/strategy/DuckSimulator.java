package mik.designpattern.strategy;

public class DuckSimulator {
    public static void main(String[] args) {
        System.out.println("test");

        Duck duck = new MallardDuck();
        duck.performFly();
        duck.performSound();

        Duck duck1 = new RubberDuck();
        duck1.performFly();
        duck1.performSound();

        duck1.setFlyBehavior(new FlyWithRocketPower());
        duck1.performFly();

    }
}
