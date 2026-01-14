CREATE TABLE tb_users(
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(10) NOT NULL
);


CREATE TABLE tb_expenses(
    id UUID PRIMARY KEY,
    expense VARCHAR(255) NOT NULL,
    price NUMERIC(13, 2) NOT NULL,
    date TIMESTAMP NOT NULL,
    user_id UUID NOT NULL,
    CONSTRAINT fk_expenses_user
        FOREIGN KEY (user_id)
        REFERENCES tb_users (id)
        ON DELETE CASCADE
);


CREATE INDEX idx_expenses_user_id ON tb_expenses(user_id);
CREATE INDEX idx_expenses_date ON tb_expenses(date);
CREATE INDEX idx_expenses_user_date ON tb_expenses(user_id, date);