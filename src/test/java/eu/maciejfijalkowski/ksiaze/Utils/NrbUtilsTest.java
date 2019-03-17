package eu.maciejfijalkowski.ksiaze.Utils;

import eu.maciejfijalkowski.ksiaze.Main;
import org.junit.Test;

import static org.junit.Assert.*;

public class NrbUtilsTest extends Main {

    NrbUtils nrbUtils = new NrbUtils();

    @Test
    public void correctAccountNumber() {
        nrbUtils.setAccountNumber("11 1320 0022 0169 0022 0249 0063");
        assertEquals(true,nrbUtils.correctAccountNumber());
    }

    @Test
    public void getAccountNumberWithSpaces() {
        nrbUtils.setAccountNumber("11 1320 0022 0169 0022 0249 0063");
        assertEquals("11 1320 0022 0169 0022 0249 0063",nrbUtils.getAccountNumberWithSpaces());
    }

    @Test
    public void getAccountNumberNoNrb() {
        nrbUtils.setAccountNumber("11 1320 0022 0169 0022 0249 0063");
        assertEquals("132000220169002202490063",nrbUtils.getAccountNumberNoNrbNoWhiteSpaces());

    }

    @Test
    public void nrbGenerator() {
        nrbUtils.setAccountNumber("11 1320 0022 0169 0022 0249 0063");
        assertEquals("11",nrbUtils.nrbGenerator());
    }

    @Test
    public void nrbGenerator2() {
        nrbUtils.setAccountNumber("10 1020 4274 2029 0012 0198 0112");
        assertEquals("10",nrbUtils.nrbGenerator());
    }

    @Test
    public void nrbGeneratorZeroPasses() {
        nrbUtils.setAccountNumber("06 1320 0022 0169 0021 0464 0045");
        assertEquals("06",nrbUtils.nrbGenerator());
    }

    @Test
    public void nrbGeneratorNoWhiteSpaces() {
        nrbUtils.setAccountNumber("06132000220169002104640045");
        assertEquals("06",nrbUtils.nrbGenerator());
    }

}