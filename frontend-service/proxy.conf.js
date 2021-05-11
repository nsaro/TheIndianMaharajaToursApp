const PROXY_CONFIG = {
    "/api": {
        "logLevel": "debug",
        "target": "http://localhost:8085",
        "secure": false,
        "changeOrigin": true,
        "pathRewrite": {
            "^/api": ""
        }
    }
};

module.exports = PROXY_CONFIG;
