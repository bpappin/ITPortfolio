package moura.groff.ernani.itportfolio.portfolio_app.content

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.widget.ImageView
import com.squareup.picasso.Picasso

class PortfolioAppContentViewModel : ViewModel() {

    fun loadImage(image: Int, imageView: ImageView){
        Picasso.get().load(image).into(imageView)
    }

}