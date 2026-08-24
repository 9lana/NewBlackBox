package app.viscount.loadera.util

import app.viscount.loadera.data.AppsRepository
import app.viscount.loadera.data.FakeLocationRepository
import app.viscount.loadera.data.GmsRepository

import app.viscount.loadera.view.apps.AppsFactory
import app.viscount.loadera.view.fake.FakeLocationFactory
import app.viscount.loadera.view.gms.GmsFactory
import app.viscount.loadera.view.list.ListFactory



object InjectionUtil {

    private val appsRepository = AppsRepository()



    private val gmsRepository = GmsRepository()

    private val fakeLocationRepository = FakeLocationRepository()

    fun getAppsFactory() : AppsFactory {
        return AppsFactory(appsRepository)
    }

    fun getListFactory(): ListFactory {
        return ListFactory(appsRepository)
    }


    fun getGmsFactory():GmsFactory{
        return GmsFactory(gmsRepository)
    }

    fun getFakeLocationFactory():FakeLocationFactory{
        return FakeLocationFactory(fakeLocationRepository)
    }
}