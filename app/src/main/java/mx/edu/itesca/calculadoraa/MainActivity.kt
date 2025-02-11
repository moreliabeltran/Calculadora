package mx.edu.itesca.calculadoraa

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnCero = findViewById<Button>(R.id.btn0)
        val btnUno = findViewById<Button>(R.id.btn1)
        val btnDos = findViewById<Button>(R.id.btn2)
        val btnTres = findViewById<Button>(R.id.btn3)
        val btnCuatro = findViewById<Button>(R.id.btn4)
        val btnCinco = findViewById<Button>(R.id.btn5)
        val btnSeis = findViewById<Button>(R.id.btn6)
        val btnSiete = findViewById<Button>(R.id.btn7)
        val btnOcho = findViewById<Button>(R.id.btn8)
        val btnNueve = findViewById<Button>(R.id.btn9)

        val btnResult = findViewById<Button>(R.id.btnResult)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)

        val btnSuma = findViewById<Button>(R.id.btnSuma)
        val btnResta = findViewById<Button>(R.id.btnResta)
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        val btnMulti = findViewById<Button>(R.id.btnMulti2)

        val up = findViewById<TextView>(R.id.tvArriba)
        val down = findViewById<TextView>(R.id.tvAbajo)

        btnCero.setOnClickListener {
            val numero = "0"
            agregarNumero(down,numero)
        }
        btnUno.setOnClickListener {
            val numero = "1"
            agregarNumero(down,numero)
        }
        btnDos.setOnClickListener {
            val numero = "2"
            agregarNumero(down,numero)
        }
        btnTres.setOnClickListener {
            val numero = "3"
            agregarNumero(down,numero)
        }
        btnCuatro.setOnClickListener {
            val numero = "4"
            agregarNumero(down,numero)
        }
        btnCinco.setOnClickListener {
            val numero = "5"
            agregarNumero(down,numero)
        }
        btnSeis.setOnClickListener {
            val numero = "6"
            agregarNumero(down,numero)
        }
        btnSiete.setOnClickListener {
            val numero = "7"
            agregarNumero(down,numero)
        }
        btnOcho.setOnClickListener {
            val numero = "8"
            agregarNumero(down,numero)
        }
        btnNueve.setOnClickListener {
            val numero = "9"
            agregarNumero(down,numero)
        }

        var variable: Double = 0.0
        var opcion: String = ""

        btnSuma.setOnClickListener {
            opcion = "1"
            if(up.text.toString().isNotEmpty()){
                variable = up.text.toString().toDouble()
            }else{
                variable = down.text.toString().toDouble()
            }
            up.setText(variable.toString()+"+")
            down.setText("0")
        }
        btnResta.setOnClickListener {
            opcion = "2"
            if(up.text.toString().isNotEmpty()){
                variable = up.text.toString().toDouble()
            }else{
                variable = down.text.toString().toDouble()
            }
            up.setText(variable.toString()+"-")
            down.setText("0")
        }
        btnMulti.setOnClickListener {
            opcion = "3"
            if(up.text.toString().isNotEmpty()){
                variable = up.text.toString().toDouble()
            }else{
                variable = down.text.toString().toDouble()
            }
            up.setText(variable.toString()+"*")
            down.setText("0")
        }
        btnDiv.setOnClickListener {
            opcion = "4"
            if(up.text.toString().isNotEmpty()){
                variable = up.text.toString().toDouble()
            }else{
                variable = down.text.toString().toDouble()
            }
            up.setText(variable.toString()+"/")
            down.setText("0")
        }

        btnResult.setOnClickListener {
            var resultado : Double = 0.0

            if(opcion.equals("1")){
                resultado=variable+down.text.toString().toDouble()
            } else if(opcion.equals("2")){
                resultado=variable-down.text.toString().toDouble()
            } else if(opcion.equals("3")){
                resultado=variable*down.text.toString().toDouble()
            } else if(opcion.equals("4")){
                resultado=variable/down.text.toString().toDouble()
            }

            up.setText(resultado.toString())

            down.setText("0")

        }

        btnBorrar.setOnClickListener {
            up.setText("")
            down.setText("0")
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun agregarNumero(num:TextView, vl: String) {
        if (num.text.toString().equals("0")){
            num.setText(vl)
        }else{
            num.setText(num.text.toString()+vl)
        }
    }
}