CREATE TABLE question
(
    question_id BIGSERIAL PRIMARY KEY,
    question_text TEXT
);
CREATE TABLE response
(
    response_id BIGSERIAL PRIMARY KEY,
    response_text TEXT
);
CREATE TABLE ai_interactions
(
    interaction_id BIGSERIAL PRIMARY KEY,
    question_id BIGINT NOT NULL,
    response_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE history
(
    history_id BIGSERIAL PRIMARY KEY,
    interaction_id BIGINT NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
