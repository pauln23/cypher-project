package com.cypher.encryption.test;

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

        System.out.println("Unencrypted byte[]: " + Arrays.toString(str.getBytes()));
//        testFileEncrypt(in, "password");
//        testFileEncrypt(in, out, "password");
//        testFileEncrypt(fileIn, fileOut, "password");
        // WORKS
        testStringEncrypt(str, "1234567890");

    }

    private static void testStringEncrypt(String str, String password) throws Exception{
        Encrypt strCrypt = new Encrypt(str);
        KeyFile key = new KeyFile(password, 1);
        String encryption = strCrypt.encryptToByteValues(key);
        out.println(encryption);
    }

    // Encrypt file and then overwrite with encryption
    public static void testFileEncrypt(File file, String password) throws  Exception{
        ORIGINAL_EncryptFile cf = new ORIGINAL_EncryptFile(file);
        KeyFile kf = new KeyFile(password, 1);

        cf.encryptToFile(kf, file);
    }

    // Encrypt input file and output as different file
    public static void testFileEncrypt(File input, File output, String password) throws  Exception{
        ORIGINAL_EncryptFile cf = new ORIGINAL_EncryptFile(input);
        KeyFile kf = new KeyFile(password, 1);

        try {
            kf.writeToFile("");
        }catch (IOException ioe){
            err.print("Failed to write Key to KeyFile!");
        }
        cf.encryptToFile(kf, output);
    }
}
