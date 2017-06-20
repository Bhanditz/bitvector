@file:JvmName("Platform")

package net.onedaybeard.bitvector

fun bitCount(bits: Int): Int {
    return Integer.bitCount(bits)
}

fun leadingZeros(bits: Int): Int {
    if (bits == 0)
        return 32
    if ((bits ushr 31) == 1)
        return 0

    var v = bits
    var r = 0

    val f = { shift: Int ->
        v = v ushr shift
        r = r or shift
    }

    if ((v and 0x7fff0000) > 0) f(16)
    if ((v and 0x0000ff00) > 0) f(8)
    if ((v and 0x000000f0) > 0) f(4)
    if ((v and 0x0000000c) > 0) f(2)
    if ((v and 0x00000002) > 0) f(1)

    return 31 - r
}