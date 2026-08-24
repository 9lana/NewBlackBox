package app.viscount.loadera.view.list

import androidx.lifecycle.MutableLiveData
import app.viscount.loadera.bean.InstalledAppBean
import app.viscount.loadera.data.AppsRepository
import app.viscount.loadera.view.base.BaseViewModel


class ListViewModel(private val repo: AppsRepository) : BaseViewModel() {

    val appsLiveData = MutableLiveData<List<InstalledAppBean>>()

    val loadingLiveData = MutableLiveData<Boolean>()

    fun previewInstalledList() {
        launchOnUI { repo.previewInstallList() }
    }

    fun getInstallAppList(userID: Int) {
        launchOnUI { repo.getInstalledAppList(userID, loadingLiveData, appsLiveData) }
    }
}
