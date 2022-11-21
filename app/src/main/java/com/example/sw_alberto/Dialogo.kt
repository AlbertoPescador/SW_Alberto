package com.example.sw_alberto

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MiDialogFragment: DialogFragment()  {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity.let {
            val title = "Guardar"
            val content = "¿Desea guardar el listado?"
            val builder:AlertDialog.Builder=AlertDialog.Builder(requireActivity())
            builder.setTitle(title).setMessage(content)
                .setPositiveButton(android.R.string.ok)  {dialog, which ->
                    //Callback para el ok
                    Toast.makeText(requireActivity().applicationContext,
                        "Ha guardado el listaod", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(android.R.string.cancel) {dialog, which ->
                    //Callback para el Cancel
                    Toast.makeText(requireActivity().applicationContext,
                        "Ha cancelado la acción", Toast.LENGTH_SHORT).show()
                }
            //Devuelve un AlertDialog
            //tal y como lo hemos definido en el builder
            return builder.create()} ?: throw IllegalStateException("El fragmento no está asociado a ninguna actividad")
    }
}