package model;

public class item {
   private int item_code;
    private String description;
    private int packSize ;
    private int qtyOnHand;
    private int unitPrice;
    private int item_type;

 public item() {
 }

 public item(int item_code, String description, int packSize, int qtyOnHand, int unitPrice, int item_type) {
  this.item_code = item_code;
  this.description = description;
  this.packSize = packSize;
  this.qtyOnHand = qtyOnHand;
  this.unitPrice = unitPrice;
  this.item_type = item_type;
 }

 public int getItem_code() {
  return item_code;
 }

 public void setItem_code(int item_code) {
  this.item_code = item_code;
 }

 public String getDescription() {
  return description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 public int getPackSize() {
  return packSize;
 }

 public void setPackSize(int packSize) {
  this.packSize = packSize;
 }

 public int getQtyOnHand() {
  return qtyOnHand;
 }

 public void setQtyOnHand(int qtyOnHand) {
  this.qtyOnHand = qtyOnHand;
 }

 public int getUnitPrice() {
  return unitPrice;
 }

 public void setUnitPrice(int unitPrice) {
  this.unitPrice = unitPrice;
 }

 public int getItem_type() {
  return item_type;
 }



 public void setItem_type(int item_type) {
  this.item_type = item_type;
 }
 @Override
 public String toString() {
  return "item{" +
          "item_code=" + item_code +
          ", description='" + description + '\'' +
          ", packSize=" + packSize +
          ", qtyOnHand=" + qtyOnHand +
          ", unitPrice=" + unitPrice +
          ", item_type=" + item_type +
          '}';
 }
}