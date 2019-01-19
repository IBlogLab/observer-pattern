package org.iblog.support;

/**
 *
 * @param <S> Subject (观察目标)
 * @param <O> Observer (观察者)
 * @param <A> Action (操作元)
 */
public interface Observer<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A> {
    void update(S subject, A type);
}
