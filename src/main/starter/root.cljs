(ns starter.root
  (:require 
            [helix.core :refer [$]]
            [helix.hooks :as h]
            [helix.dom :as d]
            ["antd" :refer [Button]])
  (:require-macros [starter.macros :refer [defnc]]))
  
            
(defnc root []
  (d/div {:className "flex flex-col"}
    "Hello Again"
    ($ Button {:type "primary"} "Hello World!")))

