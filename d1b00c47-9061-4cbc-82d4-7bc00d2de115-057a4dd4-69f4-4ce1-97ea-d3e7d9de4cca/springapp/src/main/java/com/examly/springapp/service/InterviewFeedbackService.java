package com.examly.springapp.service;

import com.examly.springapp.model.InterviewFeedback;
import java.util.List;

public interface InterviewFeedbackService {
    InterviewFeedback create(InterviewFeedback feedback);
    List<InterviewFeedback> getAll();
    InterviewFeedback getById(Long id);
    InterviewFeedback update(Long id, InterviewFeedback feedback);
    void delete(Long id);
}