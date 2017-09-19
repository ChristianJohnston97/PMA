package main;
import java.awt.BorderLayout;
import java.awt.Color;

import testing.Driver;
import main.Medication;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DisplayMedication extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Driver driver;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayMedication frame = new DisplayMedication();
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
	public DisplayMedication() {
		
		try{
			driver = new Driver();
		}
		catch(Exception exc)
		{
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		setTitle("Display Medication");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JButton btnNewButton = new JButton("Back to main page");
		btnNewButton.setBackground(Color.red);
		btnNewButton.setOpaque(true);
		btnNewButton.setBounds(238, 233, 183, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				Frame.main(null);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add New Medication");
		btnNewButton_1.setBackground(Color.green);
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBounds(16, 233, 198, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InputMyMedication input = new InputMyMedication(DisplayMedication.this, driver);
				input.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 438, 178);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnCalculateDosages = new JButton("Calculate Dosages");
		btnCalculateDosages.setBackground(Color.green);
		btnCalculateDosages.setOpaque(true);
		btnCalculateDosages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Dosages dose = new Dosages();
				dose.setVisible(true);
			}
		});
		btnCalculateDosages.setBounds(238, 192, 183, 29);
		contentPane.add(btnCalculateDosages);
		
		JButton btnNewButton_2 = new JButton("Click to load medication");
		btnNewButton_2.setBackground(Color.green);
		btnNewButton_2.setOpaque(true);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					List<Medication> medication = null;
					
					medication = driver.getMedication();
					
					MedicationTableModel model = new MedicationTableModel(medication);
					table.setModel(model);		
					
					//This code highlights an individual column
					
					//table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				    //table.setColumnSelectionAllowed(true);
				    //table.setRowSelectionAllowed(false);
				    // Select a column - column 0
				    //table.setColumnSelectionInterval(0, 0);
				} 
				
				catch (SQLException e2) {
					JOptionPane.showMessageDialog(DisplayMedication.this, "Error: " + e2, "Error", JOptionPane.ERROR_MESSAGE); 
					e2.printStackTrace();
				}				
			}
		});
		btnNewButton_2.setBounds(16, 192, 198, 29);
		contentPane.add(btnNewButton_2);
	}
	public void refreshMedList() {

		try {
			System.out.println("Get Medication");
			List<Medication> medication = driver.getMedication();
			System.out.println("Got Medication");
			System.out.println(medication);

			// create the model and update the "table"
			MedicationTableModel model = new MedicationTableModel(medication);

			table.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
