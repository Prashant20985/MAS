package Multi_Inheritance;

public class Flash extends FastSuperhero{
    public Flash(String name, int age) {
        super(name, age);
    }

    @Override
    void useSpecialPowers() {
        System.out.println(getName() + " is phasing through objects!");
    }
}
