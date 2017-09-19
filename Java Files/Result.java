package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Result extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Result() {
		setTitle("Drug-Drug Interaction");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Back to main page");
		button.setBackground(Color.red);
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				Frame.main(null);
			}
		});
		button.setBounds(232, 219, 183, 29);
		contentPane.add(button);
		
		JButton btnDisplayMyMedication = new JButton("Display my medication");
		btnDisplayMyMedication.setBackground(Color.green);
		btnDisplayMyMedication.setOpaque(true);
		btnDisplayMyMedication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DisplayMedication display = new DisplayMedication();
				display.setVisible(true);
			}
		});
		btnDisplayMyMedication.setBounds(37, 219, 183, 29);
		contentPane.add(btnDisplayMyMedication);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/traffic-lights-red-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(48, 19, 32, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNegativeDrugdrugInteractions = new JLabel("Potential Negative Drug-Drug Interactions");
		lblNegativeDrugdrugInteractions.setBounds(108, 19, 294, 50);
		contentPane.add(lblNegativeDrugdrugInteractions);
		
		JTextArea txtrNewDrugHas = new JTextArea();
		txtrNewDrugHas.setText("New drug has been added to your list of medication. \n\nHowever there is a potential negative drug-drug interaction \nwith another drug you are taking.\n\nPlease consult your doctor before taking.\n\n");
		txtrNewDrugHas.setBounds(37, 87, 383, 113);
		contentPane.add(txtrNewDrugHas);
	}

}
