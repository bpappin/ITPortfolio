package moura.groff.ernani.itportfolio.portfolio_app

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
import moura.groff.ernani.itportfolio.portfolio_app.adapter.PortfolioPagerAdapter

class PortfolioMainView (private val type: String) : Fragment() {

    private lateinit var viewModel: PortfolioMainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_portfolio_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Portfolio"

        viewModel = ViewModelProviders.of(this).get(PortfolioMainViewModel::class.java)
        viewModel.initModel(type)

        vpContent.adapter = fragmentManager?.let { PortfolioPagerAdapter(it) }
        tlDots.setupWithViewPager(vpContent, true)

        configObservers()
    }

    fun configObservers() {
        /* When receive data, update the app/game list porfolio */
        viewModel.listPortfolio.observe(this, Observer {
            if (it != null) {
                (vpContent.adapter as PortfolioPagerAdapter).setList(it)
                (vpContent.adapter as PortfolioPagerAdapter).notifyDataSetChanged()
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