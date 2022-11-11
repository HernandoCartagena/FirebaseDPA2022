package dev.hcartagena.firebasedpa2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = FirebaseFirestore.getInstance()
        val tvCurso: TextView = findViewById(R.id.tvCurso)
        val tvNota: TextView = findViewById(R.id.tvNota)

        db.collection("cursos")
            .addSnapshotListener{ snapshots, e->
                if(e!=null){
                    Log.w("Firebase","errorrrrrr", e)
                    return@addSnapshotListener
                }

                for(dc in snapshots!!.documentChanges){

                    when(dc.type){
                        DocumentChange.Type.ADDED, DocumentChange.Type.MODIFIED -> {
                            tvCurso.text = dc.document.data["description"].toString()
                            tvNota.text = dc.document.data["score"].toString()
                        }


                        else -> {}
                    }
                }

            }
    }
}
