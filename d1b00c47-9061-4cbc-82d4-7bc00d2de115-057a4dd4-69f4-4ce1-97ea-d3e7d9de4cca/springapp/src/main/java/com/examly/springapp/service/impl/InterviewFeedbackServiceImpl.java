package com.examly.springapp.service.impl;

import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.repository.InterviewFeedbackRepository;
import com.examly.springapp.service.InterviewFeedbackService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InterviewFeedbackServiceImpl implements InterviewFeedbackService {

    private final InterviewFeedbackRepository repo;

    public InterviewFeedbackServiceImpl(InterviewFeedbackRepository repo) {
        this.repo = repo;
    }

    @Override
    public InterviewFeedback create(InterviewFeedback feedback) {
        feedback.setFeedbackId(null);
        return repo.save(feedback);
    }

    @Override
    public List<InterviewFeedback> getAll() {
        return repo.findAll();
    }

    @Override
    public InterviewFeedback getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview Feedback not found"));
    }

    @Override
    public InterviewFeedback update(Long id, InterviewFeedback feedback) {
        InterviewFeedback existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview Feedback not found"));
        
        existing.setContent(feedback.getContent());
        existing.setInternal(feedback.isInternal());
        existing.setInterviewRound(feedback.getInterviewRound());
        
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Interview Feedback not found");
        }
        repo.deleteById(id);
    }
}
