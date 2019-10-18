package moura.groff.ernani.itportfolio.portfolio_game

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import moura.groff.ernani.itportfolio.entities.GamePortfolio

typealias CallbackGamePortfolio = (List<GamePortfolio>) -> Unit

class GameMainModel {

    fun loadGamePortfolio(callback: CallbackGamePortfolio) {
        val database = FirebaseFirestore.getInstance()
        database.collection("profiles")
                .get()
                .addOnCompleteListener() {
                    if (it.isSuccessful) {
                        database.collection("profiles").document(it.result!!.documents[0].id)
                                .collection("game_portfolio").get()
                                .addOnCompleteListener() {
                                    if (it.isSuccessful) {
                                        val list: MutableList<GamePortfolio> = mutableListOf()
                                        for (item in it.result!!) {
                                            list.add(item.toObject(GamePortfolio::class.java))
                                        }
                                        callback(list)
                                    } else {
                                        Log.i("loadGamePortfolio", "FAILURE: " + it.exception)
                                    }
                                }
                    }
                }
    }

}