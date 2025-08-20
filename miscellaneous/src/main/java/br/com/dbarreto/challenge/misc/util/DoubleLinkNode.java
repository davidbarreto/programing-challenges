package br.com.dbarreto.challenge.misc.util;

public class DoubleLinkNode<T> {

    public T value;
    public DoubleLinkNode<T> prev;
    public DoubleLinkNode<T> next;

    @Override
    public String toString() {
        return "DoubleLinkNode{" +
                "value=" + value +
                '}';
    }
}
