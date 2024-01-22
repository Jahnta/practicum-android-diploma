package ru.practicum.android.diploma.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Debounce {

    private var job: Job? = null

    fun <T> launch(
        delayMillis: Long,
        coroutineScope: CoroutineScope,
        useLastParam: Boolean,
        action: (T) -> Unit
    ): (T) -> Unit {
        return { param: T ->
            if (useLastParam) {
                job?.cancel()
            }
            if (job?.isCompleted != false || useLastParam) {
                job = coroutineScope.launch {
                    delay(delayMillis)
                    action(param)
                }
            }
        }
    }

    fun cancel() {
        job?.cancel()
    }
}
