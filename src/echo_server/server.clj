(ns echo-server.server
  (:gen-class)
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http.route.definition :refer [defroutes]]
            [echo-server.services.ping :as ping]
            [echo-server.services.echo :as echo]))

(defroutes routes
  [[["/"
      ["/ping" {:get ping/handler}]
      ["/echo" {:get echo/handler}]]]])

(def service {:env :prod
              ::http/routes routes
              ::http/resource-path "/public"
              ::http/type :jetty
              ::http/port 8080})

(defonce runnable-service (http/create-server service))

(defn run-dev
  "The entry-point for 'lein run-dev'"
  ; run repl
  ; echo-server.server=> (def serv (run-dev))
  ; echo-server.server=> (server/stop serv) ??
  [& args]
  (println "\nCreating dev server")
  (-> service

      (merge {:env :dev
              ::http/join? false
              ::http/routes #(deref #'routes)
              ::http/allowed-origins {:creds true :allowed-origins (constantly true)}})
      ;; Wire up interceptor chains
      http/default-interceptors
      http/dev-interceptors
      http/create-server
      http/start))

(defn -main
  "The entry-point for 'lein run'"
  [& args]
  (println "\nCreating prod server")
  (http/start runnable-service))
