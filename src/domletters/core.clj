(ns domletters.core
  (:gen-class))

(defn is-ascii? [s]
  "Determines whether a string contains only ASCII characters."
  (every? #(< % 128) (map int s)))

(defn is-alphabetical? [s]
  "Determines whether a string contains only alphabetical characters."
  (and 
    (not (clojure.string/blank? s))
    (is-ascii? s)
    (every? #(Character/isLetter %) s)))

(defn get-words-from-line [s]
  "Splits the string and returns only words containing only alphabetical 
  characters."
  (filter is-alphabetical? (clojure.string/split s #"\s+")))

(defn get-words-from-reader [reader]
  "Gets all alphabetical words from a reader."
  (->> (repeatedly #(.readLine reader))
    (take-while (complement nil?))
    (mapcat get-words-from-line)))

(defn frequency-dict [word]
  "Gets the frequency dictionary of the lower-case of a word."
  (frequencies (clojure.string/lower-case word)))

(defn dominant-character-count [word]
  "Gets the dominant character count of a word."
  (->> word
    frequency-dict
    vals
    (apply max)))

(defn sum-counts [reader]
  "Sums the dominant character count of every alphabetical word in the reader."
  (->> reader
    get-words-from-reader
    (map dominant-character-count)
    (reduce + 0)))

(defn -main
  "Main function. Uses stdin as the Reader to count dominant characters."
  [& args]
  (let [reader (java.io.BufferedReader. *in*)]
    (println (sum-counts reader))))

