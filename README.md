# AES-Encryption
AES-Encryption is an Android project that includes a Java class for encrypting and decrypting strings in Android with AES.

First you must change the keyValue and iv variables with your own values in AES-Encryption class. Then you can use encrypt and decrypt methods as below.

String encryptedText = AESEncryption.encrypt("encrypt it");

String decryptedText = AESEncryption.decrypt(encryptedText);


