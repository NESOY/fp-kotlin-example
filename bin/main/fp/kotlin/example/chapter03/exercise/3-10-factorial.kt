package fp.kotlin.example.chapter03.exercise

/**
 * 연습문제 3-10
 *
 * 연습문제 3-3에서 작성한 ``factorial`` 함수를 메모이제이션을 사용해서 개선해 보라.
 */

fun main() {
    require(1 == factorial(1))
    require(24 == factorial(4))
    require(5040 == factorial(7))
    require(3628800 == factorial(10))
}

val memo = mutableMapOf<Int, Int>()

private fun factorial(n: Int): Int = when (n) {
    1 -> 1
    else -> {
        if(memo[n] != null){
            memo[n]
        }

        val sum = n * factorial(n-1)
        memo[n] = sum
        sum
    }
}


/*
Refactoring Point
1. val -> var 로 선언하기
2. memo pattern 추출하기
3. null handling 잘해보기..
 */
