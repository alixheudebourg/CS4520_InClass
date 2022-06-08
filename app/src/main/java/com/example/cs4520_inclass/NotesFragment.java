package com.example.cs4520_inclass;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotesFragment extends Fragment {

    private EditText newNoteInput;
    private Button addNote;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    private NoteAdapter noteAdapter;

    private ArrayList<Note> allNotes;

    public NotesFragment() {
        // Required empty public constructor
    }

    public static NotesFragment newInstance(String param1, String param2) {
        NotesFragment fragment = new NotesFragment();
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
        View rootView =  inflater.inflate(R.layout.fragment_ic7_notes, container, false);

        recyclerView = rootView.findViewById(R.id.ic7_home_allNotes);
        newNoteInput = rootView.findViewById(R.id.ic7_home_newNote);
        addNote = rootView.findViewById(R.id.ic7_home_addNote);


        allNotes = new ArrayList<Note>();

        allNotes.add(new Note("note1", "id"));
        allNotes.add(new Note("note 3", "id2"));
        allNotes.add(new Note("note 4", "id3"));
        allNotes.add(new Note("note 5", "id4"));
        allNotes.add(new Note("note 6", "id5"));


        recyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        noteAdapter = new NoteAdapter(allNotes);
        recyclerView.setAdapter(noteAdapter);



        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getParent(), "button pressed", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}