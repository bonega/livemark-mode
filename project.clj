(defproject livemark-mode "0.1.0-SNAPSHOT"
  :description "An emacs-mode for live-ish display of a markdown-buffer in a webbrowser"
  :url "https://github.com/bonega/livemark-mode"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [markdown-clj "0.9.26"]
                 [ring "1.1.8"]]
  :main livemark-mode.core)
