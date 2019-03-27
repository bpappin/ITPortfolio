package moura.groff.ernani.itportfolio.portfolio_app

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class PortfolioMainViewModel : ViewModel() {

    private var mShowLoader = MutableLiveData<Boolean>()
    private var mSuccess = MutableLiveData<Int>()
    private var mShowError = MutableLiveData<String>()

    fun loadViewPager() {

    }

}