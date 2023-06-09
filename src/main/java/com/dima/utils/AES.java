package com.dima.utils;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AES {
    private static SecretKey key;
    private static byte[] iv;
    private static final int KEY_SIZE = 128;
    private static final int DATA_LENGTH = 128;

    public static String encrypt(String data) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(KEY_SIZE);
            key = keyGenerator.generateKey();

            byte[] dataBytes = data.getBytes();
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            iv = cipher.getIV();
            byte[] encryptedBytes = cipher.doFinal(dataBytes);
            return encode(encryptedBytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                 | InvalidKeyException | BadPaddingException
                 | IllegalBlockSizeException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return null;
    }


    public static String decrypt(String data) {
        byte[] dataInBytes = decode(data);
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec spec = new GCMParameterSpec(DATA_LENGTH, iv);
            cipher.init(Cipher.DECRYPT_MODE, key, spec);
            byte[] decryptedData = cipher.doFinal(dataInBytes);
            return new String(decryptedData);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                 | InvalidKeyException | BadPaddingException
                 | IllegalBlockSizeException | InvalidAlgorithmParameterException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return null;
    }




    private static String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private static byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }
}
