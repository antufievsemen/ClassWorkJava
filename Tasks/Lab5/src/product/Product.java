package product;

public class Product {
  private static int productIdCount = 1;
  private int id;
  private int prodId;
  private String name;
  private double cost;

  public Product(String name, double cost){
    this.prodId = productIdCount++;
    this.name = name;
    this.cost = cost;
    this.id = hashId();
  }


  public int getId() {
    return id;
  }

  public int getProdId() {
    return prodId;
  }

  private int hashId(){
    return prodId * 32 + name.length() * 32 + (int) cost * 32;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public double getCost() {
    return cost;
  }
}
