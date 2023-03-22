package Multi_Inheritance;

import org.junit.Test;

public class SuperheroTest {

    @Test
    public void test(){
        Superhero superMan = new Superman("Super Man", 33);
        superMan.fly();
        superMan.liftHeavy();
        superMan.useSpecialPowers();

        FastSuperhero flash = new Flash("The Flash", 27);
        flash.runSuperFast();
        flash.useSpecialPowers();
    }
}