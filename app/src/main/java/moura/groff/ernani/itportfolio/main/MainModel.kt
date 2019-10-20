package moura.groff.ernani.itportfolio.main

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import moura.groff.ernani.itportfolio.entities.Profile

typealias CallbackProfile = (Profile) -> Unit

class MainModel {

    // Save the data on Firestore
    fun saveProfile(profile: Profile) {
        val database = FirebaseFirestore.getInstance()
        database.collection("profiles")
                .add(profile)
                .addOnSuccessListener {
                    Log.i("MainModel saveProfile", "SUCCESS: " + it.id)
                }
                .addOnFailureListener {
                    Log.i("MainModel saveProfile", "FAILURE: " + it.message)
                }
    }

    // Load the data from Firestore
    fun loadProfile(callback: CallbackProfile) {
        val database = FirebaseFirestore.getInstance()
        database.collection("profiles")
                .get()
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        for (item in it.result!!) {
                            callback(item.toObject(Profile::class.java))
                        }
                    }
                }
                .addOnFailureListener {
                    Log.i("MainModel loadProfile", "FAILURE: " + it.message)

                }
    }
}