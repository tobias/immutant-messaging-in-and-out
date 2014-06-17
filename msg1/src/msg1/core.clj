(ns msg1.core
  (:require [immutant.messaging :as m]
            [immutant.wildfly :as wf]))

(defn -main []
  (m/respond (m/queue "req-respond") inc))
