package Qualified;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Council {
    private static final Set<Council> extent = new HashSet<>();

    private String name;

    private final Set<Member> members = new HashSet<>();

    public Council(String name) {
        setName(name);
        extent.add(this);
    }

    public static Set<Council> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("Name Must not be null");
        }
        this.name = name;
    }

    public Set<Member> getMembers() {
        return Collections.unmodifiableSet(members);
    }

    public void removeMember(Member member) {
        if(member == null){
            throw new IllegalArgumentException("Member must not be null");
        }
        if(!members.contains(member)) return;
        members.remove(member);
        member.removeCouncil(this);
    }

    public void addMember(Member member) {
        if(member == null){
            throw new IllegalArgumentException("Member must not be null");
        }
        if(members.contains(member)) return;
        members.add(member);
        member.addCouncil(this);
    }

    public static void delete(Council council){
        Set<Member> membersTemp = Set.copyOf(council.members);
        council.members.remove(council);
        membersTemp.forEach(x -> x.removeCouncil(council));
        extent.removeIf(x -> x.name.equals(council.getName()));
    }
}
