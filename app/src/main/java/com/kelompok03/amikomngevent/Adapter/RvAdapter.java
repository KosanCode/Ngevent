package com.kelompok03.amikomngevent.Adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.kelompok03.amikomngevent.Model.Event;
import com.kelompok03.amikomngevent.R;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    private List<Event> eventList;
    private Context context;
    private FirebaseFirestore firestoreDB;

    public RvAdapter(List<Event> eventList, Context context, FirebaseFirestore firestoreDB) {
        this.eventList = eventList;
        this.context = context;
        this.firestoreDB = firestoreDB;
}

    @Override
    public RvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_event_recycler, parent, false);

        return new RvAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RvAdapter.ViewHolder holder, int position) {
        final int itemPosition = position;
        final Event event = eventList.get(itemPosition);

        holder.judul.setText(event.getJudul());
        holder.tanggal.setText(event.getTanggal());
        holder.lokasi.setText(event.getTempat());
        holder.harga.setText(event.getHarga());

//        holder.edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                updateNote(note);
//            }
//        });
//
//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                deleteNote(note.getId(), itemPosition);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judul, kategori, tanggal, lokasi, harga, deskripsi;
        ImageView edit;
        ImageView delete;

        ViewHolder(View view) {
            super(view);
            judul = view.findViewById(R.id.textInputEditTextJudul);
            tanggal = view.findViewById(R.id.textViewDate);
            lokasi = view.findViewById(R.id.textInputEditTextLokasi);
            harga = view.findViewById(R.id.textInputEditTextHarga);

//            edit = view.findViewById(R.id.ivEdit);
//            delete = view.findViewById(R.id.ivDelete);
        }
    }
}
