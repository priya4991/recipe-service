-- liquibase formatted sql

-- changeset liquibase:5
DROP TABLE IF EXISTS tags CASCADE;
DROP TABLE IF EXISTS recipes CASCADE;
DROP TABLE IF EXISTS recipes_tags;

CREATE TABLE tags
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(25)
);
INSERT INTO tags (name) VALUES
('vegan'),('vegetarian'),('non-veg'),('gluten'),('gluten-free'),('keto'),('dairy'),('seafood'),('poultry'),
('spicy'),('mild'),('nuts'),('allergens'),('over-free'),('baking'),('quick'),('indian'),('italian'),('asian');

CREATE TABLE recipes
(
    id SERIAL PRIMARY KEY,
    user_id VARCHAR(10),
    title VARCHAR(50),
    subtitle VARCHAR(100),
    hero_image VARCHAR(500),
    content TEXT
);

CREATE TABLE recipes_tags
(
    tag_id BIGINT REFERENCES tags (id) ON DELETE CASCADE,
    recipe_id BIGINT REFERENCES recipes (id) ON DELETE CASCADE,
    PRIMARY KEY (tag_id, recipe_id)
);

CREATE TABLE comments
(
    id SERIAL PRIMARY KEY,
    user_id VARCHAR(10),
    recipe_id BIGINT REFERENCES recipes (id) ON DELETE CASCADE,
    comment VARCHAR(1000)
);

CREATE TABLE likes
(
    recipe_id BIGINT REFERENCES recipes (id) ON DELETE CASCADE,
    user_id VARCHAR(10),
    PRIMARY KEY (recipe_id, user_id)
);