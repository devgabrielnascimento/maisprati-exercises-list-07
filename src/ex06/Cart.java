package ex06;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Cart {
    private final List<CartItem> items;
    private final BigDecimal couponDiscount; 

    public Cart(List<CartItem> items, BigDecimal couponDiscount) {
        if (items == null) throw new IllegalArgumentException("Items cannot be null");
        this.items = Collections.unmodifiableList(new ArrayList<>(items));

        if (couponDiscount == null) couponDiscount = BigDecimal.ZERO;

        this.couponDiscount = couponDiscount;
    }


    public Cart add(CartItem newItem) {
        List<CartItem> newList = new ArrayList<>(this.items);
        newList.add(newItem);
        return new Cart(newList, this.couponDiscount);
    }


    public Cart applyCoupon(BigDecimal percentage) {
        if (percentage.compareTo(BigDecimal.ZERO) < 0 || percentage.compareTo(new BigDecimal("0.3")) > 0) {
            throw new IllegalArgumentException("Maximum coupon discount: 30%.");
        }
        return new Cart(this.items, percentage);
    }


    public Money calculateTotal() {
        if (items.isEmpty()) return new Money(BigDecimal.ZERO, Currency.EUR);


        Money total = new Money(BigDecimal.ZERO, items.get(0).getProduct().getPrice().getCurrency());

        for (CartItem item : items) {
            BigDecimal subtotalAmount = item.getProduct().getPrice().getAmount()
                    .multiply(new BigDecimal(item.getQuantity()))
                    .setScale(2, RoundingMode.HALF_EVEN);

            Money subtotal = new Money(subtotalAmount, item.getProduct().getPrice().getCurrency());
            total = new Money(
                    total.getAmount().add(subtotal.getAmount()).setScale(2, RoundingMode.HALF_EVEN),
                    total.getCurrency()
            );
        }


        if (couponDiscount.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal discountAmount = total.getAmount().multiply(couponDiscount)
                    .setScale(2, RoundingMode.HALF_EVEN);
            total = new Money(total.getAmount().subtract(discountAmount), total.getCurrency());
        }

        return total;
    }

    public void showInfo() {
        System.out.println("Cart Items:");
        for (CartItem item : this.items) {
            System.out.println(item.getQuantity() + " x " + item.getProduct().getName() 
                + " - " + item.getProduct().getPrice().getAmount() + " " 
                + item.getProduct().getPrice().getCurrency());
        }
    }
    
    
    public List<CartItem> getItems() {
        return items;
    }

    public BigDecimal getCouponDiscount() {
        return couponDiscount;
    }
}
