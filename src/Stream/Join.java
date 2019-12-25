//package Stream;
////import org.apache.commons.beanutils.BeanMap;
//
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * Created by Administrator on 2019/5/31.
// */
//public class Join {
//    public static void main(String[] args) throws Exception {
//        Db inst = new Db();
//        List<Employee> es = inst.getEmployee();
//        List r = inst.getPerson().stream().map(p ->
//                        es.stream().filter(e -> e.getPersonID() == p.getPersonID()).findFirst().map(e -> {
//                            Map s = new HashMap();
//                            s.putAll(new BeanMap(e));
//                            s.putAll(new BeanMap(p));
//                            return s;
//                        }).orElse(null)
//        ).filter(p -> p != null).collect(Collectors.toList());
//        r.forEach(System.out::println);
//    }
