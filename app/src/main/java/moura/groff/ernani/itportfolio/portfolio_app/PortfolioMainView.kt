package moura.groff.ernani.itportfolio.portfolio_app

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_portfolio_main.*
import moura.groff.ernani.itportfolio.R
import moura.groff.ernani.itportfolio.portfolio_app.adapter.PortfolioAppPagerAdapter

class PortfolioMainView : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_portfolio_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vpContent.adapter = PortfolioAppPagerAdapter(fragmentManager!!)
        tlDots.setupWithViewPager(vpContent, true)
    }

}