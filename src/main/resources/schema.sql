CREATE TABLE users (
    id IDENTITY,
    name CHAR NOT NULL
);

CREATE TABLE matches (
    id IDENTITY PRIMARY KEY,
    user1 CHAR NOT NULL,
    user2 CHAR NOT NULL,
    user1Hand CHAR NOT NULL,
    user2Hand CHAR NOT NULL
);
