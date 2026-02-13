public class Main {

    public static void main(String[] args) {

        Order order = new Order();
        order.setDiscountType(DiscountType.LOYALTY);
        order.setPaymentType(PaymentType.PAYPAL);

        order.addProduct(new Product("Laptop", 1000, 1));
        order.addProduct(new Product("Mouse", 50, 2));

        order.processPayment();
    }
}
