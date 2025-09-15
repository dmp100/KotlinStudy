package oop

/**
 * 날짜: 2025-09-15
 * 주제: PropertyAccessors
 *
 * 배운 내용:
 * - Kotlin에서 클래스의 프로퍼티는 getter와 setter를 통해 접근 가능
 * - 기본 getter/setter는 자동 생성되지만, 커스터마이징 가능
 * - backing property를 이용하면 read-only 컬렉션 등도 안전하게 제공 가능
 * - setter에서 값 검증이나 로깅, getter에서 동적 정보 생성 가능
 */

class Client(name: String, age: Int) {

    // 커스텀 setter와 getter 예제
    var fullName: String = name
        get() {
            println("누군가 fullName을 가져가고 있습니다: $field")
            return field
        }
        set(value) {
            println("fullName이 변경됩니다. 이전값: $field, 새값: $value")
            field = value
        }

    var age: Int = age
        set(value) {
            // 나이가 음수면 기본값으로 설정
            field = if (value < 0) {
                println("나이는 음수일 수 없습니다. 기본값 18로 설정")
                18
            } else {
                value
            }
        }

    // read-only 프로퍼티 info, getter로 동적 생성
    val info: String
        get() {
            return "Client 이름: $fullName, 나이: $age"
        }

    // backing property를 활용한 read-only 컬렉션 예제
    private val _numbers = mutableListOf<Int>()
    val numbers: List<Int> get() = _numbers // 외부에서는 읽기 전용
}

fun main() {
    println("PropertyAccessors 학습 시작!")

    val client = Client("Annie", 20)

    // Getter 사용
    println(client.fullName) // 누군가 fullName을 가져가고 있습니다: Annie
    // Annie

    // Setter 사용
    client.fullName = "Ann"  // fullName이 변경됩니다. 이전값: Annie, 새값: Ann

    // 음수 나이 테스트
    client.age = -5           // 나이는 음수일 수 없습니다. 기본값 18로 설정
    println(client.age)       // 18

    // info getter 사용 (동적 정보 생성)
    println(client.info)      // Client 이름: Ann, 나이: 18

    // read-only 리스트 테스트
    // client.numbers.add(1)  // Error: 외부에서 수정 불가
    println(client.numbers)   // []
}
