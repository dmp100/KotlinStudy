package oop

/**
 * 날짜: 2025-09-15
 * 주제: Encapsulation
 *
 * 배운 내용:
 * - 캡슐화는 데이터와 그 데이터를 다루는 메소드를 하나로 묶고,
 *   외부에서 불필요하게 접근하지 못하도록 제한하는 객체지향 기법
 * - Getter와 Setter를 통해 안전하게 데이터에 접근 가능
 * - 도메인 특화 메소드를 만들어 현실 세계의 행동을 코드로 표현 가능
 * - 속성 보호를 위해 접근 범위 제한(public, private 등) 활용
 */

class Clock(private var hour: Int, private var minute: Int, private var second: Int) {
    // private: 외부에서 직접 접근할 수 없음
    // 캡슐화를 통해 데이터 보호

    // Getter 메소드: 외부에서 데이터를 읽을 때 사용
    fun getTime(): String {
        return "$hour:$minute:$second"
    }

    // Setter 메소드: 외부에서 데이터를 수정할 때 사용, 안전하게 검증 가능
    fun setTime(h: Int, m: Int, s: Int) {
        if (h in 0..23 && m in 0..59 && s in 0..59) {
            hour = h
            minute = m
            second = s
        } else {
            println("잘못된 시간 입력!")
        }
    }

    // 도메인 특화 메소드: 현실 세계 동작을 코드로 표현
    fun addHour(h: Int) {
        hour = (hour + h) % 24
    }

    fun addMinute(m: Int) {
        val totalMinutes = minute + m
        addHour(totalMinutes / 60)
        minute = totalMinutes % 60
    }

    fun addSecond(s: Int) {
        val totalSeconds = second + s
        addMinute(totalSeconds / 60)
        second = totalSeconds % 60
    }
}

fun main() {
    println("Encapsulation 학습 시작!")

    val clock = Clock(10, 30, 0)

    // 직접 접근 불가: clock.hour = 5 // Error
    println("현재 시간: ${clock.getTime()}") // Getter 사용

    // 시간 변경
    clock.setTime(12, 45, 30) // Setter 사용
    println("변경된 시간: ${clock.getTime()}")

    // 도메인 메소드 사용
    clock.addHour(3)
    clock.addMinute(20)
    clock.addSecond(50)
    println("시간 추가 후: ${clock.getTime()}")
}
