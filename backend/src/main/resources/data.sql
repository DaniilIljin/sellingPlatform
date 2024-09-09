-- Insert data into 'brand' table
INSERT INTO brand (name) 
SELECT 'Nike' WHERE NOT EXISTS (SELECT 1 FROM brand WHERE name = 'Nike');
INSERT INTO brand (name) 
SELECT 'Adidas' WHERE NOT EXISTS (SELECT 1 FROM brand WHERE name = 'Adidas');
INSERT INTO brand (name) 
SELECT 'Puma' WHERE NOT EXISTS (SELECT 1 FROM brand WHERE name = 'Puma');
INSERT INTO brand (name) 
SELECT 'Under Armour' WHERE NOT EXISTS (SELECT 1 FROM brand WHERE name = 'Under Armour');
INSERT INTO brand (name) 
SELECT 'Reebok' WHERE NOT EXISTS (SELECT 1 FROM brand WHERE name = 'Reebok');

-- Insert data into 'category' table
INSERT INTO category (name, category_id)
SELECT 'Sportswear', NULL WHERE NOT EXISTS (SELECT 1 FROM category WHERE name = 'Sportswear');
INSERT INTO category (name, category_id)
SELECT 'Casual', NULL WHERE NOT EXISTS (SELECT 1 FROM category WHERE name = 'Casual');
INSERT INTO category (name, category_id)
SELECT 'Accessories', NULL WHERE NOT EXISTS (SELECT 1 FROM category WHERE name = 'Accessories');
INSERT INTO category (name, category_id)
SELECT 'Footwear', NULL WHERE NOT EXISTS (SELECT 1 FROM category WHERE name = 'Footwear');
INSERT INTO category (name, category_id)
SELECT 'Outdoor', NULL WHERE NOT EXISTS (SELECT 1 FROM category WHERE name = 'Outdoor');
INSERT INTO category (name, category_id)
SELECT 'Clothes', NULL WHERE NOT EXISTS (SELECT 1 FROM category WHERE name = 'Clothes');

-- inserting subcategories
INSERT INTO category (name, category_id)
SELECT 'Trainers', (SELECT id FROM category WHERE name = 'Sportswear') 
WHERE NOT EXISTS (SELECT 1 FROM category WHERE name = 'Trainers');
INSERT INTO category (name, category_id)
SELECT 'Watches', (SELECT id FROM category WHERE name = 'Accessories') 
WHERE NOT EXISTS (SELECT 1 FROM category WHERE name = 'Watches');
INSERT INTO category (name, category_id)
SELECT 'Sunglasses', (SELECT id FROM category WHERE name = 'Accessories') 
WHERE NOT EXISTS (SELECT 1 FROM category WHERE name = 'Sunglasses');
INSERT INTO category (name, category_id)
SELECT 'Gear', (SELECT id FROM category WHERE name = 'Outdoor') 
WHERE NOT EXISTS (SELECT 1 FROM category WHERE name = 'Gear');

-- inserting subsubcategory
INSERT INTO category (name, category_id)
SELECT 'Pickaxe', (SELECT id FROM category WHERE name = 'Gear') 
WHERE NOT EXISTS (SELECT 1 FROM category WHERE name = 'Pickaxe');

-- Insert data into 'size' table
INSERT INTO size (name)
SELECT 'Small' WHERE NOT EXISTS (SELECT 1 FROM size WHERE name = 'Small');
INSERT INTO size (name)
SELECT 'Medium' WHERE NOT EXISTS (SELECT 1 FROM size WHERE name = 'Medium');
INSERT INTO size (name)
SELECT 'Large' WHERE NOT EXISTS (SELECT 1 FROM size WHERE name = 'Large');
INSERT INTO size (name)
SELECT 'X-Large' WHERE NOT EXISTS (SELECT 1 FROM size WHERE name = 'X-Large');
INSERT INTO size (name)
SELECT 'XX-Large' WHERE NOT EXISTS (SELECT 1 FROM size WHERE name = 'XX-Large');

-- Insert data into 'user' table
INSERT INTO "user" (name, email, password, address, additional_info)
SELECT 'John Doe', 'john.doe@example.com', 'password123', '123 Elm Street', 'Regular customer'
WHERE NOT EXISTS (SELECT 1 FROM "user" WHERE email = 'john.doe@example.com');
INSERT INTO "user" (name, email, password, address, additional_info)
SELECT 'Jane Smith', 'jane.smith@example.com', 'securepass', '456 Oak Avenue', 'VIP customer'
WHERE NOT EXISTS (SELECT 1 FROM "user" WHERE email = 'jane.smith@example.com');
INSERT INTO "user" (name, email, password, address, additional_info)
SELECT 'Alice Johnson', 'alice.johnson@example.com', 'mypassword', '789 Pine Road', 'Frequent buyer'
WHERE NOT EXISTS (SELECT 1 FROM "user" WHERE email = 'alice.johnson@example.com');
INSERT INTO "user" (name, email, password, address, additional_info)
SELECT 'Bob Brown', 'bob.brown@example.com', '123456', '101 Maple Lane', 'New user'
WHERE NOT EXISTS (SELECT 1 FROM "user" WHERE email = 'bob.brown@example.com');

-- Insert data into 'item' table
INSERT INTO item (category_id, size_id, brand_id, seller_id, name, status, description, price, user_id)
SELECT 1, 2, 1, 1, 'Nike Air Max', 1, 'Comfortable running shoes', 120.00, 1
WHERE NOT EXISTS (SELECT 1 FROM item WHERE name = 'Nike Air Max' AND brand_id = 1);
INSERT INTO item (category_id, size_id, brand_id, seller_id, name, status, description, price, user_id)
SELECT 2, 3, 2, 2, 'Adidas T-Shirt', 1, 'Cotton casual T-shirt', 25.00, 2
WHERE NOT EXISTS (SELECT 1 FROM item WHERE name = 'Adidas T-Shirt' AND brand_id = 2);
INSERT INTO item (category_id, size_id, brand_id, seller_id, name, status, description, price, user_id)
SELECT 4, 1, 3, 3, 'Puma Sneakers', 1, 'Stylish and durable sneakers', 90.00, NULL
WHERE NOT EXISTS (SELECT 1 FROM item WHERE name = 'Puma Sneakers' AND brand_id = 3);
INSERT INTO item (category_id, size_id, brand_id, seller_id, name, status, description, price, user_id)
SELECT 3, 4, 4, 1, 'Under Armour Cap', 1, 'High-quality sports cap', 20.00, 3
WHERE NOT EXISTS (SELECT 1 FROM item WHERE name = 'Under Armour Cap' AND brand_id = 4);
INSERT INTO item (category_id, size_id, brand_id, seller_id, name, status, description, price, user_id)
SELECT 5, 5, 5, 4, 'Reebok Jacket', 1, 'Warm outdoor jacket', 150.00, NULL
WHERE NOT EXISTS (SELECT 1 FROM item WHERE name = 'Reebok Jacket' AND brand_id = 5);

-- Insert data into 'liked_items' table
INSERT INTO liked_items (user_id, item_id)
SELECT 1, 1 WHERE NOT EXISTS (SELECT 1 FROM liked_items WHERE user_id = 1 AND item_id = 1);
INSERT INTO liked_items (user_id, item_id)
SELECT 2, 2 WHERE NOT EXISTS (SELECT 1 FROM liked_items WHERE user_id = 2 AND item_id = 2);
INSERT INTO liked_items (user_id, item_id)
SELECT 3, 3 WHERE NOT EXISTS (SELECT 1 FROM liked_items WHERE user_id = 3 AND item_id = 3);
INSERT INTO liked_items (user_id, item_id)
SELECT 4, 4 WHERE NOT EXISTS (SELECT 1 FROM liked_items WHERE user_id = 4 AND item_id = 4);

-- Insert data into 'picture' table
INSERT INTO picture (item_id, file_name, file_location)
SELECT 1, 'nike_air_max.jpg', 'images/nike_air_max.jpg'
WHERE NOT EXISTS (SELECT 1 FROM picture WHERE item_id = 1 AND file_name = 'nike_air_max.jpg');
INSERT INTO picture (item_id, file_name, file_location)
SELECT 2, 'adidas_tshirt.jpg', 'images/adidas_tshirt.jpg'
WHERE NOT EXISTS (SELECT 1 FROM picture WHERE item_id = 2 AND file_name = 'adidas_tshirt.jpg');
INSERT INTO picture (item_id, file_name, file_location)
SELECT 3, 'puma_sneakers.jpg', 'images/puma_sneakers.jpg'
WHERE NOT EXISTS (SELECT 1 FROM picture WHERE item_id = 3 AND file_name = 'puma_sneakers.jpg');
INSERT INTO picture (item_id, file_name, file_location)
SELECT 4, 'under_armour_cap.jpg', 'images/under_armour_cap.jpg'
WHERE NOT EXISTS (SELECT 1 FROM picture WHERE item_id = 4 AND file_name = 'under_armour_cap.jpg');
INSERT INTO picture (item_id, file_name, file_location)
SELECT 5, 'reebok_jacket.jpg', 'images/reebok_jacket.jpg'
WHERE NOT EXISTS (SELECT 1 FROM picture WHERE item_id = 5 AND file_name = 'reebok_jacket.jpg');
