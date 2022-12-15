package com.nbgsoftware.utilities.state

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
sealed class BaseRequestState<T> {
    data class Success<T>(val profile: T) : BaseRequestState<T>()
    data class Failure<T>(val errorMessage: String? = null, val throwable: Throwable? = null) :
        BaseRequestState<T>()
}

sealed class BaseViewState {
    object Loading : BaseViewState()
    data class Success<T>(val profile: T) : BaseViewState()
    data class Failure(val errorMessage: String? = null, val throwable: Throwable? = null) :
        BaseViewState()
}

sealed class BaseActionState