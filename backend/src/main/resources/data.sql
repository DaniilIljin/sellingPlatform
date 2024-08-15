-- Insert data into 'brand' table
INSERT INTO brand (name) VALUES
('Nike'),
('Adidas'),
('Puma'),
('Under Armour'),
('Reebok');

-- Insert data into 'category' table
INSERT INTO category (name, category_id) VALUES
('Sportswear', NULL),
('Casual', NULL),
('Accessories', NULL),
('Footwear', NULL),
('Outdoor', NULL);

-- Insert data into 'size' table
INSERT INTO size (name) VALUES
('Small'),
('Medium'),
('Large'),
('X-Large'),
('XX-Large');

-- Insert data into 'user' table
INSERT INTO "user" (name, email, password, address, additional_info) VALUES
('John Doe', 'john.doe@example.com', 'password123', '123 Elm Street', 'Regular customer'),
('Jane Smith', 'jane.smith@example.com', 'securepass', '456 Oak Avenue', 'VIP customer'),
('Alice Johnson', 'alice.johnson@example.com', 'mypassword', '789 Pine Road', 'Frequent buyer'),
('Bob Brown', 'bob.brown@example.com', '123456', '101 Maple Lane', 'New user');

-- Insert data into 'item' table
INSERT INTO item (category_id, size_id, brand_id, seller_id, name, status, description, price, user_id) VALUES
(1, 2, 1, 1, 'Nike Air Max', 1, 'Comfortable running shoes', 120.00, 1),
(2, 3, 2, 2, 'Adidas T-Shirt', 1, 'Cotton casual T-shirt', 25.00, 2),
(4, 1, 3, 3, 'Puma Sneakers', 1, 'Stylish and durable sneakers', 90.00, NULL),
(3, 4, 4, 1, 'Under Armour Cap', 1, 'High-quality sports cap', 20.00, 3),
(5, 5, 5, 4, 'Reebok Jacket', 1, 'Warm outdoor jacket', 150.00, NULL);

-- Insert data into 'liked_items' table
INSERT INTO liked_items (user_id, item_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4);

-- Insert data into 'picture' table
INSERT INTO picture (item_id, file_name, file_location) VALUES
(1, 'nike_air_max.jpg', 'images/nike_air_max.jpg'),
(2, 'adidas_tshirt.jpg', 'images/adidas_tshirt.jpg'),
(3, 'puma_sneakers.jpg', 'images/puma_sneakers.jpg'),
(4, 'under_armour_cap.jpg', 'images/under_armour_cap.jpg'),
(5, 'reebok_jacket.jpg', 'images/reebok_jacket.jpg');
