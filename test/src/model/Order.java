package model;

public class Order {
   private int cusID;
   private int orderid;
   private int order_date;
    private double price;

    public Order() {
    }

    public Order(int cusID, int orderid, int order_date, double price) {
        this.cusID = cusID;
        this.orderid = orderid;
        this.order_date = order_date;
        this.price = price;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getOrder_date() {
        return order_date;
    }

    public void setOrder_date(int order_date) {
        this.order_date = order_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
