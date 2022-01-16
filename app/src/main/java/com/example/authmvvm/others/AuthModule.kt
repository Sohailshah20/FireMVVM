package com.example.authmvvm.others

import com.example.authmvvm.models.auth.AuthRepository
import com.example.authmvvm.models.auth.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object AuthModule {


    @Provides
    @ViewModelScoped
    fun providesAuthrepository() = AuthRepositoryImpl() as AuthRepository
}