ALTER TABLE history
    ADD CONSTRAINT fk_interaction
    FOREIGN KEY (interaction_id) REFERENCES ai_interactions(interaction_id)
    ON DELETE CASCADE;

ALTER TABLE ai_interactions
    ADD CONSTRAINT fk_question
    FOREIGN KEY (question_id) REFERENCES question(question_id)
    ON DELETE CASCADE;

ALTER TABLE ai_interactions
    ADD CONSTRAINT fk_response
    FOREIGN KEY (response_id) REFERENCES response(response_id)
    ON DELETE CASCADE;