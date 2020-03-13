package textfields;

import constraints.Constraints;

import javax.swing.JTextField;
import javax.swing.JPanel;

public class AttributeTextField implements Constraints {

  private JTextField jTextField;

  public AttributeTextField(JPanel jPanel, int gridX, int gridY, String type){
    jTextField = new JTextField(type,20);
    printTextField(jPanel, gridX, gridY);
  }

  public JTextField getjTextField() {
    return jTextField;
  }

  public String getValue(){
    return jTextField.getText();
  }

  private void printTextField(JPanel jPanel, int x, int y){
    jPanel.add(jTextField, createConstraints(x, y, 1, 1));
  }
}
