package crypto;

import java.io.File;

import static java.lang.System.*;

/**
 * Created by adlerd on 3/2/17.
 */
public class Test {
    public static void main(String... args) throws Exception {
        File in = new File("/Users/adlerd/workspace/IdeaProjects/cypher/Crypto/src/crypto/test.txt");
        File out = new File("/Users/adlerd/workspace/IdeaProjects/cypher/Crypto/src/crypto/out.txt");

        CryptedFile cf = new CryptedFile(in);
        KeyFile kf = new KeyFile("password", 1);

        cf.encryptToFile(kf, out);
    }
}
