package com.example.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import com.example.notifications.databinding.ActivityMain2Binding.inflate
import com.example.notifications.databinding.ActivityMainBinding.inflate

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var button: Button
    private val channelId = "myapp.notifications"
    private val description = "Notification App Example"
    lateinit var builder: Notification.Builder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

editText=findViewById(R.id.editText)
  button=findViewById(R.id.button)


    button.setOnClickListener {


        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val intent = Intent(this, Main3Activity2::class.java)


        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var notificationChannel = NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
             builder = Notification.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_notification)
                .setContentIntent(pendingIntent)
                .setContentTitle("My Notification")
                .setContentText(editText.text.toString())
        } else {
            var builder = Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentIntent(pendingIntent)
                .setContentTitle("My Notification")
                .setContentText(editText.text.toString())
        }
        notificationManager.notify(1234, builder.build())
    }



    }}