package com.example.rodrigofrancisco.nextagender


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_descripcion_heroe.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Descripcion_heroeFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_descripcion_heroe, container, false)
    }

    fun cargarDescripcion(heroe: Heroe){
        fotoHeroe.setImageResource(heroe.foto)
        headerHeroe.text = heroe.nombre
        superPoder.text = heroe.superPod
        idenHeroe.text = heroe.identy
    }

}
