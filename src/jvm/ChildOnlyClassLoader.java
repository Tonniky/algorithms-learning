//package jvm;
//
///**
// * 这是一个简单的ClassLoader实现，只能加载一个类
// * 即LoadedInChildClassLoader类.这里需要解决一些麻烦
// * 必须确保每次得到一个新的类
// * (而非系统class loader提供的
// * 重用类).如果此子类所在JAR文件不在系统的classpath中,
// * 不需要这么麻烦.
// */
//static final class ChildOnlyClassLoader extends ClassLoader {
//    ChildOnlyClassLoader() {
//        super(ClassLoaderLeakExample.class.getClassLoader());
//    }
//
//    @Override protected Class<?> loadClass(String name, boolean resolve)
//            throws ClassNotFoundException {
//        if (!LoadedInChildClassLoader.class.getName().equals(name)) {
//            return super.loadClass(name, resolve);
//        }
//        try {
//            Path path = Paths.get(LoadedInChildClassLoader.class.getName()
//                    + ".class");
//            byte[] classBytes = Files.readAllBytes(path);
//            Class<?> c = defineClass(name, classBytes, 0, classBytes.length);
//            if (resolve) {
//                resolveClass(c);
//            }
//            return c;
//        } catch (IOException ex) {
//            throw new ClassNotFoundException("Could not load " + name, ex);
//        }
//    }
//
//    /**
//     * Helper方法会创建一个新的ClassLoader, 加载一个类,
//     * 然后丢弃对它们的所有引用.从理论上讲，应该不会影响GC
//     * 因为没有引用可以逃脱该方法! 但实际上，
//     * 结果会像筛子一样泄漏内存.
//     */
//    static void loadAndDiscard() throws Exception {
//        ClassLoader childClassLoader = new ChildOnlyClassLoader();
//        Class<?> childClass = Class.forName(
//                LoadedInChildClassLoader.class.getName(), true, childClassLoader);
//        childClass.newInstance();
//        // 该方法返回时，将无法访问
//        // childClassLoader或childClass的引用，
//        // 但是这些对象仍会成为GC Root!
//    }
//
//
