package br.com.bycoders.desafiodev.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MD5UtilTest {

    @Test
    public void encode() throws Exception {
        String encode = MD5Util.encode("md5");

        assertNotNull(encode);
        assertEquals(32, encode.length());
        assertEquals("1bc29b36f623ba82aaf6724fd3b16718", encode);
    }
}
