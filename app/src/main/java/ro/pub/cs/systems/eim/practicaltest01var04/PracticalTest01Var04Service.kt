package ro.pub.cs.systems.eim.practicaltest01var04

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.sqrt
import kotlin.random.Random

class PracticalTest01Var04Service : Service() {

    private val handler = Handler(Looper.getMainLooper())
    private var isRunning = false

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val nume = intent.getStringExtra("nume")
        val grupa = intent.getStringExtra("grupa")

        Log.d("Service", "Pornit")

        if (isRunning) return START_NOT_STICKY
        isRunning = true

        val actions = listOf(
            "ro.pub.cs.systems.eim.practicaltest01.ACTION_1",
            "ro.pub.cs.systems.eim.practicaltest01.ACTION_2",
        )

        fun sendBroadcastPeriodically() {
            Log.d("AAA", "AAA")


            val br = Intent(this, MyReceiver::class.java).apply {
                action = "action1"
                putExtra("nume", nume)
                putExtra("grupa", grupa)
            }

            sendBroadcast(br)

            handler.postDelayed({ sendBroadcastPeriodically() }, 5_000)
        }

        handler.post { sendBroadcastPeriodically() }

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        isRunning = false
        Log.d("Service", "Serviciul a fost oprit")
        super.onDestroy()
    }
}
