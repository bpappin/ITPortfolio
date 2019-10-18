package moura.groff.ernani.itportfolio.portfolio_game.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_portfolio_app_content.*
import moura.groff.ernani.itportfolio.R
import moura.groff.ernani.itportfolio.entities.GamePortfolio

class GameContentView(gm: GamePortfolio) : Fragment() {

    private lateinit var viewModel: GameContentViewModel
    private var gamePortfolio: GamePortfolio = gm

    companion object {
        fun newInstance(gamePortfolio: GamePortfolio): GameContentView {
            return GameContentView(gamePortfolio)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(GameContentViewModel::class.java)
        return inflater.inflate(R.layout.fragment_portfolio_app_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivImageApp.visibility = View.GONE
        ibVideoApp.visibility = View.VISIBLE

        viewModel.setTitle(gamePortfolio.name, tvTitle)
        viewModel.setDescription(gamePortfolio.description, tvDescription)

        configView()
    }

    fun configView() {
        ibVideoApp.setOnClickListener {
            viewModel.callVideo(context, gamePortfolio.videoUrl)
        }
    }

}