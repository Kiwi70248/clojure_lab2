(ns untitled1.core)
(require '[clojure.core.async :refer [<! <!! >!! >!] :as async])

(def c (async/chan))

(async/go-loop [count 0 res []]
  (let [i (<! c) temp (dec count)]
    (recur (if (= temp -1) i temp) (if (= temp -1) (do (println res) []) (conj res i)))))
(>!! c 1)