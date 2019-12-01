package com.ss.utopia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ss.utopia.entity.CardInfo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;


@Entity 
@Table(name = "cardInfo", schema = "utopia")
public class CardInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8701877991019898571L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cardNumber", updatable = false, unique = true, nullable = false)
	private String cardNumber;
	
	@Column(name = "expirationDate")
	private Timestamp expirationDate;
	
	@Column(name = "cvv")
	private Integer cvv;
	
	@Column(name = "cardHolderName")
	private String cardHolderName;
	
	@OneToMany(mappedBy = "cardInfo")
	private Collection<User> Users;	
	
	public CardInfo() {}
	
	public CardInfo(String cardNumber, Timestamp expirationDate, Integer cvv, String cardHolderName) {
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
		this.cardHolderName = cardHolderName;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the expirationDate
	 */
	public Timestamp getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the cvv
	 */
	public Integer getCvv() {
		return cvv;
	}

	/**
	 * @param cvv the cvv to set
	 */
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	/**
	 * @return the cardHolderName
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}

	/**
	 * @param cardHolderName the cardHolderName to set
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	/**
	 * @return the users
	 */
	public Collection<User> getUsers() {
		return Users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Collection<User> users) {
		Users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Users == null) ? 0 : Users.hashCode());
		result = prime * result + ((cardHolderName == null) ? 0 : cardHolderName.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + ((cvv == null) ? 0 : cvv.hashCode());
		result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardInfo other = (CardInfo) obj;
		if (Users == null) {
			if (other.Users != null)
				return false;
		} else if (!Users.equals(other.Users))
			return false;
		if (cardHolderName == null) {
			if (other.cardHolderName != null)
				return false;
		} else if (!cardHolderName.equals(other.cardHolderName))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cvv == null) {
			if (other.cvv != null)
				return false;
		} else if (!cvv.equals(other.cvv))
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		return true;
	}


}
