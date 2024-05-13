package ir.shariaty.x_o

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

object GameData {
    private var _gameModel : MutableLiveData<GameModel> = MutableLiveData()
    var gameModel : LiveData<GameModel> = _gameModel
    var myID = ""

    fun saveGameModel(model: GameModel){
        _gameModel.postValue(model)
        if (model.gameId !="-1"){
            Firebase.firestore.collection("games")
                .document(model.gameId)
                .set(model)
        }

    }
}