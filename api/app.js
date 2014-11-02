var express = require('express');
var app = express();

app.get('/', function(req, res) { 
     res.send('Hello World Expressjs');
});

app.get('/doc', function(req, res) {
      var startTime = Date.now();
        var aglio = require('aglio');
        var path = require('path');
        var fs = require('fs');

	var root = path.dirname(__dirname + '/sense');
        var blueprint = fs.readFileSync(path.join(root, './api.md'), 'utf-8');

        // Template options are 'slate', 'default', 'flatly', and 'cyborg'
        // from https://github.com/danielgtaylor/aglio
        var template = 'slate';

        aglio.render(blueprint, template, function renderCallback(err, html, warnings) {
            if (err) {
                res.writeHead( 500 );
                res.write("Error!!!!");
                res.write(err.message);
                res.end();
                return;
            }

            res.writeHead( 200, {'Content-Type': 'text/html'});
            res.write(html);
            res.end();
        });
        var elapsedTime = Date.now() - startTime;
      console.log('Documentation rendered in ' + elapsedTime + 'ms');
});

var port = 3000;
app.listen(port);
console.log('Server is running on port ' + port);

