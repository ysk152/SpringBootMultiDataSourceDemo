# Create a stored procedure in the library
DELIMITER $$

CREATE PROCEDURE AddCourse(
    IN p_title VARCHAR(64),
    IN p_description VARCHAR(128),
    IN p_category VARCHAR(64)
)
BEGIN
    INSERT INTO t_course (title, description, category, creation_date, update_data)
    VALUES (p_title, p_description, p_category, NOW(), NOW());
END$$

DELIMITER ;

# call function
CALL AddCourse('物理', 'Advanced Physics class', '7');

# View all stored procedure in the library
SHOW PROCEDURE STATUS;

# View a stored procedure in the library
SHOW CREATE PROCEDURE ${procedure_name};

# Delete a stored procedure in the library
DROP PROCEDURE IF EXISTS ${procedure_name};