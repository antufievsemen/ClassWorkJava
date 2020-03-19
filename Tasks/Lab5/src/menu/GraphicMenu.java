package menu;

import buttons.CategoryRadioButtons;
import buttons.ExitButton;
import buttons.ResultButton;
import database.products.ProductDataBase;
import javabean.FaceBean;
import textfields.AttributeTextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.Dimension;


public class GraphicMenu {

  private JFrame jFrameOfMenu;
  private JPanel jPanelOfMenu;
  private CategoryRadioButtons categoryRadioButtons;
  private AttributeTextField nameField;
  private AttributeTextField priceField;
  private ResultButton resultButton;
  private ExitButton exitButton;
  private FaceBean faceBean;


  public GraphicMenu(){
    ProductDataBase productDataBase = new ProductDataBase();
    jFrameOfMenu = getFrame();
    jPanelOfMenu = new JPanel();
    jFrameOfMenu.add(jPanelOfMenu);
    GridBagLayout gridBagLayout = new GridBagLayout();
    jPanelOfMenu.setLayout(gridBagLayout);
    categoryRadioButtons = new CategoryRadioButtons(jPanelOfMenu, 0, 0);
    nameField = new AttributeTextField(jPanelOfMenu, 3, 3, "NameOfProduct");
    priceField = new AttributeTextField(jPanelOfMenu, 5, 3, "CostProduct");
    exitButton = new ExitButton(jPanelOfMenu, 0, 15);
    resultButton = new ResultButton(jPanelOfMenu, 15, 15, categoryRadioButtons.getRadioButtons(), nameField, priceField, productDataBase.getConnectionToBD());
    jPanelOfMenu.revalidate();
    faceBean = new FaceBean();
    faceBean.setMouthWidth(50);
  }

  public JPanel getjPanelOfMenu() {
    return jPanelOfMenu;
  }

  public JFrame getjFrameOfMenu() {
    return jFrameOfMenu;
  }

  private JFrame getFrame(){
    JFrame jFrame = new JFrame();
    jFrame.setVisible(true);
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension dimension = toolkit.getScreenSize();
    jFrame.setBounds(dimension.width / 2 - 350, dimension.height / 2 - 250, 700, 500);
    jFrame.setDefaultCloseOperation(jFrameOfMenu.EXIT_ON_CLOSE);
    return jFrame;
  }
}

