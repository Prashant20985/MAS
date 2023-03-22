package Multi_Inheritance;

public class Superman extends Superhero{
    public Superman(String name, int age) {
        super(name, age);
    }

    @Override
    void useSpecialPowers() {
        System.out.println(getName() + " kills Doomsday");
    }
}
