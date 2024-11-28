package com.example.vazamento_de_dados_api

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var checkButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailInput = findViewById(R.id.emailInput)
        checkButton = findViewById(R.id.checkButton)
        resultTextView = findViewById(R.id.resultTextView)

        checkButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            if (email.isNotEmpty()) {
                checkEmailLeak(email)
            } else {
                Toast.makeText(this, "Por favor, insira um e-mail", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkEmailLeak(email: String) {
        val api = RetrofitInstance.api
        api.checkEmail(email).enqueue(object : Callback<LeakResponse> {
            override fun onResponse(call: Call<LeakResponse>, response: Response<LeakResponse>) {
                if (response.isSuccessful) {
                    val leakResponse = response.body()
                    if (leakResponse != null && leakResponse.success) {
                        val result = buildString {
                            append("E-mail vazado em ${leakResponse.found} locais:\n\n")
                            leakResponse.sources.forEach {
                                append("- ${it.name} (Data: ${it.date})\n")
                            }
                            append("\nCampos vazados: ${leakResponse.fields.joinToString(", ")}")
                        }
                        resultTextView.text = result
                    } else {
                        resultTextView.text = "Nenhum vazamento encontrado para este e-mail."
                    }
                } else {
                    resultTextView.text = "Erro na consulta. Tente novamente."
                }
            }

            override fun onFailure(call: Call<LeakResponse>, t: Throwable) {
                resultTextView.text = "Erro: ${t.message}"
            }
        })
    }
}
