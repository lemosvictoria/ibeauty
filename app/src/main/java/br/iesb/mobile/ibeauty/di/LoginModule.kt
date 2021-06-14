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
}