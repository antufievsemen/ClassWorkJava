package buttons;

import constraints.Constraints;
import javafx.scene.control.RadioButton;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class CategoryRadioButtons implements Constraints {

  private ButtonGroup buttonGroup;
  private JRadioButton[] radioButtons;

  public CategoryRadioButtons(JPanel jPanel, int gridX, int gridY) {
    buttonGroup = new ButtonGroup();
    radioButtons = new JRadioButton[6];
    radioButtons[0] = createRadioButton("Add");
    radioButtons[1] = createRadioButton("ChangePrice");
    radioButtons[2] = createRadioButton("ShowAll");
    radioButtons[3] = createRadioButton("Price");
    radioButtons[4] = createRadioButton("Delete");
    radioButtons[5] = createRadioButton("FilterByPrice");
    for (int i = 0; i < 6; i++) {
      buttonGroup.add(radioButtons[i]);
    }
    printButtons(jPanel, gridX, gridY);
  }

  private JRadioButton createRadioButton(String name) {
    JRadioButton jRadioButton = new JRadioButton(name);
    return jRadioButton;
  }

  public JRadioButton[] getRadioButtons(){
    return radioButtons;
  }

  private void printButtons(JPanel jPanel, int gridX, int gridY) {
    jPanel.add(radioButtons[0], createConstraints(gridX, gridY++, 1, 1));
    jPanel.add(radioButtons[1], createConstraints(gridX, gridY++, 1, 1));
    jPanel.add(radioButtons[2], createConstraints(gridX, gridY++, 1, 1));
    jPanel.add(radioButtons[3], createConstraints(gridX, gridY++, 1, 1));
    jPanel.add(radioButtons[4], createConstraints(gridX, gridY++, 1, 1));
    jPanel.add(radioButtons[5], createConstraints(gridX, gridY, 1, 1));
  }
}
