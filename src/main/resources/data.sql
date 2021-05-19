INSERT INTO users (name, email, password)
VALUES
       ('user', 'user@email.ru', '{noop}user_pass'),
       ('admin', 'admin@email.ru', '{noop}admin_pass');

INSERT INTO roles (user_id, role)
VALUES
        (1, 'USER'),
       (2, 'USER'),
       (2, 'ADMIN');

INSERT INTO categories (name, req_name)
VALUES
       ('game', 'game_requests'),
       ('food', 'food_requests');

INSERT INTO banners (name, price, id_category, content)
VALUES
       ('dota2', 100, 1, 'dota2 is cool game');

INSERT INTO requests (banner_id, user_agent, ip_address, date_time)
VALUES
      (1, 'user_agent', '10050005', '2021-10-10');
