package ir.shariaty.x_o

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.shariaty.x_o.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playOfflineBtn.setOnClickListener{
                createOfflineGame()
        }

        binding.createOnlineBtn.setOnClickListener{
            createOnlineGame()
        }

        binding.joinOnlineBtn.setOnClickListener{
            joinOnlineGame()
        }
    }

    private fun joinOnlineGame() {
        TODO("Not yet implemented")
    }

    fun createOfflineGame() {
        GameData.saveGameModel(
            GameModel(
                gameStatus = GameStatus.JOINED
            )
        )
        startGame()
    }

    fun createOnlineGame(){
        GameData.myID = "X"
        GameData.saveGameModel(
            GameModel(
                gameStatus = GameStatus.CREATED,
                gameId = Random.nextInt(1000,9999).toString()
            )
        )
        startGame()
    }

    fun startGame(){
        startActivity(Intent(this,GameActivity::class.java))
    }
}