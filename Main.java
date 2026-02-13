public class Main {

    public static void main(String[] args) {

        Order order = new Order();
        order.discountType = "SEASONAL";
        order.paymentType = "CREDIT";

        order.addProduct(new Product("Laptop", 1000, 1));
        order.addProduct(new Product("Mouse", 50, 2));

        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment(order);
    }
}
