package moura.groff.ernani.itportfolio.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.v4.app.FragmentManager
import moura.groff.ernani.itportfolio.R
import moura.groff.ernani.itportfolio.contact.ContactView
import moura.groff.ernani.itportfolio.hobbies.HobbiesView
import moura.groff.ernani.itportfolio.portfolio_app.PortfolioMainView
import moura.groff.ernani.itportfolio.technical_abilities.AbilitiesView

class MainFragmentViewModel : ViewModel() {

    companion object {
        const val BS_APP = "APP_PORTFOLIO"
        const val BS_GAME = "GAME_PORTFOLIO"
        const val BS_TECHABILITIES = "TECHABILITIES"
        const val BS_HOWIWORK = "HOWIWORK"
        const val BS_HOBBIES = "HOBBIES"
        const val BS_CONTACT = "CONTACT"
    }

    private var model = MainModel()

    private var mShowLoader = MutableLiveData<Boolean>()
    private var mName = MutableLiveData<String>()
    private var mRole = MutableLiveData<String>()

    val showLoader: LiveData<Boolean>
        get() = mShowLoader
    val name: LiveData<String>
        get() = mName
    val role: LiveData<String>
        get() = mRole

    fun initModel() {
        mShowLoader.value = true
        model.loadProfile {
            mName.value = it.name
            mRole.value = it.role
            mShowLoader.value = false
        }
    }

    fun openAppPortfolio(fm: FragmentManager) {
        fm.beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .addToBackStack(BS_APP)
                .replace(R.id.flMainContent, PortfolioMainView())
                .commit()
    }

    fun openGamePortfolio(fm: FragmentManager) {
        fm.beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .addToBackStack(BS_GAME)
                .replace(R.id.flMainContent, PortfolioMainView())
                .commit()
    }

    fun openTechnicalAbilities(fm: FragmentManager) {
        fm.beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .addToBackStack(BS_TECHABILITIES)
                .replace(R.id.flMainContent, AbilitiesView())
                .commit()
    }

    fun openHowIWork(fm: FragmentManager) {
        fm.beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .addToBackStack(BS_HOWIWORK)
                .replace(R.id.flMainContent, PortfolioMainView())
                .commit()
    }

    fun openHobbies(fm: FragmentManager) {
        fm.beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .addToBackStack(BS_HOBBIES)
                .replace(R.id.flMainContent, HobbiesView())
                .commit()
    }

    fun openContact(fm: FragmentManager) {
        fm.beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .addToBackStack(BS_CONTACT)
                .replace(R.id.flMainContent, ContactView())
                .commit()
    }

    fun removeFragment(fm: FragmentManager) {
        fm.popBackStackImmediate(fm.backStackEntryCount, R.id.flMainContent)
    }
}