package com.tsunghsuanparty.utils.ui.basic_framework_demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.broadcast
import kotlinx.coroutines.channels.consumeEach
import java.util.concurrent.atomic.AtomicReference

/**
 * Author: Tsung Hsuan, Lai
 * Created on: 2019/9/4
 * Description:
 */
class BoomMenuViewModel(): ViewModel() {

    val channel = Channel<Int>(Channel.CONFLATED)

    fun userNeedDocs() {
        // Start a new coroutine in a ViewModel

        val job = viewModelScope.launch {
            coroutineScope {
                launch {  }
                val test = async {  }

                test.await()

                repeat(1_000) {

                }

            }

            channel.broadcast(5)

            channel.offer(2)

            activeTask.get()?.cancelAndJoin()
        }

        if (job.isActive) {
            job.cancel()
        }
    }

    private val activeTask = AtomicReference<Deferred<Int>?>(null)
}