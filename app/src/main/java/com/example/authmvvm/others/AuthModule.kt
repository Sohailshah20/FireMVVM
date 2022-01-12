package com.example.authmvvm.others

import com.example.authmvvm.auth.Authmodels.AuthRepository
import com.example.authmvvm.auth.Authmodels.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object AuthModule {

    @ActivityScoped
    @Provides
    fun providesAuthrepository() = AuthRepositoryImpl() as AuthRepository
}