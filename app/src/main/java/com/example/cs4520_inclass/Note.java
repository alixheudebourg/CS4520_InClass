package com.example.cs4520_inclass;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {

    private String noteText;
    private String id;

    public Note() {
    }

    public Note(String noteText, String id) {
        this.noteText = noteText;
        this.id = id;
    }

    protected Note(Parcel in) {
        noteText = in.readString();
        id = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getNoteText());
        dest.writeString(getId());
    }
}
