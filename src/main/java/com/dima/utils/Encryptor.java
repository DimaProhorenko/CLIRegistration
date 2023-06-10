package com.dima.utils;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Encryptor {

    public static String generateHashString(String str) {
        return generateHashString(str, generateSalt());
    }

    public static String generateHashString(String str, byte[] salt) {
        try {
            KeySpec spec = new PBEKeySpec(str.toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return concatSaltWithPass(toHex(hash), salt);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static boolean validatePassword(String pass, String hashed) {
        byte[] salt = retrieveSalt(hashed);
        return false;
    }

    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private static byte[] retrieveSalt(String hash) {
        String salt = hash.substring(0, 32);
        String firstHalf = hash.substring(0, salt.length() / 2);
        String secondHalf = hash.substring(hash.length() - salt.length() / 2);
        return fromHex(firstHalf.concat(secondHalf));
    }
    private static String concatSaltWithPass(String hashedPassword, byte[] salt) {
        String saltString = toHex(salt);
        int saltLength = saltString.length();
//        return saltString +"|" + hashedPassword;
        return saltString.substring(0, saltLength / 2) + hashedPassword + saltString.substring(saltLength / 2, saltLength);
    }

    private static byte[] fromHex(String hex)
    {
        byte[] binary = new byte[hex.length() / 2];
        for(int i = 0; i < binary.length; i++)
        {
            binary[i] = (byte)Integer.parseInt(hex.substring(2*i, 2*i+2), 16);
        }
        return binary;
    }
    private static String toHex(byte[] array)
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
            return String.format("%0" + paddingLength + "d", 0) + hex;
        else
            return hex;
    }
}
