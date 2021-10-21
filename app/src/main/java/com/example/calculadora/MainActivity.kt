package com.example.calculadora

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.lang.Math.pow
import android.util.Log


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //BOTONES
        botones()
        operaciones()
        //HORIZONTAL
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            botonesdecimal()
            operaciones()

            decimal.setOnClickListener {
                botonesdecimal()
                operaciones()
            }

            binario.setOnClickListener {
                botonbinario()
                operaciones()

            }
            Hexadecimal.setOnClickListener {
                botonhexadecimal()
                operaciones()

            }

        }


    }
    //VARIABLES

    var num1 = 0.0
    var num2 = 0.0
    var aux = 0.0
    var sum = 1
    var res = 2
    var mul = 3
    var div = 4
    var porc = 5
    var op = 0

    //BOTONES BINARIOS
    fun botonbinario() {
        resultado.text = ""
        cero.isEnabled = true
        uno.isEnabled = true
        dos.isEnabled = false //.isEnable para habilitarlo o no ( que funcione o no)
        tres.isEnabled = false
        cuatro.isEnabled = false
        cinco.isEnabled = false
        seis.isEnabled = false
        siete.isEnabled = false
        ocho.isEnabled = false
        nueve.isEnabled = false
        coma.isEnabled = false
        porciento.isEnabled = false
        positivoNegativo.isEnabled = false
    }

    //BOTONES HEXADECIMAL
    fun botonhexadecimal() {
        resultado.text = ""
        cero.isEnabled = true
        uno.isEnabled = true
        dos.isEnabled = true //.isEnable para habilitarlo o no ( que funcione o no)
        tres.isEnabled = true
        cuatro.isEnabled = true
        cinco.isEnabled = true
        seis.isEnabled = true
        siete.isEnabled = true
        ocho.isEnabled = true
        nueve.isEnabled = true
        coma.isEnabled = false
        porciento.isEnabled = false
        positivoNegativo.isEnabled = true
        btnA.isEnabled = true
        btnB.isEnabled = true
        btnC.isEnabled = true
        btnD.isEnabled = true
        btnE.isEnabled = true
        btnF.isEnabled = true
    }

    //BOTONES DECIMAL
    fun botonesdecimal() {
        resultado.text = ""
        cero.isEnabled = true
        uno.isEnabled = true
        dos.isEnabled = true
        tres.isEnabled = true
        cuatro.isEnabled = true
        cinco.isEnabled = true
        seis.isEnabled = true
        siete.isEnabled = true
        ocho.isEnabled = true
        nueve.isEnabled = true
        coma.isEnabled = true
        porciento.isEnabled = true
        positivoNegativo.isEnabled = true
        btnA.isEnabled = false
        btnB.isEnabled = false
        btnC.isEnabled = false
        btnD.isEnabled = false
        btnE.isEnabled = false
        btnF.isEnabled = false

    }

    //CONVIERTE A DECIMAL EL BINARIO
    fun converBinario(numBinario: String): Double {
        var sum = 0.00
        numBinario.reversed().forEachIndexed { k, v ->
            sum += v.toString().toDouble() * pow(2.00, k.toDouble())
        }
        return sum
    }

    //CONVIERTE A BINARIO Y HEXADECIMAL EL DECIMAL
    fun converDecimal(decNum: Double): String {

        if (btnA.isEnabled) {
            return Integer.toHexString(decNum.toInt()).uppercase()
        } else {
            return Integer.toBinaryString(decNum.toInt()).toString()
        }
    }


    //CONVERTIR A HEXADECIMAL
    fun convertirHexadecimal(numHexadecimal: String): Int {
        var decimalhexad = Integer.parseInt(numHexadecimal, 16)
        return decimalhexad
    }

    //TODOS LOS BOTONES
    fun botones() {

        cero.setOnClickListener {
            resultado.text = resultado.text.toString() + "0"
        }
        uno.setOnClickListener {
            resultado.text = resultado.text.toString() + "1"
        }
        dos.setOnClickListener {
            resultado.text = resultado.text.toString() + "2"
        }
        tres.setOnClickListener {
            resultado.text = resultado.text.toString() + "3"
        }
        cuatro.setOnClickListener {
            resultado.text = resultado.text.toString() + "4"
        }
        cinco.setOnClickListener {
            resultado.text = resultado.text.toString() + "5"
        }
        seis.setOnClickListener {
            resultado.text = resultado.text.toString() + "6"
        }
        siete.setOnClickListener {
            resultado.text = resultado.text.toString() + "7"
        }
        ocho.setOnClickListener {
            resultado.text = resultado.text.toString() + "8"
        }
        nueve.setOnClickListener {
            resultado.text = resultado.text.toString() + "9"
        }
        borrar.setOnClickListener {
            resultado.text = ""
            num1 = 0.0
            num2 = 0.0
        }
        porciento.setOnClickListener {
            op = 5

        }
        var varcoma: Boolean = true

        coma.setOnClickListener {
            if (varcoma && resultado.text.toString() != "") {
                var x = resultado.text.toString().indexOf(".")
                if (x == -1) {
                    resultado.text = resultado.text.toString() + "."
                }
            }

        }

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            btnA.setOnClickListener {
                resultado.text = resultado.text.toString() + "A"
            }
            btnB.setOnClickListener {
                resultado.text = resultado.text.toString() + "B"
            }
            btnC.setOnClickListener {
                resultado.text = resultado.text.toString() + "C"
            }
            btnD.setOnClickListener {
                resultado.text = resultado.text.toString() + "D"
            }
            btnE.setOnClickListener {
                resultado.text = resultado.text.toString() + "E"
            }
            btnF.setOnClickListener {
                resultado.text = resultado.text.toString() + "F"
            }
        }
    }

//OPERACIONES
    fun operaciones() {
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            sumar.setOnClickListener {
                if (resultado.text.isNotEmpty()) {
                    if (dos.isEnabled && !btnA.isEnabled) {
                        op = 1

                        num1 = resultado.text.toString().toDouble()
                        resultado.text = ""
                    } else if (btnA.isEnabled) {
                        num1 = convertirHexadecimal(resultado.text.toString()).toDouble()
                        resultado.text = ""
                        op = 1
                    } else {
                        num1 = converBinario(resultado.text.toString())
                        resultado.text = ""
                        op = 1
                    }
                }
            }
            restar.setOnClickListener {
                if (resultado.text.isNotEmpty()) {
                    if (dos.isEnabled && !btnA.isEnabled) {
                        op = 2
                        num1 = resultado.text.toString().toDouble()
                        resultado.text = ""
                    } else if (btnA.isEnabled) {
                        num1 = convertirHexadecimal(resultado.text.toString()).toDouble()
                        resultado.text = ""
                        op = 2
                    } else {
                        num1 = converBinario(resultado.text.toString())
                        resultado.text = ""
                        op = 2
                    }
                }
            }
            dividir.setOnClickListener {
                if (resultado.text.isNotEmpty()) {
                    if (dos.isEnabled && !btnA.isEnabled) {
                        op = 3
                        num1 = resultado.text.toString().toDouble()
                        resultado.text = ""
                    } else if (btnA.isEnabled) {
                        num1 = convertirHexadecimal(resultado.text.toString()).toDouble()
                        resultado.text = ""
                        op = 3
                    } else {
                        num1 = converBinario(resultado.text.toString())
                        resultado.text = ""
                        op = 3
                    }
                }
            }
            multiplicar.setOnClickListener {
                if (resultado.text.isNotEmpty()) {
                    if (dos.isEnabled && !btnA.isEnabled) {
                        op = 4
                        num1 = resultado.text.toString().toDouble()
                        resultado.text = ""
                    } else if (btnA.isEnabled) {
                        num1 = convertirHexadecimal(resultado.text.toString()).toDouble()
                        resultado.text = ""
                        op = 4
                    } else {
                        num1 = converBinario(resultado.text.toString())
                        resultado.text = ""
                        op = 4
                    }
                }
            }
            positivoNegativo.setOnClickListener {
                var aux = 0
                aux = resultado.text.toString().toInt() * -1
                resultado.text = aux.toString()
            }
            igual.setOnClickListener {
                when (op) {
                    1 -> {
                        if (dos.isEnabled && !btnA.isEnabled) {
                            num2 = resultado.text.toString().toDouble()
                            aux = num1 + num2
                            resultado.text = aux.toString()
                        } else if (btnA.isEnabled) {
                            num2 = convertirHexadecimal(resultado.text.toString()).toDouble()
                            aux = num1 + num2
                            resultado.text = converDecimal(aux)
                        } else {
                            num2 = converBinario(resultado.text.toString())
                            aux = num1 + num2
                            resultado.text = converDecimal(aux)
                        }
                    }
                    2 -> {
                        if (dos.isEnabled && !btnA.isEnabled) {
                            num2 = resultado.text.toString().toDouble()
                            aux = num1 - num2
                            resultado.text = aux.toString()
                        } else if (btnA.isEnabled) {
                            num2 = convertirHexadecimal(resultado.text.toString()).toDouble()
                            aux = num1 - num2
                            resultado.text = converDecimal(aux)
                        } else {
                            num2 = converBinario(resultado.text.toString())
                            aux = num1 - num2
                            resultado.text = converDecimal(aux)
                        }
                    }
                    3 -> {
                        if (dos.isEnabled && !btnA.isEnabled) {
                            num2 = resultado.text.toString().toDouble()
                            aux = num1 * num2
                            resultado.text = aux.toString()
                        } else if (btnA.isEnabled) {
                            num2 = convertirHexadecimal(resultado.text.toString()).toDouble()
                            aux = num1 * num2
                            resultado.text = converDecimal(aux)
                        } else {
                            num2 = converBinario(resultado.text.toString())
                            aux = num1 * num2
                            resultado.text = converDecimal(aux)
                        }
                    }
                    4 -> {
                        if (dos.isEnabled && !btnA.isEnabled) {
                            num2 = resultado.text.toString().toDouble()
                            if (num2 == 0.00) {
                                print("No se puede dividir entre 0")
                            }
                            aux = num1 / num2
                            resultado.text = aux.toString()
                        } else if (btnA.isEnabled) {
                            num2 = convertirHexadecimal(resultado.text.toString()).toDouble()
                            aux = num1 / num2
                            resultado.text = converDecimal(aux)
                        } else {
                            num2 = converBinario(resultado.text.toString())
                            aux = num1 / num2
                            resultado.text = converDecimal(aux)
                        }
                    }
                    5 -> {

                        if (num2.toString().isEmpty() && num1.toString().isEmpty())
                            resultado.text =
                                (resultado.text.toString().toDouble() * 1 / 100).toString()
                    }
                }
            }
        }
        else{
            sumar.setOnClickListener {
                if (resultado.text.isNotEmpty()) {
                    if (dos.isEnabled) {
                        op = 1
                        num1 = resultado.text.toString().toDouble()
                        resultado.text = ""
                    }
                }
            }
            restar.setOnClickListener {
                if (resultado.text.isNotEmpty()) {
                    if (dos.isEnabled) {
                        op = 2
                        num1 = resultado.text.toString().toDouble()
                        resultado.text = ""
                    }
                }
            }
            dividir.setOnClickListener {
                if (resultado.text.isNotEmpty()) {
                    if (dos.isEnabled) {
                        op = 3
                        num1 = resultado.text.toString().toDouble()
                        resultado.text = ""
                    }
                }
            }
            multiplicar.setOnClickListener {
                if (resultado.text.isNotEmpty()) {
                    if (dos.isEnabled) {
                        op = 4
                        num1 = resultado.text.toString().toDouble()
                        resultado.text = ""
                    }
                }
            }
            positivoNegativo.setOnClickListener {
                var aux = 0
                aux = resultado.text.toString().toInt() * -1
                resultado.text = aux.toString()
            }
            igual.setOnClickListener {
                when (op) {
                    1 -> {
                        if (dos.isEnabled) {
                            num2 = resultado.text.toString().toDouble()
                            aux = num1 + num2
                            resultado.text = aux.toString()
                        }
                    }
                    2 -> {
                        if (dos.isEnabled) {
                            num2 = resultado.text.toString().toDouble()
                            aux = num1 - num2
                            resultado.text = aux.toString()
                        }
                    }
                    3 -> {
                        if (dos.isEnabled) {
                            num2 = resultado.text.toString().toDouble()
                            aux = num1 / num2
                            resultado.text = aux.toString()
                        }
                    }
                    4 -> {
                        if (dos.isEnabled) {
                            num2 = resultado.text.toString().toDouble()
                            if (num2 == 0.00) {
                                print("No se puede dividir entre 0")
                            }
                            aux = num1 * num2
                            resultado.text = aux.toString()
                        }
                    }
                    5 -> {
                        if (num2.toString().isEmpty() && num1.toString().isEmpty())
                            resultado.text =
                                (resultado.text.toString().toDouble() * 1 / 100).toString()
                    }
                }
            }

        }
    }

}
