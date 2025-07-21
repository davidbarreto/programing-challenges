package br.com.dbarreto.challenge.leetcode.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {

    public static int[][] stringToMatrix(String input) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(input, int[][].class);
        } catch (JsonProcessingException e) {
            throw new ConvertionException(e);
        }
    }
}
