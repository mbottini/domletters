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

(defn create-buffered-reader [s]
  (->> s
    java.io.StringReader.
    java.io.BufferedReader.))

(deftest test-get-words-from-reader
  (testing "Getting strings from a constructed BufferedInputReader."
    (is (= '("The" "quick" "brown" "fox")
      (get-words-from-reader 
        (create-buffered-reader "The ,quick\n\n quick br_wn\n brown fox. fox"))))))
