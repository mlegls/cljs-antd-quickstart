(ns starter.root
  (:require [helix.core :refer [defnc $]]
            [helix.hooks :as h]
            [helix.dom :as d]
            ["antd" :refer [Button]]))
            
(defnc root []
  {:helix/features {:fast-refresh true}}
  (d/div {:className "flex flex-col"}
    "Hello Again"
    ($ Button {:type "primary"} "Hello World!")))

