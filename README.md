# Customised Database Management System (CDMS)

The Customised Database Management System (DBMS) is a simple database system implemented in Java. It provides essential database functionalities, including creating databases, tables, inserting data, retrieving data, updating records, and deleting records.

## Table of Contents
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)

## Features
The Customised DBMS supports the following features:
- Create new databases.
- Create tables within databases.
- Insert data into tables.
- Retrieve data from tables with basic queries.
- Update existing records in tables.
- Delete records from tables.
- Display all records in a table.

## Installation
To compile and run the Customised DBMS project, follow these steps:

1. Clone the repository:
    ```bash
    git clone https://github.com/Mayurdpatil67/customised-database-management-system.git
    ```

2. Navigate to the project directory:
    ```bash
    cd customised-database-management-system
    ```

3. Compile the Java source code:
    ```bash
    javac DBMS.java
    ```

4. Run the DBMS program:
    ```bash
    java DBMS
    ```

## Usage
Once the DBMS system is running, you can use the following commands:

- **Create a new table:**
    ```bash
    create_table employees "id INT, name VARCHAR(100), salary DOUBLE"
    ```

- **Insert data into a table:**
    ```bash
    insert employees "1, 'John Doe', 50000"
    ```

- **Retrieve data from a table:**
    ```bash
    select employees "id, name"
    ```

## Contributing
Contributions to the Customised DBMS are welcome! If you find any issues or have ideas for improvements, feel free to open an issue or submit a pull request.

1. Fork the repository.
2. Create your feature branch:
    ```bash
    git checkout -b feature/AmazingFeature
    ```
3. Commit your changes:
    ```bash
    git commit -m 'Add some AmazingFeature'
    ```
4. Push to the branch:
    ```bash
    git push origin feature/AmazingFeature
    ```
5. Open a pull request.
