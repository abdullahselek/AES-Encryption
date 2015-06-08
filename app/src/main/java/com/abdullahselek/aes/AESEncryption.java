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
    private static final byte[] keyValue = new byte[] {
            'a', 'b', 'd', 'u', 'l', 'l', 'a', 'h', 's', 'e', 'l', 'e',
            'k', 'i', 's', 't', 'a', 'n', 'b', 'u', 'l', 't', 'u', 'r'};

    /**
     * vector array for encryption & decryption
     */
    private static byte[] iv = { 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8 };

    /**
     * encrypt given string data
     *
     * @param Data
     * @return
     * @throws Exception
     */
    public static String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] encVal = cipher.doFinal(Data.getBytes());
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
    public static String decrypt(String encryptedData) throws Exception {
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
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }

}
