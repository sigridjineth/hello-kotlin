package classPackage

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    BLUE(0, 0, 255),
    VIOLET(238, 130, 238);

    fun rgb(): Int {
        return (r * 256 + g) * 256 + b
    }

    companion object {
        fun getWarmth(color: Color): String {
            return when (color) {
                Color.RED, Color.ORANGE -> "warm"
                Color.BLUE -> "cool"
                else -> throw RuntimeException("dirty color")
            }
        }

        fun mix(c1: Color, c2: Color): Int {
            return when (setOf(c1, c2)) {
                setOf(RED, YELLOW) -> ORANGE.rgb()
                setOf(YELLOW, BLUE) -> VIOLET.rgb()
                else -> throw RuntimeException("dirty color")
            }
        }
    }
}
