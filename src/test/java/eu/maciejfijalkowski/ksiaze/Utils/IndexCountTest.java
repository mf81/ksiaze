package eu.maciejfijalkowski.ksiaze.Utils;

import eu.maciejfijalkowski.ksiaze.Main;
import org.junit.Test;

import static org.junit.Assert.*;

public class IndexCountTest extends Main {
    IndexCount indexCount = IndexCount.getInstance();

    @Test
    public void count() {
        String count = indexCount.count("11 1320 0022 0169 0022 0249 0063");
        assertEquals("202490063",count );
    }

    @Test
    public void count2() {
        String count = indexCount.count("11132000220169002202490063");
        assertEquals("202490063",count );
    }

    @Test
    public void count3() {
        String count = indexCount.count("0002202490063");
        assertEquals("000000000",count );
    }

    @Test
    public void setIndexRightValue() {
        indexCount.setIndex("202490063");
        assertEquals("202490063", indexCount.getIndex());
    }

    @Test
    public void setIndexToLong() {
        indexCount.setIndex("11132000220169002202490063");
        assertEquals("000000000", indexCount.getIndex());
    }
    @Test
    public void setIndexOnlyLetters() {
        indexCount.setIndex("abcefghij");
        assertEquals("000000000", indexCount.getIndex());
    }

    @Test
    public void setIndexLettersWithNumbers() {
        indexCount.setIndex("a23456789");
        assertEquals("000000000", indexCount.getIndex());
    }

}