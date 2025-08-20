package br.com.dbarreto.challenge.misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LruCacheTest {

    @Test
    void test() {

        LruCache<String, String> cache = new LruCache<>(5);
        assertNull(cache.get("banana"));

        cache.put("banana", "amarelo");
        assertEquals("amarelo", cache.get("banana"));

        cache.put("maca", "vermelho");
        cache.put("limao", "verde");
        cache.put("laranja", "laranja");
        cache.put("uva", "roxo");

        assertEquals("amarelo", cache.get("banana"));
        assertEquals("vermelho", cache.get("maca"));
        assertEquals("verde", cache.get("limao"));
        assertEquals("laranja", cache.get("laranja"));
        assertEquals("roxo", cache.get("uva"));

        cache.put("mertilo", "azul");

        assertNull(cache.get("banana"));
        assertEquals("azul", cache.get("mertilo"));
        assertEquals("vermelho", cache.get("maca"));
        assertEquals("verde", cache.get("limao"));
        assertEquals("laranja", cache.get("laranja"));
        assertEquals("roxo", cache.get("uva"));

        cache.put("maca", "verde");
        assertEquals("azul", cache.get("mertilo"));
        assertEquals("verde", cache.get("maca"));
        assertEquals("verde", cache.get("limao"));
        assertEquals("laranja", cache.get("laranja"));
        assertEquals("roxo", cache.get("uva"));

        cache.put("pera", "amarelo");
        assertNull(cache.get("mertilo"));
        assertEquals("verde", cache.get("maca"));
        assertEquals("verde", cache.get("limao"));
        assertEquals("amarelo", cache.get("pera"));
        assertEquals("laranja", cache.get("laranja"));
        assertEquals("roxo", cache.get("uva"));
    }
}