package com.kelompok03.amikomngevent.BnvFragment;


import android.app.Dialog;
import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
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

    private FirebaseAuth mAuth;
    private String current_user_id;

    FirebaseFirestore fStore;
    ImageView imgUser;
    TextView name,email,phone;

    @Override
    public void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser() == null) {
            Intent intent = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
    }

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

        mAuth = FirebaseAuth.getInstance();
        current_user_id = mAuth.getUid();
        fStore = FirebaseFirestore.getInstance();
        imgUser = view.findViewById(R.id.imgUser);
        name = view.findViewById(R.id.tv_name);
        email = view.findViewById(R.id.tv_email);

        if(current_user_id != null) {
            fStore.collection("users").document(current_user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if(task.isSuccessful()){
                        if(task.getResult().exists()){
                            String image = task.getResult().getString("imgUser");
                            String Name = task.getResult().getString("name");
                            String Email = task.getResult().getString("email");

                            name.setText(Name);
                            email.setText(Email);


                        }
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
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
