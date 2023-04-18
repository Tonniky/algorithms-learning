//package jdkversion;
//
//import jdk.incubator.vector.FloatVector;
//import jdk.incubator.vector.VectorSpecies;
//
//public class jdk15 {
//    static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_256;
//
//    void vectorComputation(float[] a, float[] b, float[] c) {
//
////        for (int i = 0; i < a.length; i += SPECIES.length()) {
////            var m = SPECIES.indexInRange(i, a.length);
////            // FloatVector va, vb, vc;
////            var va = FloatVector.fromArray(SPECIES, a, i, m);
////            var vb = FloatVector.fromArray(SPECIES, b, i, m);
////            var vc = va.mul(va).
////                    add(vb.mul(vb)).
////                    neg();
////            vc.intoArray(c, i, m);
////        }
//    }
//
//    @jdk.internal.ValueBased
//    public final class SomeVbc {
//
//        public SomeVbc() {}
//
//        final String ref = "String";
//
//        void abuseVbc() {
//
//            synchronized(ref) {           // OK
//                synchronized (this) {     // WARN
//                }
//            }
//        }
//    }
//
//    final class AuxilliaryAbuseOfVbc {
//
//        void abuseVbc(SomeVbc vbc) {
//
//            synchronized(this) {           // OK
//                synchronized (vbc) {       // WARN
//                }
//            }
//        }
//    }
//
//
//}
