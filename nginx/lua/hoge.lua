ngx.log(ngx.INFO,"call-hoge")
local template = require("resty.template")

-- local html = template.new "hoge.html"

-- local html = "<p>{{ content }}</p>"

template.render("index.html", { content = "Hello World" })
