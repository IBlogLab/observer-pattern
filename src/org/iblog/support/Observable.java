package org.iblog.support;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @param <S> Subject (观察目标)
 * @param <O> Observer (观察者)
 * @param <A> Argument Type (参数类型)
 */
public abstract class Observable<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A> {
    protected List<O> observers;

    public Observable() {
        this.observers = new CopyOnWriteArrayList<>();
    }

    public void addObserver(O observer) {
        this.observers.add(observer);
    }

    public void removeObserver(O observer) {
        this.observers.remove(observer);
    }

    @SuppressWarnings("unchecked")
    public void notify(A type) {
        for (O observer : observers) {
            observer.update((S) this, type);
        }
    }
}
