package com.example.integrazione.hw2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CollectionOperationsTest {

    @Test
    void identicalTest() {

        //Test in cui le grandezze sono diverse
        assertFalse(CollectionOperations.identicalCollections(new ArrayList<>(Arrays.asList("a","b","c")), new ArrayList<>(Arrays.asList("a","b","c","d"))));

        //Test in cui le grandezze sono uguali ma gli elementi sono diversi
        assertFalse(CollectionOperations.identicalCollections(new ArrayList<>(Arrays.asList("a","b","c")), new ArrayList<>(Arrays.asList("b","b","c"))));

        //Test in cui le grandezze e gli elementi sono uguali, ma non le occorrenze
        assertFalse(CollectionOperations.identicalCollections(new ArrayList<>(Arrays.asList("a","b","c","a","a")), new ArrayList<>(Arrays.asList("a","b","b","c","a"))));

        //Test in cui ci sono le stesse stringhe con la stessa cardinalità
        assertTrue(CollectionOperations.identicalCollections(new ArrayList<>(Arrays.asList("a","b","e","c","d")), new ArrayList<>(Arrays.asList("a","b","e","c","d"))));

    }

    @Test
    void casoBase(){
        //Test in cui ci sono le stesse stringhe con la stessa cardinalità
        assertTrue(CollectionOperations.identicalCollections(new ArrayList<>(Arrays.asList("a","b","e","c","d")), new ArrayList<>(Arrays.asList("a","b","e","c","d"))));
    }

    @Test
    void variTest(){

        //Test in cui le grandezze sono diverse
        assertFalse(CollectionOperations.identicalCollections(new ArrayList<>(Arrays.asList("a","b","c")), new ArrayList<>(Arrays.asList("a","b","c","d"))));

        //Test in cui le grandezze sono uguali ma gli elementi sono diversi
        assertFalse(CollectionOperations.identicalCollections(new ArrayList<>(Arrays.asList("a","b","c")), new ArrayList<>(Arrays.asList("b","b","c"))));

        //Test in cui le grandezze e gli elementi sono uguali, ma non le occorrenze
        assertFalse(CollectionOperations.identicalCollections(new ArrayList<>(Arrays.asList("a","b","c","a","a")), new ArrayList<>(Arrays.asList("a","b","b","c","a"))));
    }


}