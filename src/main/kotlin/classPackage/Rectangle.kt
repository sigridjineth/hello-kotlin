package classPackage

class Rectangle(private val height: Int, private val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
    val size: Int
        get() = height * width
}
