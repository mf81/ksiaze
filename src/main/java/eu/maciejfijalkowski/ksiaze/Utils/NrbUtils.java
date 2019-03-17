package eu.maciejfijalkowski.ksiaze.Utils;

import java.math.BigInteger;

public class NrbUtils {

    private String accountNumber;
    private String oryginalAccountNumber;

    public NrbUtils() {
    }

    public NrbUtils(String accountNumber) {
        setAccountNumber(accountNumber);
    }

    public Boolean correctAccountNumber() {
        if (oryginalAccountNumber.matches("[0-9]+") && oryginalAccountNumber.length() == 26)
            return oryginalAccountNumber.equals(getAccountNumber());
        return false;
    }

    public String getAccountNumber() {
        return nrbGenerator() + accountNumber;
    }

    public String getAccountNumberWithSpaces() {
        String string = nrbGenerator() + " " + accountNumber.replaceAll("....", "$0 ");
        return string.substring(0, string.length() - 1);
    }

    public String getAccountNumberNoNrbNoWhiteSpaces() {
        return accountNumber;
    }

    public void setAccountNumber(String account) {
        String accountNumber = account.replaceAll("\\s+", "");
        String oryginalAccountNumber = account.replaceAll("\\s+", "");
        if (oryginalAccountNumber.length() == 26) accountNumber = accountNumber.substring(2);

        if (oryginalAccountNumber.matches("[0-9]+") && oryginalAccountNumber.length() == 26) {
            this.accountNumber = accountNumber;
            this.oryginalAccountNumber = oryginalAccountNumber;
        } else {
            this.accountNumber = "";
            this.oryginalAccountNumber = "";
        }
    }

    public String nrbGenerator() {
        BigInteger numberAccount, moduloNumber, constNumber, lowerNumber;
        numberAccount = new BigInteger(accountNumber + "252100");
        moduloNumber = numberAccount.mod(new BigInteger("97"));
        constNumber = BigInteger.valueOf(98);

        if ((BigInteger.valueOf(9).compareTo(constNumber.subtract(moduloNumber)) >= 0)) {
            return "0" + constNumber.subtract(moduloNumber).toString();

        }
        return constNumber.subtract(moduloNumber).toString();


    }

}