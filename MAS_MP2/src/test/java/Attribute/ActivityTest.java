package Attribute;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.Assert.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ActivityTest {

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
    public void activityTest() {
        //Add ActivityRecord
        assertEquals(1, activity.getActivityRecords().size());
        assertEquals(1, activity2.getActivityRecords().size());

        //Remove ActivityRecord
        activity.removeActivityRecord(activityRecord);
        assertEquals(0, activity.getActivityRecords().size());
        activity2.removeActivityRecord(activityRecord2);
        assertEquals(0, activity2.getActivityRecords().size());

        //Delete Activity
        Activity.delete(activity);
        assertEquals(1, Activity.getActivityExtent().size());
        Activity.delete(activity2);
        assertEquals(0, Activity.getActivityExtent().size());

    }
}