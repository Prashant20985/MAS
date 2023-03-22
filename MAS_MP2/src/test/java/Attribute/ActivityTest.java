package Attribute;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActivityTest {

    @Before
    public void setUp(){
        Activity.clear();
        ActivityRecord.clear();
        Trainee.clear();
    }

    @Test
    public void delete(){
        ActivityRecord activityRecord = new ActivityRecord("01-03-3023", "01-04-2023");
        Trainee trainee = new Trainee("Tyler", "Durden");
        Activity activity = new Activity("Activity1", activityRecord, trainee);

        assertEquals(1, activityRecord.getActivities().size());
        assertEquals(1, Activity.getActivityExtent().size());
        assertEquals(1, trainee.getActivities().size());

        Activity.delete(activity);
        assertEquals(0, Activity.getActivityExtent().size());
        assertEquals(0, activityRecord.getActivities().size());
        assertEquals(0, trainee.getActivities().size());
    }
}