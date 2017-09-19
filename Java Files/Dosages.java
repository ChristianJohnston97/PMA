package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

import testing.Driver;
import main.Medication;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;



public class Dosages extends JFrame {

	private JPanel contentPane;
	private Driver driver;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dosages frame = new Dosages();
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
	public Dosages() {
		
		try{
			driver = new Driver();
		}
		catch(Exception exc)
		{
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		setTitle("Weekly Dosages");
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
		button.setBounds(226, 232, 183, 29);
		contentPane.add(button);
		
		JButton btnClickToCalculate = new JButton("Load!");
		btnClickToCalculate.setBackground(Color.green);
		btnClickToCalculate.setOpaque(true);
		btnClickToCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<MedicationExtended> medicationExtended = null;
					medicationExtended = driver.getMedicationDosage();
					
					List<Double> weeklyDosages = null;
					weeklyDosages = driver.getDosages(4);
										
					int i=0;
					for(MedicationExtended tempMedication : medicationExtended)
					{
						double weeklyDosageReal = weeklyDosages.get(i);
						tempMedication.setWeeklyDosage(weeklyDosageReal);
						i++;
					}
					
					DosageTableModel model = new DosageTableModel(medicationExtended);
					table.setModel(model);
				} 
				
				catch (SQLException e2) {
					JOptionPane.showMessageDialog(Dosages.this, "Error: " + e2, "Error", JOptionPane.ERROR_MESSAGE); 
					e2.printStackTrace();
				}
			}
		});
		btnClickToCalculate.setBounds(293, 18, 137, 44);
		contentPane.add(btnClickToCalculate);
		
		JLabel lblClickToCalculate = new JLabel("Click to calculate weekly dosages in mg:");
		lblClickToCalculate.setBounds(17, 14, 291, 50);
		contentPane.add(lblClickToCalculate);
		
		table = new JTable();
		//table.setBounds(18, 76, 412, 138);
		//contentPane.add(table);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 72, 403, 142);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);

	}
}
