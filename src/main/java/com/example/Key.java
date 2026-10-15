package com.example;

import java.math.BigInteger;

public record Key(BigInteger exponent, BigInteger modulus) {}

// esto está vació porque el record lo que hace es internamente ya importar todo lo que se necesita,
// exponent(), modulus() (getters), toString, equals() y HashCode().