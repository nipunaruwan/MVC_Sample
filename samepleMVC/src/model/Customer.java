package model;

public class Customer {
    private int cusID;
   private String cust_title;
    private String name;
    private String addresss;
    private String city;
    private String provide;
    private int postalcode;

    public Customer() {
    }

    public Customer(int cusID, String cust_title, String name, String addresss, String city, String provide, int postalcode) {
        this.cusID = cusID;
        this.cust_title = cust_title;
        this.name = name;
        this.addresss = addresss;
        this.city = city;
        this.provide = provide;
        this.postalcode = postalcode;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public String getCust_title() {
        return cust_title;
    }

    public void setCust_title(String cust_title) {
        this.cust_title = cust_title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvide() {
        return provide;
    }

    public void setProvide(String provide) {
        this.provide = provide;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    @Override
    public String toString() {
        return "customer{" +
                "cusID=" + cusID +
                ", cust_title='" + cust_title + '\'' +
                ", name='" + name + '\'' +
                ", addresss='" + addresss + '\'' +
                ", city='" + city + '\'' +
                ", provide='" + provide + '\'' +
                ", postalcode=" + postalcode +
                '}';
    }
}
