package database.products;

import actions.databasefunctions.DataBaseActions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ProductDataBase  implements DataBaseActions{

  private Connection connectionToBD;

  public ProductDataBase(){
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("Bad connection with Driver");
      System.exit(1);
    }
    try {
      this.connectionToBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "1234");
      Statement statement = connectionToBD.createStatement();
      statement.executeUpdate("DROP TABLE IF EXISTS Products");
      statement.executeUpdate("CREATE TABLE IF NOT EXISTS Products(id INTEGER NOT NULL, productId INTEGER NOT NULL, name CHAR(30) NOT NULL, cost DOUBLE NOT NULL)");
      randomAdd();
      statement.close();
    } catch (SQLException e){
      System.out.println("Error with connect to SQL DataBase");
      System.exit(1);
    }
  }

  public Connection getConnectionToBD() {
    return connectionToBD;
  }


  public void randomAdd() throws SQLException {
    for (int i = 1; i <= 10; i++) {
      addProduct("product" + i, i * 10, connectionToBD);
    }
  }


}
