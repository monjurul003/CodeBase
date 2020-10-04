package mik.designpattern.strategy;

public class CanNotFly implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("can not fly");
    }
}
