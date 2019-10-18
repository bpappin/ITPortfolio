package moura.groff.ernani.itportfolio.portfolio_game.content

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.ViewModel


class GameContentViewModel : ViewModel() {

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