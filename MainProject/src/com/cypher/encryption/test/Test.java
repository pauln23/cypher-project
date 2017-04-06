package com.cypher.encryption.test;

/**
 * Created by adlerd on 3/2/17.
 */

import com.cypher.encryption.Crypto;
import com.cypher.encryption.KeyFile;

import static java.lang.System.*;

public class Test {
    private static final String password = "1234";
    private static final String str = "test";

    private static final String encrypted = "֨���œSL��*(M�>{";
    private static final KeyFile key = new KeyFile(password, 1);

    public static void main(String... args) throws Exception {

//        testStringEncrypt(str, key);
        testStringDecrypt(encrypted, key);
    }


    // TEST ENCRYPTION
    private static void testStringEncrypt(String str, KeyFile k) throws Exception{
        Crypto crypto = new Crypto(str);
        out.printf("[TEST] Enrypted: %s%n", crypto.encryptToByteValues(k));
//        out.println("Encrypted byte[]: " + Arrays.toString(encryption.getBytes()));
    }

    // TEST DECRYPTION
    private static void testStringDecrypt(String str, KeyFile k) throws Exception{
        Crypto crypto = new Crypto(str);
        out.printf("[TEST] Decrypted: %s%n", crypto.encryptToByteValues(k));
    }
}
