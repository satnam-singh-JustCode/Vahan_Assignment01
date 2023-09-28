import android.app.Service
import android.content.Intent
import android.os.IBinder
import java.lang.Thread

class MyForegroundService: Service(),FragmentFratured() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        thread(start = true){
            override fun showResponse()
            println("${Thread.currentThread()} has run.")
            delay(2000)
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
     return null
    }
}