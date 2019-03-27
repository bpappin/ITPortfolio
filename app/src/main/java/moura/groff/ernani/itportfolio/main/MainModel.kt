package moura.groff.ernani.itportfolio.main

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import moura.groff.ernani.itportfolio.entities.Profile

typealias CallbackProfile = (Profile) -> Unit

class MainModel {

    fun saveProfile(profile: Profile) {
        val database = FirebaseFirestore.getInstance()
        database.collection("profiles")
                .add(profile)
                .addOnSuccessListener {
                    Log.i("saveProfile", "SUCCESS: " + it.id)
                }
                .addOnFailureListener {
                    Log.i("saveProfile", "FAILURE: " + it.message)
                }
    }

    fun loadProfile(callback: CallbackProfile) {
        val database = FirebaseFirestore.getInstance()
        database.collection("profiles")
                .get()
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        for (item in it.result!!) {
                            //TODO: WHEN MORE THAN 1 PROFILE (LOGIN APP), CHANGE HERE
                            callback(item.toObject(Profile::class.java))
                        }
                    } else {
                        Log.i("loadProfile", "FAILURE: " + it.exception)
                    }
                }
    }
}