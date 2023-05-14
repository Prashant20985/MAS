package xor;

import org.junit.Test;

import static org.junit.Assert.*;

public class XorTest {
    @Test
    public void test() {
        Subscription subscription = new Subscription("Tier 1");
        FreeChannel freeChannel = new FreeChannel("FX Now");
        PaidChannel paidChannel = new PaidChannel("ESPN");

        subscription.addPaidChannel(paidChannel);
        assertThrows(RuntimeException.class,
                () -> subscription.addFreeChannel(freeChannel));

        subscription.clearPaidChannels();

        subscription.addFreeChannel(freeChannel);
        assertThrows(RuntimeException.class,
                () -> subscription.addPaidChannel(paidChannel));

        subscription.clearFreeChannels();
    }
}
