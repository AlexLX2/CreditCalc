package alex.lx.creditcalc

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onCalcClick(view: View) {
        val sum = txtSum.text.toString().toDouble()
        val months = txtMonths.text.toString().toDouble()
        val percent = txtPercent.text.toString().toDouble()
        var rate = 0.0

        if (radioButton.isChecked) {
            val monthPercent = percent / 1200

            rate = (sum * monthPercent) / (1 - Math.pow((1 + monthPercent), -months))
        } else {
            rate = (sum / months) + (sum * percent / 1200)
        }
        txtResultRate.text = "First payment: " + Math.ceil(rate)
    }
}
