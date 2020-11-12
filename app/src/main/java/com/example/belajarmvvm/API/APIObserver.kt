package com.example.belajarmvvm.API

import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.util.*

abstract class APIObserver<T> constructor(private val compositeDisposable: CompositeDisposable): Observer<T> {
    override fun onComplete() {
        TODO("Not yet implemented")
    }

    override fun onSubscribe(d: Disposable) {
        compositeDisposable.add(d)
    }

    override fun onNext(t: T) {
        onApiSuccess(t)
    }

    override fun onError(e: Throwable) {
        onApiError(e)
    }

    abstract fun onApiSuccess(data: T)
    abstract fun onApiError(er: Throwable)
}