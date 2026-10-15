package com.example;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class RSACipherService {

    public BigInteger encrypt(BigInteger message, Key publicKey) {
        return message.modPow(publicKey.exponent(), publicKey.modulus()); // exponent: e | modulus: n -> calcula M^e mod n
    }

    public BigInteger decrypt(BigInteger cipherText, Key privateKey) {
        return cipherText.modPow(privateKey.exponent(), privateKey.modulus()); // exponent: d | modulus: n -> lo mismo pero con la privada para recuperar el mensaje (C^d mod n)
    }

    public BigInteger encryptText(String text, Key publicKey) {
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8); // paso el texto a un array de bytes en UTF-8
        BigInteger message = new BigInteger(1, bytes); // convierto los bytes a BigInteger (el 1 fuerza a que sea positivo)
        return encrypt(message, publicKey); // llamo al método de arriba para cifrar el número con la clave pública
    }

    public String decryptText(BigInteger cipherText, Key privateKey) {
        BigInteger decryptedMessage = decrypt(cipherText, privateKey); // descifro el número usando el método decrypt y la clave privada
        byte[] bytes = decryptedMessage.toByteArray(); // paso el BigInteger descifrado de vuelta a array de bytes
        return new String(bytes, StandardCharsets.UTF_8); // reconstruyo el String original a partir de los bytes en UTF-8
    }

}