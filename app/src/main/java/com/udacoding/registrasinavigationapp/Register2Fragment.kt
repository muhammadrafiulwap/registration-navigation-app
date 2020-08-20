package com.udacoding.registrasinavigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_register2.*

class Register2Fragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    var get_name : String? = null
    var get_email : String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register2, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        get_name = arguments?.getString("name")
        get_email = arguments?.getString("email")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnFinish.setOnClickListener(this)
        back.setOnClickListener(this)
        tvHalo.text = "Halo $get_name, untuk melanjutkan register silahkan isi password dibawah"
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnFinish -> {
                if (etPassword.text.toString().isEmpty()){
                    etPassword.error = "Password harus diisi"
                }
                else if (etConfirmationPassword.text.toString().isEmpty()){
                    etConfirmationPassword.error = "Confirmation password harus diisi"
                } else {
                    if (etPassword.text.toString().equals(etConfirmationPassword.text.toString())){
                        val bundle = bundleOf("name" to get_name, "email" to get_email)
                        navController.navigate(R.id.action_register2Fragment2_to_resultFragment2, bundle)
                    } else {
                        Toast.makeText(context, "Password tidak sama dengan confirmation password", Toast.LENGTH_LONG).show()
                    }
                }

            }
            R.id.back -> activity?.onBackPressed()
        }
    }

}