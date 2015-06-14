package com.abdullahselek.aes;

/**
 * Created by abdullahselek on 08/06/15.
 */

import android.util.Base64;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryption {

    /*** algorithm ***/
    private static final String ALGO = "AES";

    /**
     * key value for encryption & decryption
     */
    private byte[] keyValue = null;

    /**
     * vector array for encryption & decryption
     */
    private byte[] iv = null;

    /**
     * constructor with two variable parameters
     * @param keyValue
     * @param iv
     */
    public AESEncryption(String keyValue, String iv) {
        if (keyValue == null || iv == null)
            throw new NullPointerException("Encryption values can not be null!");

        this.keyValue = keyValue.getBytes();
        this.iv = iv.getBytes();
    }

    /**
     * encrypt given string data
     *
     * @param rawdata
     * @return
     * @throws Exception
     */
    public String encrypt(String rawdata) throws Exception {
        if (rawdata == null)
            throw new NullPointerException("Raw data can not be null!");

        Key key = generateKey();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] encVal = cipher.doFinal(rawdata.getBytes());
        String encryptedValue = Base64.encodeToString(encVal, Base64.DEFAULT);
        return encryptedValue;
    }

    /**
     * decrypt given string data
     *
     * @param encryptedData
     * @return
     * @throws Exception
     */
    public String decrypt(String encryptedData) throws Exception {
        if (encryptedData == null)
            throw new NullPointerException("Encrypted data can not be null!");

        Key key = generateKey();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] decodedValue = Base64.decode(encryptedData, Base64.DEFAULT);
        byte[] decValue = cipher.doFinal(decodedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    /**
     * key generator
     *
     * @return
     * @throws Exception
     */
    private Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }

}
