package app.viscount.loadera.util

import androidx.annotation.StringRes
import app.viscount.loadera.app.App


fun getString(@StringRes id:Int,vararg arg:String):String{
    if(arg.isEmpty()){
        return App.getContext().getString(id)
    }
    return App.getContext().getString(id,*arg)
}

