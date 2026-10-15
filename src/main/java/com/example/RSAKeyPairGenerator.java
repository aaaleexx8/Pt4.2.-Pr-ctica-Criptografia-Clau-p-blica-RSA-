package com.example;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSAKeyPairGenerator {

    private final Key publicKey;
    private final Key privateKey;

    public RSAKeyPairGenerator() {
    int bits = 1024; //bits de cada clave (en total son 2048)
    SecureRandom rs = new SecureRandom(); //más seguro que el random

    //declaro las claves p y q como BigIntegers, pasándoles la cantidad de bits y que sean randoms seguros.
    BigInteger p = BigInteger.probablePrime(bits, rs); 
    BigInteger q = BigInteger.probablePrime(bits, rs);

    BigInteger n = p.multiply(q); // lo que vendría siendo p * q de toda la vida

    //aprovechando el multiply, voy a calcular phi
    BigInteger pm1 = p.subtract(BigInteger.ONE); // (P - 1)
    BigInteger qm1 = q.subtract(BigInteger.ONE); // (Q - 1)
    BigInteger phi = qm1.multiply(pm1); // (Q - 1) (P - 1)
    
    //moodle
    BigInteger e = BigInteger.valueOf(65537);
    BigInteger d = e.modInverse(phi);

    this.publicKey = new Key(e, n);
    this.privateKey = new Key(d, n);

    }

    public Key getPublicKey() {
        return publicKey;
    }

    public Key getPrivateKey() {
        return privateKey;
    }

}
