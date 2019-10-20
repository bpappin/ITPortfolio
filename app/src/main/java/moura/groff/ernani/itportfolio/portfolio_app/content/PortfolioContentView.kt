package moura.groff.ernani.itportfolio.portfolio_app.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_portfolio_app_content.*
import moura.groff.ernani.itportfolio.R
import moura.groff.ernani.itportfolio.entities.Portfolio

class PortfolioContentView(ap: Portfolio) : Fragment() {

    private lateinit var viewModel: PortfolioContentViewModel
    private var portfolio: Portfolio = ap

    companion object {
        fun newInstance(portfolio: Portfolio): PortfolioContentView {
            return PortfolioContentView(portfolio)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(PortfolioContentViewModel::class.java)
        return inflater.inflate(R.layout.fragment_portfolio_app_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadImage(portfolio.photoUrl, portfolio.videoUrl, ivImageApp, ibVideoApp)
        viewModel.setTitle(portfolio.name, tvTitle)
        viewModel.setDescription(portfolio.description, tvDescription)

        configView()
    }

    fun configView() {
        ibVideoApp.setOnClickListener {
            viewModel.callVideo(context, portfolio.videoUrl)
        }
    }

}