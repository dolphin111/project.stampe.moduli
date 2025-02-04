package com.fideuram.formattazioni;

import com.fideuram.factory.FormatterFactory;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by
 * User: logan
 * Date: 17/04/13
 * Time: 17.08
 */
public class FormatterTest extends TestCase {
    
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(FormatterTest.class);
    }

    public void testQuote(){
        Double quota=1720.00;
        String s= FormatterFactory.getStandardQuote(quota);
        assertTrue(s.equalsIgnoreCase("1.720,000"));
    }

    public void testImporto(){
        Double quota=1720.00;
        String s=FormatterFactory.getStandardImporto(quota);
        assertTrue(s.equalsIgnoreCase("1.720,00"));
    }

    public void testImporto_ConValoreZero(){
        Double quota=new Double(0);
        String s=FormatterFactory.getStandardImporto(quota);
        assertTrue(s.equalsIgnoreCase("0,00"));
    }
}
