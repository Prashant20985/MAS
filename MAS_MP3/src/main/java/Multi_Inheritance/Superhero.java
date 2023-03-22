package Multi_Inheritance;

public abstract class Superhero extends Human implements Flyable, SuperStrong {
    public Superhero(String name, int age) {
        super(name, age);
    }

    @Override
    public void liftHeavy() {
        System.out.println(getName() + "is lifting heavy object");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying!");
    }

    abstract void useSpecialPowers();
}
