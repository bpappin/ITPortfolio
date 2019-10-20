package moura.groff.ernani.itportfolio.portfolio_app.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import moura.groff.ernani.itportfolio.entities.Portfolio
import moura.groff.ernani.itportfolio.portfolio_app.content.PortfolioContentView

class PortfolioPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var list: List<Portfolio> = listOf()

    override fun getItem(position: Int): Fragment {
        return PortfolioContentView.newInstance(list[position])
    }

    override fun getCount(): Int {
        return list.size
    }

    fun setList(list: List<Portfolio>) {
        this.list = list
    }
}