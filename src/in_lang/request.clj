(ns in-lang.request 
  (:require [clj-http.client :as client]
            [net.cgrand.enlive-html :as enl]))

(defn fetch-content [url]
  (try
    (let [response (client/get url)]
      (:body response))
    (catch Exception e
      (println "Erreur lors de la récupération de la page :" (.getMessage e))
      nil)))

(defn parse-html [html]
  (enl/html-resource (java.io.ByteArrayInputStream.(.getBytes html))))

(defn extract-title [parsed-html]
  (map #(enl/text %)
       (enl/select parsed-html [:a.title])))

(defn scrape [url]
  (let [html (fetch-content url)
        parsed-html (parse-html html)]
    (extract-title parsed-html)))

