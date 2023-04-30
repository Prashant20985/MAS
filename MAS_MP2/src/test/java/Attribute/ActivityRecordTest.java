package Attribute;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActivityRecordTest {

    private Activity activity;
    private Activity activity2;
    private ActivityRecord activityRecord;
    private ActivityRecord activityRecord2;
    private Trainee trainee;
    private Trainee trainee2;

    @Before
    public void setUp() {
        activity = new Activity("Activity 1");
        activity2 = new Activity("Activity 2");
        trainee = new Trainee("Prashant", "Sharma");
        trainee2 = new Trainee("Prashant2", "Sharma2");
        activityRecord = new ActivityRecord("01-01-2023", "01-02-2023", activity, trainee);
        activityRecord2 = new ActivityRecord("01-01-2023", "01-02-2023", activity2, trainee2);
    }

    @Test
    public void delete() {
        ActivityRecord.delete(activityRecord);
        assertEquals(1, ActivityRecord.getActivityRecordExtent().size());
        assertEquals(0, activity.getActivityRecords().size());
        assertEquals(0, trainee.getActivityRecords().size());

        ActivityRecord.delete(activityRecord2);
        assertEquals(0, ActivityRecord.getActivityRecordExtent().size());
        assertEquals(0, activity2.getActivityRecords().size());
        assertEquals(0, trainee2.getActivityRecords().size());
    }
}