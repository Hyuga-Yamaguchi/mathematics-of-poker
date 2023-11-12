(ns baysian-statistics.core
  (:require [incanter.stats :as stats]
            [clojure.string :as string]
            [clojure.pprint :refer [print-table]]))

(def reward-mean-per-100hands 1.15)

(def reward-sd-per-100hands 1.61)

(def players-with-win-rate
  {:-5BB-per-100 0.0025
   :-4BB-per-100 0.02
   :-3BB-per-100 0.08
   :-2BB-per-100 0.2
   :-1BB-per-100 0.395
   :0BB-per-100  0.2
   :1BB-per-100 0.08
   :2BB-per-100 0.02
   :3BB-per-100 0.0025})

(def key-list
  [:-5BB-per-100
   :-4BB-per-100
   :-3BB-per-100
   :-2BB-per-100
   :-1BB-per-100
   :0BB-per-100
   :1BB-per-100
   :2BB-per-100
   :3BB-per-100])

(defn get-rate
  [k]
  (-> k
      (name)
      (string/replace "BB-per-100" "")
      Integer/parseInt))

(defn get-complementaly-event
  [probs-map]
  (into
   {}
   (map (fn [[key value]] [key (- 1 value)])
        probs-map)))

(defn get-probability
  [probs-map]
  (into
   {}
   (map (fn [[key value]]
          [key
           (let [rate (get-rate key)
                 offset 0.01
                 upper-mean (+ reward-mean-per-100hands offset)
                 lower-mean (- reward-mean-per-100hands offset)]
             (Math/abs
              (- (stats/cdf-normal rate
                                   :mean upper-mean
                                   :sd reward-sd-per-100hands)
                 (stats/cdf-normal rate
                                   :mean lower-mean
                                   :sd reward-sd-per-100hands))))])
        probs-map)))

(defn get-direct-product
  [first-map second-map]
  (into
   {}
   (map (fn [[key value]]
          [key
           (* value (key second-map))])
        first-map)))

(defn get-value-sum-from-map
  [first-map]
  (reduce
   +
   (vals first-map)))

(defn get-weighted-mean
  [win-rate-probs-map win-rate-and-observed-probs-map]
  (into
   {}
   (let [weighted-mean-map (get-direct-product win-rate-probs-map win-rate-and-observed-probs-map)
         weighted-mean-sum (get-value-sum-from-map weighted-mean-map)]
     (map (fn [[key value]]
            [key
             (- weighted-mean-sum value)])
          weighted-mean-map))))

(defn baysian-theory
  [probs-a-given-b probs-b probs-a-given-not-b probs-not-b]
  (into
   {}
   (map (fn [[key value]]
          [key
           (/
            (* value (key probs-b))
            (+ (* value (key probs-b))
               (* (key probs-a-given-not-b) (key probs-not-b))))])
        probs-a-given-b)))

(defn main
  []
  (let [probs-b players-with-win-rate
        probs-a-given-b (get-probability probs-b)
        probs-not-b (get-complementaly-event probs-b)
        probs-a-given-not-b (get-weighted-mean probs-b probs-a-given-b)
        probs-b-given-a (baysian-theory probs-a-given-b probs-b probs-a-given-not-b probs-not-b)]
    (print-table key-list [probs-b-given-a])))
