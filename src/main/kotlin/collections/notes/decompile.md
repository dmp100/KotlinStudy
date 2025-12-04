# 코틀린의 함수는 Java에서 어떻게 동작할까 ?


단순한 Collection 코드를 가져와봤어요.

```kotlin
    val numbers = listOf(1, 2, 3, 4, 5)

    println(numbers)
    // [1, 2, 3, 4, 5]

    val result = numbers.filter { it > 2 }.map { it * 2 }

    println(result)
    // [6, 8, 10]
```

단순한 코드입니다. 직관적으로 이해 할 수 있어요.

`numbers` 변수에 1, 2, 3, 4, 5를 담고 출력하기.

`result` 변수에 위의 정수들을 필터링(`filter`)하고 

새로 리스트를 만들어서(`map`) 2보다 큰 정수들

즉,

`3,4,5`가 되겠죠 ? 이 녀석들을 두배 해주는 람다식입니다.

그런데 저는 너무나 축약된 함수와, 람다식으로 직관적입니다.

여기서 코틀린에 익숙하지않거나, 뭔가 함수들에 이해가 안되서 찾아가서 읽어보실거에요 !!

- map
```kotlin
/**
 * Returns a list containing the results of applying the given [transform] function
 * to each element in the original collection.
 * 
 * @sample samples.collections.Collections.Transformations.map
 */

public inline fun <T, R> Iterable<T>.map(transform: (T) -> R): List<R> {
    return mapTo(ArrayList<R>(collectionSizeOrDefault(10)), transform)
}

```

하지만 저는 여기서도 코틀린에 대해 잘 아는게 아니라서 뭔가 근본적으로 알아가고 싶었어요 !

그래서 저는 이거를 디컴파일을 해보려고 했어요.


> `Tools` -> `Kotlin` -> `Shows Kotlin ByteCode`

를 해주게 되면 이런 코드들이 나와요 !

```
// ================collections/DecompileKt.class =================
// class version 52.0 (52)
// access flags 0x31
public final class collections/DecompileKt {

  // compiled from: decompile.kt
  // debug info: SMAP
decompile.kt
Kotlin
*S Kotlin
*F
+ 1 decompile.kt
collections/DecompileKt
+ 2 _Collections.kt
kotlin/collections/CollectionsKt___CollectionsKt
    ...

  @Lkotlin/Metadata;(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u00a8\u0006\u0002"}, d2={"main", "", "KotlinStudy.main"})

  @Lkotlin/jvm/internal/SourceDebugExtension;(value={"SMAP\ndecompile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 decompile.kt\ncollections/DecompileKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,84:1\n774#2:85\n865#2,2:86\n1563#2:88\n1634#2,3:89\n*S KotlinDebug\n*F\n+ 1 decompile.kt\ncollections/DecompileKt\n*L\n20#1:85\n20#1:86,2\n20#1:88\n20#1:89,3\n*E\n"}) // invisible

  // access flags 0x19
  public final static main()V
   L0
    LINENUMBER 15 L0
    ICONST_5
    ANEWARRAY java/lang/Integer
    ASTORE 1
    ...


  // access flags 0x1009
  public static synthetic main([Ljava/lang/String;)V
   L0
    INVOKESTATIC collections/DecompileKt.main ()V
    RETURN
   L1
    LOCALVARIABLE args [Ljava/lang/String; L0 L1 0
    MAXSTACK = 0
    MAXLOCALS = 1
}
```

조금 줄였는데도 상당히 길죠 ?

이거를 다시 Java로 변환해볼께요 !

```java
package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(
   mv = {2, 1, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"},
   d2 = {"main", "", "Sources of KotlinStudy.main"}
)
@SourceDebugExtension({"SMAP\ndecompile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 decompile.kt\ncollections/DecompileKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,25:1\n774#2:26\n865#2,2:27\n1563#2:29\n1634#2,3:30\n*S KotlinDebug\n*F\n+ 1 decompile.kt\ncollections/DecompileKt\n*L\n20#1:26\n20#1:27,2\n20#1:29\n20#1:30,3\n*E\n"})
public final class DecompileKt {
   public static final void main() {
      Integer[] var1 = new Integer[]{1, 2, 3, 4, 5};
      List numbers = CollectionsKt.listOf(var1);
      System.out.println(numbers);
      Iterable $this$filter$iv = (Iterable)numbers;
      int $i$f$filter = 0;
      Collection destination$iv$iv = (Collection)(new ArrayList());
      int $i$f$filterTo = 0;

      for(Object element$iv$iv : $this$filter$iv) {
         int it = ((Number)element$iv$iv).intValue();
         int var10 = 0;
         if (it > 2) {
            destination$iv$iv.add(element$iv$iv);
         }
      }

      $this$filter$iv = (Iterable)((List)destination$iv$iv);
      $i$f$filter = 0;
      destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$filter$iv, 10)));
      $i$f$filterTo = 0;

      for(Object item$iv$iv : $this$filter$iv) {
         int it = ((Number)item$iv$iv).intValue();
         int var20 = 0;
         destination$iv$iv.add(it * 2);
      }

      List result = (List)destination$iv$iv;
      System.out.println(result);
   }

   // $FF: synthetic method
   public static void main(String[] args) {
      main();
   }
}


```

이런식으로 나옵니다 !! 저도 알아볼수가 없는데요ㅎ;

중요한것만 짚고 넘어가볼께요 !

## Java 코드 뜯어보기 

위의 Java 코드가 너무 길고 복잡해보이지만, 사실 핵심은 간단해요. 메타데이터나 어노테이션 같은 부분은 무시하고, 실제 로직만 보면 이해가 됩니다.

### filter가 실제로 하는 일

디컴파일된 코드에서 filter 부분만 추려보면 이렇습니다.

```java
// 1. 빈 ArrayList를 하나 만들어요
Collection destination$iv$iv = new ArrayList();

// 2. 원본 리스트를 하나씩 돌면서
for(Object element$iv$iv : $this$filter$iv) {
    int it = ((Number)element$iv$iv).intValue();
    
    // 3. 조건에 맞으면 새 리스트에 추가
    if (it > 2) {
        destination$iv$iv.add(element$iv$iv);
    }
}
```

결국 filter는 새로운 ArrayList를 만들어서, 조건에 맞는 요소들만 쏙쏙 골라 담는 거였어요. 우리가 평소에 for문 돌면서 if문 체크하던 그 방식 그대로입니다 !

### map이 실제로 하는 일

map 부분도 똑같아요.

```java
// 1. 또 새로운 ArrayList 생성 (이번엔 크기를 미리 계산해서 최적화)
Collection destination$iv$iv = new ArrayList(
    CollectionsKt.collectionSizeOrDefault($this$filter$iv, 10)
);

// 2. filter 결과를 하나씩 돌면서
for(Object item$iv$iv : $this$filter$iv) {
    int it = ((Number)item$iv$iv).intValue();
    
    // 3. 변환해서 새 리스트에 추가
    destination$iv$iv.add(it * 2);
}
```

map도 결국 새로운 ArrayList를 만들어서, 각 요소를 변환한 값을 담는 거였네요 !

## 여기서 알 수 있는 것들

이렇게 디컴파일해서 보면 몇 가지 중요한 사실을 발견할 수 있어요.

첫 번째로, filter와 map은 각각 새로운 리스트를 생성합니다. 

그러니까 `numbers.filter { it > 2 }.map { it * 2 }` 이 코드는 실제로 중간에 ArrayList가 두 개나 만들어지는 거예요.

하나는 filter 결과용, 하나는 map 결과용이죠. 원본 numbers 리스트까지 합치면 총 3개의 리스트가 메모리에 존재하게 됩니다.

두 번째로, inline 함수의 마법을 볼 수 있어요. 람다가 별도의 객체로 생성되지 않고, 직접 for문 안에 if문과 계산식이 들어가 있죠. 

이게 바로 inline 키워드가 하는 일입니다. 함수 호출 오버헤드를 없애고, 람다를 그 자리에 바로 펼쳐 넣는 거예요.

세 번째로, map은 결과 크기를 미리 계산해서 ArrayList를 생성합니다. 

`collectionSizeOrDefault`를 호출해서 적절한 초기 용량을 설정하는 걸 볼 수 있어요. 

이렇게 하면 ArrayList가 자동으로 크기를 늘리는 비용을 줄일 수 있습니다.

## 그럼 이제 뭘 해야하나요 ?

 이제 다른 함수들도 똑같이 해보면 됩니다 !

이제 방법을 알았으니까, 다른 컬렉션 함수들도 같은 방식으로 뜯어보면 어떻게 동작하는지 알 수 있어요. 예를 들어서 reduce나 fold 같은 함수들이 궁금하다면 똑같이 디컴파일해보면 됩니다.

간단하게 reduce를 한번 볼까요?

```kotlin
val sum = listOf(1, 2, 3, 4, 5).reduce { acc, n -> acc + n }
```

이걸 디컴파일하면 이렇게 나와요.

```java
Iterator var2 = numbers.iterator();
int accumulator = ((Number)var2.next()).intValue(); // 첫 번째 요소로 시작

while(var2.hasNext()) {
    int n = ((Number)var2.next()).intValue();
    accumulator = accumulator + n; // 계속 누적
}
```
reduce는 Iterator를 돌면서 accumulator 변수에 계속 값을 누적하는 방식이었어요. 새로운 리스트를 만드는 게 아니라,

단 하나의 변수만 가지고 계산하는 거죠. 그래서 메모리 효율이 좋은 겁니다.

## 그래서요 ?

이제 여러분도 궁금한 함수가 있으면 직접 디컴파일해서 확인해보세요. groupBy는 어떻게 Map을 만들까요?

flatMap은 정말로 flatten과 map을 합친 걸까요? zip은 두 리스트를 어떻게 합치는 걸까요?

하나씩 확인하다 보면 Kotlin 표준 라이브러리가 어떻게 설계되어 있는지, 왜 이런 함수들이 있는지 이해하게 될 거예요.

그리고 자연스럽게 여러분의 코드도 더 효율적이고 가독성 있게 작성할 수 있게 됩니다!

## 이거 너무 복잡한거 아닌가요 ? 왜 이렇게해야하죠 ?

처음 보면 복잡해 보일 수 있어요. 저도 처음엔 "이게 맞나?" 싶었거든요. 그런데 알고 보니 저만 이상하게 공부하는 게 아니었습니다!

[O'Reilly의 "Kotlin Standard Library Cookbook"](https://www.oreilly.com/library/view/kotlin-standard-library/9781788837668/b3b1147a-3688-47ba-8e48-f9807f94bf31.xhtml) 같은 공식 교재에서도 이 방법을 다루고 있어요. Kotlin의 다양한 개념이 내부적으로 어떻게 구현되는지 발견하고, 코드 디버깅과 최적화에 유용하다고 설명합니다.

[Bekk의 개발 블로그](https://www.bekk.christmas/post/2020/05/using-the-bytecode-viewer-and-decompiler-tools-in-intellij-to-lift-the-veil-of-kotlin's-magic)에서는 "IntelliJ의 Bytecode Viewer와 Decompiler 도구를 사용해서 Kotlin의 마법 베일을 벗기기"라는 제목으로 이 학습 방법을 소개하기도 했어요. 특히 Java 백그라운드를 가진 개발자가 Kotlin을 시작할 때 유용하다고 강조합니다.

실제 개발자들도 많이 사용하는 방법입니다. [Kotlin 공식 포럼](https://discuss.kotlinlang.org/t/viewing-kotlin-bytecode-as-java-for-compiler-generated-classes/3217)에서 한 개발자는 "Kotlin 컴파일러가 코드를 어떻게 생성하는지 배우는 훌륭한 방법"이라고 언급했고, [Medium](https://moshenskyi.medium.com/decompiling-kotlin-code-c56a736ab096)에는 "왜 Kotlin은 main() 함수를 인자 없이 만들 수 있는지" 궁금해서 디컴파일로 공부했다는 글도 올라왔습니다.

실무에서도 활용되요. [CommonsWare의 Android 개발 문서](https://commonsware.com/Kotlin/pages/chap-java-004.html)에서는 Java/Kotlin 상호운용성 이슈를 디버깅할 때 이 방법이 도움이 된다고 설명하고, [Android Studio에서 바이트코드를 확인하는 것](https://medium.com/softaai-blogs/how-to-check-kotlin-bytecode-in-android-studio-8ddd40ac9ff0)이 성능 최적화와 내부 동작 이해에 유용하다고 합니다.

결국 복잡해 보이지만, 실제로는 많은 개발자들이 Kotlin을 깊이 이해하기 위해 사용하는 정석적인 방법이었던 거죠!

## 마무리

처음엔 복잡해 보이지만, 몇 번 해보다 보면 패턴이 보이기 시작합니다. 궁금한 함수를 하나씩 디컴파일하면서 Kotlin이 어떻게 동작하는지 확인해보세요.

이 과정에서 단순히 함수를 사용하는 것을 넘어서, 언제 어떤 함수를 써야 효율적인지 판단할 수 있게 될 거예요. 여러분의 코드가 한 단계 더 성장하는 순간입니다!