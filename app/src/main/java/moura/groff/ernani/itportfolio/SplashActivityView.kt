package moura.groff.ernani.itportfolio

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import moura.groff.ernani.itportfolio.main.MainActivityView

class SplashActivityView : AppCompatActivity(), Runnable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed(this, 2500)
    }

    override fun run() {
        startActivity(Intent(this, MainActivityView::class.java))
        finish()
    }
}