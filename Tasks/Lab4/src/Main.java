import java.sql.SQLException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    Scanner scanner = new Scanner(System.in);
    try {
      ProductsBaseData productsBaseData = new ProductsBaseData();
      productsBaseData.randomAdd();
      while(true){
        String userString = scanner.next();
        if(userString.equals("exit")){
          break;
        }
        switch (userString){
          case "add":{
            String nameOfProduct = scanner.next();
            double costOfProduct = scanner.nextDouble();

            productsBaseData.addProduct(nameOfProduct, costOfProduct);
            break;
          }

          case "delete":{
            String nameOfProduct = scanner.next();

            productsBaseData.removeProduct(nameOfProduct);
            break;
          }

          case "show_all":{
            productsBaseData.showAllProducts();
            break;
          }

          case "price":{
            String nameOfProduct = scanner.next();

            productsBaseData.getPrice(nameOfProduct);
            break;
          }

          case "change_price":{
            String nameOfProduct = scanner.next();
            double priceOfProduct = scanner.nextDouble();

            productsBaseData.changePrice(nameOfProduct, priceOfProduct);
            break;
          }

          case "filter_by_price":{
            double from = scanner.nextDouble();
            double to = scanner.nextDouble();

            productsBaseData.filterByPrice(from, to);
            break;
          }
        }
      }

    } catch(SQLException e){
      System.out.println("Bad connection to SQL");
      System.exit(1);
    }


  }
}
