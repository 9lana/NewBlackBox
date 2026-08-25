package app.viscount.loader.view.fake

import androidx.lifecycle.MutableLiveData
import app.viscount.loader.entity.location.BLocation
import app.viscount.loader.bean.FakeLocationBean
import app.viscount.loader.data.FakeLocationRepository
import app.viscount.loader.view.base.BaseViewModel


class FakeLocationViewModel(private val mRepo: FakeLocationRepository) : BaseViewModel() {

    val appsLiveData = MutableLiveData<List<FakeLocationBean>>()


    fun getInstallAppList(userID: Int) {
        launchOnUI {
            mRepo.getInstalledAppList(userID, appsLiveData)
        }
    }

    fun setPattern(userId: Int, pkg: String, pattern: Int) {
        launchOnUI {
            mRepo.setPattern(userId, pkg, pattern)
        }
    }

    fun setLocation(userId: Int, pkg: String, location: BLocation) {
        launchOnUI {
            mRepo.setLocation(userId, pkg, location)
        }
    }

}