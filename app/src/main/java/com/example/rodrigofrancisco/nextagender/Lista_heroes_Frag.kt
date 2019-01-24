package com.example.rodrigofrancisco.nextagender


import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.Toast
import com.example.rho.ebook.AdaptadorCustom
import com.example.rho.ebook.ClickListener
import kotlinx.android.synthetic.main.fragment_lista_heroes_.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Lista_heroes_Frag : Fragment() {

    var twoPane: Boolean = false
    var comunicador:Comunicador? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (activity?.resources?.configuration?.orientation == Configuration.ORIENTATION_LANDSCAPE){
            twoPane = true
        }


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_heroes_, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var misHeroes = cargarHeroes()
        comunicador = activity as Comunicador

        rv_heroes.layoutManager = LinearLayoutManager(activity?.applicationContext)
        rv_heroes.adapter = AdaptadorCustom(misHeroes, object : ClickListener {
            override fun onClick(view: View, posicion : Int){
                if (twoPane){
                    comunicador?.responder(misHeroes.get(posicion))
                }else {
                    Toast.makeText(activity?.applicationContext, misHeroes.get(posicion).nombre, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    fun cargarHeroes(): ArrayList<Heroe>{
        var heroes: ArrayList<Heroe> = ArrayList()
        heroes.add(Heroe("DeathPool", R.drawable.deathpool, "regeneracion", "wade Wilson"))
        heroes.add(Heroe("Capitan America", R.drawable.capitan, "super Fuerza","Steve Roger"))
        heroes.add(Heroe("BlackPanter", R.drawable.blackpanther, "Traje poderoso", "luke Charles"))
        heroes.add(Heroe("spiderman", R.drawable.spidi, "Sentido Aragnido", "Peter Parker" ))
        heroes.add(Heroe("wolverine", R.drawable.wolverine, "Regeneracion", "logan"))
        heroes.add(Heroe("ironman", R.drawable.ironman, "Super Rico","Tony Stark"))

        return heroes

    }
}
