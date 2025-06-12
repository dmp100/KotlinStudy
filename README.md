# 🎓 Kotlin

## 📚 학습 파트별 바로가기

### 0. [Hello World](https://github.com/dmp100/KotlinStudy/blob/44e3f1e468feb50a7e842cb9ec8e2bc9d53f7e1d/src/main/kotlin/Main.kt)
Hello World | Expression | Statement | How Program Works
### 1.[Literals](./src/main/kotlin/literals/README.md)
문자열, 숫자 리터럴 | String Template, Raw String

### 2.[Variables](./src/main/kotlin/variables/)
val/var, 타입 추론, Nullable (예정)

###  3.[Control Flow](./src/main/kotlin/controlflow/)
if/when, 반복문, 예외처리 (예정)

###  4.[Functions](./src/main/kotlin/functions/)
기본 함수, 람다, 고차함수 (예정)

---

## 🔧 사용법

**새 파일 만들기:**
```bash
./gradlew newStudy
# 코틀린 파일명 입력: NumberLiterals
# 패키지명 입력: literals  
# → 파일 생성 + daily-log 업데이트 + Git 커밋 자동!
```

**파일 실행:**
```bash
# 기본 실행 (StringBasic.kt)
./gradlew run

# 새로 만든 파일 실행
./gradlew runNew -PfileName=NumberLiterals -PpackageName=literals

# 컴파일만 확인
./gradlew compileKotlin
```

---
💡 MySummaryNotes are Here [SummaryInKor](SummaryInKor.md)