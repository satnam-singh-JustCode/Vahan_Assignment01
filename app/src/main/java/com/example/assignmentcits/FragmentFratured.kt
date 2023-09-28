package com.example.assignmentcits

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.startForegroundService
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.assignmentcits.databinding.FragmentFraturedBinding
import org.json.JSONArray
import org.json.JSONException

open class FragmentFratured : Fragment() {
    private lateinit var bindingFragmentFratured: FragmentFraturedBinding
//    open var name = mutableListOf<String>()
//    open var countryName = mutableListOf<String>()
//    open var website  = mutableListOf<String>()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragmentFratured = FragmentFraturedBinding.inflate(inflater,container,false)
        val view = bindingFragmentFratured.root
        var intent  = Intent(requireContext(),MyForegroundService::class.java)
        requireContext().startForegroundService(intent)
        showResponse(requireContext().applicationContext)
        return view
    }

    fun showResponse(context: Context = requireContext().applicationContext) {
    val queue = Volley.newRequestQueue(context)
    val request1 = JsonArrayRequest(
        Request.Method.GET, "http://universities.hipolabs.com/search", null,
        { response: JSONArray ->
            try { // it is always a good practice to put our response in try{} and catch{} because from getting information from web there are anoonemus kind of errors .
                //---------------------------------------------------JSON PARSING
//                    Log.d("SATNAM SINGH", "onCreateView: ${response}")
                val root = response
//                    var name = root.getJSONObject(0).toString()
                for(i in 0 ..200) {
                    var name = root.getJSONObject(i).getString("name")
                    var countryName = root.getJSONObject(i).getString("country")
                    var website = root.getJSONObject(i).getJSONArray("web_pages").getString(0)
                    Objects.name.add(name)
                    Objects.countryName.add(countryName)
                    Objects.website.add(website)
                    Log.d("satnamSingh", "satnamSingh: $name")
                    Log.d("satnamSingh", "satnamSingh: $countryName")
                    Log.d("satnamSingh", "satnamSingh: $website")
                }
                Thread{
                    activity?.runOnUiThread{
                        bindingFragmentFratured.recyclerView.layoutManager = LinearLayoutManager(context)
                        bindingFragmentFratured.recyclerView.adapter = showDataAdapter(context,Objects.name,Objects.countryName,Objects.website)
                    }
                }.start()
//                ---------------------------------------------------JSON PARSING
            } catch (e: JSONException) {
                Log.d("SATNAM SINGH", "onCreateView: $e")
            }
        }
    ) { error: VolleyError? ->
        Log.d("SATNAM SINGH", "onCreateView: $error")
    }
    queue.add(request1)
    }
}