package buttons;

import actions.ResultButtonActions;
import constraints.Constraints;
import textfields.AttributeTextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;

public class ResultButton implements Constraints, ResultButtonActions {
  private JFrame jFrameResult;
  private JButton jButton;

  public ResultButton(JPanel jPanel, int gridX, int gridY, JRadioButton[] radioButtons,
                      AttributeTextField fieldName, AttributeTextField fieldPrice, Connection connectionToBD) {
    this.jFrameResult = new JFrame();
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension dimension = toolkit.getScreenSize();
    jFrameResult.setBounds(dimension.width / 2 + 350, dimension.height / 2 - 250, 500, 300);
    jFrameResult.setDefaultCloseOperation(jFrameResult.HIDE_ON_CLOSE);
    jButton = new JButton("Result");
    jButton.addActionListener(createActionButtonResult(radioButtons, fieldName, fieldPrice, connectionToBD));
    printButton(jPanel, gridX, gridY);
  }

  private ActionListener createActionButtonResult(JRadioButton[] radioButtons, AttributeTextField fieldName, AttributeTextField fieldPrice, Connection connectionToBD) {
    return actionEvent -> {
      JPanel jPanel = new JPanel();

      if (radioButtons[0].isSelected()) {
        try {
          createActionAdd(jPanel, fieldName.getValue(), Double.parseDouble(fieldPrice.getValue()), connectionToBD);
        } catch (NumberFormatException e) {
          createErrorDialogs(jPanel, "incorrect number");
        }
      } else if (radioButtons[1].isSelected()) {
        try {
          createActionChangePrice(jPanel, fieldName.getValue(), Double.parseDouble(fieldPrice.getValue()), connectionToBD);
        } catch (NumberFormatException e) {
          createErrorDialogs(jPanel, "incorrect number");
        }
      } else if (radioButtons[2].isSelected()) {
        createActionForShowAll(jFrameResult, connectionToBD);
      } else if (radioButtons[3].isSelected()) {
        createActionGetPrice(jPanel, fieldName.getValue(), connectionToBD);
      } else if (radioButtons[4].isSelected()) {
        createActionDelete(jPanel, fieldName.getValue(), connectionToBD);
      } else if (radioButtons[5].isSelected()) {
        try {
          createActionFilterByPrice(jFrameResult, Double.parseDouble(fieldName.getValue()), Double.parseDouble(fieldPrice.getValue()), connectionToBD);
        } catch (NumberFormatException e) {
          createErrorDialogs(jPanel, "incorrect number");
        }
      }
    };
  }

  private void printButton(JPanel jPanel, int gridX, int gridY) {
    jPanel.add(jButton, createConstraints(gridX, gridY, 1, 2));
  }
}
