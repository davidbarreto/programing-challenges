package br.com.dbarreto.challenge.misc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Streaming JSON Parser
 * 
 * You are given an open socket handler. The api for this handler looks like:
 * 
 * - socketHandler.getNextChar(), which returns a single character at a time and moves the handler pointer forward, and:
 * - socketHandler.isEof(), which returns a boolean indicating if it's reached the end of the stream.
 * 
 * We know nothing about the data size: it's unbounded. The only thing that's known about it: it's a sequence of valid JSON documents.
 * Your goal is to implement a streaming JSON parser, which should search for a specific key in the stream.
 * 
 * Example:
 * 
 * String search(SocketHandler socketHandler, String searchPath) {
 *    // Implement me
 * }
 * 
 * search(socketHandler, "lookup_key") // Should output everything as a string to STDOUT if it found this key in the document.
 * 
 * An example of the data that might be read from the socket:
 * 
 * {"k1": 1, "k2": {"k3": ["a", "b", "c"]}, "lookup_key": {"a": 1, "b": [2]}
 * 
 * Expected output: {"a": 1, "b": [2]}
 */
public class StreamingJsonParser {
	
	public String search(SocketHandler handler, String searchPath) {
				
		if (!foundKey(handler, searchPath)) {
			return null;
		}
		
		char currentChar = skipWhiteSpaces(handler);
		return retrieveValue(handler, currentChar);
	}
	
	private char skipWhiteSpaces(SocketHandler handler) {
		char currentChar = '\0';
		while (!handler.isEof()) {
			currentChar = handler.getNextChar();
			if (!Character.isWhitespace(currentChar)) {
				break;
			}
		}
		
		return currentChar;
	}
	
	private String retrieveValue(SocketHandler handler, char firstChar) {
		
		StringBuilder builder = new StringBuilder();
		builder.append(firstChar);
		Deque<Character> bracketsStack = new LinkedList<>();
		ValueType valueType = decodeFirstChar(firstChar);
		if (valueType == ValueType.STRUCTURE) {
			bracketsStack.push(firstChar);
		}
		
		while (!handler.isEof()) {
			
			char currentChar = handler.getNextChar();
			builder.append(currentChar);
			if (foundLastValueChar(currentChar, firstChar, valueType, bracketsStack)) {
				break;
			}
		}
		
		if (valueType == ValueType.NUMBER) {
			builder.deleteCharAt(builder.length()-1);
		}
		
		return builder.toString();
	}
	
	private ValueType decodeFirstChar(char firstChar) {
		
		if (firstChar == '\"') {
			return ValueType.STRING;
		}
		
		if (isOpenBracket(firstChar)) {
			return ValueType.STRUCTURE;
		}
		
		if (Character.isDigit(firstChar)) {
			return ValueType.NUMBER;
		}
		
		return ValueType.INVALID;
	}

	private boolean foundLastValueChar(char currentChar, char firstChar, ValueType valueType, Deque<Character> bracketsStack) {
		
		if (valueType == ValueType.STRING) {
			return currentChar == firstChar;
		}
		
		if (valueType == ValueType.NUMBER) {
			return !Character.isDigit(currentChar);
		}
		
		if (valueType == ValueType.STRUCTURE && isCloseMatchingBracket(firstChar, currentChar)) {
			bracketsStack.poll();
			return bracketsStack.isEmpty();
		}
		
		return false;
	}
	
	private boolean isOpenBracket(char ch) {
		return ch == '[' || ch == '{';
	}

	private boolean isCloseMatchingBracket(char firstChar, char currentChar) {
		return (firstChar == '[' && currentChar == ']') || (firstChar == '{' && currentChar == '}');
	}

	private boolean foundKey(SocketHandler handler, String searchPath) {
		
		int index = 0;
		char previousChar = '\0';
		char currentChar = '\0';
		
		int len = searchPath.length();
		boolean readKey = false;
		
		while (!handler.isEof()) {
			
			previousChar = currentChar;
			currentChar = handler.getNextChar();
			
			if (foundLastKeyChar(currentChar, previousChar, readKey)) {
				break;
			}
			
			if (!Character.isWhitespace(currentChar)) {
				
				if (foundFirstKeyChar(currentChar, previousChar, index, searchPath) || foundOneMoreKeyChar(currentChar, readKey, index, len, searchPath)) {
					readKey = true;
					index++;
				} else {
					index = 0;
					readKey = false;
				}	
			}
		}
		
		return readKey;
	}
	
	private boolean foundFirstKeyChar(char currentChar, char previousChar, int index, String searchPath) {
		return index == 0 && currentChar == searchPath.charAt(0) && previousChar == '\"';
	}
	
	private boolean foundOneMoreKeyChar(char currentChar, boolean readingKey, int index, int len, String searchPath) {
		return readingKey && (((index == len) && currentChar == '\"') || ((index < len) && currentChar == searchPath.charAt(index)));
	}
	
	private boolean foundLastKeyChar(char currentChar, char previousChar, boolean readingKey) {
		return readingKey && currentChar == ':' && (previousChar == ' ' || previousChar == '\"');
	}
	
	public enum ValueType {
		STRUCTURE, NUMBER, STRING, INVALID
	}
	
	public static class SocketHandler {
		
		private String stream;
		private int position; 
		
		public SocketHandler(String stream) {
			this.stream = stream;
			this.position = 0;
		}
		
		public Character getNextChar() {
			return stream.charAt(position++);
		}
		
		public boolean isEof() {
			return position >= stream.length();
		}
		
		public void reset() {
			position = 0;
		}
	}
}