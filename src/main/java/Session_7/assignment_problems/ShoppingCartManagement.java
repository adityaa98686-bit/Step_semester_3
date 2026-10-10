package Session_7.assignment_problems;
class Cart {
    private double[] prices;
    private int count;
    private final String cartId;

    public Cart(String cartId, int size) {
        this.cartId = cartId;
        this.prices = new double[Math.max(0, size)];
        this.count = 0;
    }

    public void addItem(double price) {
        if (price < 0) {
            System.out.println("Invalid price");
        } else if (count < prices.length) {
            prices[count] = price;
            count++;
        } else {
            System.out.println("Cart is full");
        }
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < count; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return count;
    }

    public String getCartId() {
        return cartId;
    }
}

public class ShoppingCartManagement {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}