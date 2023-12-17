const http = require('http');
const mysql = require('mysql');
const url = require('url');
const fs = require('fs');

const port = 3000;

// Create a MySQL connection
const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'your_database'
});

// Connect to the MySQL database
connection.connect((err) => {
    if (err) throw err;
    console.log('Connected to the database');
});

// Create an HTTP server
const server = http.createServer((req, res) => {
    const { pathname, query } = url.parse(req.url, true);

    if (req.method === 'GET') {
        // Serve the index.html file
        if (pathname === '/') {
            fs.readFile('index.html', (err, data) => {
                if (err) {
                    res.writeHead(500, { 'Content-Type': 'text/plain' });
                    res.end('Internal Server Error');
                } else {
                    res.writeHead(200, { 'Content-Type': 'text/html' });
                    res.end(data);
                }
            });
        }
    } else if (req.method === 'POST') {
        // Handle form submission for SignIn
        if (pathname === '/signin') {
            let body = '';
            req.on('data', (chunk) => {
                body += chunk;
            });

            req.on('end', () => {
                const { username, password } = JSON.parse(body);

                // Perform a database query to check the credentials
                const query = `SELECT * FROM users WHERE username = '${username}' AND password = '${password}'`;
                connection.query(query, (err, results) => {
                    if (err) {
                        res.writeHead(500, { 'Content-Type': 'text/plain' });
                        res.end('Internal Server Error');
                    } else {
                        if (results.length > 0) {
                            // Successful SignIn, redirect to the welcome page
                            res.writeHead(302, { 'Location': '/welcome' });
                            res.end();
                        } else {
                            // Invalid credentials, display an error message
                            res.writeHead(200, { 'Content-Type': 'text/plain' });
                            res.end('Invalid username or password');
                        }
                    }
                });
            });
        }

        // Handle form submission for SignUp
        if (pathname === '/signup') {
            let body = '';
            req.on('data', (chunk) => {
                body += chunk;
            });

            req.on('end', () => {
                const { username, password } = JSON.parse(body);

                // Perform a database query to insert the new user
                const query = `INSERT INTO users (username, password) VALUES ('${username}', '${password}')`;
                connection.query(query, (err, results) => {
                    if (err) {
                        res.writeHead(500, { 'Content-Type': 'text/plain' });
                        res.end('Internal Server Error');
                    } else {
                        // Successful SignUp, redirect back to the index.html page
                        res.writeHead(302, { 'Location': '/' });
                        res.end();
                    }
                });
            });
        }
    }
});

server.listen(port, () => {
    console.log(`Server running on port ${port}`);
});
