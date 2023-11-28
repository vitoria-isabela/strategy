package strategy;

public class DeliveryProcessor {
    private DeliveryStrategy deliveryStrategy;

    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public String processDelivery(String packageId) {
        if (packageId == null) {
            throw new IllegalArgumentException("Package ID cannot be null");
        }

        if (deliveryStrategy == null) {
            throw new IllegalStateException("Delivery strategy not set");
        }

        return deliveryStrategy.deliver(packageId);
    }
}
