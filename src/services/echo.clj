(ns echo-server.services.echo
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http.route.definition :refer [defroutes]]))
;
(defn respond [request]
  (let [message (get-in request [:params :message] "pong")]
    { :status 200 :body (str message "!\n")}))
