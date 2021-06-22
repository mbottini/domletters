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

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [reader (java.io.BufferedReader. *in*)]
    (println (clojure.string/join " " (get-words-from-reader reader)))))

