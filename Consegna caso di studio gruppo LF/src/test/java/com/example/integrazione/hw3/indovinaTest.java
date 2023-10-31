package com.example.integrazione.hw3;

import net.jqwik.api.*;
import net.jqwik.api.arbitraries.ListArbitrary;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.*;

class indovinaTest {

    @Property
    void testEseguiGioco(@ForAll("validGuesses") int numPensato, @ForAll("invalidGuesses") int[] invalidGuesses) {
        int originalPartiteVinte = indovinaNumeri.partiteVinte;

        // Initialize the System.in with custom input
        String input = String.join((CharSequence) "\n", (CharSequence) Integer.toString(numPensato), (CharSequence) Arrays.stream(invalidGuesses).mapToObj(String::valueOf).toArray());
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Redirect the System.out to capture the console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        indovinaNumeri.eseguiGioco(numPensato);

        // Verify the output
        String output = outputStream.toString();
        if (numPensato == invalidGuesses[0]) {
            assertTrue(output.contains("Hai perso! Io avevo pensato il numero " + numPensato));
            assertEquals(originalPartiteVinte, indovinaNumeri.partiteVinte);
        } else {
            assertTrue(output.contains("Hai vinto!"));
            assertEquals(originalPartiteVinte + 1, indovinaNumeri.partiteVinte);
        }
    }

    @Provide
    Arbitrary<Integer> validGuesses() {
        return Arbitraries.integers().between(1, 100);
    }

    @Provide
    ListArbitrary<Integer> invalidGuesses() {
        return Arbitraries.integers().between(101, 200).list().ofSize(3);
    }
}