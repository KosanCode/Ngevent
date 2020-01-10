package com.kelompok03.amikomngevent.BnvFragment.DashboardPager;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.kelompok03.amikomngevent.Adapter.RvAdapter;
import com.kelompok03.amikomngevent.Model.Event;
import com.kelompok03.amikomngevent.R;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
      private RecyclerView recyclerView;
    private RvAdapter mAdapter;

    private FirebaseFirestore firestoreDB;
    private ListenerRegistration firestoreListener;

    //private FirestoreRecyclerAdapter<Event,ListViewHolder> adapterFR;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

//        firestoreDB = FirebaseFirestore.getInstance();
//
//
//        RecyclerView recyclerView = v.findViewById(R.id.listEventRecycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        // Inflate the layout for this fragment
        return v;
    }

//
//    public void onViewCreated(final View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        // 2. set layoutManger
//
//        loadNotesList(view);
//
//        firestoreListener = firestoreDB.collection("event")
//                .addSnapshotListener(new EventListener<QuerySnapshot>() {
//                    @Override
//                    public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
//                        if (e != null) {
//                            Log.e(TAG, "Listen failed!", e);
//                            return;
//                        }
//
//                        List<Event> eventList = new ArrayList<>();
//
//                        for (DocumentSnapshot doc : documentSnapshots) {
//                            Event event = doc.toObject(Event.class);
//                            event.setID(doc.getId());
//                            eventList.add(event);
//                        }
//
//                        mAdapter = new RvAdapter(eventList, Objects.requireNonNull(getActivity()).getApplicationContext(), firestoreDB);
//                        recyclerView.setAdapter(mAdapter);
//                    }
//                });
//    }
//
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//
//        firestoreListener.remove();
//    }
//
//    private void loadNotesList(final View view) {
//        firestoreDB.collection("event")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            List<Event> eventList = new ArrayList<>();
//
//                            for (DocumentSnapshot doc : Objects.requireNonNull(task.getResult())) {
//                                Event event = doc.toObject(Event.class);
//                                event.setID(doc.getId());
//                                eventList.add(event);
//                            }
//
//                            mAdapter = new RvAdapter(eventList, Objects.requireNonNull(getActivity()).getApplicationContext(), firestoreDB);
//                            recyclerView = view.findViewById(R.id.listEventRecycler);
//                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//                            recyclerView.setItemAnimator(new DefaultItemAnimator());
//                            recyclerView.setAdapter(mAdapter);
//                        } else {
//                            Log.d(TAG, "Error getting documents: ", task.getException());
//                        }
//                    }
//                });
//    }
//
//    private class ListViewHolder extends RecyclerView.ViewHolder{
//
//        TextView judul, kategori, tanggal, lokasi, harga, deskripsi;
//
//        public ListViewHolder(View view) {
//            super(view);
//            judul = view.findViewById(R.id.textInputEditTextJudul);
//            tanggal = view.findViewById(R.id.textViewDate);
//            lokasi = view.findViewById(R.id.textInputEditTextLokasi);
//            harga = view.findViewById(R.id.textInputEditTextHarga);
//        }
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        adapterFR.startListening();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (adapterFR != null) {
//            adapterFR.stopListening();
//        }
//
//    }
}

