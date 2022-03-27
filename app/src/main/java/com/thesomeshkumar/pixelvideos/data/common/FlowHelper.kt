package com.thesomeshkumar.pixelvideos.data.common

import com.thesomeshkumar.pixelvideos.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart

fun <T> Flow<Result<T>>.onFlowStarts() = onStart { emit(Result.Loading) }.catch { e: Throwable ->
    e.printStackTrace()
    emit(Result.Error(RemoteSourceException.Unexpected(R.string.error_client_unexpected_message)))
}