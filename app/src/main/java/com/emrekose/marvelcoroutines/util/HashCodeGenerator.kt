package com.emrekose.marvelcoroutines.util

import java.math.BigInteger
import java.security.MessageDigest

object HashCodeGenerator {

    fun generate(timeStamp: Long, privateApiKey: String, publicApiKey: String): String =
        md5("$timeStamp$privateApiKey$publicApiKey")

    private fun md5(s: String): String {
        val digest = MessageDigest.getInstance("MD5")
        digest.update(s.toByteArray())
        val messageDigest = digest.digest()
        val bigInt = BigInteger(1, messageDigest)
        var hashText = bigInt.toString(16)
        while (hashText.length < 32) {
            hashText = "0$hashText"
        }
        return hashText
    }
}