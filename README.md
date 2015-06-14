# AES-Encryption
AES-Encryption is an Android project that includes a Java class for encrypting and decrypting strings in Android with AES.

First initialize your own AESEncryption class variable with keyValue and iv string values. Then you can use encrypt and decrypt methods as below.

# Initialization of AESEncryption class

	String keyValue = "abdullahselekistanbultur";
	String ivValue = "0102030405060708";

	AESEncryption aesEncryption = new AESEncryption(keyValue, ivValue);

# For encryption

	String encryptedText = aesEncryption.encrypt("encrypt it");

# For decryption

  	String decryptedText = aesEncryption.decrypt(encryptedText);


