package moura.groff.ernani.itportfolio.portfolio_app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import moura.groff.ernani.itportfolio.entities.AppPortfolio

class PortfolioMainViewModel : ViewModel() {

    private var model = PortfolioMainModel()

    private var mShowLoader = MutableLiveData<Boolean>()
    private var mListAppPortfolio = MutableLiveData<List<AppPortfolio>>()

    val showLoader: MutableLiveData<Boolean>
        get() = mShowLoader
    val listAppPortfolio: MutableLiveData<List<AppPortfolio>>
        get() = mListAppPortfolio

    fun initModel() {
        mShowLoader.value = true
        model.loadAppPortfolio {
            listAppPortfolio.value = it
            mShowLoader.value = false
        }
    }

}