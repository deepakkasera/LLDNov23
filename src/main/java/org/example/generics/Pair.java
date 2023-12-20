package org.example.generics;

public class Pair<V, S> {
    V first; // V is a placeholder for datatype for first;
    S second; // S is a placeholder for datatype for second;

    public V getFirst() {
        return first;
    }

    public void setFirst(V first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    //Generic Static Method.
    public static <T> void doSomething(T t) {
        System.out.println(t);
    }

//    public static <X, Y> X doSomething2(X attr1, Y attr2) {
//        return attr1;
//    }
    //Pair.doSomething()
    //? extends Animal

//    public static <X> X doSomething3(X attr1, X attr2) {
//        return attr1;
//    }
}
