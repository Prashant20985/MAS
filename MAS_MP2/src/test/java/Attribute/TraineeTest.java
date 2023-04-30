package Attribute;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TraineeTest {

    private ActivityRecord activityRecord;
    private ActivityRecord activityRecord2;
    private Trainee trainee;
    private Trainee trainee2;

    @Before
    public void setUp() {
        Activity activity = new Activity("Activity 1");
        Activity activity2 = new Activity("Activity 2");
        trainee = new Trainee("Prashant", "Sharma");
        trainee2 = new Trainee("Prashant2", "Sharma2");
        activityRecord = new ActivityRecord("01-01-2023", "01-02-2023", activity, trainee);
        activityRecord2 = new ActivityRecord("01-01-2023", "01-02-2023", activity2, trainee2);
    }

    @Test
    public void activityTest() {
        //Add ActivityRecord
        assertEquals(1, trainee.getActivityRecords().size());
        assertEquals(1, trainee2.getActivityRecords().size());

        //Remove ActivityRecord
        trainee.removeActivityRecord(activityRecord);
        assertEquals(0, trainee.getActivityRecords().size());
        trainee2.removeActivityRecord(activityRecord2);
        assertEquals(0, trainee2.getActivityRecords().size());

        //Delete Activity
        Trainee.delete(trainee);
        assertEquals(1, Trainee.getTraineeExtent().size());
        Trainee.delete(trainee2);
        assertEquals(0, Trainee.getTraineeExtent().size());
    }
}