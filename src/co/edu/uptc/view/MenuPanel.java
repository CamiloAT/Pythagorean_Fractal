package co.edu.uptc.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class MenuPanel extends JPanel{

	private FractalPanel fractalPanel;
	private JLabel text1;
	private JLabel text2;
	private JTextField textField;
	private JButton button;
	private JPanel superiorPanel;
	private JPanel inferiorPanel;
	private JPanel emptyPanel;
	private JPanel cardLayout;
	private CardLayout card;

	public MenuPanel(ActionListener actionListener) {
		this.initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.setLayout(null);
		superiorPanel = new JPanel();
		superiorPanel.setBackground(new Color(82, 184, 255));
		superiorPanel.setBounds(0, 0, 900, 50);
		add(superiorPanel);

		inferiorPanel = new JPanel();
		inferiorPanel.setBackground(new Color(82, 184, 255));
		inferiorPanel.setBounds(0, 530, 900, 100);
		add(inferiorPanel);

		text1 = new JLabel("Ingrese el numero");
		text1.setForeground(new Color(5, 47, 77));
		text1.setFont(new Font("Monospaced", Font.PLAIN, 25));
		text1.setBounds(50, 150, 350, 50);
		add(text1);

		text2 = new JLabel("de iteraciones:");
		text2.setForeground(new Color(5, 47, 77));
		text2.setFont(new Font("Monospaced", Font.PLAIN, 25));
		text2.setBounds(50, 180, 350, 50);
		add(text2);

		textField = new JTextField();
		textField.setBorder(new MatteBorder(3, 3, 3, 3, new Color(5, 47, 77)));
		textField.setFont(new Font("Monospaced", Font.PLAIN, 25));
		textField.setBounds(50, 240, 200, 50);
		add(textField);

		button = new JButton("Comenzar");
		button.setBorder(new MatteBorder(3, 3, 3, 3, new Color(5, 47, 77)));
		button.setBackground(new Color(142, 209, 255));
		button.setFont(new Font("Monospaced", Font.PLAIN, 25));
		button.setActionCommand("Start");
		button.addActionListener(actionListener);
		button.setBounds(50, 310, 200, 50);
		add(button);

		card = new CardLayout();
		cardLayout = new JPanel(card);
		emptyPanel = new JPanel();
		emptyPanel.setBorder(new MatteBorder(5, 5, 5, 5, new Color(5, 47, 77)));
		cardLayout.add(emptyPanel, "Vacio");
		cardLayout.setBounds(400, 60, 450, 450);
		card.show(cardLayout, "Vacio");
		add(cardLayout);

	}

	public void initFractalPanel() {
		fractalPanel = new FractalPanel(Integer.parseInt(textField.getText()));
		fractalPanel.setBorder(new MatteBorder(5, 5, 5, 5, new Color(5, 47, 77)));
		cardLayout.add(fractalPanel, "Lleno");
		card.show(cardLayout, "Lleno");
		cardLayout.revalidate();
		cardLayout.repaint();
	}
	
	public int getIntValue() {
		return Integer.parseInt(textField.getText());
	}
}
