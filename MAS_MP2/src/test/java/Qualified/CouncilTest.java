package Qualified;

import org.junit.Test;

import static org.junit.Assert.*;

public class CouncilTest {

    @Test
    public void addCouncil(){
        Member member1 = new Member("member1");
        Council council1 = new Council("council1");
        Council council2 = new Council("council2");
        assertEquals(0, council1.getMembers().size());
        assertEquals(0, council2.getMembers().size());
        assertEquals(0, member1.getCouncils().size());

        member1.addCouncil(council1);
        member1.addCouncil(council2);

        assertEquals(1, council1.getMembers().size());
        assertEquals(1, council2.getMembers().size());
        assertEquals(2, member1.getCouncils().size());
    }

    @Test
    public void removeCouncil() {
        Member member1 = new Member("member1");
        Council council1 = new Council("council1");
        Council council2 = new Council("council2");
        assertEquals(0, council1.getMembers().size());
        assertEquals(0, council2.getMembers().size());
        assertEquals(0, member1.getCouncils().size());

        member1.addCouncil(council1);
        member1.addCouncil(council2);

        assertEquals(1, council1.getMembers().size());
        assertEquals(1, council2.getMembers().size());
        assertEquals(2, member1.getCouncils().size());

        member1.removeCouncil(council1);
        assertEquals(0, council1.getMembers().size());
        assertEquals(1, council2.getMembers().size());
        assertEquals(1, member1.getCouncils().size());

        member1.removeCouncil(council2);
        assertEquals(0, council1.getMembers().size());
        assertEquals(0, council2.getMembers().size());
        assertEquals(0, member1.getCouncils().size());
    }

    @Test
    public void findByName(){
        Member member1 = new Member("member1");
        Council council1 = new Council("council1");
        Council council2 = new Council("council2");

        member1.addCouncil(council1);
        member1.addCouncil(council2);
        assertEquals("council1", member1.councilByName("council1").get().getName());
        assertEquals("council2", member1.councilByName("council2").get().getName());
        assertFalse(member1.councilByName("ahahahaha").isPresent());
    }

    @Test
    public void deleteCouncil(){
        Member member1 = new Member("member1");
        Council council1 = new Council("council1");
        Council council2 = new Council("council2");
        assertEquals(0, council1.getMembers().size());
        assertEquals(0, council2.getMembers().size());
        assertEquals(0, member1.getCouncils().size());

        member1.addCouncil(council1);
        member1.addCouncil(council2);

        assertEquals(1, council1.getMembers().size());
        assertEquals(1, council2.getMembers().size());
        assertEquals(2, member1.getCouncils().size());

        Member.delete(member1);
        assertEquals(0, council1.getMembers().size());
        assertEquals(0, council2.getMembers().size());
    }
}