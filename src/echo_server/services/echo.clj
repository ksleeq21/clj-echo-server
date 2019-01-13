(ns echo-server.services.echo)

(defn handler [request]
  (let [message (get-in request [:params :message] "Echo")]
    {:status 200 :body (str message "\n")}))
