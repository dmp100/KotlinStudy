# 🎓 Kotlin 학습 여정

## 📚 학습 파트별 바로가기

### 🔤 [Literals](./src/main/kotlin/literals/)
문자열, 숫자 리터럴 | String Template, Raw String

### 📦 [Variables](./src/main/kotlin/variables/)
val/var, 타입 추론, Nullable (예정)

### 🔄 [Control Flow](./src/main/kotlin/controlflow/)
if/when, 반복문, 예외처리 (예정)

### 🎯 [Functions](./src/main/kotlin/functions/)
기본 함수, 람다, 고차함수 (예정)

---

## 🔧 사용법

**새 파일 만들기:**
```bash
./gradlew newStudy
# 파일명 입력: NumberLiterals
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
💡 *더 자세한 학습 과정은 [daily-log.md](./daily-log.md)를 확인하세요!*