package buttons;

import constraints.Constraints;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton implements Constraints {

  public ExitButton(JPanel jPanel, int gridX, int gridY){
    JButton jButton = new JButton("Exit");
    jButton.addActionListener(createActionListener());
    jPanel.add(jButton, createConstraints(gridX, gridY, 1, 2));
  }

  private ActionListener createActionListener(){
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
      }
    };
  }

}
