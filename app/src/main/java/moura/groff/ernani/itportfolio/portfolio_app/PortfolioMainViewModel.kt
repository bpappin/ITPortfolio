package moura.groff.ernani.itportfolio.portfolio_app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import moura.groff.ernani.itportfolio.entities.Portfolio

class PortfolioMainViewModel : ViewModel() {

    private var model = PortfolioMainModel()

    private var mShowLoader = MutableLiveData<Boolean>()
    private var mListPortfolio = MutableLiveData<List<Portfolio>>()

    val showLoader: MutableLiveData<Boolean>
        get() = mShowLoader
    val listPortfolio: MutableLiveData<List<Portfolio>>
        get() = mListPortfolio

    /* Initialize View App and Game Portfolio after receive all the data from Firestore */
    fun initModel(type: String) {
        mShowLoader.value = true
        model.loadAppPortfolio(type, callback = {
            listPortfolio.value = it
            mShowLoader.value = false
        })
    }

}