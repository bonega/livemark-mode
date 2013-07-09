(ns livemark-mode.core
  (:use [markdown.core :only [md-to-html md-to-html-string]] )
  (:require [ring.middleware.reload :refer :all]
            [ring.adapter.jetty :refer :all]))

(def header "<meta http-equiv=\"refresh\" content=\"1; URL=http://localhost:8080\">")

(def raw-markdown (atom (str "*Waiting for input*" "\n" header)))

(defn app [req]
  {:status  200
   :headers {"content-Type" "text/html"}
   :body    (md-to-html-string @raw-markdown)})

(defn get-input []
  (loop [current nil]
    (let [line (read-line)]
      (if (= line "")
        current
        (recur (str current (when-not (nil? current) "\n" ) line))))))


(defn -main
  "The application's main function"
  [& args]
  (run-jetty #'livemark-mode.core/app {:port 8080 :join? false })
  (loop []
    (reset! raw-markdown (str header "\n" (get-input)))
    (recur)))
