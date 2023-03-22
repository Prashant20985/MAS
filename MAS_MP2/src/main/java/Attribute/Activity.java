package Attribute;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Activity {
    private static final Set<Activity> activityExtent = new HashSet<>();

    private String activityName;
    private ActivityRecord activityRecord;
    private Trainee trainee;

    public Activity(String activityName, ActivityRecord activityRecord, Trainee trainee) {
        setActivityName(activityName);
        setTrainee(trainee);
        setActivityRecord(activityRecord);
        activityRecord.addActivityRecord(this);
        trainee.addActivity(this);
        activityExtent.add(this);
    }

    public static Set<Activity> getActivityExtent() {
        return Collections.unmodifiableSet(activityExtent);
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        if(activityName == null || activityName.isBlank()){
            throw new IllegalArgumentException("Activity name must not be blank or null");
        }
        this.activityName = activityName;
    }

    public ActivityRecord getActivityRecord() {
        return activityRecord;
    }

    public void setActivityRecord(ActivityRecord activityRecord) {
        if(activityRecord == null){
            throw new IllegalArgumentException("Activity record must not be null");
        }
        this.activityRecord = activityRecord;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        if(trainee == null){
            throw new IllegalArgumentException("Trainee must not be null");
        }
        this.trainee = trainee;
    }

    public static void clear(){
        activityExtent.clear();
    }

    public static void delete(Activity activity){
        if(activity == null){
            throw new IllegalArgumentException("Activity must not be null");
        }

        activity.activityRecord.removeActivityRecord(activity);
        activity.trainee.removeActivity(activity);
        activityExtent.remove(activity);
    }
}
