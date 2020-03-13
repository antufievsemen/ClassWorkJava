package actions.databasefunctions;

import product.Product;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface DataBaseActions {

  default void addProduct(String name, double cost, Connection connectionToBD) throws SQLException, NullPointerException{
    if(!isNameCorrect(name)){
      System.out.println("Incorrect name");
      throw new NullPointerException();
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

  default void removeProduct(String name, Connection connectionToBD) throws SQLException, NullPointerException{

    if(!isNameCorrect(name)){
      System.out.println("Incorrect name");
      throw new NullPointerException();
    }
      PreparedStatement preparedStatement = connectionToBD.prepareStatement("DELETE FROM Products WHERE name = ?");
      preparedStatement.setString(1, name);
      preparedStatement.execute();
      preparedStatement.close();
  }

  default String showAllProducts(Connection connectionToBD) throws SQLException{
      Statement statement = connectionToBD.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM Products");
      StringBuilder stringBuilder = new StringBuilder();
      while (resultSet.next()) {
        stringBuilder.append("id : ").append(resultSet.getString("id"));
        stringBuilder.append(" productId : ").append(resultSet.getString("productId"));
        stringBuilder.append(" name : ").append(resultSet.getString("name"));
        stringBuilder.append(" cost : ").append(resultSet.getDouble("cost")).append("\n");

      }
      resultSet.close();
      statement.close();
      return stringBuilder.toString();
  }

  default String getPrice(String name, Connection connectionToBD) throws SQLException, NullPointerException{
    if(!isNameCorrect(name)){
      System.out.println("Incorrect name");
      throw new NullPointerException();
    }
      PreparedStatement preparedStatement = connectionToBD.prepareStatement("SELECT * FROM Products WHERE name = ?");
      preparedStatement.setString(1, name);
      ResultSet resultSet = preparedStatement.executeQuery();
      StringBuilder stringBuilder = new StringBuilder();
      if (resultSet.next()) {
        stringBuilder.append("Name : ").append(name);
        stringBuilder.append(" Cost : ").append(resultSet.getString("cost")).append("\n");
      } else {
        stringBuilder.append(name).append(" doesnt exist");
      }
      resultSet.close();
      preparedStatement.close();
      return stringBuilder.toString();
  }

  default String changePrice(String name, double cost, Connection connectionToBD) throws SQLException, NullPointerException{
    if(!isNameCorrect(name)){
      System.out.println("Incorrect name");
      throw new NullPointerException();
    }
      PreparedStatement preparedStatement = connectionToBD.prepareStatement("UPDATE Products SET cost = ? WHERE name = ?");
      preparedStatement.setDouble(1, cost);
      preparedStatement.setString(2, name);
      preparedStatement.execute();
      Statement statement = connectionToBD.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM Products WHERE name = '" + name + "'");
      StringBuilder stringBuilder = new StringBuilder();
      if (resultSet.next()) {
        stringBuilder.append("Name : ").append(name);
        stringBuilder.append("Cost : ").append(resultSet.getDouble("cost")).append("\n");
      } else {
        stringBuilder.append(name).append("doesnt exist");
      }
      resultSet.close();
      return stringBuilder.toString();
  }

  default String filterByPrice(double from, double to, Connection connectionToBD) throws SQLException{
      PreparedStatement preparedStatement = connectionToBD.prepareStatement("SELECT * FROM Products WHERE (cost >= ?) AND (cost <= ? )" +
              "order by cost");
      preparedStatement.setDouble(1, from);
      preparedStatement.setDouble(2, to);
      ResultSet resultSet = preparedStatement.executeQuery();
      StringBuilder stringBuilder = new StringBuilder();
      while (resultSet.next()) {
        stringBuilder.append("Name : ").append(resultSet.getString("name"));
        stringBuilder.append(" Price : ").append(resultSet.getDouble("cost")).append("\n");
      }
      preparedStatement.close();
      resultSet.close();
      return stringBuilder.toString();
  }

  default void randomAdd(Connection connectionToBD) throws SQLException{
    for (int i = 1; i <= 10; i++) {
      addProduct("product" + i, i * 10, connectionToBD);
    }
  }

  private boolean isNameCorrect(String name){
    if(name == null){
      return false;
    }

    if(name.equals("")){
      return false;
    }

    return true;
  }
}
