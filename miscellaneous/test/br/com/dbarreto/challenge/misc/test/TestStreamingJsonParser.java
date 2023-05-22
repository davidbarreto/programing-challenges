package br.com.dbarreto.challenge.misc.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.com.dbarreto.challenge.misc.StreamingJsonParser;

public class TestStreamingJsonParser {

	private String input = "{\"k1\": 1, \"k2\": {\"k3\": [\"a\", \"b\", \"c\"]}, \"lookup_key\": {\"a\": 1, \"b\": [2]}";
	private StreamingJsonParser.SocketHandler handler = new StreamingJsonParser.SocketHandler(input);
	private StreamingJsonParser parser = new StreamingJsonParser();
	
	@Before
	public void prepareTest() {
		handler.reset();
	}
	
	@Test
	public void testCase001() {

		String expected = "1";
		assertEquals(expected, parser.search(handler, "k1"));
	}
	
	@Test
	public void testCase002() {

		String expected = "{\"k3\": [\"a\", \"b\", \"c\"]}";
		assertEquals(expected, parser.search(handler, "k2"));
	}
	
	@Test
	public void testCase003() {

		String expected = "[\"a\", \"b\", \"c\"]";
		assertEquals(expected, parser.search(handler, "k3"));
	}
	
	@Test
	public void testCase004() {
		
		String expected = "{\"a\": 1, \"b\": [2]}";
		assertEquals(expected, parser.search(handler, "lookup_key"));
	}
	
	@Test
	public void testCase005() {
		
		String expected = "1";
		assertEquals(expected, parser.search(handler, "a"));
	}
	
	@Test
	public void testCase006() {
		String expected = "[2]";
		assertEquals(expected, parser.search(handler, "b"));
	}
}