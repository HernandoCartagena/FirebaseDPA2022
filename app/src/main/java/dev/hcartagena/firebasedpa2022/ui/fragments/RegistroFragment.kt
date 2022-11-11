package dev.hcartagena.firebasedpa2022.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import dev.hcartagena.firebasedpa2022.R
import dev.hcartagena.firebasedpa2022.ui.fragments.model.CourseModel
import java.util.*


class RegistroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_registro, container, false)

        val txtCourse: EditText = view.findViewById(R.id.txtCourse)
        val txtScore: EditText = view.findViewById(R.id.txtScore)
        val btnSaveCourse: Button =  view.findViewById(R.id.btnSaveCourse)
        val db = FirebaseFirestore.getInstance()


        btnSaveCourse.setOnClickListener {
            val curso = txtCourse.text.toString()
            val nota = txtScore.text.toString()

            val nuevoCurso = CourseModel(curso, nota)
            val id: UUID = UUID.randomUUID()

            db.collection("cursos")
                .document(id.toString())
                .set(nuevoCurso)
                .addOnSuccessListener {
                    enviarMensaje(view,"Se registró correctamente")
                }.addOnFailureListener {
                    enviarMensaje(view,"Ocurrió un error al registra el curso...")
                }
        }
        return view
    }


}
private fun enviarMensaje(vista:View, mensaje: String)
{
    Snackbar.make(vista,mensaje, Snackbar.LENGTH_LONG).show()
}