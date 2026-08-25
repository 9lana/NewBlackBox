package app.viscount.loader.util

import app.viscount.loader.data.AppsRepository
import app.viscount.loader.data.FakeLocationRepository
import app.viscount.loader.data.GmsRepository

import app.viscount.loader.view.apps.AppsFactory
import app.viscount.loader.view.fake.FakeLocationFactory
import app.viscount.loader.view.gms.GmsFactory
import app.viscount.loader.view.list.ListFactory



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