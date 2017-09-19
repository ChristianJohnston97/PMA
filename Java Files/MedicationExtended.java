package main;

import java.math.BigDecimal;

public class MedicationExtended {

	private String pharmaceuticalCompany;
	private String medication;
	private double weeklyDosage;
	
	
	public MedicationExtended(String pharmaceuticalCompany, String medication, double weeklyDosage)
	{
		super();
		this.pharmaceuticalCompany = pharmaceuticalCompany;
		this.medication = medication;
		this.weeklyDosage = weeklyDosage;	
	}

	public String getPharmaceuticalCompany() {
		return pharmaceuticalCompany;
	}

	public void setPharmaceuticalCompany(String pharmaceuticalCompany) {
		this.pharmaceuticalCompany = pharmaceuticalCompany;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public double getWeeklyDosage() {
		return weeklyDosage;
	}

	public void setWeeklyDosage(double weeklyDosage) {
		this.weeklyDosage = weeklyDosage;
	}

	@Override
	public String toString() {
		return String
				.format("Medication [pharmaceuticalCompany=%s, medication=%s, weeklyDosage=%s]",
						pharmaceuticalCompany, medication, weeklyDosage);
	}
}
