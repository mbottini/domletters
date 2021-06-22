(defproject domletters "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "MIT"
            :url "https://choosealicense.com/licenses/mit"
            :comment "MIT License"
            :year 2021
            :key "mit"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main ^:skip-aot domletters.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
