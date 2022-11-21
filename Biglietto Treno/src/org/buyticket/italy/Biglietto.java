package org.buyticket.italy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Biglietto {
	
	private int userKm = 0;
	private int userAge = 0;
	private LocalDate date;
	private boolean flexible;
	
	private static final BigDecimal PRICE_FOR_KM = new BigDecimal(0.21);
	private static final BigDecimal OVER_65_DISCOUNT = new BigDecimal(0.6);
	private static final BigDecimal YOUNG_DISCOUNT = new BigDecimal(0.8);
	private static final BigDecimal FLEXIBLE_PRICE = new BigDecimal(1.10);
	private static int NORMAL = 30;
	private static int FLEXIBLE = 90;
	
	Biglietto(int userKm, int userAge, boolean flexible) throws Exception{
		setUserKm(userKm);
		setUserAge(userAge);
		this.date = LocalDate.now();
		this.flexible = flexible;
	}

	public int getUserKm() {
		return userKm;
	}

	public void setUserKm(int userKm) throws Exception{
		if(isValidKm(userKm)) {
			throw new Exception("Kilometers must be positive number");
		}
		this.userKm = userKm;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) throws Exception{
		if(isValidEta(userAge)) {
			throw new Exception("L'età deve essere maggiore di 0");
		}
		this.userAge = userAge;
	}
	
	public static BigDecimal getPriceForKm() {
		return PRICE_FOR_KM;
	}
	
	public static BigDecimal getOver65Discount() {
		return OVER_65_DISCOUNT;
	}
	
	public static BigDecimal getYoungDiscount() {
		return YOUNG_DISCOUNT;
	}
	
	private boolean isValidKm(int km) {
        return km<0;
	}
	
	private boolean isValidEta(int eta) {
		return eta<0;
	}
	
	private BigDecimal getDiscount() {
		if(userAge < 18) {
			return YOUNG_DISCOUNT.multiply(PRICE_FOR_KM);
		} else if(userAge > 65) {
			return OVER_65_DISCOUNT.multiply(PRICE_FOR_KM);
		} else {
			return PRICE_FOR_KM;
		}
	}
	
	public BigDecimal getTicketPrice() {
		if(flexible) {
			return getDiscount().multiply(BigDecimal.valueOf(userKm).multiply(FLEXIBLE_PRICE));			
		} else {
			return getDiscount().multiply(BigDecimal.valueOf(userKm));
		}
	}
	
	public String getTicketPriceFormatted() {
		double priceToDouble = getTicketPrice().doubleValue();
		return String.format("%.2f", priceToDouble);
	}
	
	public LocalDate getExpirationDate() {
		if(flexible) {
			return date.plusDays(FLEXIBLE);
		} else {
			return date.plusDays(NORMAL);
		}
	}
	
	@Override
    public String toString() {
    	return "Km: " + getUserKm()
    			+ "\nEtà: " + getUserAge()
                + "\nPrezzo: " + getTicketPriceFormatted() + "€"
                + "\nBiglietto flessibile: " + (flexible ? "si" : "no")
                + "\nData di scadenza biglietto: " + getExpirationDate();
    }
}
