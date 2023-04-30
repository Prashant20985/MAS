package Attribute;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ActivityRecord {

    private static final Set<ActivityRecord> activityRecordExtent = new HashSet<>();
    private String startDate;
    private String endDate;
    private Activity activity;
    private Trainee trainee;

    public ActivityRecord(String startDate, String endDate, Activity activity, Trainee trainee) {
        validate(activity, trainee);
        setStartDate(startDate);
        setEndDate(endDate);
        setActivity(activity);
        setTrainee(trainee);
        activity.addActivityRecord(this);
        trainee.addActivityRecord(this);
        activityRecordExtent.add(this);
    }

    private static void validate(Activity activity, Trainee trainee) {
        if(activityRecordExtent.stream().anyMatch(activityRecord ->
            activityRecord.getTrainee().equals(trainee) && activityRecord.getActivity().equals(activity)
        ))
            throw new IllegalArgumentException("Activity is already assigned to trainee");
    }

    public static Set<ActivityRecord> getActivityRecordExtent() {
        return Collections.unmodifiableSet(activityRecordExtent);
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        if (startDate == null || startDate.isBlank()) {
            throw new IllegalArgumentException("Start Date must not be Blank or Null");
        }
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        if (endDate == null || endDate.isBlank()) {
            throw new IllegalArgumentException("End Date must not be Blank or Null");
        }
        this.endDate = endDate;
    }

    public Activity getActivity() {
        return activity;
    }

    private void setActivity(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not be null");
        }
        this.activity = activity;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    private void setTrainee(Trainee trainee) {
        if (trainee == null) {
            throw new IllegalArgumentException("Trainee must not be null");
        }
        this.trainee = trainee;
    }

    public static void delete(ActivityRecord activityRecord) {
        if (activityRecord == null) {
            throw new IllegalArgumentException("Activity Record must not be null");
        }
        activityRecord.activity.removeActivityRecord(activityRecord);
        activityRecord.trainee.removeActivityRecord(activityRecord);
        activityRecordExtent.remove(activityRecord);
    }
}
