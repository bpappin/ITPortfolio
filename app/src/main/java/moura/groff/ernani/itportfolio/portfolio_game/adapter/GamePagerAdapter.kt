package moura.groff.ernani.itportfolio.portfolio_game.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import moura.groff.ernani.itportfolio.entities.GamePortfolio
import moura.groff.ernani.itportfolio.portfolio_game.content.GameContentView

class GamePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var list: List<GamePortfolio> = listOf()

    override fun getItem(position: Int): Fragment {
        return GameContentView.newInstance(list[position])
    }

    override fun getCount(): Int {
        return list.size
    }

    fun setList(list: List<GamePortfolio>) {
        this.list = list
    }

}