var http = require('http');

var server = http.createServer(function (req, res) {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end('Hello world, This is my Node.js server');
});

server.listen(10000, function () {
    console.log('Server is running on port 10000');
});
