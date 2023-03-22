package Attribute;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActivityRecordTest {

    @Before
    public void setUp(){
        Activity.clear();
        ActivityRecord.clear();
        Trainee.clear();
    }

    @Test
    public void addActivityRecord(){
        ActivityRecord activityRecord = new ActivityRecord("01-03-3023", "01-04-2023");
        Trainee trainee = new Trainee("Tyler", "Durden");
        Activity activity = new Activity("Activity1", activityRecord, trainee);
        assertEquals(1, activityRecord.getActivities().size());
    }

    @Test
    public void removeActivityRecord(){
        ActivityRecord activityRecord = new ActivityRecord("01-03-3023", "01-04-2023");
        Trainee trainee = new Trainee("Tyler", "Durden");
        Activity activity = new Activity("Activity1", activityRecord, trainee);
        assertEquals(1, activityRecord.getActivities().size());
        activityRecord.removeActivityRecord(activity);
        assertEquals(0, activityRecord.getActivities().size());
    }

    @Test
    public void delete(){
        ActivityRecord activityRecord = new ActivityRecord("01-03-3023", "01-04-2023");
        Trainee trainee = new Trainee("Tyler", "Durden");
        Activity activity = new Activity("Activity1", activityRecord, trainee);
        assertEquals(1, ActivityRecord.getActivityRecordExtent().size());
        ActivityRecord.delete(activityRecord);
        assertEquals(0, ActivityRecord.getActivityRecordExtent().size());

    }
}