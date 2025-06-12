package literalanddatatype

/**
 * 날짜: 2025-06-12
 * 주제: measureTimeMillis
 * 
 * 배운 내용:
 * - 동적 VS 정적 타입 비교
 * - 정적타입인 코틀린을 동적으로 시뮬레이션 돌렸을 때의 성능차이.
 * - 정적타입 : 코드길이가 길고 성능이 빠름 -> 깊이가 필요할 때,
 * - 동적타임 : 코드길이가 짧고 성능이 느림 -> 빠르게 시작할 때,
 *
 * 어려웠던 점:
 * - 명시적 타입과 암시적 타입과는 관계없었는데 성능상 관계있는줄 알고 헷갈림
 */
import kotlin.system.measureTimeMillis
import kotlin.system.measureNanoTime
import kotlin.random.Random

/**
 * 정적 vs 동적 타입 성능 비교 - 개선된 버전
 * JVM 최적화를 방지하고 더 현실적인 시나리오 테스트
 */

fun main() {
    println("🔥 정적 vs 동적 타입 성능 비교 (개선된 버전)")
    println("=".repeat(60))

    // 더 긴 워밍업
    println("⏳ JVM 워밍업 중...")
    warmUp()

    // 다양한 테스트들
    testArithmeticOperations()
    testTypeCheckingOverhead()
    testPolymorphicFunctions()
    testRealWorldScenario()
    testMemoryFootprint()
}

fun warmUp() {
    // 충분한 워밍업으로 JIT 컴파일러가 최적화하도록 함
    repeat(50000) { i ->
        // 정적 타입 워밍업
        staticAdd(i, i + 1)
        staticMultiply(i, 2)

        // 동적 타입 워밍업 (다양한 타입으로)
        val types = arrayOf("int", "double", "string")
        val randomType = types[i % 3]
        when (randomType) {
            "int" -> dynamicOperation(i, i + 1, "add")
            "double" -> dynamicOperation(i.toDouble(), (i + 1).toDouble(), "add")
            "string" -> dynamicOperation(i.toString(), (i + 1).toString(), "concat")
        }
    }

    // GC 정리
    System.gc()
    Thread.sleep(100)
}

// 테스트 1: 산술 연산 (예측 불가능한 패턴)
fun testArithmeticOperations() {
    println("\n🧮 산술 연산 테스트 (300만 번)")

    val iterations = 3_000_000
    val random = Random(12345) // 동일한 시드로 재현 가능

    // 정적 타입: 컴파일 타임에 타입 확정
    val staticTime = measureNanoTime {
        var result = 0L
        repeat(iterations) {
            val a = random.nextInt(1000)
            val b = random.nextInt(1000)
            result += staticAdd(a, b)           // 직접 정수 덧셈
            result += staticMultiply(a, 2)      // 직접 정수 곱셈
            result += staticDivide(a, b + 1)    // 직접 정수 나눗셈
        }
        println("정적 결과 체크섬: $result")
    }

    // 동적 타입: 런타임에 타입 검사 필요
    val random2 = Random(12345) // 동일한 패턴
    val dynamicTime = measureNanoTime {
        var result = 0.0
        repeat(iterations) {
            val a = random2.nextInt(1000)
            val b = random2.nextInt(1000)

            // 의도적으로 다양한 타입 섞기
            val aValue: Any = when (a % 4) {
                0 -> a
                1 -> a.toDouble()
                2 -> a.toLong()
                else -> a.toFloat()
            }

            val bValue: Any = when (b % 4) {
                0 -> b
                1 -> b.toDouble()
                2 -> b.toLong()
                else -> b.toFloat()
            }

            result += dynamicOperation(aValue, bValue, "add")
            result += dynamicOperation(aValue, 2, "multiply")
            result += dynamicOperation(aValue, bValue, "divide")
        }
        println("동적 결과 체크섬: $result")
    }

    println("정적 타입: ${staticTime / 1_000_000}ms")
    println("동적 타입: ${dynamicTime / 1_000_000}ms")
    println("성능 비율: ${String.format("%.1f", dynamicTime.toDouble() / staticTime)}배")
    println("오버헤드: ${(dynamicTime - staticTime) / 1_000_000}ms")
}

// 정적 타입 함수들
fun staticAdd(a: Int, b: Int): Int = a + b
fun staticMultiply(a: Int, b: Int): Int = a * b
fun staticDivide(a: Int, b: Int): Int = if (b != 0) a / b else 0

// 동적 타입 연산 (실제 타입 체크 수행)
fun dynamicOperation(a: Any, b: Any, operation: String): Double {
    val numA = convertToNumber(a)
    val numB = convertToNumber(b)

    return when (operation) {
        "add" -> numA + numB
        "multiply" -> numA * numB
        "divide" -> if (numB != 0.0) numA / numB else 0.0
        "concat" -> (a.toString() + b.toString()).length.toDouble()
        else -> 0.0
    }
}

fun convertToNumber(value: Any): Double {
    return when (value) {
        is Int -> value.toDouble()
        is Long -> value.toDouble()
        is Float -> value.toDouble()
        is Double -> value
        is String -> value.toDoubleOrNull() ?: 0.0
        else -> 0.0
    }
}

// 테스트 2: 타입 체크 오버헤드
fun testTypeCheckingOverhead() {
    println("\n🔍 타입 체크 오버헤드 (100만 번)")

    val iterations = 1_000_000

    // 정적: 타입이 확실한 리스트
    val staticNumbers = (1..iterations).toList()
    val staticTime = measureNanoTime {
        var sum = 0L
        for (num in staticNumbers) {
            sum += num * 2  // 타입 체크 없이 바로 연산
        }
    }

    // 동적: 섞인 타입 리스트
    val mixedValues: List<Any> = (1..iterations).map { i ->
        when (i % 5) {
            0 -> i
            1 -> i.toDouble()
            2 -> i.toString()
            3 -> i.toFloat()
            else -> i.toLong()
        }
    }

    val dynamicTime = measureNanoTime {
        var sum = 0.0
        for (value in mixedValues) {
            // 매번 타입 체크 필요
            when (value) {
                is Int -> sum += value * 2
                is Long -> sum += value * 2
                is Float -> sum += value * 2
                is Double -> sum += value * 2
                is String -> sum += (value.toIntOrNull() ?: 0) * 2
                else -> sum += 0
            }
        }
    }

    println("정적 타입: ${staticTime / 1_000_000}ms")
    println("동적 타입: ${dynamicTime / 1_000_000}ms")
    println("성능 비율: ${String.format("%.1f", dynamicTime.toDouble() / staticTime)}배")
}

// 테스트 3: 다형성 함수 호출
fun testPolymorphicFunctions() {
    println("\n🔧 다형성 함수 호출 (50만 번)")

    val iterations = 500_000
    val random = Random(54321)

    // 정적: 구체적인 타입의 함수들
    val staticTime = measureNanoTime {
        repeat(iterations) {
            val value = random.nextInt(100)
            processInt(value)           // 컴파일 타임에 함수 결정
            processString(value.toString())
            processDouble(value.toDouble())
        }
    }

    // 동적: Any 타입으로 런타임에 타입 결정
    val random2 = Random(54321)
    val dynamicTime = measureNanoTime {
        repeat(iterations) {
            val value = random2.nextInt(100)
            val anyValue: Any = when (value % 3) {
                0 -> value
                1 -> value.toString()
                else -> value.toDouble()
            }
            processAny(anyValue)        // 런타임에 타입 체크 후 처리
        }
    }

    println("정적 타입: ${staticTime / 1_000_000}ms")
    println("동적 타입: ${dynamicTime / 1_000_000}ms")
    println("성능 비율: ${String.format("%.1f", dynamicTime.toDouble() / staticTime)}배")
}

// 정적 타입 처리 함수들
fun processInt(value: Int): Int = value * value
fun processString(value: String): Int = value.length
fun processDouble(value: Double): Int = value.toInt()

// 동적 타입 처리 함수
fun processAny(value: Any): Int {
    return when (value) {
        is Int -> value * value
        is String -> value.length
        is Double -> value.toInt()
        is Float -> value.toInt()
        is Long -> value.toInt()
        else -> 0
    }
}

// 테스트 4: 실제 시나리오 (JSON 파싱 시뮬레이션)
fun testRealWorldScenario() {
    println("\n🌍 실제 시나리오: JSON 파싱 시뮬레이션 (10만 번)")

    val iterations = 100_000

    // 정적 타입: 미리 정의된 데이터 클래스
    data class User(val id: Int, val name: String, val score: Double)

    val staticTime = measureTimeMillis {
        repeat(iterations) {
            val user = User(it, "User$it", it * 0.85)
            val processed = user.id + user.name.length + user.score.toInt()
        }
    }

    // 동적 타입: Map으로 시뮬레이션 (실제 JSON과 유사)
    val dynamicTime = measureTimeMillis {
        repeat(iterations) {
            val userData: Map<String, Any> = mapOf(
                "id" to it,
                "name" to "User$it",
                "score" to it * 0.85
            )

            // 매번 타입 체크하며 값 추출
            val id = (userData["id"] as? Int) ?: 0
            val name = (userData["name"] as? String) ?: ""
            val score = (userData["score"] as? Double) ?: 0.0

            val processed = id + name.length + score.toInt()
        }
    }

    println("정적 타입: ${staticTime}ms")
    println("동적 타입: ${dynamicTime}ms")
    println("성능 비율: ${String.format("%.1f", dynamicTime.toDouble() / staticTime)}배")
}

// 테스트 5: 메모리 사용량 (개선된 측정)
fun testMemoryFootprint() {
    println("\n💾 메모리 사용량 비교")

    val size = 50_000
    val runtime = Runtime.getRuntime()

    // 여러 번 측정해서 평균내기
    fun measureMemory(block: () -> Unit): Long {
        val measurements = mutableListOf<Long>()

        repeat(3) {
            System.gc()
            Thread.sleep(100)
            val before = runtime.totalMemory() - runtime.freeMemory()

            block()

            System.gc()
            Thread.sleep(100)
            val after = runtime.totalMemory() - runtime.freeMemory()

            measurements.add(after - before)
        }

        return measurements.average().toLong()
    }

    // 정적 타입 메모리 측정
    var staticData: List<Int>? = null
    val staticMemory = measureMemory {
        staticData = (1..size).toList()  // List<Int>
    }

    // 동적 타입 메모리 측정
    var dynamicData: List<Any>? = null
    val dynamicMemory = measureMemory {
        dynamicData = (1..size).map { i ->
            when (i % 4) {
                0 -> i                    // Int (박싱됨)
                1 -> i.toDouble()         // Double (박싱됨)
                2 -> i.toString()         // String
                else -> i.toFloat()       // Float (박싱됨)
            }
        }
    }

    println("정적 타입 메모리: ${staticMemory / 1024}KB")
    println("동적 타입 메모리: ${dynamicMemory / 1024}KB")

    if (dynamicMemory > 0 && staticMemory > 0) {
        println("메모리 오버헤드: ${String.format("%.1f", dynamicMemory.toDouble() / staticMemory)}배")
    } else {
        println("메모리 측정에 문제 발생 (GC 타이밍 이슈)")
    }

    // 메모리 정리
    staticData = null
    dynamicData = null
    System.gc()

    println("\n📊 최종 결론:")
    println("✅ 정적 타입의 장점:")
    println("  - 컴파일 시점 타입 확정으로 런타임 오버헤드 없음")
    println("  - 직접적인 기계어 명령어 생성 가능")
    println("  - 메모리 효율적 (타입 정보 불필요)")
    println("  - JIT 컴파일러 최적화에 유리")
    println()
    println("❌ 동적 타입의 단점:")
    println("  - 매 연산마다 타입 체크 필요")
    println("  - 타입 변환 오버헤드")
    println("  - 추가 메모리 사용 (타입 정보)")
    println("  - 예측 불가능한 성능")
}