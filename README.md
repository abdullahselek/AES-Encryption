# AES-Encryption

AES-Encryption is a Java class for encrypting and decrypting strings in Android with AES.

First initialize your own AESEncryption class variable with a password key. Then you can use encrypt and decrypt methods as below.

## Installation

### Gradle
> Add it in your root build.gradle at the end of repositories
```
repositories {
    maven { url "https://jitpack.io" }
}
```
> Add the dependency
```
dependencies {
	compile 'com.github.abdullahselek:AES-Encryption:0.1'
}
```
### Maven
```
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```
> Add the dependency
```
<dependency>
	<groupId>com.github.abdullahselek</groupId>
	<artifactId>AES-Encryption</artifactId>
	<version>0.1</version>
</dependency>
```

## Example Usage

- Initialization of AESEncryption class
```
String passwordKey = "abdullahselek";
AESEncryption aesEncryption = new AESEncryption(passwordKey);
```

- For encryption
```
String encryptedText = aesEncryption.encrypt("encrypt it");
```

- For decryption
```
String decryptedText = aesEncryption.decrypt(encryptedText);
```

## Information

If you get `Illegal key size or default parameters` error from Java Cipher class you can download two .jar files supported by Oracle according to your jre version. And add to your `${java.home}/jre/lib/security/` folder.

[Related StackOverflow link](http://stackoverflow.com/a/6481658/7677598)

- [Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files 6 Download](http://www.oracle.com/technetwork/java/javase/downloads/jce-6-download-429243.html)
- [Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files 7 Download](http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html)
- [Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files 8 Download](http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html)


