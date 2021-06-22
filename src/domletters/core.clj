(ns domletters.core
  (:gen-class))

(defn is-alphabetical? [s]
  (and 
    (not (clojure.string/blank? s))
    (every? #(Character/isLetter %) s)))

(defn get-words-from-line [s]
  (filter is-alphabetical? (clojure.string/split s #"\s+")))

(defn get-words-from-reader [reader]
  (let [line (.readLine reader)]
    (if (nil? line)
      '()
      (concat (get-words-from-line line) (get-words-from-reader reader)))))

(defn frequency-dict [word]
  (frequencies (clojure.string/lower-case word)))

(defn dominant-character-count [word]
  (->> word
    frequency-dict
    vals
    (apply max)))

(defn sum-counts [reader]
  (->> reader
    get-words-from-reader
    (map dominant-character-count)
    (apply +)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [reader (java.io.BufferedReader. *in*)]
    (println (sum-counts reader))))

