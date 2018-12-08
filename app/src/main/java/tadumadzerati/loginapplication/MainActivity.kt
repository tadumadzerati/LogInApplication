package tadumadzerati.loginapplication


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
    }
    public override fun onStart() {
        super.onStart()
        signUp()
        signIn()
        val currentUser = auth.currentUser

    }

    private fun signUp() {
        emailCreateAccountButton.setOnClickListener{
            auth.createUserWithEmailAndPassword(fieldEmail.toString(), fieldPassword.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                    } else {
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }

    private fun signIn(){
        emailSignInButton.setOnClickListener {
            auth.signInWithEmailAndPassword(fieldEmail.toString(), fieldPassword.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
			val intent = Intent(this,SecondActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()

                    }

                }
        }
    }

}
