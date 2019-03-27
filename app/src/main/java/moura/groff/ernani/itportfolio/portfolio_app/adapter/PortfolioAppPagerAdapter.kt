package moura.groff.ernani.itportfolio.portfolio_app.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import moura.groff.ernani.itportfolio.portfolio_app.content.PortfolioAppContentView

class PortfolioAppPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return PortfolioAppContentView.newInstance()
    }

    override fun getCount(): Int {
        return 3
    }
}