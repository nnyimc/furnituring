package fr.nnyimc.test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class SwingTest {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Cr�ation et d�finition du frame
		JFrame jframe = new JFrame("Current Time");
		jframe.setLayout(new GridLayout(4,3));
		
		// Cr�ation du label suivi de son ajout � la frame
		final JLabel clockLabel = new JLabel("", JLabel.CENTER);
		jframe.add(clockLabel);
		
		// Cr�ation et ajout du button � la frame
		JButton clockButton = new JButton("Unveil time");
		jframe.add(clockButton);
		
		//Mise en place du listener pour le clockButton
		clockButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent actionEvent) {
						clockLabel.setText(String.format("%tT", new Date()));
					}
				}
		);
		
		jframe.pack();
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
