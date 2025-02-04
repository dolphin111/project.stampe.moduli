package com.fideuram.stampe.modello.redditi.d2018.datiPrevidenziali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.ValidationException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068 Date: 18/01/16 Time: 11.55
 */
@XmlRootElement(name = "", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q19 extends AbstractQBase {
	private String c1;
	private String c2;
	private String c3;
	private Double c4;
	private Double c5;
	private Double c6;
	private char c7;
	private char[] c8; // 12 posizioni

	public Q19() {
	}

	public Q19(char c7) {
		this.c7 = c7;
	}

	public Q19(char[] c8) throws ValidationException {
		if (c8.length < 12)
			throw new ValidationException(
					"Q19 - Character[] c8 --- deve essere di docici elementi non uno di pi\u00F9 non uno di meno");
		this.c8 = c8;
	}

	public String getC1() {
		return c1 != null ? c1 : "";
	}

	public String getC2() {
		return c2 != null ? c2 : "";
	}

	public String getC3() {
		return c3 != null ? c3 : "";
	}

	public String getC4() {
		return formattedDouble2String(c4);
	}

	public String getC5() {
		return formattedDouble2String(c5);
	}

	public String getC6() {
		return formattedDouble2String(c6);
	}

	public char[] getC8() {
		return c8;
	}

	public void setC1(String c1) {
		this.c1 = c1;
	}

	public void setC2(String c2) {
		this.c2 = c2;
	}

	public void setC3(String c3) {
		this.c3 = c3;
	}

	public void setC4(Double c4) {
		this.c4 = c4;
	}

	public void setC5(Double c5) {
		this.c5 = c5;
	}

	public void setC6(Double c6) {
		this.c6 = c6;
	}

	/**
	 * restuisce tutto l'anno = true
	 * 
	 * @return
	 */
	public boolean isT() {
		return c8 != null ? false : true;
	}
}
