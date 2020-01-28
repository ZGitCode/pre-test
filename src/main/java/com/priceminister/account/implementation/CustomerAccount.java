package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

	Double balance ;
	Double overdraft ;
	
    public CustomerAccount(Double overdraft) {
    	this.balance = new Double(0.0);
    	this.overdraft = overdraft;
	}

	public void add(Double addedAmount) {
        if(addedAmount != null && addedAmount>0)
        {
        	this.balance = getBalance()+addedAmount;
        }
    }

    public Double getBalance() {
        return this.balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) 
    		throws IllegalBalanceException {
    	
    	Double resultingAccountBalance = getBalance() - withdrawnAmount;
        
    	if(rule.withdrawPermitted(resultingAccountBalance, getOverdraft()))
        {
        	this.balance = resultingAccountBalance;
        	return getBalance();
        }
        else
        {	
        	throw new IllegalBalanceException(resultingAccountBalance);
        }
    }

	public Double getOverdraft() {
		return this.overdraft;
	}

}
