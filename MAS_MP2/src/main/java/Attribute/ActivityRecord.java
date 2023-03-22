package Attribute;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ActivityRecord {

    private static final Set<ActivityRecord> activityRecordExtent = new HashSet<>();

    private String startDate;
    private String endDate;

    private final Set<Activity> activities = new HashSet<>();

    public ActivityRecord(String startDate, String endDate) {
        setStartDate(startDate);
        setEndDate(endDate);
        activityRecordExtent.add(this);
    }

    public static Set<ActivityRecord> getActivityRecordExtent() {
        return Collections.unmodifiableSet(activityRecordExtent);
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        if(startDate == null || startDate.isBlank()){
            throw new IllegalArgumentException("Start Date must not be null or Blank");
        }
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        if(startDate == null || startDate.isBlank()){
            throw new IllegalArgumentException("Start Date must not be null or Blank");
        }
        this.endDate = endDate;
    }

    public Set<Activity> getActivities() {
        return Collections.unmodifiableSet(activities);
    }

    public static void clear(){
        activityRecordExtent.clear();
    }

    public void addActivityRecord(Activity activity){
        if(activity == null){
            throw new IllegalArgumentException("Activity must not be null");
        }
        if(activities.contains(activity)) return;

        activities.add(activity);
    }

    public void removeActivityRecord(Activity activity){
        if(activity == null){
            throw new IllegalArgumentException("Activity must not be null");
        }
        if(!activities.contains(activity)) return;

        activities.remove(activity);
        Activity.delete(activity);
    }

    public static void delete(ActivityRecord activityRecord){
        if(activityRecord == null){
            throw new IllegalArgumentException("Activity record must not be null");
        }

        Set<Activity> activitiesTmp = Set.copyOf(activityRecord.activities);
        activityRecord.activities.clear();
        activitiesTmp.forEach(Activity::delete);

        activityRecordExtent.remove(activityRecord);
    }
}
