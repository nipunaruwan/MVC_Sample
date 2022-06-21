package model;

public class customer {
    private int cusID;
   private String cust_title;
    private String name;
    private String addresss;
    private String city;
    private String provide;
    private int postalcode;

    public customer() {
    }

    public customer(int cusID, String cust_title, String name, String addresss, String city, String provide, int postalcode) {
        this.setCusID(cusID);
        this.setCust_title(cust_title);
        this.setName(name);
        this.setAddresss(addresss);
        this.setCity(city);
        this.setProvide(provide);
        this.setPostalcode(postalcode);
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
}
