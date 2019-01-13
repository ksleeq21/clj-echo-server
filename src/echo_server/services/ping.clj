(ns echo-server.services.ping)

(defn handler [request]
  {:status 200 :body (str "pong\n")})
