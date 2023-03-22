package xor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubscriptionTest {

    private Subscription subscription;
    private PaidChannel paidChannel;
    private FreeChannel freeChannel1;
    private FreeChannel freeChannel2;

    @Before
    public void setUp() {
        subscription = new Subscription("Basic");
        paidChannel = new PaidChannel("HBO");
        freeChannel1 = new FreeChannel("ABC");
        freeChannel2 = new FreeChannel("NBC");
    }

    @Test
    public void testAddFreeChannel() {
        subscription.addFreeChannel(freeChannel1);
        assertEquals(1, subscription.getFreeChannels().size());
        assertEquals(freeChannel1, subscription.getFreeChannels().get(0));
    }

    @Test(expected = RuntimeException.class)
    public void testAddFreeChannelWithPaidChannel() {
        subscription.addPaidChannel(paidChannel);
        subscription.addFreeChannel(freeChannel1);
    }

    @Test
    public void testRemoveFreeChannel() {
        subscription.addFreeChannel(freeChannel1);
        subscription.addFreeChannel(freeChannel2);
        subscription.removeFreeChannel(freeChannel1);
        assertEquals(1, subscription.getFreeChannels().size());
        assertEquals(freeChannel2, subscription.getFreeChannels().get(0));
    }

    @Test
    public void testSetPaidChannel() {
        subscription.addPaidChannel(paidChannel);
        assertEquals(paidChannel, subscription.getPaidChannel().get(0));
    }

    @Test(expected = RuntimeException.class)
    public void testSetPaidChannelWithFreeChannels() {
        subscription.addFreeChannel(freeChannel1);
        subscription.addPaidChannel(paidChannel);
    }

    @Test
    public void testRemovePaidChannel() {
        subscription.addPaidChannel(paidChannel);
        subscription.removePaidChannel(paidChannel);
        assertFalse(subscription.getPaidChannel().contains(paidChannel));
    }

    @Test
    public void testAddSubscriptionToFreeChannel() {
        freeChannel1.addSubscription(subscription);
        assertEquals(1, freeChannel1.getSubscriptions().size());
        assertEquals(subscription, freeChannel1.getSubscriptions().get(0));
    }

    @Test(expected = RuntimeException.class)
    public void testAddSubscriptionToFreeChannelWithPaidChannel() {
        subscription.addPaidChannel(paidChannel);
        freeChannel1.addSubscription(subscription);
    }

    @Test
    public void testRemoveSubscriptionFromFreeChannel() {
        freeChannel1.addSubscription(subscription);
        freeChannel1.addSubscription(new Subscription("Premium"));
        freeChannel1.removeSubscription(subscription);
        assertEquals(1, freeChannel1.getSubscriptions().size());
        assertEquals("Premium", freeChannel1.getSubscriptions().get(0).getName());
    }

    @Test(expected = RuntimeException.class)
    public void testSetSubscriptionToPaidChannelWithFreeChannels() {
        subscription.addFreeChannel(freeChannel1);
        paidChannel.addSubscription(subscription);
    }

    @Test
    public void testSetSubscriptionToPaidChannel() {
        paidChannel.addSubscription(subscription);
        assertEquals(subscription, paidChannel.getSubscription().get(0));
    }

    @Test
    public void testRemoveSubscriptionFromPaidChannel() {
        paidChannel.addSubscription(subscription);
        paidChannel.removeSubscription(subscription);
        assertFalse(paidChannel.getSubscription().contains(subscription));
    }
}