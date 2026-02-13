import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Product> products = new ArrayList<>();
    private DiscountType discountType; // "NONE", "SEASONAL", "LOYALTY"
    private PaymentType paymentType;  // "CREDIT", "PAYPAL"
    private final double SEASONAL_DISCOUNT = 0.90;
    private final double LOYALTY_DISCOUNT = 0.85;
    private final double SALES_TAX = 1.08;
    DecimalFormat df = new DecimalFormat("#.##");


    public DiscountType getDiscountType() { return discountType; }
    public PaymentType getPaymentType() { return paymentType; }
    public List<Product> getProducts() { return products; }

    public void setProducts(List<Product> products){ this.products = products; }
    public void setDiscountType(DiscountType discountType) { this.discountType = discountType; }
    public void setPaymentType(PaymentType paymentType) { this.paymentType = paymentType; }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {

        double total = 0;

        for (Product p : products) {
            total += p.getTotal();
        }

        // Apply discount
        if (discountType == DiscountType.SEASONAL) {
            total *= SEASONAL_DISCOUNT;
        } else if (discountType == DiscountType.LOYALTY) {
            total *= LOYALTY_DISCOUNT;
        }

        // Apply tax
        total *= SALES_TAX;


        return total;
    }

    public void processPayment() {

        double total = calculateTotal();

        if (this.paymentType == PaymentType.CREDIT) {
            System.out.println("Processing credit card payment of $" + df.format(total));
            paymentSuccess();
        } else if (this.paymentType == PaymentType.PAYPAL) {
            System.out.println("Processing PayPal payment of $" + df.format(total));
            paymentSuccess();
        } else {
            System.out.println("Payment type not permitted, try again");
            throw new RuntimeException("Payment type was not " + PaymentType.CREDIT + " or" + PaymentType.PAYPAL);
        }
    }

    public void paymentSuccess() {
        System.out.println("Payment complete.");
    }
}
