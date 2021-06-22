(ns domletters.core-test
  (:require [clojure.test :refer :all]
            [domletters.core :refer :all]))

(deftest a-test
  (testing "I pass!"
    (is true)))

(deftest test-is-alphabetical
  (testing "These are alphabetical."
    (is (every? is-alphabetical? ["abc" "sPoNgEbOb" "def"])))
  (testing "These are not alphabetical."
    (is (every? (complement is-alphabetical?) [",abc" "hjsas_eajs" "{}"])))
  (testing "Blank strings are not alphabetical."
    (is (not (is-alphabetical? "")))))

(deftest test-get-words-from-line
  (testing "Provided example from Bart."
    (is (= 
      '("This" "an" "Really") 
      (get-words-from-line "This isn't an \"incomplete sentence\". Really\n not.")))))

(defn create-buffered-reader [s]
  (->> s
    java.io.StringReader.
    java.io.BufferedReader.))

(deftest test-get-words-from-reader
  (testing "Getting strings from a constructed BufferedInputReader."
    (is 
      (= '("The" "quick" "brown" "fox")
      (get-words-from-reader 
        (create-buffered-reader "The ,quick\n\n quick br_wn\n brown fox. fox"))))))

(deftest test-frequency-dict
  (testing "Provided examples from Bart."
    (is (= {\a 1, \n 1, \y 1} (frequency-dict "any")))
    (is (= {\b 1, \o 2, \k 2, \e 3, \p 1, \r 1} (frequency-dict "bookkeeper")))
    (is (= {\a 2, \r 1, \b 1, \l 1, \e 1} (frequency-dict "Arable")))))

(deftest test-dominant-character-count
  (testing "Provided examples from Bart."
    (is (= 1 (dominant-character-count "any")))
    (is (= 3 (dominant-character-count "bookkeeper")))
    (is (= 2 (dominant-character-count "Arable")))))

(defn create-buffered-file-reader [input-stream]
  (->> input-stream
    java.io.InputStreamReader.
    java.io.BufferedReader.))
    

(deftest test-full-files
  (testing "Testing provided resource files."
    (is
      (= 20
         (with-open [r (clojure.java.io/input-stream "resources/sentence.txt")]
           (sum-counts (create-buffered-file-reader r)))))
    (is
      (= 71
         (with-open [r (clojure.java.io/input-stream "resources/swift.txt")]
           (sum-counts (create-buffered-file-reader r)))))))
