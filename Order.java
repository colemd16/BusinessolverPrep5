import java.util.ArrayList;
import java.util.List;

public class Order {

    public List<Product> products = new ArrayList<>();
    public String discountType; // "NONE", "SEASONAL", "LOYALTY"
    public String paymentType;  // "CREDIT", "PAYPAL"

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {

        double total = 0;

        for (Product p : products) {
            total += p.getTotal();
        }

        // Apply discount
        if (discountType.equals("SEASONAL")) {
            total *= 0.90;
        } else if (discountType.equals("LOYALTY")) {
            total *= 0.85;
        }

        // Apply tax
        total *= 1.08;

        return total;
    }
}
