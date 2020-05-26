package com.example.blockone_onboarding.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.util.concurrent.Executors

private val IO_EXECUTOR = Executors.newSingleThreadExecutor()
val mainScope = CoroutineScope(Dispatchers.Main + Job())
val ioScope = CoroutineScope(Dispatchers.IO + Job() )
val defaultScope = CoroutineScope(Dispatchers.Default + Job())


fun executeOnIo(f : () -> Unit) {
    IO_EXECUTOR.execute(f)
}