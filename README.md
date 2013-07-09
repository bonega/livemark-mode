# Livemark-mode

An Emacs-mode for live-ish display of a markdown-buffer in a
webbrowser.   
This is mostly a toy for Clojure/Emacs integration at the moment, maybe I will package it one day.

## Installation
Depends on [leiningen](https://github.com/technomancy/leiningen).  
place something like `(load "~/pathtodir/livemark/src/livemark/livemark")` in your `init.el`

## Usage
Open your markdown and execute `M-x: livemark-mode`  
Now there should be a server displaying your markdown at:
 `http://localhost:8080`.  
Just open the link with your favorite browser.  
At the moment it will refresh every second.  


## License

Copyright © 2013 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
