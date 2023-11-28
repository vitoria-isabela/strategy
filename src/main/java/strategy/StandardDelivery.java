package strategy;

public class StandardDelivery implements DeliveryStrategy {
    @Override
    public String deliver(String packageId) {
        return "Pacote " + packageId + " entregue via entrega padrão.";
    }
}