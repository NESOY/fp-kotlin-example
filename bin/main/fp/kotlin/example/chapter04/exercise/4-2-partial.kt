package fp.kotlin.example.chapter04.exercise

/**
 * 연습문제 4-2
 *
 * 매개변수 3개를 받는 부분 적용 함수 3개를 직접 구현하라.
 */

fun main() {
    /*
     * 주석을 해제하고 partial1, partial2, partial3을 구현해보세요.
     */

    val func = { a: Int, b: Int, c: Int -> a + b + c }

    val partiallyAppliedFunc1 = func.partial1(1)
    require(6 == partiallyAppliedFunc1(2, 3))

    val partiallyAppliedFunc2 = func.partial2(2)
    require(6 == partiallyAppliedFunc2(1, 3))

    val partiallyAppliedFunc3 = func.partial3(3)
    require(6 == partiallyAppliedFunc3(1, 2))

    // Nesoy Test
    val funcNesoy = {a: Int, b: Int, c: Int -> a * b + c}
    // 1*2+3
    val part1 = funcNesoy.partial1(1)
    require(5 == part1(2,3))
    // 3*3+0
    val part2 = funcNesoy.partial2(3)
    require(9 == part2(3, 0))

}

fun <P1, P2, P3, R>((P1, P2, P3) -> R).partial1(p1: P1) : (P2, P3) -> R {
    return {p2, p3 -> this(p1, p2, p3)}
}

fun <P1, P2, P3, R>((P1, P2, P3) -> R).partial2(p2: P2) : (P1, P3) -> R {
    return {p1, p3 -> this(p1, p2, p3)}
}

fun <P1, P2, P3, R>((P1, P2, P3) -> R).partial3(p3: P3) : (P1, P2) -> R {
    return {p1, p2 -> this(p1, p2, p3)}
}