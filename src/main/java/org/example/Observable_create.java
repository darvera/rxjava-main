package org.example;


import io.reactivex.Observable;


public class Observable_create {

    static void example1() {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("Alpha");
            emitter.onNext("Beta");
            emitter.onNext("Gamma");
            emitter.onNext("Delta");
            emitter.onNext("Epsilon");
            emitter.onComplete();
        });
        source.subscribe(s -> System.out.println("RECEIVED: " + s));
    }

    static void example2() {
        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("Alpha");
                emitter.onNext("Beta");
                emitter.onNext("Gamma");
                emitter.onNext("Delta");
                emitter.onNext("Epsilon");
                emitter.onComplete();
            } catch (Throwable e) {
                emitter.onError(e);
            }
        });
        source.subscribe(s -> System.out.println("RECEIVED: " + s),
                Throwable::printStackTrace);
    }

    static void example3() {
        Observable<String> source = Observable
                .create(emitter -> {
                            try {
                                emitter.onNext("exa");
                                emitter.onNext("example2");
                                emitter.onNext("example3");
                                emitter.onNext("example4");
                                emitter.onComplete();
                            } catch (Throwable e) {
                                emitter.onError(e);
                            }
                        }
                );
        Observable<Integer> length = source.map(String::length);
        Observable<Integer> filtered = length.filter(i->i>=5);
        filtered.subscribe(s->System.out.println(s));

    }

    static void example4(){
        Observable<String> source = Observable.create(
                observableEmitter -> {
                    try{
                        observableEmitter.onNext("Alpha");
                        observableEmitter.onNext("Beta");
                        observableEmitter.onNext("Gamma");
                        observableEmitter.onNext("Delta");
                        observableEmitter.onNext("Epsilon");
                        observableEmitter.onComplete();
                    }catch (Throwable e){
                        observableEmitter.onError(e);
                    }
                }
        );
        source.map(String::length)
                .filter(i->i>=5)
                .subscribe(s->System.out.println("RECIEVE: "+s));
    }
    public static void main(String[] args) {
        example4();
    }


}