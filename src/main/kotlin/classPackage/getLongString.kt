package classPackage

infix fun String.getLongString(target: String): String =
    if (this.length > target.length) {
        this
    } else {
        target
    }