package com.priceminister.account;

/**
 * Checks if the requested operation is permitted.
 */
public interface AccountRule {
    
    /**
     * Checks if the resulting account balance after a withdrawal is OK
     * @param overdraft - the overdraft if authorized
     * @param resultingAccountBalance - the amount resulting of the withdrawal
     * @return true if the operation is permitted, false otherwise
     */
    boolean withdrawPermitted(Double resultingAccountBalance,Double overdraft);
}
