(ns starter.root
  (:require [starter.macros :refer [defnc]]
            [helix.core :refer [$]]
            [helix.hooks :as h]
            [helix.dom :as d]
            ["antd" :refer [Button]]))
            
(defnc root []
  (d/div {:className "flex flex-col"}
    "Hello Again"
    ($ Button {:type "primary"} "Hello World!")))

