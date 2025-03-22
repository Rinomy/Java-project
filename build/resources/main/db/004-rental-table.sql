CREATE TABLE rentals (
    rental_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES users(user_id),
    car_id INT NOT NULL REFERENCES cars(car_id),
    rental_start_date DATE NOT NULL,
    rental_end_date DATE NOT NULL,
    total_cost DECIMAL(10, 2) NOT NULL,
    payment_status VARCHAR(20) DEFAULT 'Pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);