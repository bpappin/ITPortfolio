package moura.groff.ernani.itportfolio.portfolio_game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_portfolio_main.*
import moura.groff.ernani.itportfolio.R
import moura.groff.ernani.itportfolio.portfolio_game.adapter.GamePagerAdapter

class GameMainView : Fragment() {

    private lateinit var viewModel: GameMainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_portfolio_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "App Portfolio"

        viewModel = ViewModelProviders.of(this).get(GameMainViewModel::class.java)
        viewModel.initModel()

        vpContent.adapter = fragmentManager?.let { GamePagerAdapter(it) }
        tlDots.setupWithViewPager(vpContent, true)

        configObservers()
    }

    fun configObservers() {
        viewModel.listGamePortfolio.observe(this, Observer {
            if (it != null) {
                (vpContent.adapter as GamePagerAdapter).setList(it)
                (vpContent.adapter as GamePagerAdapter).notifyDataSetChanged()
            }
        })

        viewModel.showLoader.observe(this, Observer {
            if (it ?: false) {
                pbLoader.visibility = View.VISIBLE
            } else {
                pbLoader.visibility = View.GONE
            }
        })
    }

}