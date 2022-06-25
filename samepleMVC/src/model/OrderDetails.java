package model;

public class OrderDetails {
   private int orderid;
   private int item_code;
   private int orderqty;
    private double discount;

    public OrderDetails() {
    }

    public OrderDetails(int orderid, int item_code, int orderqty, double discount) {
        this.orderid = orderid;
        this.item_code = item_code;
        this.orderqty = orderqty;
        this.discount = discount;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getItem_code() {
        return item_code;
    }

    public void setItem_code(int item_code) {
        this.item_code = item_code;
    }

    public int getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(int orderqty) {
        this.orderqty = orderqty;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderid=" + orderid +
                ", item_code=" + item_code +
                ", orderqty=" + orderqty +
                ", discount=" + discount +
                '}';
    }

    public void setDiscount(double discount) {
        this.discount = discount;

    }
}
