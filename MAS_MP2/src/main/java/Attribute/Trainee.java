package Attribute;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Trainee {
    private static final Set<Trainee> traineeExtent = new HashSet<>();
    private String firstName;
    private String lastName;
    private final Set<ActivityRecord> activityRecords = new HashSet<>();

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
            throw new IllegalArgumentException("first Name must not be blank or null");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isBlank()){
            throw new IllegalArgumentException("Last name must not be blank or null");
        }
        this.lastName = lastName;
    }

    public Set<ActivityRecord> getActivityRecords() {
        return Collections.unmodifiableSet(activityRecords);
    }

    public void addActivityRecord(ActivityRecord activityRecord){
        if(activityRecord == null){
            throw new IllegalArgumentException("Activity record must not be null");
        }
        if(activityRecords.contains(activityRecord)) return;
        activityRecords.add(activityRecord);
    }

    public void removeActivityRecord(ActivityRecord activityRecord){
        if(activityRecord == null){
            throw new IllegalArgumentException("Activity record must not be null");
        }
        if(!activityRecords.contains(activityRecord)) return;
        activityRecords.remove(activityRecord);
        ActivityRecord.delete(activityRecord);
    }

    public static void delete(Trainee trainee){
        if(trainee == null){
            throw new IllegalArgumentException("Trainee must not be null");
        }
        Set<ActivityRecord> activityRecordSeTmp = Set.copyOf(trainee.activityRecords);
        trainee.activityRecords.clear();
        activityRecordSeTmp.forEach(ActivityRecord::delete);
        traineeExtent.remove(trainee);
    }
}
