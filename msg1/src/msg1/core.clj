(ns msg1.core
  (:require [immutant.messaging :as m]))

(defn -main []
  (m/respond (m/queue "req-respond") inc))
