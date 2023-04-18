package jdkversion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class jdk10 {

    /**
     * Usage of API documented as @since 1.9+
     */

//    @Test
//    public void testOrElseThrow(){
//        var data = List.of("a","b","c");
//        Optional<String> optional = data.stream()
//                .filter(s -> s.startsWith("z"))
//                .findAny();
//        String res = optional.orElseThrow();
//        System.out.println(res);
//    }
    @Test(expected = UnsupportedOperationException.class)
    public void testCollectionCopyOf() {
        List<String> list = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> "num" + i)
                .collect(Collectors.toList());
//       List<String> newList = List.copyOf(list); //Usage of API documented as @since 10+
        List<String> newList = new ArrayList<>();
        newList.add("not allowed");
    }

}
