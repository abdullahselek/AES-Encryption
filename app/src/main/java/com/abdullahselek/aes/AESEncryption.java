package com.abdullahselek.aes;

/**
 * Created by abdullahselek on 08/06/15.
 */

import android.util.Base64;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryption {

    public static byte[] SALT = {
            (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
            (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
    };

    private static final int ITERATION_COUNT = 65536;
    private static final int KEY_LENGTH = 256;
    private Cipher encryptCipher;
    private Cipher decryptCipher;

    /**
     * Initiates AESEncryption with password key
     * @param passwordKey
     * @throws Exception
     */
    public AESEncryption(String passwordKey) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(passwordKey.toCharArray(), SALT, ITERATION_COUNT, KEY_LENGTH);
        SecretKey tempKey = factory.generateSecret(spec);
        SecretKey secret = new SecretKeySpec(tempKey.getEncoded(), "AES");

        encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secret);

        decryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] iv = encryptCipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
        decryptCipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));
    }

    /**
     * Encrypts given text
     * @param encrypt
     * @return
     * @throws Exception
     */
    public String encrypt(String encrypt) throws Exception {
        byte[] bytes = encrypt.getBytes("UTF8");
        byte[] encrypted = encrypt(bytes);
        return Base64.encodeToString(encrypted, Base64.DEFAULT);
    }

    /**
     * Encrypts given byte array
     * @param plain
     * @return
     * @throws Exception
     */
    public byte[] encrypt(byte[] plain) throws Exception {
        return encryptCipher.doFinal(plain);
    }

    /**
     * Decrypts given text
     * @param encrypt
     * @return
     * @throws Exception
     */
    public String decrypt(String encrypt) throws Exception {
        byte[] bytes = Base64.decode(encrypt, Base64.DEFAULT);
        byte[] decrypted = decrypt(bytes);
        return new String(decrypted, "UTF8");
    }

    /**
     * Decrypts given byte array
     * @param encrypt
     * @return
     * @throws Exception
     */
    public byte[] decrypt(byte[] encrypt) throws Exception {
        return decryptCipher.doFinal(encrypt);
    }

}
