
# 0. 코틀린은 무엇인가 ?


> 코틀린은 명확,간결성이 강한 언어.

> 코틀린은 상속 없이 확장기능 사용가능, 타입추론이 제공되어 문맥기반 변수타입 지정가능.

>  컴파일러가 변수, 표현식, 함수 매개변수의 데이터타입 자동추론. [람다표현식](https://inpa.tistory.com/entry/%E2%98%95-Lambda-Expression)에서 유용

> Java보다 더 안전하고 간결한 대안위해 개발됨

> JVM,Android, JS, Native, 멀티플랫폼 등등 유연하게 사용가능

>  명령형, 함수형, 객체지향, 제네릭 등등 여러 프로그래밍 패러다임 지원
>


# 1. 기본 리터럴

> literalanddatatype : 숫자, 문자열 및 기타 값에 대한 연산 수행
>> 코드에 직접 표현된 고정값 : 정수,문자 ,문자열

> 정수
> > 쉼표 구분 유효 정수 리터럴 : `0`, `1`, `2`, `10`, `11`, `100`.
> > 읽기 쉽게 블록으로 나누기 가능 : `1_000_000`
> > 원하는 만큼 쓸수도 있음 : `1__000_000`, `1_2_3`.
> *주의* !숫자의 시작과 끝엔 쓸수 없음 : `_10` 또는 `100_`

> 문자
> > 단일문자 : `'A'`, `'B'`, `'C'`, `'x'`, `'y'`, `'z'`, `'0'`, `'1'`, `'2'`, `'9'`
> 작은 따옴표로 감싸기, 정수와 구분 필수 (`'9'` and `9`)

>> 문자열
>> 개별 문자의 스퀀스 :`"text"`, `"I want to learn Kotlin"`, `"123456"`, `"e-mail@gmail.com"`
>> 큰 따옴표로 감싸기, 문자와 문자열 구분 (`'A'` and `'A'` )

# 2. 첫 프로그램 작성

> 프로그램
> > 예측 가능한 방식으로 하나씩 실행되는 일련의 명령어

```kotlin
fun main() {
    println("첫 번째")     // 1. 먼저 실행
    println("두 번째")     // 2. 그 다음 실행  
    println("세 번째")     // 3. 마지막 실행
}
```

> 표현식(Expression)
> > 값을 만들어 내는 것.
> > 예: `2 + 3` → 결과는 `5`


> 문장(Statement)
> > 값을 만들어내지 않고, 어떤 동작을 수행
> >예: `println("안녕")` → 화면에 출력하는 동작


# 3. 값 저장하기.

> 변수(variable)란 ? : 문자열(string), 숫자(number), 또는 다른 것이 될 수 있는 값(value)을 저장하는 저장소
> > 이름(name)또는 식별자(identifier)을 가짐
> > >이름을 통해 값에 접근 가능

> Keyword : 언어에서의 특별한 의미, 예약어이며 식별자로 사용가능, 프로그래머가 변경 X
> > EX) `fun`(함수정의),`var`(변수정의) 등등...

> 선언 방법 : `val` & `var`

>> `val` : value, read-only variable(named value)
>>> 초기화(initialized) 후에 변경 X
>>>> 초기화 : 변수 선언시, 초기값 할당
>>>>>`val a = 1`, `class Person(val name: String)`
>>>>>>>>  immutable variable : 초기화후, 변경 및 값 재할당 X

```kotlin
var dayOfWeek = "Monday"
println(dayOfWeek) // Monday를 출력합니다

dayOfWeek = "Tuesday"
println(dayOfWeek) // Tuesday를 출력합니다
```

- = 연산자를 통해서 새 값 할당하기.


>> `var` : mutable-variable
>>> 필요한 만큼 변경 O

- 값을 재할당 할때, 초기 값과 같은 타입이어야만함.
    - Int 쓰는데 Char 쓰면 오류남, Int는 Int로 사용

```kotlin
var number = 10
number = 11 // 괜찮습니다
number = "twelve" // 여기서 오류가 발생합니다!
```


>> `const` : Known at compile-time, with val

> Data Types : 변수, 표현식 또는 함수 매개변수가 보유할 수 있는 값의 종류를 지정하는 분류

- 주요 데이터 타입들
```kotlin
val 정수: Int = 25          // 정수 (1, 2, 3...)
val 실수: Double = 3.14     // 소수점 있는 숫자
val 문자: Char = 'A'        // 한 글자
val 참거짓: Boolean = true   // true 또는 false
val 문자열: String = "안녕"   // 글자들의 모음

```
문자열은 조건문, [정규표현식](https://namu.wiki/w/%EC%A0%95%EA%B7%9C%20%ED%91%9C%ED%98%84%EC%8B%9D)에 사용

- 코틀린에서의 명시적 타입.
```kotlin
val age : Int = 25
// 직접 Integer 라는 타입 명시
```

- 코틀린에서의 암시적 타입.
```kotlin
val age = 25
// 컴파일러가 알아서 Integer 판단
```

- 그럼 대충 타입 지정해서 써도 되지않나요 ?
    -  [정적타입](https://velog.io/@hahan/%EC%A0%95%EC%A0%81%ED%83%80%EC%9E%85-%EC%96%B8%EC%96%B4-vs-%EB%8F%99%EC%A0%81%ED%83%80%EC%9E%85-%EC%96%B8%EC%96%B4)이라서 상관은 없음

### a.  그럼에도 명시적 타입 지정을 해야하는 이유.

1. 코드 가독성, 유지보수
2. API설계 인터페이스(백엔드)
3. 컴파일 시점 오류 방지
4. 팀 협업, 유지보수
5. IDE 혹은 Cursor 같은 프로그램쓸때 빠름.

```kotlin
// 암시적 - 의도가 불분명
val result = calculateSomething()

// 명시적 - 의도가 명확
val result: Double = calculateSomething()
```
이렇게 알아맞춰보세요 하면 나중가면 어지러움





