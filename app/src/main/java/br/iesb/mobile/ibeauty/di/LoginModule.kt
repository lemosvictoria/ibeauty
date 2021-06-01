package br.iesb.mobile.ibeauty.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.security.auth.callback.Callback

@Module
@InstallIn(SingletonComponent::class)
class LoginModule {

    private val auth = FirebaseAuth.getInstance()

    @Provides
    fun firebaseAuthProvider() = Firebase.auth

    fun verifyLogin(callback: (Boolean) -> Unit) {
        auth.addAuthStateListener { v ->
            if (v.currentUser == null) {
//                this.verifyLogin { resultado ->
//                    if(resultado){
//                        val intencaoDeChamada = Intent(activity, AppActivity::class.java)
//                        activity?.startActivity(intencaoDeChamada)
//                    }
//
//                    else {
//                        activity?.supportFragmentManager
//                                ?.beginTransaction()
//                                ?.replace(R.id.fundoApp, LoginFragment(), "Fragmento verificação")
//                                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                                ?.commit()
//                    }
//                }
                callback(false)
            } else {
                callback(true)
            }
        }
    }
}