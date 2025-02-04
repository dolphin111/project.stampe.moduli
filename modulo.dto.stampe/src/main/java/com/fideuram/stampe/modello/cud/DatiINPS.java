package com.fideuram.stampe.modello.cud;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DatiINPS")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatiINPS {
 
	private INPSDipSubordinati inpsSub;
	private INPSDipPubblici inpsPub;
	private INPSCollaboratori inpsColl;
	
	
	public INPSDipSubordinati getInpsSub() {
		return inpsSub;
	}
	public void setInpsSub(INPSDipSubordinati inpsSub) {
		this.inpsSub = inpsSub;
	}
	public INPSDipPubblici getInpsPub() {
		return inpsPub;
	}
	public void setInpsPub(INPSDipPubblici inpsPub) {
		this.inpsPub = inpsPub;
	}
	public INPSCollaboratori getInpsColl() {
		return inpsColl;
	}
	public void setInpsColl(INPSCollaboratori inpsColl) {
		this.inpsColl = inpsColl;
	}


}
