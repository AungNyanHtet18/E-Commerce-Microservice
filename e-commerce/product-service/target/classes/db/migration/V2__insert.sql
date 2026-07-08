INSERT INTO category (id, name, description) VALUES
(1, 'Electronics', 'Electronic devices and accessories'),
(2, 'Books', 'Educational and entertainment books'),
(3, 'Clothing', 'Men and women clothing'),
(4, 'Home Appliances', 'Household electrical appliances'),
(5, 'Sports', 'Sports equipment and accessories');

INSERT INTO product (id, available_quantity, description, name, price, category_id) VALUES
(1, 50, 'Latest Android smartphone with 128GB storage', 'Samsung Galaxy A55', 499.99, 1),
(2, 30, '15-inch laptop with Intel Core i7 processor', 'Dell Inspiron 15', 899.99, 1),
(3, 100, 'Wireless Bluetooth headphones', 'Sony WH-CH520', 79.99, 1),

(4, 75, 'Java programming guide for beginners', 'Learn Java', 39.99, 2),
(5, 40, 'Spring Boot development book', 'Spring Boot in Action', 49.99, 2),
(6, 60, 'Database design fundamentals', 'SQL Essentials', 29.99, 2),

(7, 120, '100% cotton T-shirt', 'Basic T-Shirt', 19.99, 3),
(8, 80, 'Slim fit blue jeans', 'Denim Jeans', 45.99, 3),
(9, 35, 'Lightweight sports jacket', 'Running Jacket', 69.99, 3),

(10, 25, '1500W electric kettle', 'Electric Kettle', 34.99, 4),
(11, 15, '800W microwave oven', 'Microwave Oven', 129.99, 4),
(12, 20, 'Cordless vacuum cleaner', 'Vacuum Cleaner', 199.99, 4),

(13, 90, 'Professional football', 'Football', 24.99, 5),
(14, 45, 'Badminton racket', 'Badminton Racket', 59.99, 5),
(15, 70, 'Non-slip yoga mat', 'Yoga Mat', 29.99, 5);