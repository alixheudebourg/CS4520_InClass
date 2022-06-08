package com.example.cs4520_inclass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private ArrayList<Note> allNotes;
    private FragmentActivity fragmentActivity;

    public NoteAdapter(ArrayList<Note> allNotes, FragmentActivity fragmentActivity) {
        if(fragmentActivity != null) {
            this.allNotes = allNotes;
            this.fragmentActivity = fragmentActivity;
        } else {
            throw new RuntimeException(fragmentActivity.toString()
                    + " must be called from a Fragment");
        }
    }

    public NoteAdapter(ArrayList<Note> allNotes) {
        this.allNotes = allNotes;
    }

    public List<Note> getAllNotes() {
        return allNotes;
    }

    public void setAllNotes(ArrayList<Note> allNotes) {
        this.allNotes = allNotes;
        this.notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // display/delete notes elements
        private ConstraintLayout container;
        private TextView noteDisplay;
        private Button deleteNote;

        // add note elements
        private EditText newNote;
        private Button addNote;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.container = itemView.findViewById(R.id.ic07_noteView);
            this.noteDisplay = itemView.findViewById(R.id.ic7_note_text);
            this.deleteNote = itemView.findViewById(R.id.ic7_deleteNote);

            this.newNote = itemView.findViewById(R.id.ic7_home_newNote);
            this.addNote = itemView.findViewById(R.id.ic7_home_addNote);
        }

        public ConstraintLayout getContainer() {
            return container;
        }

        public TextView getNoteText() {
            return noteDisplay;
        }

        public Button getDeleteButton() {
            return deleteNote;
        }

        public EditText getNewNote() {
            return newNote;
        }

        public Button getAddNote() {
            return addNote;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_single_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder holder, int position) {
        holder.getNoteText().setText(allNotes.get(position).getNoteText());
        holder.getDeleteButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allNotes.remove(holder.getAdapterPosition());
                notifyDataSetChanged();

            }
        });
    }

    @Override
    public int getItemCount() {
        return allNotes.size();
    }
}
