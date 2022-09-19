(ns starter.app
  (:require [helix.core :refer [defnc $]]
            [helix.hooks :as h]
            [helix.dom :as d]
            ["antd" :refer [Button]]))
            
(defnc app []
  (d/div {:className "flex flex-col"}
    "Hello"
    ($ Button {:type "primary"} "Hello World!")))

