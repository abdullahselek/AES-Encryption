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
