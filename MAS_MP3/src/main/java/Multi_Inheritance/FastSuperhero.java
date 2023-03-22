package Multi_Inheritance;

public abstract class FastSuperhero extends Human implements SuperFast{

    public FastSuperhero(String name, int age) {
        super(name, age);
    }

    @Override
    public void runSuperFast() {
        System.out.println(getName() + " is running super fast!");
    }

    abstract void useSpecialPowers();
}
