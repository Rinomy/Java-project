-- Insert Default Roles
INSERT INTO roles (role_name) VALUES ('ADMIN'), ('CUSTOMER');




-- Insert Default Admin User
-- Password: admin123 (hashed in a real application)
INSERT INTO users (name, email, password, phone_number, address, role_id)
VALUES ('Admin', 'admin@admin.com', 'admin123', '1234567890', 'Admin Address', 1);