package Qualified;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {

    @Test
    public void addMember(){
        Council council1 = new Council("council1");
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");
        assertEquals(0, council1.getMembers().size());
        assertEquals(0, member1.getCouncils().size());
        assertEquals(0, member2.getCouncils().size());
        council1.addMember(member1);
        council1.addMember(member2);
        assertEquals(2, council1.getMembers().size());
        assertEquals(1, member1.getCouncils().size());
        assertEquals(1, member2.getCouncils().size());
    }
    @Test
    public void removeMember(){
        Council council1 = new Council("council1");
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");
        assertEquals(0, council1.getMembers().size());
        assertEquals(0, member1.getCouncils().size());
        assertEquals(0, member2.getCouncils().size());
        council1.addMember(member1);
        council1.addMember(member2);
        assertEquals(2, council1.getMembers().size());
        assertEquals(1, member1.getCouncils().size());
        assertEquals(1, member2.getCouncils().size());
        council1.removeMember(member1);
        assertEquals(1, council1.getMembers().size());
        assertEquals(0, member1.getCouncils().size());
        assertEquals(1, member2.getCouncils().size());
        council1.removeMember(member2);
        assertEquals(0, council1.getMembers().size());
        assertEquals(0, member1.getCouncils().size());
        assertEquals(0, member2.getCouncils().size());
    }

    @Test
    public void deleteMember() {
        Council council1 = new Council("council1");
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");
        assertEquals(0, council1.getMembers().size());
        assertEquals(0, member1.getCouncils().size());
        assertEquals(0, member2.getCouncils().size());
        council1.addMember(member1);
        council1.addMember(member2);
        assertEquals(2, council1.getMembers().size());
        assertEquals(1, member1.getCouncils().size());
        assertEquals(1, member2.getCouncils().size());
        Council.delete(council1);
        assertEquals(0, member1.getCouncils().size());
        assertEquals(0, member2.getCouncils().size());
    }

}