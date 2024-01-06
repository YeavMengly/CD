package kh.edu.rupp.ite.cd.view.activity

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kh.edu.rupp.ite.cd.R
import kh.edu.rupp.ite.cd.databinding.ActivityLoginBinding


class LoginActivity:AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        // Initialize Firebase = auth
        auth = FirebaseAuth.getInstance()

        //Handle click switch to signUp
        binding.signInBtn.setOnClickListener {
            val intent = Intent(this , SignInActivity::class.java)
            startActivity(intent)
        }

        // Handle login button click
        binding.btnLogin.setOnClickListener {
            loginUser(
                email = findViewById(R.id.txtEmail),
                password = findViewById(R.id.txtPassword)
            )
        }
    }

    // start create function loginUser
    private fun loginUser(email: EditText, password: EditText){

        // Start check condition
        if (email.text.isEmpty() && password.text.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        } else {
            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        var user = auth.currentUser
                        val profileUpdates = UserProfileChangeRequest.Builder()
                            .setDisplayName(email.toString())
                            .build()

                        Log.d(TAG, "signInWithEmail:success")

                        //create intent into main activity
                        val intent= Intent(this, MainActivity::class.java)
                        startActivity(intent)

                        // Login success
                        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                        user?.updateProfile(profileUpdates)
                            ?.addOnCompleteListener { updateTask ->
                                if (updateTask.isSuccessful) {
                                    Log.d("Registration", "User profile updated.")
                                } else {
                                    Log.w("Registration", "Failed to update user profile.")
                                }
                            }

                    } else {
                        // If Login fails, display a message to the user.
                        Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                    }
                }.addOnFailureListener {
                    Toast.makeText(this, "Error occurred ${it.localizedMessage}", Toast.LENGTH_SHORT)
                        .show()
                }
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
        }
        //end check condition
    }
    //end function loginUser


}