package com.example.alarmfuture

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var timeText: TextView
    private lateinit var description: TextView
    private lateinit var btnSetAlarm: Button
    private lateinit var btnStop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeText = findViewById(R.id.timeText)
        description = findViewById(R.id.description)
        btnSetAlarm = findViewById(R.id.btnSetAlarm)
        btnStop = findViewById(R.id.btnStop)

        updateTime()

        btnSetAlarm.setOnClickListener {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.MINUTE, 1)
            val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
            timeText.text = formatter.format(calendar.time)
            description.text = "Будильник установлен на ${formatter.format(calendar.time)}"
        }

        btnStop.setOnClickListener {
            description.text = "Пробуждение остановлено. Выспались?"
            timeText.text = "—"
        }
    }

    private fun updateTime() {
        val calendar = Calendar.getInstance()
        val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
        timeText.text = formatter.format(calendar.time)
    }
}
