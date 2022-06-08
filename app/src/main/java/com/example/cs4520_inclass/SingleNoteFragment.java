package com.example.cs4520_inclass;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SingleNoteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SingleNoteFragment extends Fragment {

    private Note note;
    private TextView displayNote;
    private Button deleteNote;

    public SingleNoteFragment() {
        // Required empty public constructor
    }

    public static SingleNoteFragment newInstance(Note note) {
        SingleNoteFragment fragment = new SingleNoteFragment();
        Bundle args = new Bundle();
        args.putParcelable("note", note);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_single_note, container, false);

        displayNote = rootview.findViewById(R.id.ic7_note_text);
        deleteNote = rootview.findViewById(R.id.ic7_deleteNote);

        displayNote.setText(note.getNoteText());

        deleteNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return rootview;

    }
}