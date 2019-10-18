package moura.groff.ernani.itportfolio.portfolio_app.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import moura.groff.ernani.itportfolio.entities.AppPortfolio
import moura.groff.ernani.itportfolio.portfolio_app.content.PortfolioAppContentView

class PortfolioAppPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var list: List<AppPortfolio> = listOf()

    override fun getItem(position: Int): Fragment {
        return PortfolioAppContentView.newInstance(list[position])
    }

    override fun getCount(): Int {
        return list.size
    }

    fun setList(list: List<AppPortfolio>) {
        this.list = list
    }
}