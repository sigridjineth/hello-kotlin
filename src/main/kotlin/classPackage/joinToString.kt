package classPackage

// * Jin Hyung Park * //
// * declares an extension function on Collection<T>.
fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    // * "this" refers to the receiver of object: a collection of T. * //
    for ((index, element) in this.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun String.lastChar(): Char = this[this.length - 1]

// declaring an extension property
val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1) // property getter
    set(value: Char) {
        this.setCharAt(length - 1, value) // property setter
    }