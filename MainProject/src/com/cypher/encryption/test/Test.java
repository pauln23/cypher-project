package com.cypher.encryption.test;

import com.cypher.encryption.Decrypt;
import com.cypher.encryption.Encrypt;
import com.cypher.encryption.ORIGINAL_EncryptFile;
import com.cypher.encryption.KeyFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static java.lang.System.*;

/**
 * Created by adlerd on 3/2/17.
 */
public class Test {
    public static void main(String... args) throws Exception {
        File fileIn = new File("com/cypher/encryption/test/test.txt");
        File fileOut = new File("com/cypher/encryption/test/out.txt");

        String str = "Test message for encryption!";
        String encrypted = "֨ⱛ⢾ౣ�ˠ䓣ꁓ\uF74E톦婘㭨䘋\uE191踲璍\n";

        System.out.println("Unencrypted byte[]: " + Arrays.toString(str.getBytes()));
//        testFileEncrypt(in, "password");
//        testFileEncrypt(in, out, "password");
//        testFileEncrypt(fileIn, fileOut, "password");
        
//        testStringEncrypt(str, "1234567890");
        testStringDecrypt(encrypted, "1234567890");

    }

    private static void testStringEncrypt(String str, String password) throws Exception{
        Encrypt strCrypt = new Encrypt(str);
        KeyFile key = new KeyFile(password, 1);
        String encryption = strCrypt.encryptToByteValues(key);
        out.println(encryption);
        out.println("Encrypted byte[]: " + Arrays.toString(encryption.getBytes()));
    }

    // Encrypt file and then overwrite with encryption
    private static void testFileEncrypt(File file, String password) throws  Exception{
        ORIGINAL_EncryptFile cf = new ORIGINAL_EncryptFile(file);
        KeyFile kf = new KeyFile(password, 1);

        cf.encryptToFile(kf, file);
    }

    // Encrypt input file and output as different file
    private static void testFileEncrypt(File input, File output, String password) throws  Exception{
        ORIGINAL_EncryptFile cf = new ORIGINAL_EncryptFile(input);
        KeyFile kf = new KeyFile(password, 1);

        try {
            kf.writeToFile("");
        }catch (IOException ioe){
            err.print("Failed to write Key to KeyFile!");
        }
        cf.encryptToFile(kf, output);
    }

    // Test for decrypting a string
    private static void testStringDecrypt(String str, String password) throws Exception{
        Decrypt strDecrypt = new Decrypt(str);
        KeyFile key = new KeyFile(password, 1);
        strDecrypt.decryptToByteValues(key);
    }
}
