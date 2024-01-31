package com.example.Seminar6Home.service;


import com.example.Seminar6Home.model.Note;
import com.example.Seminar6Home.repository.NoteRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@RequiredArgsConstructor
@Service
public class NoteService {
    @Autowired
    private final NoteRepository noteRepository;

    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    public Note addNote(Note note){
        return noteRepository.save(note);
    }

    public Optional<Note> findById(Long id){
        return noteRepository.findById(id);
    }

    public void deleteById(Long id){
        noteRepository.deleteById(id);
    }

    public Note updateNote(Long id , String newContent){
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note not found with id: " + id));
        note.setContent(newContent);
        return noteRepository.save(note);
    }
}
