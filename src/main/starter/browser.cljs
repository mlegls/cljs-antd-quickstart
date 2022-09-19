(ns starter.browser
  (:require ["react" :refer [React]]
            ["react-dom/client" :as rdom]
            ["react-router-dom" :refer [createBrowserRouter RouterProvider Route]]
            [helix.core :refer [$]]
            [starter.app :refer [app]]))

;; this is called before any code is reloaded
(defn ^:dev/before-load stop []
  (js/console.log "stop"))

;; start is called by init and after code reloading finishes
(defn ^:dev/after-load start []
  (js/console.log "start"))

(defn init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (js/console.log "init")
  (defonce router
    (createBrowserRouter (clj->js [{:path "/"
                                    :element (app/app)}])))
  (.render (rdom/createRoot (.getElementById js/document "app"))
           (React/StrictMode
             (RouterProvider {:router router}))))
  
