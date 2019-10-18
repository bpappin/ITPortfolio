package moura.groff.ernani.itportfolio.portfolio_game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import moura.groff.ernani.itportfolio.entities.GamePortfolio

class GameMainViewModel : ViewModel() {

    private var model = GameMainModel()

    private var mShowLoader = MutableLiveData<Boolean>()
    private var mListGamePortfolio = MutableLiveData<List<GamePortfolio>>()

    val showLoader: MutableLiveData<Boolean>
        get() = mShowLoader
    val listGamePortfolio: MutableLiveData<List<GamePortfolio>>
        get() = mListGamePortfolio

    fun initModel() {
        mShowLoader.value = true
        model.loadGamePortfolio {
            listGamePortfolio.value = it
            mShowLoader.value = false
        }
    }
}