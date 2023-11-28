package strategy;

public class ExpressDelivery implements DeliveryStrategy {
    @Override
    public String deliver(String packageId) {
        return "Pacote " + packageId + " entregue via entrega expressa.";
    }
}