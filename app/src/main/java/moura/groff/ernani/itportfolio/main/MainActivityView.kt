package moura.groff.ernani.itportfolio.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import moura.groff.ernani.itportfolio.R

class MainActivityView : AppCompatActivity() {

    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .add(R.id.flMainContent, MainFragmentView())
                .commit()

        viewModel = ViewModelProviders.of(this).get(MainFragmentViewModel::class.java)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        viewModel.removeFragment(supportFragmentManager)
    }
}