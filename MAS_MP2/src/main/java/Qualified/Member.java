package Qualified;

import java.util.*;

//Member has qualified association with Council class
public class Member {
    private static final Set<Member> extent = new HashSet<>();
    private String name;

    private final Map<String, Council> councils = new HashMap<>();

    public Member(String name) {
        setName(name);
        extent.add(this);
    }

    public static Set<Member> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("Name must not be null");
        }
        this.name = name;
    }

    public Map<String, Council> getCouncils() {
        return Collections.unmodifiableMap(councils);
    }

    public void addCouncil(Council council){
        if(council == null){
            throw new IllegalArgumentException("Council must not be null");
        }
        if(councils.containsKey(council.getName())) return;
        councils.put(council.getName(), council);
        council.addMember(this);
    }

    public void removeCouncil(Council council){
        if(council == null){
            throw new IllegalArgumentException("Council must not be null");
        }
        if(!councils.containsKey(council.getName())) return;
        councils.remove(council.getName());
        council.removeMember(this);
    }

    public Optional<Council> councilByName(String name){
        if(name == null){
            throw new IllegalArgumentException("Team Name must not be null");
        }
        return Optional.ofNullable(councils.get(name));
    }

    public static void delete(Member member){
        Map<String, Council> counciltemp = Map.copyOf(member.councils);
        member.councils.clear();
        counciltemp.forEach((x, council) -> council.removeMember(member));
        extent.removeIf(x -> x.name.equals(member.getName()));
    }
}
