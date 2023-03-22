package Attribute;

import Basic.Student;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TraineeTest {

    @Before
    public void setUp(){
        Activity.clear();
        ActivityRecord.clear();
        Trainee.clear();
    }

    @Test
    public void addActivity(){
        ActivityRecord activityRecord = new ActivityRecord("01-03-3023", "01-04-2023");
        Trainee trainee = new Trainee("Tyler", "Durden");
        Activity activity = new Activity("Activity1", activityRecord, trainee);
        Activity activity1 = new Activity("Activity 2", activityRecord, trainee);
        assertEquals(2, trainee.getActivities().size());
        assertFalse(!trainee.getActivities().contains(activity1));
        assertFalse(!trainee.getActivities().contains(activity));
    }

    @Test
    public void removeActivity(){
        ActivityRecord activityRecord = new ActivityRecord("01-03-3023", "01-04-2023");
        Trainee trainee = new Trainee("Tyler", "Durden");
        Activity activity = new Activity("Activity1", activityRecord, trainee);
        Activity activity1 = new Activity("Activity 2", activityRecord, trainee);
        assertEquals(2, trainee.getActivities().size());

        trainee.removeActivity(activity1);
        assertFalse(trainee.getActivities().contains(activity1));
        assertTrue(trainee.getActivities().contains(activity));
        assertEquals(1, trainee.getActivities().size());

        trainee.removeActivity(activity);
        assertFalse(trainee.getActivities().contains(activity1));
        assertFalse(trainee.getActivities().contains(activity));
        assertEquals(0, trainee.getActivities().size());
    }

    @Test
    public void delete(){
        ActivityRecord activityRecord = new ActivityRecord("01-03-3023", "01-04-2023");
        Trainee trainee = new Trainee("Tyler", "Durden");
        Activity activity = new Activity("Activity1", activityRecord, trainee);

        assertEquals(1, Trainee.getTraineeExtent().size());

        Trainee.delete(trainee);
        assertFalse(Trainee.getTraineeExtent().contains(trainee));
        assertFalse(Activity.getActivityExtent().contains(activity));
        assertFalse(activity.getActivityRecord().getActivities().contains(activity));
    }
}