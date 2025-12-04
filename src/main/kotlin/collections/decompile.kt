package collections

/**
 * 날짜: 2025-12-04
 * 주제: decompile
 * 
 * 배운 내용:
 * - 
 * 
 * 어려웠던 점:
 * - 
 */
fun main() {

    val numbers = listOf(1, 2, 3, 4, 5)

    println(numbers)
    // [1, 2, 3, 4, 5]

    val result = numbers.filter { it > 2 }.map { it * 2 }

    println(result)
    // [6, 8, 10]

}

/**
 * package collections;
 *
 * import java.util.ArrayList;
 * import java.util.Collection;
 * import java.util.List;
 * import kotlin.Metadata;
 * import kotlin.collections.CollectionsKt;
 * import kotlin.jvm.internal.SourceDebugExtension;
 *
 * @Metadata(
 *    mv = {2, 1, 0},
 *    k = 2,
 *    xi = 48,
 *    d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"},
 *    d2 = {"main", "", "Sources of KotlinStudy.main"}
 * )
 * @SourceDebugExtension({"SMAP\ndecompile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 decompile.kt\ncollections/DecompileKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,25:1\n774#2:26\n865#2,2:27\n1563#2:29\n1634#2,3:30\n*S KotlinDebug\n*F\n+ 1 decompile.kt\ncollections/DecompileKt\n*L\n20#1:26\n20#1:27,2\n20#1:29\n20#1:30,3\n*E\n"})
 * public final class DecompileKt {
 *    public static final void main() {
 *       Integer[] var1 = new Integer[]{1, 2, 3, 4, 5};
 *       List numbers = CollectionsKt.listOf(var1);
 *       System.out.println(numbers);
 *       Iterable $this$filter$iv = (Iterable)numbers;
 *       int $i$f$filter = 0;
 *       Collection destination$iv$iv = (Collection)(new ArrayList());
 *       int $i$f$filterTo = 0;
 *
 *       for(Object element$iv$iv : $this$filter$iv) {
 *          int it = ((Number)element$iv$iv).intValue();
 *          int var10 = 0;
 *          if (it > 2) {
 *             destination$iv$iv.add(element$iv$iv);
 *          }
 *       }
 *
 *       $this$filter$iv = (Iterable)((List)destination$iv$iv);
 *       $i$f$filter = 0;
 *       destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$filter$iv, 10)));
 *       $i$f$filterTo = 0;
 *
 *       for(Object item$iv$iv : $this$filter$iv) {
 *          int it = ((Number)item$iv$iv).intValue();
 *          int var20 = 0;
 *          destination$iv$iv.add(it * 2);
 *       }
 *
 *       List result = (List)destination$iv$iv;
 *       System.out.println(result);
 *    }
 *
 *    // $FF: synthetic method
 *    public static void main(String[] args) {
 *       main();
 *    }
 * }
 *
 */