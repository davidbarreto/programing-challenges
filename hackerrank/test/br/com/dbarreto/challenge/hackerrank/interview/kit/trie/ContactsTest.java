package br.com.dbarreto.challenge.hackerrank.interview.kit.trie;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactsTest {

    @Test
    void testCase001() {

        List<Integer> expectedResult = List.of(2, 0);

        List<List<String>> queries = new ArrayList<>();
        queries.add(List.of("add", "hack"));
        queries.add(List.of("add", "hackerrank"));
        queries.add(List.of("find", "hac"));
        queries.add(List.of("find", "hak"));

        var result = Contacts.contacts(queries);

        assertEquals(expectedResult, result);
    }
}