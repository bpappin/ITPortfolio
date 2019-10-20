package moura.groff.ernani.itportfolio.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_main.*
import moura.groff.ernani.itportfolio.R

class MainFragmentView : Fragment() {

    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = resources.getString(R.string.app_name)

        viewModel = ViewModelProviders.of(this).get(MainFragmentViewModel::class.java)
        viewModel.initModel(ivPhoto)

        configView()
        configObservers()
    }

    fun configView() {
        cvApp.setOnClickListener {
            viewModel.openPortfolio(fragmentManager, "App")
        }

        cvGame.setOnClickListener {
            viewModel.openPortfolio(fragmentManager, "Game")
        }

        cvTechAbilities.setOnClickListener {
            viewModel.openTechnicalAbilities(fragmentManager)
        }

        cvHowIWork.setOnClickListener {
            viewModel.openHowIWork(fragmentManager)
        }

        cvHobbies.setOnClickListener {
            viewModel.openHobbies(fragmentManager)
        }

        cvChat.setOnClickListener {
            viewModel.openContact(fragmentManager)
        }
    }

    // WHEN RECEIVE THE RESULTS AND CHANGES FROM SERVER, UPDATE THE VIEW
    fun configObservers() {
        viewModel.name.observe(this, Observer {
            tvName.text = it
        })

        viewModel.role.observe(this, Observer {
            tvHeadLine.text = it
        })

        viewModel.showLoader.observe(this, Observer {
            if (it ?: false) {
                pbLoader.visibility = View.VISIBLE
            } else {
                pbLoader.visibility = View.GONE
            }
        })

        viewModel.showLoaderPhoto.observe(this, Observer {
            if (it ?: false) {
                pbLoaderPhoto.visibility = View.VISIBLE
            } else {
                pbLoaderPhoto.visibility = View.GONE
            }
        })
    }
}