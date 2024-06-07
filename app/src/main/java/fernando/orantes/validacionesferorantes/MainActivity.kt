package fernando.orantes.validacionesferorantes

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1- Mandar a llamar todos los elementos de la vista

        val txtName = findViewById<EditText>(R.id.txtName)
        val txtEmail = findViewById<EditText>(R.id.txtEmail)
        val txtPassword = findViewById<EditText>(R.id.txtPassword)
        val txtDUI = findViewById<EditText>(R.id.txtDUI)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val btnRegistrarse= findViewById<Button>(R.id.btnRegistrarse)

        //Hay que programar el boton chero
        btnRegistrarse.setOnClickListener{

            //Se valida que ningun campo este vacio
            if (txtName.text.isEmpty()  || txtEmail.text.isEmpty() || txtEdad.text.isEmpty() || txtDUI.text.isEmpty() ||
                txtPassword.text.isEmpty()) {
                Toast.makeText(this, "Please complete all fields", Toast.LENGTH_SHORT).show()

            }
            else {
                //Comprobar que solo ingrese numeros
                if (!txtEdad.text.matches("[0-9]+".toRegex())) {
                    Toast.makeText(this, "Enter numbers", Toast.LENGTH_SHORT).show()

                } else {
                    //Validar el correo
                    if (!txtEmail.text.matches("[a-zA-Z0-9.-_]+@[a-z]+\\.[a-z]".toRegex())) {
                        Toast.makeText(this, "Enter valid email", Toast.LENGTH_SHORT).show()
                    } else{
                        //Validar las contraseñas
                        if (txtPassword.text.length < 6 || txtPassword.text.matches("[0-9]+".toRegex())){
                            Toast.makeText(this, "The password must contain more than 6 digits", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            if(!txtDUI.text.matches("[0-9]+-[0-9]".toRegex())) {
                                Toast.makeText(this, "Ingrese un DUI valido", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }
        }
    }
}