package com.priceminister.account;

import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    Account customerAccount;
    AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount(null);
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
    	assertEquals("account balance is null or not equals to zero",customerAccount.getBalance(),new Double(0.0));
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
        Double moneyToAdd = new Double(500);
        Double newBalance = customerAccount.getBalance() + moneyToAdd;
        
        customerAccount.add(moneyToAdd);
        
        assertEquals("the new balance is not as expected" , customerAccount.getBalance() , newBalance );
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test
    public void testWithdrawAndReportBalanceIllegalBalance() {
        CustomerAccountRule rule = new CustomerAccountRule();
        customerAccount.add(new Double(500));
        try {
        	customerAccount.withdrawAndReportBalance(new Double(200),rule);
        }catch(IllegalBalanceException e)
        {
        	fail(e.getMessage());
        }
        
        
    }
    

}
