package moura.groff.ernani.itportfolio.portfolio_app.content

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.ViewModel
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso

class PortfolioAppContentViewModel : ViewModel() {

    fun loadImage(image: String, video: String, imageView: ImageView, imageButton: ImageButton) {
        if (image != "") {
            imageView.visibility = View.VISIBLE
            imageButton.visibility = View.GONE
            FirebaseStorage.getInstance().getReferenceFromUrl(image).downloadUrl.addOnSuccessListener {
                Picasso.get().load(it).into(imageView)
            }
        } else if (video != "") {
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

    fun callVideo(context: Context?, video: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(video))
        context?.startActivity(intent)
    }

}