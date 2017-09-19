package main;

import java.math.BigDecimal;

public class Medication {

	private String pharmaceuticalCompany;
	private String medication;
	private double strength;
	private BigDecimal barCode;
	private int noInPacket;
	
	public Medication(String pharmaceuticalCompany, String medication, double strength, BigDecimal barCode,
			int noInPacket) {
		super();
		this.pharmaceuticalCompany = pharmaceuticalCompany;
		this.medication = medication;
		this.strength = strength;
		this.barCode = barCode;
		this.noInPacket = noInPacket;
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

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	public BigDecimal getBarCode() {
		return barCode;
	}

	public void setBarCode(BigDecimal barCode) {
		this.barCode = barCode;
	}

	public int getNoInPacket() {
		return noInPacket;
	}
	
	public void setNoInPacket(int noInPacket) {
		this.noInPacket = noInPacket;
	}

	@Override
	public String toString() {
		return String
				.format("Medication [pharmaceuticalCompany=%s, medication=%s, strength=%s, barCode=%s, noInPacket=%s]",
						pharmaceuticalCompany, medication, strength, barCode, noInPacket);
	}
}
