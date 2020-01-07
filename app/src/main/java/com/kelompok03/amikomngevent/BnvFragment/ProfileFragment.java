package com.kelompok03.amikomngevent.BnvFragment;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.kelompok03.amikomngevent.LoginActivity;
import com.kelompok03.amikomngevent.MainActivity;
import com.kelompok03.amikomngevent.R;
import com.kelompok03.amikomngevent.RegisterActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener{

    ImageView btnLogout;
    ImageView btnEditProfile;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnLogout = view.findViewById(R.id.btnLogout);
        btnEditProfile = view.findViewById(R.id.btnEditProfile);

        btnLogout.setOnClickListener(this);
        btnEditProfile.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogout:
                FirebaseAuth.getInstance().signOut(); //logout
                Intent intentLogin = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
                startActivity(intentLogin);
                break;
            case R.id.btnEditProfile:
                // Navigate to RegisterActivity
                Dialog dialogEditProfile = new Dialog(getActivity());
                dialogEditProfile.setContentView(R.layout.activity_edit_profile);
                //set width of dialog
                int width = (int) (getActivity().getResources().getDisplayMetrics().widthPixels * 0.95);
                //set hieght of dialog
                int height = (int) (getActivity().getResources().getDisplayMetrics().heightPixels * 0.7);
                dialogEditProfile.getWindow().setLayout(width, height);
                dialogEditProfile.show();
                break;
        }
    }

}
