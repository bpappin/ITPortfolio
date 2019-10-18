package moura.groff.ernani.itportfolio.portfolio_app.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_portfolio_app_content.*
import moura.groff.ernani.itportfolio.R
import moura.groff.ernani.itportfolio.entities.AppPortfolio

class PortfolioAppContentView(ap: AppPortfolio) : Fragment() {

    private lateinit var viewModel: PortfolioAppContentViewModel
    private var appPortfolio: AppPortfolio = ap

    companion object {
        fun newInstance(appPortfolio: AppPortfolio): PortfolioAppContentView {
            return PortfolioAppContentView(appPortfolio)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(PortfolioAppContentViewModel::class.java)
        return inflater.inflate(R.layout.fragment_portfolio_app_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadImage(appPortfolio.photoUrl, appPortfolio.videoUrl, ivImageApp, ibVideoApp)
        viewModel.setTitle(appPortfolio.name, tvTitle)
        viewModel.setDescription(appPortfolio.description, tvDescription)

        configView()
    }

    fun configView() {
        ibVideoApp.setOnClickListener {
            viewModel.callVideo(context, appPortfolio.videoUrl)
        }
    }

}