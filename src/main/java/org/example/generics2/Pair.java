package org.example.generics2;

public class Pair<TYPE_F, TYPE_S> {
    private TYPE_F first;
    private TYPE_S second;

    Pair() {

    }

    Pair(TYPE_F first, TYPE_S second) {
        this.first = first;
        this.second = second;
    }

    public TYPE_F getFirst() {
        return first;
    }

    public void setFirst(TYPE_F first) {
        this.first = first;
    }

    public TYPE_S getSecond() {
        return second;
    }

    public void setSecond(TYPE_S second) {
        this.second = second;
    }

    //Static method to create an object.
    //Generics at method level.
    public static <X, Y> Pair<X,Y> of(X first, Y second) {
        return new Pair<>(first, second);
    }
}
