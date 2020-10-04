package mik.designpattern.strategy;

public class RubberDuck extends Duck {

    public RubberDuck() {
        flyBehavior = new CanNotFly();
        quackBehavior = new Squeek();
    }

    @Override
    public void display() {
        System.out.println("Decoy duck!!");
    }

}
