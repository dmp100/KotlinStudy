package functions

/**
 * 날짜: 2025-09-15
 * 주제: 함수형 분해 (Functional Decomposition)
 *
 * 배운 내용:
 * - 복잡한 프로그램을 여러 함수로 나누는 함수형 분해 접근법
 * - 큰 문제를 작은 하위 문제들로 분해하는 원리
 * - 코드 구조화, 가독성 향상, 재사용성 증대의 장점
 * - 새로운 기능 추가 시 기존 코드 수정 최소화
 * - when과 if 표현식을 활용한 간결한 함수 작성
 * - 단일 표현식 함수로 더욱 간결한 코드 작성
 *
 * 어려웠던 점:
 * - 어떤 부분을 별도 함수로 분리할지 판단하는 기준
 * - 함수 간의 의존성과 호출 관계 설계
 * - 코드 중복과 재사용성 사이의 균형점
 * - 적절한 함수 크기와 책임 범위 결정
 */
fun main() {

    /*************** - 함수형 분해 전 (단일 함수) - ****************/
    // 문서의 예제: 모든 로직이 main 함수에 집중된 경우

    println("=== 분해 전 구조 (개념) ===")
    println("모든 로직이 main 함수에 집중:")
    println("- 비밀번호 확인")
    println("- 사용자 입력 처리")
    println("- 기기 제어 로직")
    println("- 오류 처리")
    println("→ 코드가 복잡하고 수정이 어려움")

    /*************** - 스마트홈 앱 분해 버전 - ****************/
    // 문서의 핵심 예제: 각 기능을 별도 함수로 분리

    println("\n=== 분해 후 스마트홈 앱 ===")

    // turns the music on and off
    fun controlMusic() {
        println("on/off?")
        val tumbler = readln()
        when (tumbler) {
            "on" -> println("The music is on")
            "off" -> println("The music is off")
            else -> println("Invalid operation")
        }
    }

    // controls the light
    fun controlLight() {
        println("on/off?")
        val tumbler = readln()
        when (tumbler) {
            "on" -> println("The light is on")
            "off" -> println("The light is off")
            else -> println("Invalid operation")
        }
    }

    // controls the door
    fun controlDoor() {
        println("lock/unlock?")
        val tumbler = readln()
        when (tumbler) {
            "lock" -> println("The door is locked")
            "unlock" -> println("The door is unlocked")
            else -> println("Invalid operation")
        }
    }

    // main menu for choosing the action
    fun chooseAction() {
        println("Choose the object: 1 – speakers, 2 – lamp, 3 – door")
        val action = readln()

        when (action) {
            "1" -> controlMusic()
            "2" -> controlLight()
            "3" -> controlDoor()
            else -> println("Invalid action")
        }
    }

    // verifies the password and gives the access to Smart home actions if the password is correct
    fun accessSmartHome() {
        val password = "76543210"
        print("Enter password: ")
        val passwordInput = readln()
        if (passwordInput == password)
            chooseAction()
        else
            println("Incorrect password!")
    }

    // 프로그램 실행
    accessSmartHome()

    /*************** - 새 기능 추가 예제 - ****************/
    // 문서 예제: 전기 주전자 기능 추가

    println("\n=== 새 기능 추가 예제 ===")

    // controls electric kettle
    fun controlKettle() {
        println("on/off?")
        val tumbler = readln()
        when (tumbler) {
            "on" -> println("The kettle is heating water")
            "off" -> println("The kettle is off")
            else -> println("Invalid operation")
        }
    }

    // 확장된 메뉴
    fun chooseActionExtended() {
        println("Choose the object: 1 – speakers, 2 – lamp, 3 – door, 4 – kettle")
        val action = readln()

        when (action) {
            "1" -> controlMusic()
            "2" -> controlLight()
            "3" -> controlDoor()
            "4" -> controlKettle()  // 새로운 기능 추가
            else -> println("Invalid action")
        }
    }

    println("새 기능이 추가된 스마트홈 앱:")
    // chooseActionExtended()  // 실제 실행은 주석 처리

    /*************** - 관용적 패턴: when 표현식 - ****************/
    // 문서의 관용구 예제들

    println("\n=== 관용적 패턴: when 표현식 ===")

    // 비권장: 여러 return문
    fun transformBad(color: String): Int {
        when (color) {
            "Red" -> return 0
            "Green" -> return 1
            "Blue" -> return 2
            else -> return -1
        }
    }

    // 비권장: var 변수 사용
    fun transformVar(color: String): Int {
        var colorNumber = -1
        when (color) {
            "Red" -> colorNumber = 0
            "Green" -> colorNumber = 1
            "Blue" -> colorNumber = 2
        }
        return colorNumber
    }

    // 권장: when 표현식 사용
    fun transform(color: String): Int {
        return when (color) {
            "Red" -> 0
            "Green" -> 1
            "Blue" -> 2
            else -> -1
        }
    }

    // 더 간결한 단일 표현식 함수
    fun transformConcise(color: String) = when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> -1
    }

    println("색깔 변환 테스트:")
    println("Red -> ${transform("Red")}")
    println("Green -> ${transformConcise("Green")}")
    println("Unknown -> ${transform("Purple")}")

    /*************** - 관용적 패턴: if 표현식 - ****************/
    // 문서의 if 표현식 예제

    println("\n=== 관용적 패턴: if 표현식 ===")

    // 간결한 if 표현식 함수
    fun max(a: Int, b: Int) = if (a > b) a else b

    fun min(a: Int, b: Int) = if (a < b) a else b

    fun isAdult(age: Int) = if (age >= 18) "성인" else "미성년자"

    println("최댓값: ${max(10, 5)}")
    println("최솟값: ${min(10, 5)}")
    println("나이 판별: ${isAdult(20)}")

    /*************** - 실용적 활용 예제 - ****************/

    println("\n=== 실용적 활용 예제 ===")

    // 계산기 앱 분해
    fun add(a: Double, b: Double) = a + b
    fun subtract(a: Double, b: Double) = a - b
    fun multiply(a: Double, b: Double) = a * b
    fun divide(a: Double, b: Double) = if (b != 0.0) a / b else Double.NaN

    fun calculate(a: Double, operator: String, b: Double) = when (operator) {
        "+" -> add(a, b)
        "-" -> subtract(a, b)
        "*" -> multiply(a, b)
        "/" -> divide(a, b)
        else -> Double.NaN
    }

    // 학점 계산 시스템 분해
    fun getLetterGrade(score: Int) = when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        else -> "F"
    }

    fun calculateGPA(grades: List<String>) = grades.map { grade ->
        when (grade) {
            "A" -> 4.0
            "B" -> 3.0
            "C" -> 2.0
            "D" -> 1.0
            else -> 0.0
        }
    }.average()

    fun formatGradeReport(name: String, scores: List<Int>): String {
        val grades = scores.map { getLetterGrade(it) }
        val gpa = calculateGPA(grades)
        return "$name - 성적: ${grades.joinToString(", ")}, GPA: %.2f".format(gpa)
    }

    // 테스트
    println("계산기 테스트:")
    println("10 + 5 = ${calculate(10.0, "+", 5.0)}")
    println("10 / 0 = ${calculate(10.0, "/", 0.0)}")

    println("\n학점 시스템 테스트:")
    val studentScores = listOf(95, 87, 78, 92)
    println(formatGradeReport("김학생", studentScores))

    // 사용자 인증 시스템 분해
    fun validatePassword(password: String) = password.length >= 8

    fun validateEmail(email: String) = email.contains("@") && email.contains(".")

    fun authenticateUser(email: String, password: String) =
        validateEmail(email) && validatePassword(password)

    fun getUserRole(email: String) = when {
        email.startsWith("admin") -> "관리자"
        email.contains("staff") -> "직원"
        else -> "일반사용자"
    }

    fun processLogin(email: String, password: String): String {
        return if (authenticateUser(email, password)) {
            val role = getUserRole(email)
            "$role 로그인 성공"
        } else {
            "로그인 실패"
        }
    }

    println("\n인증 시스템 테스트:")
    println(processLogin("admin@company.com", "password123"))
    println(processLogin("user@test.com", "123"))

    /*************** - 분해의 장점 비교 - ****************/

    println("\n=== 함수형 분해의 장점 ===")

    // 분해 전: 모든 로직이 한 함수에
    fun processOrderMonolithic(item: String, quantity: Int, userType: String): String {
        // 가격 계산
        val basePrice = when (item) {
            "book" -> 10.0
            "pen" -> 2.0
            "notebook" -> 5.0
            else -> 0.0
        }

        // 할인 계산
        val discount = when (userType) {
            "student" -> 0.1
            "teacher" -> 0.15
            "senior" -> 0.2
            else -> 0.0
        }

        // 총액 계산
        val total = basePrice * quantity * (1 - discount)

        return "주문: $item x$quantity, 총액: $total"
    }

    // 분해 후: 각 책임을 별도 함수로
    fun getItemPrice(item: String) = when (item) {
        "book" -> 10.0
        "pen" -> 2.0
        "notebook" -> 5.0
        else -> 0.0
    }

    fun getDiscount(userType: String) = when (userType) {
        "student" -> 0.1
        "teacher" -> 0.15
        "senior" -> 0.2
        else -> 0.0
    }

    fun calculateTotal(price: Double, quantity: Int, discount: Double) =
        price * quantity * (1 - discount)

    fun processOrder(item: String, quantity: Int, userType: String): String {
        val price = getItemPrice(item)
        val discount = getDiscount(userType)
        val total = calculateTotal(price, quantity, discount)
        return "주문: $item x$quantity, 총액: $total"
    }

    println("주문 처리 테스트:")
    println(processOrder("book", 3, "student"))

    // 개별 함수 테스트 용이성
    println("개별 함수 테스트:")
    println("책 가격: ${getItemPrice("book")}")
    println("학생 할인율: ${getDiscount("student")}")

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")
    println("함수형 분해의 장점:")
    println("1. 코드 구조화와 가독성 향상")
    println("2. 쉬운 수정과 확장")
    println("3. 함수 재사용으로 코드 간소화")
    println("4. 개별 컴포넌트 테스트 용이")
    println("5. when/if 표현식으로 간결한 코드 작성")
    println("6. 단일 표현식 함수로 더욱 간소화")
}
