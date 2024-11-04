(ns in-lang.core
   (:require [in-lang.request :as req])
  (:gen-class))

(defn -main [& args] (let [url "https://en.wikipedia.org/wiki/Swedish_language"]
                       (req/scrape url)))

