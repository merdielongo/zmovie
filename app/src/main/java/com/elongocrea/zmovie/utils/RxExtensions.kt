package com.elongocrea.zmovie.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable

fun <T : Any> Observable<T>.toLiveData(compositeDisposable: CompositeDisposable): LiveData<T> {
    val liveData = MediatorLiveData<T>()
    compositeDisposable.add(
        this.subscribe(
            { liveData.postValue(it) },
            { liveData.postValue(null) }
        )
    )
    return liveData
}

fun <T : Any> Flowable<T>.toLiveData(compositeDisposable: CompositeDisposable): LiveData<T> {
    val liveData = MediatorLiveData<T>()
    compositeDisposable.add(
        this.subscribe(
            { liveData.postValue(it) },
            { liveData.postValue(null) }
        )
    )
    return liveData
}
