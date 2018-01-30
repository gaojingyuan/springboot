package com.gao.practice.lambda;

import java.util.function.Consumer;

/**
 * Created by jionglu on 17/4/12.
 */
public class LambdaTest {
    public static void main(String[] args) {
        // Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.println( e ) );

        // Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
        // System.out.println(defaulable.notRequired());
        //
        // defaulable = DefaulableFactory.create(OverridableImpl::new);
        // System.out.println(defaulable.notRequired());

        Consumer<String> c = s -> System.out.println(s);
        c.accept("hello lambda!");

//        List<String> collected = new ArrayList<>();
//        collected.add("alpha");
//        collected.add("beta");
//        collected = collected.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());
//        System.out.println(collected);

//        Optional< String > fullName = Optional.ofNullable( "aaa" );
//        System.out.println( "Full Name is set? " + fullName.isPresent() );
//        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
//        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );


    }
}
