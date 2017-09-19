package main;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.Font;
import java.awt.Image;



public class Frame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Hello Medical User!");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Personal Medication Advisor (PMA)");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewLabel.setBounds(89, 6, 301, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Display my medication");
		btnNewButton.setBackground(Color.green);
		btnNewButton.setOpaque(true);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DisplayMedication info = new DisplayMedication();
				info.setVisible(true);
			}
		});
		btnNewButton.setBounds(221, 70, 192, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add new medication");
		btnNewButton_1.setBackground(Color.green);
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InputMyMedication input = new InputMyMedication();
				input.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(221, 133, 192, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnMyDosages = new JButton("My Weekly dosages");
		btnMyDosages.setBackground(Color.green);
		btnMyDosages.setOpaque(true);
		btnMyDosages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Dosages dose = new Dosages();
				dose.setVisible(true);
			}
		});
		btnMyDosages.setBounds(221, 200, 192, 40);
		frame.getContentPane().add(btnMyDosages);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(38, 117, 158, 137);
		Image img = new ImageIcon(this.getClass().getResource("/pill1.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPleaseSelectWhich = new JLabel("Please select which service ");
		lblPleaseSelectWhich.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblPleaseSelectWhich.setBounds(16, 40, 254, 64);
		frame.getContentPane().add(lblPleaseSelectWhich);
		
		JLabel lblYouWouldLike = new JLabel("you would like:");
		lblYouWouldLike.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblYouWouldLike.setBounds(16, 67, 254, 64);
		frame.getContentPane().add(lblYouWouldLike);
		
	

	}
}
