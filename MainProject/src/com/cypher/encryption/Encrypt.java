package com.cypher.encryption;

import java.io.File;
import java.util.stream.Stream;

/**
 * Created by adlerd on 3/4/17.
 */
public class Encrypt {

    private String string;
    private File file;
    private byte[] data;

    public Encrypt(String string) {
        this.string = string;
    }

    public Encrypt(File file) {
        this.file = file;
    }

    public Encrypt(byte[] data) {
        this.data = data;
    }

    public byte[] encryptToDataAES(KeyFile keyFile){
        byte[] data = null;
        if (string.equalsIgnoreCase("")){

        }
    }

    public byte[] encryptToDataAES(KeyFile keyFile){

    }

    public byte[] encryptToDataAES(KeyFile keyFile){

    }

}
