package paint.panels;

import net.miginfocom.swing.MigLayout;
import paint.MainFrame;
import paint.Tool;
import paint.tools.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Max on 5/3/2015.
 */
public class ToolPanel extends JPanel {
    public boolean fillIsTrue;

    private Tool currentTool;
    private JSlider slider;
    private JTextField jTextField;
    private JCheckBox jCheckBox;

    public ToolPanel(MainFrame mainFrame) {
        super(new MigLayout());
        this.setBackground(new Color(255, 150, 0, 132));
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        Font font = new Font("Arial", Font.BOLD, 40);
        JLabel buttonLabel = new JLabel("Tools");
        buttonLabel.setFont(font);

        this.add(buttonLabel, "wrap");

//        this.add(new JButton("Test 1"));

        JButton pencilButton = new JButton("Pencil");
        pencilButton.setMnemonic(KeyEvent.VK_P);
        pencilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentTool(new Pencil());
            }
        });

        JButton brushButton = new JButton("Paint Brush");
        brushButton.setMnemonic(KeyEvent.VK_B);
        brushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentTool(new PaintBrush());
            }
        });

        JButton lineTool = new JButton("Line Tool");
        lineTool.setMnemonic(KeyEvent.VK_L);
        lineTool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentTool(new LineTool());
            }
        });

        JButton rectTool = new JButton("Rect Tool");
        rectTool.setMnemonic(KeyEvent.VK_R);
        rectTool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentTool(new RectTool());
            }
        });

        JButton circTool = new JButton("Circle Tool");
        circTool.setMnemonic(KeyEvent.VK_C);
        circTool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentTool(new CircTool());
            }
        });

        JButton textTool = new JButton("Text Tool");
        textTool.setMnemonic(KeyEvent.VK_T);
        textTool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentTool(new TextTool());
            }
        });

        JButton clearButton = new JButton("Clear Button");
        clearButton.setMnemonic(KeyEvent.VK_C);
        clearButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().getDrawPanel().clearImage();
            }
        });


        slider = new JSlider();

        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setLabelTable(slider.createStandardLabels(10));

        jTextField = new JTextField(20);

        jCheckBox = new JCheckBox("Fill Shape");
        jCheckBox.setSelected(false);


        jCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JCheckBox cb = (JCheckBox) event.getSource();
                if (cb.isSelected()) {
                    fillIsTrue = true;
                }
            }
        });


        this.add(pencilButton);
        this.add(brushButton);
        this.add(lineTool);
        this.add(rectTool);
        this.add(circTool);
        this.add(textTool);
        this.add(clearButton);
        this.add(jTextField, "span");
        this.add(slider, "span");
        this.add(jCheckBox);

        // Default tool
        setCurrentTool(new Pencil());

    }

    public boolean getFillIsTrue() {
        return fillIsTrue;
    }

    public String getCurrentText() {
        return jTextField.getText() + "\n";
    }

    public Integer getBrushSize() {
        return slider.getValue();
    }

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }
}
