package bank;

import java.math.BigDecimal;

public class CorporateAccount extends Account{
    public CorporateAccount(BigDecimal balance, String... owner){
        super(balance, owner);
    }

    @Override
    /**{@inheritDoc} */
    protected boolean withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
        return true;
    }
}
