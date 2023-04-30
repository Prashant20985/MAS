package Attribute;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Activity {
    private static final Set<Activity> activityExtent = new HashSet<>();
    private String activityName;
    private final Set<ActivityRecord> activityRecords = new HashSet<>();

    public Activity(String activityName) {
        setActivityName(activityName);
        activityExtent.add(this);
    }

    public static Set<Activity> getActivityExtent() {
        return Collections.unmodifiableSet(activityExtent);
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        if (activityName == null || activityName.isBlank())
            throw new IllegalArgumentException("Activity Name Must not be Blank");
        this.activityName = activityName;
    }

    public Set<ActivityRecord> getActivityRecords() {
        return Collections.unmodifiableSet(activityRecords);
    }

    public void addActivityRecord(ActivityRecord activityRecord) {
        if (activityRecord == null)
            throw new IllegalArgumentException("Activity record must not be null");
        if (activityRecords.contains(activityRecord))
            return;
        if (activityRecord.getActivity() != this)
            throw new IllegalArgumentException("Activity record is assigned to different record");

        activityRecords.add(activityRecord);
    }

    public void removeActivityRecord(ActivityRecord activityRecord) {
        if (activityRecord == null)
            throw new IllegalArgumentException("Activity record must not be null");
        if (!activityRecords.contains(activityRecord))
            return;
        activityRecords.remove(activityRecord);
        ActivityRecord.delete(activityRecord);
    }

    public static void delete(Activity activity) {
        if (activity == null)
            throw new IllegalArgumentException("Activity must not be null");
        Set<ActivityRecord> activityRecordsTmp = Set.copyOf(activity.activityRecords);
        activity.activityRecords.clear();
        activityRecordsTmp.forEach(ActivityRecord::delete);
        activityExtent.remove(activity);
    }
}
