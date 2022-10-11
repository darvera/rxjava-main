package org.example;


import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class Observable_just {
    static void example1(){
        Observable<String> source = Observable.just("Alpha","Beta","Gamma","Delta","Epsilon");
        source.map(String::length)
                .filter(i->i>=5)
                .subscribe(s->System.out.println("RECIEVE"+s));

    }
    static void example2(){
        List<String> items = Arrays.asList("Alpha","Beta","Gamma", "Delta", "Epsilon");
        Observable<String> source = Observable.fromIterable(items);
        source.map(String::length)
                .filter(s->s>=5)
                .subscribe(s->System.out.println("RECIEVE: "+s));
    }
    static void example3(){

    }

    public static void main(String[] args) {
        example3();

    }
}
