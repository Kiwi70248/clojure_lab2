(ns untitled1.core)
(require '[clojure.core.async :refer [<!!] :as async])

(def data [2 3 4 4 1 2 3 4 2 1 2])
(def c (async/into [] (async/to-chan data)))

(defn check
  [ch]
  (loop [data (<!! ch) i (first data) res []]
    (if (nil? i)
      res
      (recur (subvec data (inc i)) (get data (inc i))
             (conj res (subvec data 1 (inc i)))))))
(check c)