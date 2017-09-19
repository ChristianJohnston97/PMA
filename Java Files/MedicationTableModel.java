package main;
import java.util.List;
import main.Medication;
import javax.swing.table.AbstractTableModel;


public class MedicationTableModel extends AbstractTableModel {
	
	private static final int pharmaceuticalCompany_COL = 0;
	private static final int medication_COL = 1;
	private static final int strength_COL = 2;
	private static final int barCode_COL = 3;
	private static final int noInPack_COL = 4;
	
	private String[] colomnNames = {"Pharmaceutical Company", "Medication", "Strength(mg)",
			"Bar Code", "No. tablets in packet" };
	
	private List<Medication> medication;
	
	public MedicationTableModel(List<Medication> theMedication)
	{
		medication = theMedication;
	}
	
	@Override
	public int getRowCount() {
		return medication.size();
	}

	@Override
	public int getColumnCount() {
		return colomnNames.length;
	}
	
	@Override
	public String getColumnName(int col) {
		return colomnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Medication tempMed = medication.get(row);

		switch (col) {
		case pharmaceuticalCompany_COL:
			return tempMed.getPharmaceuticalCompany();
		case medication_COL:
			return tempMed.getMedication();
		case strength_COL:
			return tempMed.getStrength();
		case barCode_COL:
			return tempMed.getBarCode();
		case noInPack_COL:
			return tempMed.getNoInPacket();
		default:
			return tempMed.getMedication();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
}
}
