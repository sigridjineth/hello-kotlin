import classPackage.*
import java.io.BufferedReader
import java.lang.IllegalArgumentException
import java.lang.Integer.max
import java.lang.NumberFormatException

fun main(args: Array<String>) {
    // code block a
    println("Hello, this is Kotlin!")
    val name = readLine()
    println("Hello, $name")

    // code block b
    val question = "Who am I?"
    val questionWithType: String = "Who am I?"
    val questionWithType2: String = StringBuilder("Who am I?").toString()
    val answerInt: Int
    answerInt = 40

    // code block c
    // val: 변경 불가능한 참조이고 초기화 한 번만 가능. var: 변경 가능한 참조지만 타입은 불변.
    val message: String
    fun canPerformOperation(answerInt: Int): Boolean {
        if (answerInt >= 40) {
            return true
        }
        return false
    }
    message = if (canPerformOperation(answerInt)) { "Success" } else { "Failed" }
    println(message)

    // code block d
    val name2: String? = name
    println("Hello, $name2")
    println("Hello, ${name2}입니다!")
    println("$name2 has ${max(100, 300)} ETH")

    val testArray = listOf<Int>(1, 2, 3)
    println("the size of testArray: ${if (testArray.isEmpty()) 0 else testArray.size}")

    // code block e
    val p = Person("Sigrid", false)
    println("${p.name}, ${p.isMarried}")
    p.isMarried = true
    println("${p.isMarried} is changed value.")

    // code block f
    val r = Rectangle(3, 3)
    println("the result of isSquare(): ${if (r.isSquare.not()) "NOT" else "OK"}")
    println("the result: ${r.size}")

    // code block g
    println("${Color.RED.rgb()}, ${Color.getWarmth(Color.ORANGE)}")
    println("${Color.mix(Color.RED, Color.YELLOW)}, ${Color.mix(Color.BLUE, Color.YELLOW)}")
    println("${ try { Color.mix(Color.VIOLET, Color.YELLOW) } catch (e: Exception) { "Exception" }}")

    // code block h
    fun eval(num: Any): Int {
        return when (num) {
            is Int -> num.dec()
            is String -> 0
            else -> throw IllegalArgumentException("unknown exp")
        }
    }

    fun evalWithLogging(num: Any): Any {
        return when (num) {
            is Int -> {
                println("num: ${num.div(3)}")
                num
            }
            is String -> {
                val left = "Sigrid"
                val right = "Poogle"
                println("sum: $left +$right")
                left + right
            }
            else -> {
                throw Exception("Unknown Exp")
            }
        }
    }

    println(eval(3))
    println(eval("Test"))
    println(evalWithLogging(3))
    println(evalWithLogging("Test"))

    // code block i
    for (i in 1..100) {
        println(i)
    }

    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
    fun isNotDigit(c: Char) = c !in '0'..'9'
    fun recognize(c: Char): String = when(c) {
        in '0'..'9' -> "digit"
        in 'a'..'z', in 'A'..'Z' -> "letter"
        else -> "I don't know"
    }
    println("Kotlin" in "Java".."Scala") // Comparable 구현 클래스
    println("Kotlin" in setOf("Java", "Scala", "Kotlin"))

    // code block j
    fun readNumber(reader: BufferedReader): Int? {
        return try {
            Integer.parseInt(reader.readLine())
        } catch (e: NumberFormatException) {
            null
        } finally {
            reader.close()
        }
    }

    // code block k
    println("the list of number")
    val ml = listOf(1, 2, 3, 4, 5)
    println(ml.joinToString("|", ">", "<").lastChar())
    val m2: String = "Sigrid"
    println(m2.lastChar)
    val m3: StringBuilder = StringBuilder("snoop").append("miracle")
    println(m3.lastChar)
    var char: Char = 'C'
    m3.lastChar = char
    println(m3.lastChar)

    // varargs
    val m4: Array<String> = arrayOf("Sigrid", "Poogle", "Solar", "Ragdoll", "Codesquad")
    val listIterator = listOf(m4).listIterator()
    while (listIterator.hasNext()) {
        val nowList = listIterator.next().iterator()
        while (nowList.hasNext()) {
            val element = nowList.next()
            println(element)
        }
    }

    // infix call
    // val multi = 3.multiply(10)
    val multi = 3 multiply 10
    println("multi: $multi")

    val source = "Hello, World!"
    val target = "This for you."
    println(source getLongString target)

    // destructuring pattern
    val sigrid = Person("Sigrid", false)
    val (newName, isMarried) = sigrid
    println("newName: $newName, isMarried: $isMarried")
    val pair: Pair<Person, String> = sigrid to "Hi"
    println("first: ${pair.first.name}, second: ${pair.second}")
}
