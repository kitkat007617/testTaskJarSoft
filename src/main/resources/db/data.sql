INSERT INTO users (name, email, password)
VALUES
       ('user', 'user@email.ru', 'user_pass'),
       ('admin', 'admin@email.ru', 'admin_pass');

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
