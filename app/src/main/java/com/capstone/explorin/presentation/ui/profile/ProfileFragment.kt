package com.capstone.explorin.presentation.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import com.capstone.explorin.R
import com.capstone.explorin.databinding.FragmentProfileBinding
import com.capstone.explorin.presentation.ui.login.LoginActivity
import com.capstone.explorin.presentation.ui.profile.editprofile.EditProfileActivity

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProfileViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun navigateToSavedTripList() {
        val intent = Intent(activity, EditProfileActivity::class.java)

        startActivity(intent)
    }

    /** Logout Dialog

    private fun showDialog() {
        val alertDialogBuilder = AlertDialog.Builder(requireActivity())

        alertDialogBuilder.setTitle(getString(R.string.action_logout))

        alertDialogBuilder
            .setMessage(getString(R.string.title_logout_question))
            .setCancelable(false)
            .setPositiveButton(
                getString(R.string.action_logout_confirm)
            ) { _, _ ->
                viewModel.logout {
                    activity?.finishAffinity()

                    val intent = Intent(requireActivity(), LoginActivity::class.java)
                    startActivity(intent)
                }
            }
            .setNegativeButton(
                getString(R.string.action_no)
            ) { dialog, _ ->
                dialog.cancel()
            }

        val alertDialog: AlertDialog = alertDialogBuilder.create()

        alertDialog.show()
    }

    **/

}