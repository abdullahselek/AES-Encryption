package com.abdullahselek.aes;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Created by abdullahselek on 14/06/15.
 */

public class AESEncryptionTest extends TestCase {

    private AESEncryption aesEncryption;
    private String encyrptedData;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        String keyValue = "abdullahselekistanbultur";
        String ivValue = "0102030405060708";
        aesEncryption = new AESEncryption(keyValue, ivValue);
    }

    @Test
    public void testInitialize() {
        assertNotNull("AESEncryption can not initiated!", aesEncryption);
    }

    @Test
    public void testEncryptDecrypt() throws Exception {
        String rawData  = "encryption test";
        encyrptedData = aesEncryption.encrypt(rawData);
        assertNotNull("Raw data can not encrypted!", encyrptedData);

        assertNotNull("Encrypted data can not decrypted!", aesEncryption.decrypt(encyrptedData));
    }

    @Override
    protected void tearDown() throws Exception {
        aesEncryption = null;

        super.tearDown();
    }
}
