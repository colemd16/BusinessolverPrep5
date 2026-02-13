public class PaymentProcessor {

    public void processPayment(Order order) {

        double total = order.calculateTotal();

        if (order.paymentType.equals("CREDIT")) {
            System.out.println("Processing credit card payment of $" + total);
        } else if (order.paymentType.equals("PAYPAL")) {
            System.out.println("Processing PayPal payment of $" + total);
        } else {
            System.out.println("Unknown payment type.");
        }

        System.out.println("Payment complete.");
    }
}
