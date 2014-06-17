(ns msg2.core
  (:require [immutant.messaging :as m]
            [immutant.util :as u]
            [immutant.wildfly :as wf]))

(defn queue [name]
  (if (wf/in-container?)
    (m/queue name)
    (let [c (m/connection :host "localhost" :port 5445)]
      (u/at-exit #(.close c))
      (m/queue name :connection c))))

(defn -main []
  (println "GOT" @(m/request (queue "req-respond") 1)))
