CREATE TABLE fruit_type (
    id SERIAL PRIMARY KEY,
    fruit_type_name VARCHAR(255) NOT NULL,
    short_description TEXT,
    actor_id INT,
    FOREIGN KEY (actor_id) REFERENCES actors(id) ON DELETE SET NULL
);