package app.viscount.loader.view.fake

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.viscount.loader.data.FakeLocationRepository


class FakeLocationFactory(private val repo: FakeLocationRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FakeLocationViewModel(repo) as T
    }
}