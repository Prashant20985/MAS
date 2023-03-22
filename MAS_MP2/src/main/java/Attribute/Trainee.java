package Attribute;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Trainee {

    private static final Set<Trainee> traineeExtent = new HashSet<>();

    private String firstName;
    private String lastName;

    private final Set<Activity> activities = new HashSet<>();

    public Trainee(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        traineeExtent.add(this);
    }

    public static Set<Trainee> getTraineeExtent() {
        return Collections.unmodifiableSet(traineeExtent);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isBlank()){
            throw new IllegalArgumentException("FirstName must not be null or Blank");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isBlank()){
            throw new IllegalArgumentException("Last name must not be null or Blank");
        }
        this.lastName = lastName;
    }

    public Set<Activity> getActivities() {
        return Collections.unmodifiableSet(activities);
    }

    public static void clear(){
        traineeExtent.clear();
    }

    public void removeActivity(Activity activity) {
        if(activity == null){
            throw new IllegalArgumentException("Activity Must not be null");
        }
        if(!activities.contains(activity)) return;
        activities.remove(activity);
        Activity.delete(activity);
    }

    public void addActivity(Activity activity) {
        if(activity == null){
            throw new IllegalArgumentException("Activity must not be null");
        }
        if(activities.contains(activity)) return;

        activities.add(activity);
    }

    public static void delete(Trainee trainee){
        Set<Activity> activitiestmp = Set.copyOf(trainee.activities);
        trainee.activities.clear();
        activitiestmp.forEach(Activity::delete);
        traineeExtent.remove(trainee);
    }
}
