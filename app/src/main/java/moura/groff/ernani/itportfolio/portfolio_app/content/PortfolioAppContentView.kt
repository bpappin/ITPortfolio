package moura.groff.ernani.itportfolio.portfolio_app.content

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moura.groff.ernani.itportfolio.R
import kotlinx.android.synthetic.main.fragment_portfolio_app_content.*

class PortfolioAppContentView : Fragment() {

    private lateinit var viewModel: PortfolioAppContentViewModel

    companion object {
        fun newInstance(): PortfolioAppContentView {
            return PortfolioAppContentView()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(PortfolioAppContentViewModel::class.java)
        return inflater.inflate(R.layout.fragment_portfolio_app_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadImage(R.drawable.mockup_gru, ivImageApp)
    }

}