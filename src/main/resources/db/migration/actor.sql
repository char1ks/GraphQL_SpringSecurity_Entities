CREATE TABLE actors (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) unique NOT NULL,
    password VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    actor_role VARCHAR(50) NOT NULL
);