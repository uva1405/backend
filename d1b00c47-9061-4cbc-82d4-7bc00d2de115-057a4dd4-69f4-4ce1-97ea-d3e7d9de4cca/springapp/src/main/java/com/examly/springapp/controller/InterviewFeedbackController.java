package com.examly.springapp.controller;

import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.service.InterviewFeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interview-feedbacks")
@CrossOrigin(origins = "*")
public class InterviewFeedbackController {

    private final InterviewFeedbackService service;

    public InterviewFeedbackController(InterviewFeedbackService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InterviewFeedback> create(@RequestBody InterviewFeedback feedback) {
        InterviewFeedback created = service.create(feedback);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<InterviewFeedback>> getAll() {
        List<InterviewFeedback> feedbacks = service.getAll();
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterviewFeedback> getById(@PathVariable Long id) {
        InterviewFeedback feedback = service.getById(id);
        return ResponseEntity.ok(feedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewFeedback> update(@PathVariable Long id, @RequestBody InterviewFeedback feedback) {
        InterviewFeedback updated = service.update(id, feedback);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
