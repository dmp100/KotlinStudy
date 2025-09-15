package collections

import java.lang.IllegalArgumentException

/**
 * 날짜: 2025-09-15
 * 주제: Enum (열거형)
 *
 * 배운 내용:
 * - Enum은 관련된 상수들을 하나로 묶어 관리하는 특별한 클래스
 * - enum class 키워드로 생성
 * - 각 상수는 Enum의 인스턴스
 * - 생성자를 통해 속성 추가 가능
 * - 메서드도 추가할 수 있음
 * - name, ordinal, entries, valueOf() 등 내장 기능 제공
 * - 코드의 가독성과 안전성 향상
 *
 * 어려웠던 점:
 * - Enum이 클래스이면서 상수인 개념
 * - 생성자 매개변수와 인스턴스 생성의 관계
 * - entries vs values() 차이점
 * - valueOf()의 대소문자 구분
 */

/*************** - 기본 Enum 정의  - ****************/
// Enum 클래스는 main 함수 외부에 정의해야 함
enum class Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

enum class Status {
    OPEN, PENDING, IN_PROGRESS, RESOLVED, REJECTED, CLOSED
}

enum class Materials {
    GLASS, WOOD, FABRIC, METAL, PLASTIC, CERAMICS, CONCRETE, ROCK
}

/*************** - 속성을 가진 Enum 정의 - ****************/
enum class SimpleRainbow(val color: String) {
    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue"),
    INDIGO("Indigo"),
    VIOLET("Violet")
}

enum class RainbowWithRgb(val color: String, val rgb: String) {
    RED("Red", "#FF0000"),
    ORANGE("Orange", "#FF7F00"),
    YELLOW("Yellow", "#FFFF00"),
    GREEN("Green", "#00FF00"),
    BLUE("Blue", "#0000FF"),
    INDIGO("Indigo", "#4B0082"),
    VIOLET("Violet", "#8B00FF")
}

/*************** - 메서드를 가진 Enum 정의  - ****************/
enum class DetailedRainbow(val color: String, val rgb: String) {
    RED("Red", "#FF0000"),
    ORANGE("Orange", "#FF7F00"),
    YELLOW("Yellow", "#FFFF00"),
    GREEN("Green", "#00FF00"),
    BLUE("Blue", "#0000FF"),
    INDIGO("Indigo", "#4B0082"),
    VIOLET("Violet", "#8B00FF"); // Enum 상수 목록과 메서드 정의 사이에는 세미콜론(;)이 필요함

    fun printFullInfo() {
        println("Color - $color, rgb - $rgb")
    }
}

/*************** - 실용적인 Enum 예제 - ****************/
enum class CharacterClass(
    val className: String,
    val health: Int,
    val mana: Int,
    val primaryStat: String
) {
    WARRIOR("전사", 150, 30, "힘"),
    MAGE("마법사", 80, 200, "지능"),
    ARCHER("궁수", 120, 100, "민첩"),
    PRIEST("성직자", 100, 180, "지혜");

    fun showStats() {
        println("$className - 체력: $health, 마나: $mana, 주요 능력치: $primaryStat")
    }

    fun isSpellCaster(): Boolean {
        return mana > 150
    }
}

enum class OrderStatus(val statusName: String, val description: String) {
    CREATED("생성됨", "주문이 생성되었습니다"),
    PAID("결제완료", "결제가 완료되었습니다"),
    SHIPPED("배송중", "상품이 배송 중입니다"),
    DELIVERED("배송완료", "배송이 완료되었습니다"),
    CANCELLED("취소됨", "주문이 취소되었습니다");

    fun canTransitionTo(newStatus: OrderStatus): Boolean {
        return when (this) {
            CREATED -> newStatus in listOf(PAID, CANCELLED)
            PAID -> newStatus in listOf(SHIPPED, CANCELLED)
            SHIPPED -> newStatus in listOf(DELIVERED, CANCELLED)
            DELIVERED, CANCELLED -> false
        }
    }

    fun getNextPossibleStatuses(): List<OrderStatus> {
        return entries.filter { canTransitionTo(it) }
    }
}

enum class ColorPalette(val color: String, val rgb: String) {
    RED("Red", "#FF0000"),
    ORANGE("Orange", "#FF7F00"),
    YELLOW("Yellow", "#FFFF00"),
    GREEN("Green", "#00FF00"),
    BLUE("Blue", "#0000FF"),
    INDIGO("Indigo", "#4B0082"),
    VIOLET("Violet", "#8B00FF"),
    NULL("", "");

    fun printFullInfo() {
        println("Color - $color, rgb - $rgb")
    }
}

fun findByRgb(rgb: String): ColorPalette {
    for (colorPalette in ColorPalette.entries) {
        if (rgb == colorPalette.rgb) return colorPalette
    }
    return ColorPalette.NULL
}

enum class LogLevel(val level: Int, val prefix: String) {
    DEBUG(1, "[DEBUG]"),
    INFO(2, "[INFO]"),
    WARNING(3, "[WARN]"),
    ERROR(4, "[ERROR]"),
    FATAL(5, "[FATAL]");

    fun shouldLog(currentLevel: LogLevel): Boolean {
        return this.level >= currentLevel.level
    }
}

fun log(level: LogLevel, message: String, currentLogLevel: LogLevel = LogLevel.INFO) {
    if (level.shouldLog(currentLogLevel)) {
        println("${level.prefix} $message")
    }
}

enum class DayOfWeek(val dayName: String, val isWeekend: Boolean) {
    MONDAY("월요일", false),
    TUESDAY("화요일", false),
    WEDNESDAY("수요일", false),
    THURSDAY("목요일", false),
    FRIDAY("금요일", false),
    SATURDAY("토요일", true),
    SUNDAY("일요일", true);

    fun getWorkingHours(): String {
        return if (isWeekend) "휴무" else "09:00 - 18:00"
    }

    companion object {
        fun getWeekdays(): List<DayOfWeek> {
            return entries.filter { !it.isWeekend }
        }

        fun getWeekends(): List<DayOfWeek> {
            return entries.filter { it.isWeekend }
        }
    }
}

enum class ApprovalStatus {
    PENDING, APPROVED, REJECTED
}

fun processRequestGood(status: ApprovalStatus) {
    when (status) {
        ApprovalStatus.PENDING -> println("대기 중")
        ApprovalStatus.APPROVED -> println("승인됨")
        ApprovalStatus.REJECTED -> println("거부됨")
    }
}


fun main() {

    println("=== 기본 Enum 생성 ===")
    println("무지개 색깔들:")
    println("빨간색: ${Rainbow.RED}")
    println("주황색: ${Rainbow.ORANGE}")

    println("\n주문 상태: ${Status.PENDING}")
    println("건축 재료: ${Materials.WOOD}")

    println("\n=== 속성을 가진 Enum ===")
    val color = SimpleRainbow.RED.color
    println("빨간색의 이름: $color")

    val rgb = RainbowWithRgb.RED.rgb
    println("빨간색의 RGB 값: $rgb")

    println("\n=== 메서드를 가진 Enum ===")
    val redColor = DetailedRainbow.RED
    redColor.printFullInfo()

    println("\n=== Enum 내장 속성들 ===")
    val selectedColor: DetailedRainbow = DetailedRainbow.RED
    println("name 속성: ${selectedColor.name}")

    val greenColor: DetailedRainbow = DetailedRainbow.GREEN
    println("ordinal 속성: ${greenColor.ordinal}")

    println("\n모든 색깔의 순서:")
    for (color in DetailedRainbow.entries) {
        println("${color.name}: ${color.ordinal}번째")
    }

    println("\n=== entries와 valueOf() ===")
    fun isRainbow(color: String): Boolean {
        for (enum in DetailedRainbow.entries) {
            if (color.uppercase() == enum.name) return true
        }
        return false
    }

    println("'black'이 무지개 색인가? ${isRainbow("black")}")
    println("'red'가 무지개 색인가? ${isRainbow("red")}")

    println("\nvalueOf() 사용:")
    println(DetailedRainbow.valueOf("RED"))

    try {
        println(DetailedRainbow.valueOf("PINK"))
    } catch (e: IllegalArgumentException) {
        println("'PINK'는 존재하지 않는 색깔입니다: ${e.message}")
    }

    println("\n=== 실용적인 Enum 예제 ===")
    println("캐릭터 클래스 정보:")
    for (characterClass in CharacterClass.entries) {
        characterClass.showStats()
        if (characterClass.isSpellCaster()) {
            println("  → 마법 사용자입니다!")
        }
        println()
    }

    println("주문 상태 전환 예제:")
    val currentStatus = OrderStatus.PAID
    println("현재 상태: ${currentStatus.statusName}")
    println("가능한 다음 상태들:")
    for (nextStatus in currentStatus.getNextPossibleStatuses()) {
        println("  - ${nextStatus.statusName}: ${nextStatus.description}")
    }

    println("\n=== RGB 검색 함수 예제 ===")
    println("RGB '#FF0000' 검색 결과: ${findByRgb("#FF0000")}")
    println("RGB '#FF0001' 검색 결과: ${findByRgb("#FF0001")}")

    println("\n=== Enum의 실제 활용 사례 ===")
    println("로그 시스템 예제:")
    log(LogLevel.DEBUG, "디버그 메시지")
    log(LogLevel.INFO, "정보 메시지")
    log(LogLevel.ERROR, "오류 발생!")

    println("요일별 근무 시간:")
    for (day in DayOfWeek.entries) {
        println("${day.dayName}: ${day.getWorkingHours()}")
    }
    println("\n평일들: ${DayOfWeek.getWeekdays().map { it.dayName }}")
    println("주말들: ${DayOfWeek.getWeekends().map { it.dayName }}")

    println("\n=== Enum 사용의 장점 ===")
    println("Enum의 장점:")
    println("1. 타입 안전성 - 잘못된 값 전달 불가")
    println("2. 가독성 향상 - 의미가 명확함")
    println("3. 유지보수 용이 - 새로운 상수 추가 시 컴파일러가 누락 체크")
    println("4. IDE 지원 - 자동완성과 리팩토링 지원")

    processRequestGood(ApprovalStatus.PENDING)

    println("\n=== 정리 ===")
    println("Enum 핵심 개념:")
    println("1. 관련된 상수들을 그룹으로 관리")
    println("2. 각 상수는 Enum 클래스의 인스턴스")
    println("3. 생성자를 통해 속성 추가 가능")
    println("4. 메서드 정의 가능")
    println("5. 타입 안전성 제공")

    println("\n내장 기능:")
    println("- name: 상수 이름")
    println("- ordinal: 선언 순서 (0부터)")
    println("- entries: 모든 상수 목록")
    println("- valueOf(): 이름으로 상수 찾기")

    println("\n사용 시점:")
    println("- 제한된 값들의 집합")
    println("- 상태나 타입 표현")
    println("- 설정값이나 옵션")
    println("- 분류나 카테고리")

    println("\n주의사항:")
    println("- valueOf()는 대소문자 구분")
    println("- entries는 values()보다 권장")
    println("- 메서드 추가 시 세미콜론(;) 필요")
}