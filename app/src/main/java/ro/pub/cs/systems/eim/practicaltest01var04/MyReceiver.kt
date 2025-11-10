package ro.pub.cs.systems.eim.practicaltest01var04

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val nume = intent.getStringExtra("nume")
        val grupa = intent.getStringExtra("grupa")

        Log.d("MyReceiver", "Received: $nume $grupa")
    }
}
