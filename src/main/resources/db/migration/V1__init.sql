CREATE TABLE hookah (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    address TEXT NOT NULL
);

CREATE TABLE employments (
    id BIGSERIAL PRIMARY KEY,
    first_name TEXT NOT NULL,
    second_name TEXT NOT NULL,
    age INT NOT NULL
);

INSERT INTO hookah (name, address) VALUES
('Горыныч №1' , 'Ленина 34'),
('Горыныч №2' , 'Островского 123'),
('Горыныч №3' , 'Ноградская 8');

INSERT INTO employments (first_name, second_name, age) VALUES
('Поцелуев', 'Вячеслав', 28);