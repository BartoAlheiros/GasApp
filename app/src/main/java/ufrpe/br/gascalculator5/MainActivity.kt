package ufrpe.br.gascalculator5

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val RESULT = ""

    override fun onSaveInstanceState(savedInstanceState: Bundle?) {
        savedInstanceState?.putString("RESULT",tfResult.text.toString())
        super.onSaveInstanceState(savedInstanceState)
    }

    fun calcular(v: View?) {

        var gasolina = tfGas.text.toString().toDouble()
        var ethanol = tfEthanol.text.toString().toDouble()

        tfResult.text = if(ethanol <= 0.7 * gasolina)
            getString(R.string.ethanolChoice)
        else
            getString(R.string.gasChoice)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null)
            tfResult.text = savedInstanceState.getString("RESULT")

    }
}
