(ns starter.browser
  (:require ["react-dom/client" :as rdom]
            ["react-router-dom" :refer [createBrowserRouter RouterProvider Route]]
            [helix.core :refer [$]]
            [helix.experimental.refresh :as r]
            [starter.root :refer [root]]))

(r/inject-hook!)

;; this is called before any code is reloaded
(defn ^:dev/before-load stop []
  (js/console.log "stop"))

;; start is called by init and after code reloading finishes
(defn ^:dev/after-load start []
  (js/console.log "start")
  (r/refresh!))

(def routes
  [{:path "/"
    :element ($ root)}])

(defn init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (js/console.log "init")
  (defonce router
    (createBrowserRouter (clj->js routes)))
  (.render (rdom/createRoot (.getElementById js/document "app"))
           ($ RouterProvider {:router router})))
  
