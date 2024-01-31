package com.example.Seminar6Home.controller;

import com.example.Seminar6Home.model.Note;
import com.example.Seminar6Home.service.NoteService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private final NoteService noteService;

    @GetMapping
    public List<Note> getAllNotes(){
        return noteService.getAllNotes();
    }


    @PostMapping
    public Note addNote(@RequestBody Note note){
        return noteService.addNote(note);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id){
        Optional<Note> note = noteService.findById(id);
        return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable Long id){
        noteService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // наконец то у меня получилось понять! вводим id потом newContent и следом вводим тело заметки
    @PutMapping("/{id}/newContent/{content}")
    public Note updateNote(@PathVariable Long id,@PathVariable String content){
        return noteService.updateNote(id,content);
    }


}
