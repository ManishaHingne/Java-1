package org.sunbeam.dac.test;

public class Account implements Comparable<Account>
{
	private int accountNumber;
	private String accountType;
	private float balance;
	public Account() 
	{	}
	public Account(int accountNumber, String accountType, float balance) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	@Override
	public int compareTo(Account other) 
	{
		return this.accountNumber - other.accountNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
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
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		return true;
	}
	@Override
	public String toString() 
	{
		return String.format("%-5d%-10s%-10.2f", this.accountNumber, this.accountType, this.balance);
	}
}
