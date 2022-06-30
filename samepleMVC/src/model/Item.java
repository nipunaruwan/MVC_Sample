package model;

public class Item {
   private String item_code;
    private String description;
    private String packSize ;
    private int qtyOnHand;
    private double unitPrice;
    private String item_type;

 public Item() {
 }

 public Item(String item_code, String description, String packSize, int qtyOnHand, double unitPrice, String item_type) {
  this.item_code = item_code;
  this.description = description;
  this.packSize = packSize;
  this.qtyOnHand = qtyOnHand;
  this.unitPrice = unitPrice;
  this.item_type = item_type;
 }

 public String getItem_code() {
  return item_code;
 }

 public void setItem_code(String item_code) {
  this.item_code = item_code;
 }

 public String getDescription() {
  return description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 public String getPackSize() {
  return packSize;
 }

 public void setPackSize(String packSize) {
  this.packSize = packSize;
 }

 public int getQtyOnHand() {
  return qtyOnHand;
 }

 public void setQtyOnHand(int qtyOnHand) {
  this.qtyOnHand = qtyOnHand;
 }

 public double getUnitPrice() {
  return unitPrice;
 }

 public void setUnitPrice(double unitPrice) {
  this.unitPrice = unitPrice;
 }

 public String getItem_type() {
  return item_type;
 }

 public void setItem_type(String item_type) {
  this.item_type = item_type;
 }

 @Override
 public String toString() {
  return "Item{" +
          "item_code='" + item_code + '\'' +
          ", description='" + description + '\'' +
          ", packSize='" + packSize + '\'' +
          ", qtyOnHand=" + qtyOnHand +
          ", unitPrice=" + unitPrice +
          ", item_type='" + item_type + '\'' +
          '}';
 }
}
