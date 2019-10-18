package moura.groff.ernani.itportfolio.main

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        viewModel.initModel()

        configView()
        configObservers()
    }

    fun configView() {
        cvApp.setOnClickListener {
            viewModel.openAppPortfolio(fragmentManager!!)
        }

        cvGame.setOnClickListener {
            viewModel.openGamePortfolio(fragmentManager!!)
        }

        cvTechAbilities.setOnClickListener {
            viewModel.openTechnicalAbilities(fragmentManager!!)
        }

        cvHowIWork.setOnClickListener {
            viewModel.openHowIWork(fragmentManager!!)
        }

        cvHobbies.setOnClickListener {
            viewModel.openHobbies(fragmentManager!!)
        }

        cvChat.setOnClickListener {
            viewModel.openContact(fragmentManager!!)
        }
    }

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
    }
}