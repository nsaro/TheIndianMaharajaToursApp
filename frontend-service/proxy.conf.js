const PROXY_CONFIG = {
    "/": {
        "logLevel": "debug",
        "target": "http://localhost:8085",
        "secure": false,
        "changeOrigin": true
    }
};

module.exports = PROXY_CONFIG;
