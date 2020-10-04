package mik.designpattern.strategy;

public class FlyWithRocketPower implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Fly with rockets");
    }
}
