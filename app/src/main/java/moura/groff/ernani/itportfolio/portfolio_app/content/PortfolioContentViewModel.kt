package moura.groff.ernani.itportfolio.portfolio_app.content

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.ViewModel
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import moura.groff.ernani.itportfolio.R

class PortfolioContentViewModel : ViewModel() {

    /* Load photo or video that came on the Portfolio entity */
    fun loadImage(photoUrl: String, videoUrl: String, imageView: ImageView, imageButton: ImageButton) {
        if (photoUrl != "") {
            imageView.visibility = View.VISIBLE
            imageButton.visibility = View.GONE
            FirebaseStorage.getInstance().getReferenceFromUrl(photoUrl)
                    .downloadUrl
                    .addOnSuccessListener {
                        if (it != null) {
                            Picasso.get().load(it).into(imageView)
                        }
                    }
                    .addOnFailureListener {
                        Picasso.get().load(R.mipmap.ic_launcher_round).into(imageView)
                        Log.i("PortfolioAppContentVM", "FAILURE: " + it.message)
                    }
        } else if (videoUrl != "") {
            imageView.visibility = View.GONE
            imageButton.visibility = View.VISIBLE
        }
    }

    fun setTitle(text: String, textView: AppCompatTextView) {
        textView.text = text
    }

    fun setDescription(text: String, textView: AppCompatTextView) {
        textView.text = text
    }

    /* Call url to watch the video outside the app.
    * For now, it's ok because of database download limit */
    fun callVideo(context: Context?, videoUrl: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(videoUrl))
        context?.startActivity(intent)
    }

}