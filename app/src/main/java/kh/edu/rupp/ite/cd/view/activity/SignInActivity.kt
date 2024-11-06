package kh.edu.rupp.ite.cd.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kh.edu.rupp.ite.cd.R
import kh.edu.rupp.ite.cd.databinding.ActivitySigninBinding

class SignInActivity:AppCompatActivity() {

    // Declare data members
    private lateinit var binding : ActivitySigninBinding
    private lateinit var auth: FirebaseAuth

    // lifecycle on create
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // Handle Click to login
        binding.loginBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        FirebaseApp.initializeApp(this)
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Handle signUp button click
        binding.btnSignUp.setOnClickListener{

            // Call function into btnSignUp
            registerUser(
                email = findViewById(R.id.txtEmail),
                password = findViewById(R.id.txtPassword),
                username = findViewById(R.id.txtName) ,
            )
        }
    }

    // Start create function registerUser
    private fun registerUser (email: EditText, password: EditText, username: EditText){

        // Start check condition
        if (email.text.isEmpty() && password.text.isEmpty() && username.text.isEmpty()){
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }
        else{
            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Registration successful, update user profile with the username
                        val user = auth.currentUser

                        val profileUpdates = UserProfileChangeRequest.Builder()
                            .setDisplayName(username.toString())
                            .build()

                        //create intent into main activity
                        val intent= Intent(this, MainActivity::class.java)
                        startActivity(intent)

                        user?.updateProfile(profileUpdates)
                            ?.addOnCompleteListener { updateTask ->
                                if (updateTask.isSuccessful) {
                                    Log.d("Registration", "User profile updated.")
                                } else {
                                    Log.w("Registration", "Failed to update user profile.")
                                }
                            }

                        Toast.makeText(this, "Register successful", Toast.LENGTH_SHORT).show()
                    } else {
                        // Registration failed
                        Log.w("Registration", "createUserWithEmail:failure", task.exception)
                    }
                }.addOnFailureListener{
                    Toast.makeText(this, "Error occurred ${it.localizedMessage}", Toast.LENGTH_SHORT)
                        .show()
                }
        }
        //end check condition
    }
    // end function registerUser
}