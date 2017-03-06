package com.cypher.encryption.test;

import com.cypher.encryption.EncryptString;
import com.cypher.encryption.EncryptFile;
import com.cypher.encryption.KeyFile;

import java.io.File;

import static java.lang.System.*;

/**
 * Created by adlerd on 3/2/17.
 */
public class Test {
    public static void main(String... args) throws Exception {
        File in = new File("/Users/adlerd/workspace/IdeaProjects/cypher/Crypto/src/crypto/test.txt");
        File out = new File("/Users/adlerd/workspace/IdeaProjects/cypher/Crypto/src/crypto/out.txt");
        String str = "Test message for encryption!";


//        testFileEncrypt(in, "password");
//        testFileEncrypt(in, out, "password");
        testStringEncrypt(str, "password");
    }

    private static void testStringEncrypt(String str, String password) throws Exception{
        EncryptString strCrypt = new EncryptString(str);
        KeyFile key = new KeyFile(password, 1);
        String encryption = strCrypt.encryptToStringAES(key);
        out.println(encryption);
    }

    // Encrypt file and then overwrite with encryption
    public static void testFileEncrypt(File file, String password) throws  Exception{
        EncryptFile cf = new EncryptFile(file);
        KeyFile kf = new KeyFile(password, 1);

        cf.encryptToFile(kf, file);
    }

    // Encrypt inputted file and output it as a different file
    public static void testFileEncrypt(File input, File output, String password) throws  Exception{
        EncryptFile cf = new EncryptFile(input);
        KeyFile kf = new KeyFile(password, 1);

        cf.encryptToFile(kf, output);
    }
}
