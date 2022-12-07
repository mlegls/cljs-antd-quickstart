(ns starter.macros
  (:require [helix.core :refer [defnc]]))

(defmacro defnc [name args & body]
  `(defnc ~name ~args
    {:helix/features {:fast-refresh true}}
    ~@body))
