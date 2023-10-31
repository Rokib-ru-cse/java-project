CREATE TABLE coursesusers
(
    id        serial PRIMARY KEY,
    course_id INT,
    user_id   INT,

    CONSTRAINT fk_course FOREIGN KEY (course_id)
        REFERENCES courses (id)
        ON DELETE CASCADE,

    CONSTRAINT fk_user FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE
);