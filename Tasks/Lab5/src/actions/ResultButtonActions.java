package actions;

import actions.databasefunctions.DataBaseActions;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.sql.Connection;
import java.sql.SQLException;

public interface ResultButtonActions extends DataBaseActions{

  default void createErrorDialogs(JPanel jPanel, String string){
    JOptionPane.showMessageDialog(jPanel, string, "title", JOptionPane.ERROR_MESSAGE);
  }

  default void createAccessDialogs(JPanel jPanel, String str){
    JOptionPane.showMessageDialog(jPanel, str, "title", JOptionPane.INFORMATION_MESSAGE);
  }

  default void createActionForShowAll(JFrame jFrame, Connection connectionToBD){
    JPanel jPanel = new JPanel();
    String string;
    try {
      string = showAllProducts(connectionToBD);
      JOptionPane.showMessageDialog(jPanel, string, "title", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException e) {
      createErrorDialogs(jPanel, "Error with connection to SQL");
    }
  }



  default void createActionAdd(JPanel jPanel, String name, double price, Connection connectionToBD){
    try{
      addProduct(name, price, connectionToBD);
    } catch (SQLException e){
       createErrorDialogs(jPanel, "SQL connect was interrupt");
    } catch (NullPointerException e){
       createErrorDialogs(jPanel, "Name is incorrect");
    }
     createAccessDialogs(jPanel, "command add is access");
  }

  default void createActionDelete(JPanel jPanel, String name, Connection connectionToBD){
    try{
      removeProduct(name, connectionToBD);
    } catch (SQLException e){
      createErrorDialogs(jPanel, "SQL connect was interrupt");
    } catch (NullPointerException e){
      createErrorDialogs(jPanel, "Name is incorrect");
    }
     createAccessDialogs(jPanel, "command delete is access");
  }

  default void createActionGetPrice(JPanel jPanel, String name, Connection connectionToBD){
    String str;
    try{
      str = getPrice(name, connectionToBD);
      JOptionPane.showMessageDialog(jPanel, str, "title", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException e){
      createErrorDialogs(jPanel, "SQL connect was interrupt");
    } catch (NullPointerException e){
      createErrorDialogs(jPanel, "Name is incorrect");
    }

  }

  default void createActionChangePrice(JPanel jPanel, String name, double newPrice, Connection connectionToBD){
    String str;
    try{
      str = changePrice(name, newPrice, connectionToBD);
      JOptionPane.showMessageDialog(jPanel, str, "title", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException e){
      createErrorDialogs(jPanel, "SQL connect was interrupt");
    } catch (NullPointerException e){
      createErrorDialogs(jPanel, "Name is incorrect");
    }
  }

  default void createActionFilterByPrice(JFrame jFrame, double from, double to, Connection connectionToBD){
    JPanel jPanel = new JPanel();
    String string;
    try {
      string = filterByPrice(from , to, connectionToBD);
      if (string.equals("")) {
        JOptionPane.showMessageDialog(jPanel, "products doesnt exist", "title", JOptionPane.INFORMATION_MESSAGE);
      }
      JOptionPane.showMessageDialog(jPanel, string, "title", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException e) {
      createErrorDialogs(jPanel, "Error with connection to SQL");
    }
  }


}
