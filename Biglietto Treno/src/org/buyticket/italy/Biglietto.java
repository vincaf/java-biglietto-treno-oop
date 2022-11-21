package org.buyticket.italy;

import java.math.BigDecimal;

public class Biglietto {
	
	private int userKm = 0;
	private int userAge = 0;
	
	private static final BigDecimal PRICE_FOR_KM = new BigDecimal(0.21);
	private static final BigDecimal OVER_65_DISCOUNT = new BigDecimal(0.6);
	private static final BigDecimal YOUNG_DISCOUNT = new BigDecimal(0.8);
	
	Biglietto(int userKm, int userAge, boolean flexible) throws Exception{
		isValidKm(userKm);
		isValidEta(userAge);
	}

	public int getUserKm() {
		return userKm;
	}

	public void setUserKm(int userKm) {
		this.userKm = userKm;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
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
	
	public void isValidKm(int km) throws Exception {
		if(km < 0) {
			throw new Exception("Kilometers must be positive number");
		} else {
			this.userKm = km;
		}
	}
	
	public void isValidEta(int eta) throws Exception {
		if (eta <= 0) {
			throw new Exception("Age must be positive and not equal to 0");
		} else {
			this.userAge = eta;
		}
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
		return getDiscount().multiply(BigDecimal.valueOf(userKm));
	}
	
	public String getTicketPriceFormatted() {
		double priceToDouble = getTicketPrice().doubleValue();
		return String.format("%.2f", priceToDouble);
	}
	
	@Override
    public String toString() {
    	return "Km: " + getUserKm()
    			+ "\nEtà: " + getUserAge()
                + "\nPrezzo: " + getTicketPriceFormatted() + "€";
    }
}
