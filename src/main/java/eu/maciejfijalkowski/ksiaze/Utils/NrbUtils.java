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

    public Boolean correctAccountNumber(){
        if (oryginalAccountNumber.matches("[0-9]+") && oryginalAccountNumber.length() == 26)
            return oryginalAccountNumber.equals(getAccountNumber());
        return false;
    }

    public String getAccountNumber() {
        return nrbGenerator()+accountNumber;
    }

    public String getAccountNumberWithSpaces(){
        return nrbGenerator()+" "+accountNumber.replaceAll("....", "$0 ");
    }

    public String getAccountNumberNoNrb() {
        return accountNumber.substring(2);
    }

    public void setAccountNumber(String account) {
        String accountNumber = account.replaceAll("\\s+","");
        String oryginalAccountNumber = account.replaceAll("\\s+","");
        if(oryginalAccountNumber.length()==26) accountNumber=accountNumber.substring(2);

        if (oryginalAccountNumber.matches("[0-9]+") && oryginalAccountNumber.length() == 26){
            this.accountNumber = accountNumber;
            this.oryginalAccountNumber = oryginalAccountNumber;
        }
        else{
            this.accountNumber="";
            this.oryginalAccountNumber="";
        }
    }

    private String nrbGenerator (){
            BigInteger numberAccount,moduloNumber,constNumber,lowerNumber;
            numberAccount = new BigInteger(accountNumber+"252100");
            moduloNumber = numberAccount.mod(new BigInteger("97"));
            constNumber = BigInteger.valueOf(98);

            if ((BigInteger.valueOf(9).compareTo(constNumber.subtract(moduloNumber)) >= 0)) {
                return "0" + constNumber.subtract(moduloNumber).toString();

            }
            return constNumber.subtract(moduloNumber).toString();


    }

    public static void main(String[] args) {

//        NrbUtils nrbUtils = new NrbUtils();
//        nrbUtils.setAccountNumber("62114020040000340230589876");

        System.out.println(new NrbUtils("62114020040000340230589876").correctAccountNumber());
        System.out.println(" ");
        System.out.println(new NrbUtils("06 1320 0022 0169 0021 0464 0045").correctAccountNumber());
        System.out.println(" ");
        System.out.println(new NrbUtils("10 1020 4274 2029 0012 0198 0112").correctAccountNumber());

        System.out.println(" ");
        System.out.println(new NrbUtils("11 1320 0022 0169 0022 0249 0063").correctAccountNumber());

        //        System.out.println(nrbUtils.getAccountNumberWithSpaces());
//        System.out.println(nrbUtils.correctAccountNumber());
    }
}