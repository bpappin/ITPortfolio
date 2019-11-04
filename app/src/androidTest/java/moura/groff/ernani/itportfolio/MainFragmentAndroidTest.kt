package moura.groff.ernani.itportfolio

import android.content.Context
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.google.firebase.FirebaseApp
import moura.groff.ernani.itportfolio.entities.Profile
import moura.groff.ernani.itportfolio.main.MainModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainFragmentAndroidTest {

    private lateinit var context: Context

    @Before
    fun setup() {
        context = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun fullProfile() {
        FirebaseApp.initializeApp(context)

        val fullProfile = Profile()
        fullProfile.name = "Ernani Guilherme Groff Moura"
        fullProfile.role = "Android/Unity Developer"
        fullProfile.photoUrl = "gs://itportfolio-9e1e9.appspot.com/main/eu1.jpg"

        var afterConvert: Profile

        val model = MainModel()
        model.loadProfile {
            afterConvert = it
            assertEquals(fullProfile, afterConvert)
        }
    }
}
