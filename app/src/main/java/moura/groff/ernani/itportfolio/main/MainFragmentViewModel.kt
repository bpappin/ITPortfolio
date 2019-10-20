package moura.groff.ernani.itportfolio.main

import android.util.Log
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import moura.groff.ernani.itportfolio.R
import moura.groff.ernani.itportfolio.contact.ContactView
import moura.groff.ernani.itportfolio.hobbies.HobbiesView
import moura.groff.ernani.itportfolio.portfolio_app.PortfolioMainView
import moura.groff.ernani.itportfolio.technical_abilities.AbilitiesView

class MainFragmentViewModel : ViewModel() {

    companion object {
        const val BS_PORTFOLIO = "PORTFOLIO"
        const val BS_TECHABILITIES = "TECHABILITIES"
        const val BS_HOWIWORK = "HOWIWORK"
        const val BS_HOBBIES = "HOBBIES"
        const val BS_CONTACT = "CONTACT"
    }

    private var model = MainModel()

    private var mShowLoader = MutableLiveData<Boolean>()
    private var mShowLoaderPhoto = MutableLiveData<Boolean>()
    private var mName = MutableLiveData<String>()
    private var mRole = MutableLiveData<String>()

    val showLoader: LiveData<Boolean>
        get() = mShowLoader
    val showLoaderPhoto: LiveData<Boolean>
        get() = mShowLoaderPhoto
    val name: LiveData<String>
        get() = mName
    val role: LiveData<String>
        get() = mRole

    fun initModel(ivPhoto: ImageView) {
        mShowLoader.value = true
        mShowLoaderPhoto.value = true
        model.loadProfile {
            mName.value = it.name
            mRole.value = it.role
            mShowLoader.value = false
            loadPhoto(it.photoUrl, ivPhoto)
        }
    }

    fun openPortfolio(fm: FragmentManager?, type: String) {
        fm?.beginTransaction()
                ?.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                ?.addToBackStack(BS_PORTFOLIO)
                ?.replace(R.id.flMainContent, PortfolioMainView(type))
                ?.commit()
    }

    fun openTechnicalAbilities(fm: FragmentManager?) {
        fm?.beginTransaction()
                ?.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                ?.addToBackStack(BS_TECHABILITIES)
                ?.replace(R.id.flMainContent, AbilitiesView())
                ?.commit()
    }

    fun openHowIWork(fm: FragmentManager?) {
        fm?.beginTransaction()
                ?.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                ?.addToBackStack(BS_HOWIWORK)
                ?.replace(R.id.flMainContent, ContactView())
                ?.commit()
    }

    fun openHobbies(fm: FragmentManager?) {
        fm?.beginTransaction()
                ?.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                ?.addToBackStack(BS_HOBBIES)
                ?.replace(R.id.flMainContent, HobbiesView())
                ?.commit()
    }

    fun openContact(fm: FragmentManager?) {
        fm?.beginTransaction()
                ?.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                ?.addToBackStack(BS_CONTACT)
                ?.replace(R.id.flMainContent, ContactView())
                ?.commit()
    }

    fun removeFragment(fm: FragmentManager) {
        fm.popBackStackImmediate(fm.backStackEntryCount, R.id.flMainContent)
    }

    // Get the photo from database and set on ImageView
    private fun loadPhoto(photoUrl: String, imageView: ImageView) {
        FirebaseStorage.getInstance().getReferenceFromUrl(photoUrl)
                .downloadUrl
                .addOnSuccessListener {
                    if (it != null) {
                        Picasso.get().load(it).into(imageView)
                        mShowLoaderPhoto.value = false
                    }
                }
                .addOnFailureListener {
                    Picasso.get().load(R.mipmap.ic_launcher_round).into(imageView)
                    Log.i("MainFragmentViewModel", "FAILURE: " + it.message)
                    mShowLoaderPhoto.value = false
                }
    }
}