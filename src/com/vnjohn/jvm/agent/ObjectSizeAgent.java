package com.vnjohn.jvm.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author vnjohn
 * @date 2021/7/2
 */
public class ObjectSizeAgent {
    // Java 内部字节码处理调试叫为 Instrumentation（调弦），所以我们在代理装到我们 JVM 时候可以截获这个 Instrumentation
    private static Instrumentation inst;

    /**
     * 必须要有 premain 函数参数也是固定的,第二个就是 Instrumentation
     * 这个是虚拟机调用的它会帮我们初始化 instrumentation
     * 所以调用 getObjectSize 方法才不会空指针
     */
    public static void premain(String agentArgs,Instrumentation _inst){
        inst = _inst;
    }

    public static long sizeOf(Object o){
        return inst.getObjectSize(o);
    }
}
