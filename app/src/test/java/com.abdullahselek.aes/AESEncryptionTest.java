package com.abdullahselek.aes;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Created by abdullahselek on 14/06/15.
 */

public class AESEncryptionTest extends TestCase {

    private AESEncryption aesEncryption;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        aesEncryption = new AESEncryption("asdfghjkl");
    }

    @Test
    public void testInitialize() {
        assertNotNull("AESEncryption can not initiated!", aesEncryption);
    }

    @Test
    public void testEncrypt() throws Exception {
        String rawData  = "encryption test";
        String encyrptedData = aesEncryption.encrypt(rawData);
        assertNotNull("Raw data can not encrypted!", encyrptedData);
    }

    @Test
    public void testDecrypt() throws Exception {
        String rawData = "test";
        String encryptedData = aesEncryption.encrypt(rawData);
        String decryptedData = aesEncryption.decrypt(encryptedData);
        assertNotNull("Encrypted data can not decrypted!", decryptedData);
    }

    @Override
    protected void tearDown() throws Exception {
        aesEncryption = null;
        super.tearDown();
    }
}
