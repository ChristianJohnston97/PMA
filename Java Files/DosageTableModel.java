package main;
import java.util.List;
import main.MedicationExtended;
import javax.swing.table.AbstractTableModel;


public class DosageTableModel extends AbstractTableModel {
	
	private static final int PHARMACEUTICAL_COMPANY_COL = 0;
	private static final int MECIATION_COL = 1;
	private static final int WEEKLY_DOSAGE_COL = 2;
	
	private String[] colomnNames = {"Pharmaceutical Company", "Medication", "Weekly Dosage (mg)" };
	
	private List<MedicationExtended> medication;
	
	public DosageTableModel(List<MedicationExtended> medicationDosage)
	{
		medication = medicationDosage;
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

		MedicationExtended tempMed = medication.get(row);

		switch (col) {
		case PHARMACEUTICAL_COMPANY_COL:
			return tempMed.getPharmaceuticalCompany();
		case MECIATION_COL:
			return tempMed.getMedication();
		case WEEKLY_DOSAGE_COL:
			return tempMed.getWeeklyDosage();
		default:
			return tempMed.getMedication();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
}
}
