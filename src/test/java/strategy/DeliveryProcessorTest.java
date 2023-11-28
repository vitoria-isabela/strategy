package strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeliveryProcessorTest {

    @Test
    void testStandardDelivery() {
        DeliveryProcessor deliveryProcessor = new DeliveryProcessor();
        deliveryProcessor.setDeliveryStrategy(new StandardDelivery());

        String result = deliveryProcessor.processDelivery("ABC123");

        assertEquals("Pacote ABC123 entregue via entrega padrão.", result);
    }

    @Test
    void testExpressDelivery() {
        DeliveryProcessor deliveryProcessor = new DeliveryProcessor();
        deliveryProcessor.setDeliveryStrategy(new ExpressDelivery());

        String result = deliveryProcessor.processDelivery("DEF456");

        assertEquals("Pacote DEF456 entregue via entrega expressa.", result);
    }

    @Test
    void testNoStrategySet() {
        DeliveryProcessor deliveryProcessor = new DeliveryProcessor();

        assertThrows(IllegalStateException.class, () -> {
            deliveryProcessor.processDelivery("GHI789");
        });
    }

    @Test
    void testStandardDeliveryWithDifferentPackage() {
        DeliveryProcessor deliveryProcessor = new DeliveryProcessor();
        deliveryProcessor.setDeliveryStrategy(new StandardDelivery());

        String result = deliveryProcessor.processDelivery("XYZ789");

        assertEquals("Pacote XYZ789 entregue via entrega padrão.", result);
    }

    @Test
    void testExpressDeliveryWithDifferentPackage() {
        DeliveryProcessor deliveryProcessor = new DeliveryProcessor();
        deliveryProcessor.setDeliveryStrategy(new ExpressDelivery());

        String result = deliveryProcessor.processDelivery("JKL321");

        assertEquals("Pacote JKL321 entregue via entrega expressa.", result);
    }

    @Test
    void testNullPackage() {
        DeliveryProcessor deliveryProcessor = new DeliveryProcessor();
        deliveryProcessor.setDeliveryStrategy(new ExpressDelivery());

        assertThrows(IllegalArgumentException.class, () -> {
            deliveryProcessor.processDelivery(null);
        });
    }
}
