package org.example;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Obsrever_interface {
    /*
    public interface Observer<T>{
        void onSubscribe(Disposable d);
        void onNext(T value);
        void onError(Throwable e);
        void onComplete();
    }
     */
    static void example1(){
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        Observer<Integer> myObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                //do nothing with Disposable, disregard for now
            }

            @Override
            public void onNext(Integer value) {
                System.out.println("RECIEVE: "+value);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println(".... done!!");
            }
        };
        source.map(String::length)
                .filter(i->i>=5)
                .subscribe(myObserver);
    }
    public static void main(String[] args) {
       example1();
    }
}
