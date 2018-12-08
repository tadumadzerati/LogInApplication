package tadumadzerati.loginapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_main)
        Toast.makeText(this,"Congratulations, You have logged in successful", Toast.LENGTH_SHORT).show()
    }
}
