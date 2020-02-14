package almada.jesus.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var ant:Double =0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_0.setOnClickListener{
            type(btn_0)
        }

        btn_1.setOnClickListener{
            type(btn_1)
        }

        btn_2.setOnClickListener{
            type(btn_2)
        }

        btn_3.setOnClickListener{
            type(btn_3)
        }

        btn_4.setOnClickListener{
            type(btn_4)
        }

        btn_5.setOnClickListener{
            type(btn_5)
        }

        btn_6.setOnClickListener{
            type(btn_6)
        }

        btn_7.setOnClickListener{
            type(btn_7)
        }

        btn_8.setOnClickListener{
            type(btn_8)
        }

        btn_9.setOnClickListener{
            type(btn_9)
        }

        btn_suma.setOnClickListener{
            typeOp(btn_suma)
        }

        btn_resta.setOnClickListener{
            typeOp(btn_resta)
        }

        btn_multiplicacion.setOnClickListener{
            typeOp(btn_multiplicacion)
        }

        btn_division.setOnClickListener{
            typeOp(btn_division)
        }

        btn_equals.setOnClickListener{
            equal()
        }

        btn_delete.setOnClickListener{
            del()
        }
    }


    fun type(btn: Button){
        tv_input.append(btn.text)
    }

    fun del(){
        tv_input.setText("")
        tv_operacion.setText("")
        tv_resultado.setText("")
    }

    fun typeOp(btn: Button){
        try {
            ant = tv_input.text.toString().toDouble()
            tv_operacion.setText(btn.text)
        }catch (e: Exception){
            Toast.makeText(applicationContext, "No hay números!", Toast.LENGTH_LONG).show()
        }

        tv_resultado.setText(tv_input.text)
        tv_input.setText("")
    }

    fun equal(){
        eval(ant, tv_input.text.toString().toDouble(), tv_operacion.text.toString().get(0))
        tv_input.setText("")
    }

    fun eval(num1: Double, num2: Double, op: Char){
        when(op){
            '+' -> {
                var Sum= num1+num2
                tv_input.setText("")
                tv_operacion.setText("")
                tv_resultado.setText("$Sum")
            }
            '-'->{
                var Res= num1-num2
                tv_input.setText("")
                tv_operacion.setText("")
                tv_resultado.setText("$Res")
            }
            '*'->{
                var Mul= num1*num2
                tv_input.setText("")
                tv_operacion.setText("")
                tv_resultado.setText("$Mul")
            }
            '/'->{
                if(num2!=0.0){
                    var Div= num1/num2
                    tv_resultado.setText("$Div")
                }else{
                    Toast.makeText(applicationContext, "El segundo numero. no puede ser 0", Toast.LENGTH_LONG).show()
                    tv_input.setText("")
                    tv_operacion.setText("")
                    tv_resultado.setText("")
                }
            }
            else -> Toast.makeText(applicationContext, "este mensaje no se mostrara nunca XD", Toast.LENGTH_LONG).show()
        }
    }
}
