package constraints;

import java.awt.GridBagConstraints;

public interface Constraints {
  default GridBagConstraints createConstraints(int gridx, int gridy, int gridWidth, int gridHeight) {
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.weighty = 0;
    constraints.weightx = 0;
    constraints.gridx = gridx;
    constraints.gridy = gridy;
    constraints.gridwidth = gridWidth;
    constraints.gridheight = gridHeight;
    return constraints;
  }
}
