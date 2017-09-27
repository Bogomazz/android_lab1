package com.example.macbook.lab1.storage;

import com.example.macbook.lab1.models.Note;

import java.util.ArrayList;

public class NotesStorage {
    private static ArrayList<Note> notes = new ArrayList<>();

    public static ArrayList<Note> get() {
        return notes;
    }

    public static Note get(int position) {
        return notes.get(position);
    }

    public static void add(Note note) {
        notes.add(note);
    }

    public static void remove(int position) {
        notes.remove(position);
    }

    public static void remove(Note note) {
        notes.remove(note);
    }
}
