package com.example.lp_disco.util

import android.content.Context
import android.util.Log
import androidx.work.*
import java.net.URL

class DiscoWorker (context: Context, workerParams: WorkerParameters)
    : Worker(context, workerParams) {
    companion object {
        private const val LOG_TAG = "448.CharacterWorker"
        const val UNIQUE_WORK_TIME = "DISCO_API_REQUEST"
        fun buildOneTimeWorkRequest() = OneTimeWorkRequest
            .Builder(DiscoWorker::class.java)
            //.setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
            .build()
        private const val DISCO_API_KEY = "apiDiscoData"
        fun getApiData(outputData: Data) = outputData.getString(DISCO_API_KEY)
    }

    override fun doWork(): Result {
        Log.d(LOG_TAG, "Work request triggered")

        val apiData = URL("https://chargen-api.herokuapp.com").readText()
        Log.d(LOG_TAG, "Got result $apiData")

        val outputData = workDataOf( DISCO_API_KEY to apiData )
        return Result.success(outputData)
    }
}