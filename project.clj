(defproject clj-sm2 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.227"]]

  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-doo "0.1.6"]
            [lein-auto "0.1.2"]]

  :auto {"test" {:file-pattern #"\.(clj|cljs|cljc|edn)$"}}

  :clean-targets ^{:protect false} ["resources/public/js" "target" "out"]


  :cljsbuild {:builds [{:id "min"
                        :source-paths ["src"]
                        :compiler {:main clj-sm2.core
                                   :output-to "resources/deploy/js/compiled/app.js"
                                   :optimizations :advanced
                                   :closure-defines {goog.DEBUG false}
                                   :pretty-print false}}

                       {:id "unit-tests"
                        :source-paths ["src" "test"]
                        :compiler {:output-to "out/unit_tests.js"
                                   :main 'clj-sm2.unit-tests
                                   :target :nodejs
                                   :optimizations :none}}]})
