package com.example.integrazione.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class wrapTest {

    @Test
    void casoBase() {
        assertEquals("xabx", wrap.wrapIfMissing("ab", "x"));
    }
    // Test del caso base

    @Test
    void strIniziaOFinisceConWrapWith() {
        assertEquals("xabx", wrap.wrapIfMissing("xab", "x"));
        assertEquals("xabx", wrap.wrapIfMissing("abx", "x"));
    }
    // Test in cui la stringa inizia o finisce con wrapWith

    @Test
    void sostituzioniMultiple(){
        assertEquals("ab", wrap.wrapIfMissing("ab", ""));
        assertEquals("'ab'", wrap.wrapIfMissing("ab", "'"));
        assertEquals("''''''''''''''''''''abcd''''''''''''''''''''", wrap.wrapIfMissing("abcd", "''''''''''''''''''''"));
        assertEquals("xxxabxx", wrap.wrapIfMissing("xab", "xx"));
        assertEquals("1ab1", wrap.wrapIfMissing("ab", "1"));
        assertEquals("12345ab12345", wrap.wrapIfMissing("ab", "12345"));
    }
    // Test con vari tipi di wrapWith

    @Test
    void nullEmptyCases(){

        //T1
        assertEquals(null, wrap.wrapIfMissing(null, "a"));

        //T2
        assertEquals("", wrap.wrapIfMissing("", "a"));

        //T3
        assertEquals("a", wrap.wrapIfMissing("a", ""));

        //T4
        assertEquals("a", wrap.wrapIfMissing("a", null));

        //T5
        assertEquals("", wrap.wrapIfMissing("", ""));

        //T6
        assertEquals(null, wrap.wrapIfMissing(null, null));
    }

    @Test
    void strIniziaEOFinisceConWrapWith() {

        //T7
        assertEquals("xabx", wrap.wrapIfMissing("xab", "x"));

        //T8
        assertEquals("xabx", wrap.wrapIfMissing("abx", "x"));

        //T9
        assertEquals("xabx", wrap.wrapIfMissing("xabx", "x"));
    }

    @Test
    void strUgualeAWrapWith() {

        //T10
        assertEquals("x", wrap.wrapIfMissing("x", "x"));
    }

    @Test
    void testParticolari(){

        //T11
        assertEquals("xxxabxx", wrap.wrapIfMissing("xab", "xx"));

        //T12
        assertEquals("xxabxxx", wrap.wrapIfMissing("abx", "xx"));

        //T13
        assertEquals("xxxxx", wrap.wrapIfMissing("x", "xx"));

        //T14
        assertEquals("1 1a b1 1", wrap.wrapIfMissing("a b", "1 1"));
    }
}
