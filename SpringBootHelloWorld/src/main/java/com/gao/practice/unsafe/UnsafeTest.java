package com.gao.practice.unsafe;

//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;

public class UnsafeTest {
//    public static void main(String[] args) throws Exception {
//        Field f = Unsafe.class.getDeclaredField("theUnsafe");
//        f.setAccessible(true);
//        Unsafe unsafe = (Unsafe) f.get(null);
//
//        // 不安全的指的是内存不安全不受jvm控制
//
//        // 一 实例化私有构造函数的Player
//        Player player = (Player) unsafe.allocateInstance(Player.class);
//        player.setAge(18);
//        player.setName("li lei");
//        for (Field field : Player.class.getDeclaredFields()) {
//            System.out.println(field.getName() + ":对应的内存偏移地址" + unsafe.objectFieldOffset(field));
//        }
//        System.out.println("-------------------");
//
//        // 二 通过对象的基地址 和偏移量 比较替换数字
//        // unsafe.objectFieldOffset(field)值为12
//        int ageOffset = 12;
//        // 修改内存偏移地址为12的值（age）,返回true,说明通过内存偏移地址修改age的值成功
//        // compareAndSwapInt 参数 ：对象（提供基地址） | offset偏移量 | 预期值 | 修改后的值
//        System.out.println(unsafe.compareAndSwapInt(player, ageOffset, 18, 20));
//        System.out.println("age修改后的值：" + player.getAge());
//        System.out.println("-------------------");
//
//        // 修改内存偏移地址为12的值，但是修改后不保证立马能被其他的线程看到。
//        unsafe.putOrderedInt(player, 12, 32);
//        System.out.println("age修改后的值：" + player.getAge());
//        System.out.println("-------------------");
//
//        // 修改内存偏移地址为12的值，volatile修饰，修改能立马对其他线程可见
//        unsafe.putObjectVolatile(player, 16, "han mei");
//        System.out.println("name修改后的值：" + unsafe.getObjectVolatile(player, 16));
//
//        // 三 声明大数组
//        // 只要内存够大，可以把这个调大，大于Integer.MAX_VALUE
//        long size = (long) Integer.MAX_VALUE + 1;
//        long addr = unsafe.allocateMemory(size);
//        System.out.println("unsafe address :" + addr);
//
//        for (int i = 0; i < size; i++) {
//            unsafe.putByte(addr + i, (byte) 6);
//            if (unsafe.getByte(addr + i) != 6) {
//                System.out.println("failed at offset");
//            }
//        }
//    }
}

class Player {

    private int age;

    private String name;

    private Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}