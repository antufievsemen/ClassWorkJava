package buttons;

import constraints.Constraints;
import javabean.FaceBean;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Dimension;
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
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 350, dimension.height / 2 - 250, 700, 500);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        FaceBean faceBean = new FaceBean();
        faceBean.setMouthWidth(50);
        faceBean.frown();
        jFrame.add(faceBean);
        //System.exit(0);
      }
    };
  }

}
