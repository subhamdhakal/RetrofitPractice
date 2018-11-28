package subham.com.rxkotlinapplication.viewmodel

import subham.com.rxkotlinapplication.Model.MarvelModel
import subham.com.rxkotlinapplication.Model.Model

class MarvelRecyclerViewModel{
    lateinit var marvelModel:MarvelModel

    fun getName():String{

        return marvelModel.name

    }

    fun getRealName():String{
        return marvelModel.realname

    }
    fun getTeam():String{
        return marvelModel.team

    }
    fun getFirstAppreance():String{
        return marvelModel.firstappearance


    }
    fun getCreator():String{
        return marvelModel.createdby

    }


}