package com.kelompok03.amikomngevent.BnvFragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.kelompok03.amikomngevent.LoginActivity;
import com.kelompok03.amikomngevent.MainActivity;
import com.kelompok03.amikomngevent.R;

import java.util.HashMap;
import java.util.Map;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddEventFragment extends Fragment implements View.OnClickListener{

    TextInputEditText textInputEditTextJudul;
    Spinner spKategori;
    DatePicker datePicker;
    TextInputEditText textInputEditTextLokasi;
    TextInputEditText textInputEditTextHarga;
    TextInputEditText textInputEditTextDeskripsi;

    Button btnTambahEvent;

    private FirebaseAuth mAuth;
    private String current_user_id;

    FirebaseFirestore fStore;

    public AddEventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_event, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initListeners(view);
    }

    private void initListeners(View view) {
        textInputEditTextJudul = view.findViewById(R.id.textInputEditTextJudul);
        textInputEditTextLokasi = view.findViewById(R.id.textInputEditTextLokasi);
        textInputEditTextHarga = view.findViewById(R.id.textInputEditTextHarga);
        textInputEditTextDeskripsi = view.findViewById(R.id.textInputEditTextDeskripsi);

        spKategori = view.findViewById(R.id.spKategori);
        datePicker = view.findViewById(R.id.datePicker);

        btnTambahEvent = view.findViewById(R.id.btnTambahEvent);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        current_user_id = mAuth.getUid();

        btnTambahEvent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.btnTambahEvent:
                        final String judul = textInputEditTextJudul.getText().toString().trim();
                        final String kategori = spKategori.getSelectedItem().toString().trim();
                        final String lokasi = textInputEditTextLokasi.getText().toString().trim();

                        Integer hari = datePicker.getDayOfMonth();
                        Integer bulan = datePicker.getMonth();
                        Integer tahun = datePicker.getYear();
                        final String tanggal = hari + " / " + bulan + " / " + tahun;

                        final String harga = textInputEditTextHarga.getText().toString().trim();
                        final String deskripsi = textInputEditTextDeskripsi.getText().toString().trim();

                        if(TextUtils.isEmpty(judul)) {
                            textInputEditTextJudul.setError("Email tidak boleh kosong!");
                            return;
                        }

                        if(TextUtils.isEmpty(lokasi)) {
                            textInputEditTextLokasi.setError("Password tidak boleh kosong!");
                            return;
                        }

                        if(TextUtils.isEmpty(harga)) {
                            textInputEditTextHarga.setError("Password tidak boleh kosong!");
                            return;
                        }

                        if(TextUtils.isEmpty(deskripsi)) {
                            textInputEditTextDeskripsi.setError("Password tidak boleh kosong!");
                            return;
                        }

                        if(current_user_id != null) {
                            DocumentReference documentReference = fStore.collection("event").document();
                            Map<String, Object> event = new HashMap<>();
                            event.put("judul", judul);
                            event.put("kategori", kategori);
                            event.put("tanggal", tanggal);
                            event.put("lokasi", lokasi);
                            event.put("harga", harga);
                            event.put("deskripsi", deskripsi);
                            event.put("id user", current_user_id);

                            //insert to db
                            documentReference.set(event).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getActivity().getApplicationContext(), "Data event berhasil dibuat" , Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "Sukses: data event berhasil dibuat untuk " + current_user_id);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "Gagal" + e.toString());
                                }
                            });
                        }


                        Intent intentHome = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                        startActivity(intentHome);

                }
    }
}
