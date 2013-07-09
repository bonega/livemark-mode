(require 'comint)

(defun livemark-send-markdown (&rest stuff)
  (comint-send-string (get-buffer-process "*livemark*")
                      (concat (buffer-substring-no-properties (point-min) (point-max)) "\n\n")))


(defun livemark-setup-server () (progn (add-hook 'after-change-functions 'livemark-send-markdown nil t)
                                       (apply 'make-comint "livemark" "lein" nil '("run"))
                                       (livemark-send-markdown)))

(defun livemark-quit-server ()
  (progn (remove-hook 'after-change-functions 'livemark-send-markdown t)
         (let (kill-buffer-query-functions) (kill-buffer "*livemark*"))))

(defun livemark-toggle-mode ()
  (if livemark-mode
    (livemark-setup-server)
      (livemark-quit-server)))

(define-minor-mode livemark-mode
  "Mode for live-ish display of a markdown-buffer in a webbrowser"
  :lighter " livemark")

(add-hook 'livemark-mode-hook 'livemark-toggle-mode)


(provide 'livemark-mode)
