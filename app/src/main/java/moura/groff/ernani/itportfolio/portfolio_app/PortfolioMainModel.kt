package moura.groff.ernani.itportfolio.portfolio_app

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import moura.groff.ernani.itportfolio.entities.Portfolio

typealias CallbackAppPortfolio = (List<Portfolio>) -> Unit

class PortfolioMainModel {
    /* Load data from Firestore database */
    fun loadAppPortfolio(type: String, callback: CallbackAppPortfolio) {
        val database = FirebaseFirestore.getInstance()
        database.collection("profiles")
                .get()
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        /* Verify if type is game or app to define the subcollection get on the database */
                        val subCollectionName = if (type == "Game") "game_portfolio" else "app_portfolio"
                        database.collection("profiles").document(it.result!!.documents[0].id)
                                .collection(subCollectionName).get()
                                .addOnCompleteListener() {
                                    if (it.isSuccessful) {
                                        val list: MutableList<Portfolio> = mutableListOf()
                                        for (item in it.result!!) {
                                            list.add(item.toObject(Portfolio::class.java))
                                        }
                                        callback(list)
                                    }
                                }
                                .addOnFailureListener {
                                    Log.i("PortfolioMainModel", "FAILURE: " + it.message)
                                }
                    }
                }
    }
}