import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.lunchbox.R

class BackgroundMusicService : Service() {
    private var mediaPlayer: MediaPlayer? = null
    private val notificationChannelId = "BackgroundMusicChannel"
    private val notificationId = 1

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer = MediaPlayer.create(this, R.raw.food)
        mediaPlayer?.isLooping = true

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel()
        }

        val notification = createNotification()
        startForeground(notificationId, notification)

        mediaPlayer?.start()

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        val channelName = "Background Music"
        val channel = NotificationChannel(
            notificationChannelId,
            channelName,
            NotificationManager.IMPORTANCE_LOW
        )
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    private fun createNotification(): Notification {
        val notificationBuilder = NotificationCompat.Builder(this, notificationChannelId)
            .setContentTitle("Background Music")
            .setContentText("Playing background music...")


        return notificationBuilder.build()
    }
}
