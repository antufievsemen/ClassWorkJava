import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductsBaseData {

  private Connection connectionToBD;

  public ProductsBaseData() throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");
    this.connectionToBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
    Statement statement = connectionToBD.createStatement();
    statement.executeUpdate("DROP TABLE IF EXISTS Products");
    statement.executeUpdate("CREATE TABLE IF NOT EXISTS Products(id INTEGER NOT NULL, productId INTEGER NOT NULL, name CHAR(30) NOT NULL, cost DOUBLE NOT NULL)");
    statement.close();
  }

  public void addProduct(String name, double cost) throws SQLException {
    if(checkParam(name)){
      System.out.println("Incorrect name");
      return;
    }

    Product product = new Product(name, cost);
    PreparedStatement preparedStatement = connectionToBD.prepareStatement("INSERT INTO Products (id, productId, name, cost) VALUES (?, ?, ?, ?)");
    preparedStatement.setInt(1, product.getId());
    preparedStatement.setInt(2, product.getProdId());
    preparedStatement.setString(3, product.getName());
    preparedStatement.setDouble(4, product.getCost());
    preparedStatement.execute();
    preparedStatement.close();
  }

  public void removeProduct(String name) throws SQLException {

    if(checkParam(name)){
      System.out.println("Incorrect name");
      return;
    }

    PreparedStatement preparedStatement = connectionToBD.prepareStatement("DELETE FROM Products WHERE name = ?");
    preparedStatement.setString(1, name);
    preparedStatement.execute();
    preparedStatement.close();
  }

  public void showAllProducts() throws SQLException {
    Statement statement = connectionToBD.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Products");
    while(resultSet.next()){
      System.out.print("id : " + resultSet.getString("id"));
      System.out.print(" productId : " + resultSet.getString("productId"));
      System.out.print(" name : " + resultSet.getString("name"));
      System.out.println(" cost : " + resultSet.getDouble("cost"));
    }
    resultSet.close();
    statement.close();
  }

  public void getPrice(String name) throws SQLException {
    if(checkParam(name)){
      System.out.println("Incorrect name");
      return;
    }

    PreparedStatement preparedStatement = connectionToBD.prepareStatement("SELECT * FROM Products WHERE name = ?");
    preparedStatement.setString(1, name);
    ResultSet resultSet = preparedStatement.executeQuery();
    if(resultSet.next()) {
      System.out.print("Name : " + name);
      System.out.println(" Cost : " + resultSet.getString("cost"));
    } else {
      System.out.println(name + " doesnt exist");
    }
    resultSet.close();
    preparedStatement.close();
  }

  public void changePrice(String name, double cost) throws SQLException {
    if(checkParam(name)){
      System.out.println("Incorrect name");
      return;
    }

    PreparedStatement preparedStatement = connectionToBD.prepareStatement("UPDATE Products SET cost = ? WHERE name = ?");
    preparedStatement.setDouble(1, cost);
    preparedStatement.setString(2, name);
    preparedStatement.execute();
    Statement statement = connectionToBD.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM Products WHERE name = '" + name + "'");
    if(resultSet.next()) {
      System.out.print("Name : " + name);
      System.out.println("Cost : " + resultSet.getDouble("cost"));
    } else {
      System.out.println(name + "doesnt exist");
    }
    resultSet.close();

  }

  public void filterByPrice(double from, double to) throws SQLException {
    PreparedStatement preparedStatement = connectionToBD.prepareStatement("SELECT * FROM Products WHERE (cost >= ?) AND (cost <= ? ) ");
    preparedStatement.setDouble(1, from);
    preparedStatement.setDouble(2, to);
    ResultSet resultSet = preparedStatement.executeQuery();
    while(resultSet.next()){
      System.out.print("Name : " + resultSet.getString("name"));
      System.out.println(" Price : " + resultSet.getDouble("cost"));
    }
    preparedStatement.close();
    resultSet.close();
  }
  
  public void randomAdd() throws SQLException {
    for (int i = 1; i <= 10; i++) {
      addProduct("product" + i, i * 10);
    }
  }

  private boolean checkParam(String name){
    if(name == null){
      return false;
    }

    if(name.equals("")){
      return false;
    }

    return true;
  }
}
